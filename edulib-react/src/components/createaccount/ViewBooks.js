import React, { Component } from 'react'
import Axios from 'axios';
import { LibrarianHomeNavbar } from '../navbar/LibrarianHomeNavbar';

export class ViewBooks extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: []
        }
    }
    componentDidMount() {
        Axios.get('http://localhost/user/searchBook?bookName=', null,
            {
                withCredentials: true
            })
            .then((response) => {
                const responseData = response.data;
                if (responseData.message === "Successfull") {
                    this.setState({
                        books: responseData.beans
                    })
                }
            })
            .catch((error) => {
                console.log('Error Object', error);
            })
    }
    editBook = (id) => {

    }
    deleteBook = id => {
        Axios.get('http://localhost/librarian/deleteBook?id=' + id, null,
            {
                withCredentials: true
            })
            .then((response) => {
                const responseData = response.data;
                if (responseData.message === "Successfull") {
                    let allBooks = this.state.books;
                    let index = allBooks.indexOf(responseData.beans[0]);
                    let newBooks = allBooks.splice(index, 1);
                    console.log('New Accounts', newBooks);
                    this.setState({
                        books: allBooks
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
                <LibrarianHomeNavbar name={this.state.username} />
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">

                            <table className="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">Book Name</th>
                                        <th scope="col">Author</th>
                                        <th scope="col">Category</th>
                                        <th scope="col">Total Books</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">ISBN</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    {this.state.books.map((book) => {
                                        return (
                                            <tr key={book.bookId}>
                                                <td>{book.bookName}</td>
                                                <td>{book.author}</td>
                                                <td>{book.category}</td>
                                                <td>{book.count}</td>
                                                <td>{book.price}</td>
                                                <td>{book.isbn}</td>
                                                <td>
                                                    <button onClick={() => { this.editBook(book.bookId) }} className="btn btn-info m-1">Edit</button>
                                                    <button onClick={() => { this.deleteBook(book.bookId) }} className="btn btn-danger">Delete</button>
                                                </td>
                                            </tr>
                                        )
                                    })
                                    }

                                </tbody>
                            </table>
                        </div>
                    </div></div></div>
        )
    }
}

export default ViewBooks
