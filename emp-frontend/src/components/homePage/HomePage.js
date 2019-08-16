import React, { Component } from 'react'
import Axios from 'axios';
import UserHomeNavbar from '../navbar/UserHomeNavbar';

export class HomePage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            bean: JSON.parse(localStorage.getItem("bean")),
        }
    }
    render() {
        return (
            <div>
                <UserHomeNavbar name={this.state.bean.name}/>
                <div className="container">
                    <div className="row">
                        <div className="col-md-5 card ">

                            <div className="card-body">
                                <h5>Personal Details</h5>
                                <hr />
                                <table className="table table-striped">
                                    <tbody>
                                        <tr>
                                            <td>Name</td>

                                            <td>{this.state.bean.name}</td>
                                        </tr>
                                        <tr>
                                            <td>Age</td>
                                            <td>{this.state.bean.age}</td>
                                        </tr>
                                        <tr>
                                            <td>Gender</td>
                                            <td>{this.state.bean.gender}</td>
                                        </tr>
                                        <tr>
                                            <td>DOB</td>
                                            <td>{this.state.bean.dob}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                        <div className="offset-2 col-md-5 card ">
                            <div className="card-body">
                                <h5>Contact Details</h5>
                                <hr />
                                <table className="table table-striped">
                                    <tbody>
                                        <tr>
                                            <td>Email</td>
                                            <td>{this.state.bean.email}</td>
                                        </tr>
                                        <tr>
                                            <td>Phone Number</td>
                                            <td>{this.state.bean.phone}</td>
                                        </tr>
                                        <tr>
                                            <td>Address 1</td>
                                            {/* <td>{localStorage.bean.addressInfoBeans.get(1).address1}</td> */}
                                        </tr>
                                        <tr>
                                            <td>Address 2</td>
                                            {/* <td>{localStorage.bean.addressInfoBeans.get(1).address2}</td> */}
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <br /> <br />
                    <div className="row">
                        <div className="col-md-12 card ">

                            <div className="card-body">
                                <h5>Professional Details</h5>
                                <hr />
                                <table className="table table-striped">
                                    <tbody>
                                        <tr>
                                            <td>Salary</td>
                                            <td>{this.state.bean.salary}</td>
                                            <td>Manager ID</td>
                                            <td>{this.state.bean.mngrId.id}</td>
                                        </tr>
                                        <tr>
                                            <td>Joining Date</td>
                                            <td>{localStorage.bean.joiningDate}</td>
                                            <td>Department ID</td>
                                            {/* <td>{localStorage.bean.deptInfoBean.departmentId}</td> */}
                                        </tr>
                                        <tr>
                                            <td>Designation</td>
                                            <td>{this.state.bean.designation}</td>
                                            <td>Account Number</td>
                                            <td>{this.state.bean.accountNumber}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>

                    </div>

                </div>
            </div>
        )
    }
}