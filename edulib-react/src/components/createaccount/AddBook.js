import React, { Component } from 'react'
import { Form, Button, Col, Alert } from 'react-bootstrap'
import Axios from 'axios'
import { LibrarianHomeNavbar } from '../navbar/LibrarianHomeNavbar';

export class AddBook extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: JSON.parse(localStorage.getItem("userBean")).name,
            newBook: {
                bookName: '',
                author: '',
                category: '',
                count: '',
                isbn: '',
                price: ''
            },
            show: false,

        }
        this.saveData = this.saveData.bind(this);
    }

    saveData(event) {
        event.preventDefault();
        console.log("this.state", this.state);
        const bookDetails = this.state.newBook;
        Axios.post('http://localhost/librarian/addBook', bookDetails)
            .then((response) => {
                console.log('Response object', response);
                const responseData = response.data;
                this.setState({
                    newBook: {
                        bookName: '',
                        author: '',
                        category: '',
                        count: '',
                        isbn: '',
                        price: ''
                    },
                    show: true,
                    password: responseData.beans[0].password,
                    id: responseData.beans[0].id
                })


            })
            .catch((error) => {
                console.log('Error Object', error);
            })

    }

    render() {
        return (
            <div>
                <LibrarianHomeNavbar name={this.state.username} />
                <div className="container">
                    <div className="col-md-6 offset-3 card">

                        <div className="card-body">
                            <Alert show={this.state.show} variant="success" onClose={() => this.setState({ show: false })} dismissible>
                                Book added Successfully!!
                            </Alert>

                            <h3>Add Book</h3>
                            <hr />
                            <Form onSubmit={this.saveData}>
                                <Form.Row>
                                    <Form.Group as={Col}>
                                        <Form.Label>Book Name</Form.Label>
                                        <Form.Control type="text" onChange={(event) => {
                                            this.setState({
                                                newBook: {
                                                    bookName: event.target.value,
                                                    author: this.state.newBook.author,
                                                    category: this.state.newBook.category,
                                                    count: this.state.newBook.count,
                                                    isbn: this.state.newBook.isbn,
                                                    price: this.state.newBook.price
                                                }
                                            })
                                        }}
                                            value={this.state.newBook.bookName} placeholder="Name" />
                                    </Form.Group>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Group as={Col}>
                                        <Form.Label>Author</Form.Label>
                                        <Form.Control type="text" onChange={(event) => {
                                            this.setState({
                                                newBook: {
                                                    bookName: this.state.newBook.bookName,
                                                    author: event.target.value,
                                                    category: this.state.newBook.category,
                                                    count: this.state.newBook.count,
                                                    isbn: this.state.newBook.isbn,
                                                    price: this.state.newBook.price
                                                }
                                            })
                                        }}
                                            value={this.state.newBook.author} placeholder="Author">

                                        </Form.Control>

                                    </Form.Group>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Group as={Col}>
                                        <Form.Label>Category</Form.Label>
                                        <Form.Control type="text" onChange={(event) => {
                                            this.setState({
                                                newBook: {
                                                    bookName: this.state.newBook.bookName,
                                                    author: this.state.newBook.author,
                                                    category: event.target.value,
                                                    count: this.state.newBook.count,
                                                    isbn: this.state.newBook.isbn,
                                                    price: this.state.newBook.price
                                                }
                                            })
                                        }}
                                            value={this.state.newBook.category} placeholder="Category">

                                        </Form.Control>

                                    </Form.Group>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Group as={Col}>
                                        <Form.Label>Count</Form.Label>
                                        <Form.Control type="text" required onChange={(event) => {
                                            this.setState({
                                                newBook: {
                                                    bookName: this.state.newBook.bookName,
                                                    author: this.state.newBook.author,
                                                    category: this.state.newBook.category,
                                                    count: event.target.value,
                                                    isbn: this.state.newBook.isbn,
                                                    price: this.state.newBook.price
                                                }
                                            })
                                        }}
                                            value={this.state.newBook.count} placeholder="Enter No. of Books" />
                                    </Form.Group>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Group as={Col}>
                                        <Form.Label>ISBN</Form.Label>
                                        <Form.Control type="text" onChange={(event) => {
                                            this.setState({
                                                newBook: {
                                                    bookName: this.state.newBook.bookName,
                                                    author: this.state.newBook.author,
                                                    category: this.state.newBook.category,
                                                    count:this.state.newBook.count, 
                                                    isbn: event.target.value,
                                                    price: this.state.newBook.price
                                                }
                                            })
                                        }}
                                            value={this.state.newBook.isbn} placeholder="ISBN" />
                                    </Form.Group>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Group as={Col}>
                                        <Form.Label>Price</Form.Label>
                                        <Form.Control type="text" onChange={(event) => {
                                            this.setState({
                                                newBook: {
                                                    bookName: this.state.newBook.bookName,
                                                    author: this.state.newBook.author,
                                                    category: this.state.newBook.category,
                                                    count:this.state.newBook.count, 
                                                    isbn: this.state.newBook.isbn,
                                                    price: event.target.value
                                                }
                                            })
                                        }}
                                            value={this.state.newBook.price} placeholder="Price" />
                                    </Form.Group>
                                </Form.Row>
                                <Form.Row >
                                    <Form.Group as={Col}>
                                        <Button className="col" variant="primary" type="submit">
                                            Save Book
  </Button></Form.Group></Form.Row>
                            </Form>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default AddBook
