import React, { Component } from 'react'
import { Button } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import LibrarianHomeNavbar from '../navbar/LibrarianHomeNavbar';

export class LibrarianHomePage extends Component {
    render() {
        return (
            <div>
                <LibrarianHomeNavbar name={localStorage.getItem("username")} />
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">

                            <h5>Library Home</h5>
                            <hr />
                            <div className="row h-100">
                                <div className="col-md-4 ">
                                    <Link to="/addBook"><Button className="btn btn-secondary w-100 h-100">Add Book</Button></Link>
                                </div>
                                <div className="col-md-4">
                                <Link to="/viewBooks"><Button className="btn btn-secondary w-100 h-100">View Books</Button></Link>
                                </div>
                                <div className="col-md-4">
                                    <Link to="/issueRequests"><Button className="btn btn-secondary w-100 h-100">Issue Requests</Button></Link>
                                </div>
                            </div>


                        </div>


                    </div>

                </div>
            </div>
        )
    }
}

export default LibrarianHomePage
