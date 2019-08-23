import React, { Component } from 'react'
// import Axios from 'axios';
// import UserHomeNavbar from '../navbar/UserHomeNavbar';
import { Link } from 'react-router-dom';
import { Button } from 'react-bootstrap'
import AdminHomeNavbar from '../navbar/AdminHomeNavbar';
export class AdminHomePage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            bean: JSON.parse(localStorage.getItem("userBean")),
            message:''
        }
    }

    
    render() {
        return (
            <div>
                <AdminHomeNavbar name={this.state.bean.name} />
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">

                            <h5>Admin Home</h5>
                            <hr />
                            <div className="row h-100">
                                <div className="col-md-4 ">
                                    <Link to="/addUser"><Button className="btn btn-secondary w-100 h-100">Add User</Button></Link>
                                </div>
                                <div className="col-md-4">
                                    <Button className="btn btn-secondary w-100 h-100">View Users</Button>
                                </div>
                                <div className="col-md-4">
                                    <Button className="btn btn-secondary w-100 h-100">Notifications</Button>
                                </div>
                            </div>


                        </div>


                    </div>

                </div>


            </div>
        )
    }
}
