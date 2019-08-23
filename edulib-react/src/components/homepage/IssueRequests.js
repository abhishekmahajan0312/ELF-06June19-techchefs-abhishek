import React, { Component } from 'react'
import Axios from 'axios';
import { LibrarianHomeNavbar } from '../navbar/LibrarianHomeNavbar';

export class IssueRequests extends Component {
    constructor(props) {
        super(props);
        this.state = {
            bookAllotments: []
        }

    }
    changeRequest = requestCode => {

    }
    componentDidMount() {
        Axios.get('http://localhost/librarian/getBookRequests').then((response) => {
            console.log('Response Data', response.data);
            this.setState({
                bookAllotments: response.data.bookAllotmentBeans
            })
            // console.log('Fetched Accounts', this.state.accounts);
        }).catch((error) => {
            console.log('Error', error);
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
                                        <th scope="col">User ID</th>
                                        <th scope="col">Book Name</th>
                                        <th scope="col">Issue Date</th>
                                        <th scope="col">Return Date</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        this.state.bookAllotments.map((allotment) => {
                                            return (
                                                <tr key={allotment.bookAllotmentId}>
                                                    <th>{allotment.userId.id}</th>
                                                    <td>{allotment.bookId.bookName}</td>
                                                    <td>{allotment.issueDate.substring(0, 10)}</td>
                                                    <td>{allotment.returnDate.substring(0, 10)}</td>
                                                    <td>
                                                        <button onClick={() => { this.changeRequest(1) }} className="btn btn-info m-1">Approve</button>
                                                        <button onClick={() => { this.changeRequest(2) }} className="btn btn-danger">Reject</button>
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

export default IssueRequests
