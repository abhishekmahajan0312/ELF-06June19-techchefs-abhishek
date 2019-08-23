import React, { Component } from 'react'
import Axios from 'axios';
import { Card, Button } from 'react-bootstrap'
import UserHomeNavbar from '../navbar/UserHomeNavbar';
import AdminHomeNavbar from '../navbar/AdminHomeNavbar';
import { LibrarianHomeNavbar } from '../navbar/LibrarianHomeNavbar';
export class BookPage extends Component {
    constructor(props) {
        super(props);
        console.log(this.props.location.state.id);
        this.state = {
            bookAllotment: {
                returnDate: "",
                bookId: { bookId: "" },
                userId: { id: "" }
            },
            book: {
                image: ""
            }
        }
    }
    componentDidMount() {
        Axios.get('http://localhost/user/getBook?id=' + this.props.location.state.id)
            .then((response) => {
                console.log('Response object', response);
                const responseData = response.data;
                if (responseData.message === "Successfull") {
                    console.log(responseData.beans[0])
                    let bookBean = responseData.beans[0]
                    this.setState({
                        bookAllotment: {
                            returnDate: "",
                            bookId: { bookId: bookBean.bookId },
                            userId: { id: JSON.parse(localStorage.getItem("userBean")).id }
                        },
                        book: bookBean
                    })
                }
            })
            .catch((error) => {
                console.log('Error Object', error);
            })

    }
    requestBook = () => {
        // console.log(bookId)
        const temp = this.state.bookAllotment;
        console.log(temp)
        Axios.post('http://localhost/user/requestBook', temp)
            .then((response) => {
                console.log('Response object', response);
                const responseData = response.data;
                if (responseData.message === "Successfull") {
                    console.log(responseData.bookAllotmentBeans[0])
                    localStorage.setItem("issueStatus","0");
                    this.props.history.push('/home')
                }
            })
            .catch((error) => {
                console.log('Error Object', error);
            })
    }
    render() {
        const img = (this.state.book.image !== "") ? (
            <Card.Img variant="top" src={require("../../uploads/" + this.state.book.image)} />
        ) : null

        return (
            <div>
                {localStorage.getItem("userType") === "librarian" ?
                    <LibrarianHomeNavbar name={localStorage.getItem("username")} /> :
                    <UserHomeNavbar name={localStorage.getItem("username")} />
                }
                <div className="container">
                    <div className="row">
                        <div className="col-md-4 offset-4">

                            <Card >
                                {img}
                                <Card.Body>
                                    <Card.Title>{this.state.book.bookName}</Card.Title>
                                    <Card.Text>
                                        <b>Author</b>: {this.state.book.author}<br />
                                        <b>ISBN</b>: {this.state.book.isbn}<br />
                                        <b>Category</b>: {this.state.book.category}<br />
                                        <b>Return Date</b><br />
                                        <input type="date" onChange={event => {
                                            this.setState({
                                                bookAllotment: {
                                                    returnDate: event.target.value,
                                                    bookId: this.state.bookAllotment.bookId,
                                                    userId: this.state.bookAllotment.userId
                                                }
                                            })
                                        }} value={this.state.bookAllotment.returnDate} className="form-control mt-1"></input>
                                    </Card.Text>
                                    <Button variant="info" onClick={this.requestBook} block>Issue</Button>
                                </Card.Body>
                            </Card>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default BookPage
