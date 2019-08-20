import React, { Component } from 'react'
import Axios from 'axios';
import { BrowserRouter as Link } from 'react-router-dom'
import { Navbar, NavDropdown,Alert } from 'react-bootstrap'
import logo from '../../assets/logo192.png';


export class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: '',
            password: '',
            show: false
        }
        this.postData = this.postData.bind(this);
    }

    postData(event) {
        event.preventDefault();
        let accountDetails = this.state;
        Axios.post('http://localhost/emp-springrest/login/authenticate', null, {
            params:
            {
                id: this.state.id,
                password: this.state.password
            }
        }
        )
            .then((response) => {
                console.log('Response object', response);
                const responseData = response.data;
                // let data = JSON.parse(responseData);
                // console.log(data);
                if (responseData.message === "Success") {
                    console.log(responseData.beans[0])
                    localStorage.setItem("bean", JSON.stringify(responseData.beans[0]))
                    localStorage.setItem("username",responseData.beans[0].name)
                    this.props.history.push("/homePage")
                    
                }
                else {
                    this.setState({
                        show: true
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
                    <Navbar.Brand href="#home">
                        <img
                            alt=""
                            src={logo}
                            width="30"
                            height="30"
                            className="d-inline-block align-top"
                        /> EMP
            </Navbar.Brand>
                    <Navbar.Toggle />
                    <Navbar.Collapse className="justify-content-end">
                        <NavDropdown className="mr-5" title="Dropdown" id="basic-nav-dropdown">
                            <Link className="nav-link" to="/"><NavDropdown.Item>Login</NavDropdown.Item></Link>
                            <Link className="nav-link" to="/info"><NavDropdown.Item>Create Employee</NavDropdown.Item></Link>
                        </NavDropdown>
                    </Navbar.Collapse>
                </Navbar>
                <br />

                <div className="container">
                    <div className="row">
                        <div className="col-md-4 offset-4 card">
                            <div className="card-body">
                                <h4 className="text-center border-bottom">Employee Login</h4>
                                <br />
                                {this.state.show ?
                                    <Alert variant="danger">
                                        <Alert.Heading>Invalid Credentials!</Alert.Heading>
                                    </Alert>

                                    : null

                                }
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
                                                value={this.state.email} type="number"
                                                className="form-control" name="id" placeholder="Enter Employee ID" />
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