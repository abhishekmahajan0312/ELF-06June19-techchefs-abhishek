import React, { Component } from 'react'
import Axios from 'axios';
import { BrowserRouter as Link } from 'react-router-dom'
import { Navbar, NavDropdown, Alert } from 'react-bootstrap'
import logo from '../assets/logo192.png';


export default class Login extends Component {
    constructor(props) {
        super(props);
        // console.log(localStorage.getItem("status"));
        this.state = {
            id: '',
            password: '',
            show: false,
            showLogout: localStorage.getItem("status")==="true"?true:false
        }
        
        this.postData = this.postData.bind(this);
    }
    // componentDidMount() {
    //     this.props.location.state = undefined;
    // }
    postData(event) {
        event.preventDefault();
        Axios.post('http://localhost/login/authenticate', null, {
            params:
            {
                id: this.state.id,
                password: this.state.password
            }, withCredentials: true

        }
        )
            .then((response) => {
                console.log('Response object', response);
                const responseData = response.data;
                if (responseData.message === "Successfull") {
                    console.log(responseData.beans[0])
                    const userType = responseData.beans[0].userType;
                    localStorage.clear();
                    localStorage.setItem("userBean", JSON.stringify(responseData.beans[0]))
                    localStorage.setItem("username", responseData.beans[0].name)
                    localStorage.setItem("userType", userType)

                    if (userType.toLowerCase() === "admin") {
                        this.props.history.push("/adminHome")
                    }
                    else if (userType.toLowerCase() === "librarian") {
                        this.props.history.push("/libraryHome")
                    }
                    else {
                        this.props.history.push("/home")
                    }
                }
                else {
                    this.setState({
                        show: true,
                        
                    })
                    this.props.history.push("/")
                }

            })
            .catch((error) => {
                console.log('Error Object', error);
            })

    }

    render() {
        return (
            <div>
                <Navbar bg="light">
                    <Navbar.Brand >
                        <img
                            alt=""
                            src={logo}
                            width="30"
                            height="30"
                            className="d-inline-block align-top"
                        /> Edulib.com
            </Navbar.Brand>
                    
                </Navbar>
                <br />

                <div className="container">
                    <div className="row">
                        <div className="col-md-4 offset-4 card">
                            <div className="card-body">
                                <h4 className="text-center border-bottom">User Login</h4>
                                <br />

                                <Alert show={this.state.show} variant="danger" onClose={() => this.setState({ show: false })} dismissible>
                                    Invalid Credentials!
                                    </Alert>


                                <Alert show={this.state.showLogout} variant="success" onClose={() => this.setState({ showLogout: false })} dismissible>
                                    Logout Successfull!!!

                                </Alert>

                                <form onSubmit={this.postData} className="form-horizontal">
                                    <div className="col-auto">
                                        <div className="input-group mb-2">
                                            <div className="input-group-prepend">
                                                <div className="input-group-text">ID</div>
                                            </div>
                                            <input onChange={(event) => {
                                                this.setState({
                                                    id: event.target.value
                                                })
                                            }}
                                                value={this.state.id} type="number"
                                                className="form-control" name="id" placeholder="Enter User ID" />
                                        </div>
                                    </div>
                                    <div className="col-auto">
                                        <div className="input-group mb-2">
                                            <div className="input-group-prepend">
                                                <div className="input-group-text">Password</div>
                                            </div>
                                            <input onChange={(event) => {
                                                this.setState({
                                                    password: event.target.value
                                                })
                                            }}
                                                value={this.state.password} type="password"
                                                className="form-control" name="password"
                                                placeholder="Enter Password" />
                                        </div>
                                    </div>
                                    <br />
                                    <div className=" row">
                                        <button type="reset"
                                            className="offset-1 col-md-5 btn btn-outline-dark"
                                            style={{ borderRadius: '3px 0 0 3px', borderRight: 0 }}>Reset</button>
                                        <button type="submit" className="col-md-5 btn btn-outline-info"
                                            style={{ borderRadius: '0 3px 3px 0' }}>Login</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        );
    }
}
