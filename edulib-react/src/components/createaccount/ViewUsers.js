import React, { Component } from 'react'
import AdminHomeNavbar from '../navbar/AdminHomeNavbar';

export class ViewUsers extends Component {
    render() {
        return (
            <div>
                <AdminHomeNavbar name={this.state.username} />
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">

                            <table className="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">Name</th>
                                        <th scope="col">User Type</th>
                                        <th scope="col">Phone</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Current Address</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    {this.state.users.map((user) => {
                                        return (
                                            <tr key={user.id}>
                                                <td>{user.name}</td>
                                                <td>{user.userType}</td>
                                                <td>{user.phone}</td>
                                                <td>{user.email}</td>
                                                <td>{user.currentAddress}</td>
                                                <td>
                                                    <button onClick={() => { this.edituser(user.id) }} className="btn btn-info m-1">Edit</button>
                                                    <button onClick={() => { this.deleteuser(user.id) }} className="btn btn-danger">Delete</button>
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

export default ViewUsers
