import React, { Component } from 'react'
import { Image, Row, Col, Alert } from 'react-bootstrap'
import Axios from 'axios'
import UserHomeNavbar from '../navbar/UserHomeNavbar';
export class UserHomePage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: [],
            show: localStorage.getItem("issueStatus")==="0"?true:false
        }
         console.log(this.state.show)
        this.getBook = this.getBook.bind(this);
    }
    getBook(id) {
        // console.log(id);
        this.props.history.push({
            pathname: '/displayBook',
            state: {
                id: id
            }
        })
    }
    componentDidMount() {
        Axios.get('http://localhost/user/searchBook?bookName=', null,
            {
                withCredentials: true
            })
            .then((response) => {
                // console.log('Response object', response);
                const responseData = response.data;
                if (responseData.message === "Successfull") {
                    // console.log(responseData.beans)
                    this.setState({
                        books: responseData.beans
                    })
                }
            })
            .catch((error) => {
                console.log('Error Object', error);
            })
    }
    render() {
        return (
            <div>
                <UserHomeNavbar name={localStorage.getItem("username")} />
                <div className="container">
                    <div className="row">
                        <div className="col-md-6 offset-3">

                            <Alert show={this.state.show} variant="success" onClose={() => this.setState({ show: false })} dismissible>
                                Request Sent Successfully!!!
                            </Alert>
                            <Row>
                                {this.state.books.map((book) => {
                                    return (
                                        <Col key={book.bookId} md={{ span: 4 }}>
                                            <Image onClick={() => { this.getBook(book.bookId) }} src={require("../../uploads/" + book.image)} thumbnail />
                                        </Col>

                                    )
                                })}
                            </Row>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default UserHomePage
