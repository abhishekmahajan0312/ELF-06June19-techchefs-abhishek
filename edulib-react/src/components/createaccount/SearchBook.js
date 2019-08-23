import React, { Component } from 'react'
import { Col, Image, Row } from 'react-bootstrap';
import UserHomeNavbar from '../navbar/UserHomeNavbar';

export class SearchBook extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: JSON.parse(localStorage.getItem("searchBeans")),
            show: false
        }
        console.log(this.state.books[0].bookId)

    }
    getBook(id) {
        this.props.history.push({
            pathname: '/displayBook',
            state: {
                id: id
            }
        })
    }
    render() {
        return (
            <div>

                <UserHomeNavbar name={localStorage.getItem("username")} />
                <div className="container">
                    <div className="row">
                        <div className="col-md-6 offset-3">
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
            </div>)
    }
}

export default SearchBook
