import React, { Component } from 'react'
import { Navbar, NavDropdown, Form, FormControl, Button } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import { LinkContainer } from 'react-router-bootstrap'
import logo from '../assets/logo192.png';
import Axios from 'axios';
import { withRouter } from 'react-router-dom'
class AdminHomeNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {
            searchId: '',
            
        }
    }


    
    logout() {
        Axios.get('http://localhost/login/logout').then((response) => {
            console.log('Response Data', response.data);
            const responseData = response.data;
            if (responseData.statusCode === 201 && responseData.message === "Successfull") {
                localStorage.clear();
                localStorage.setItem("status", "true")
                this.props.history.push("/")

            }
        }).catch((error) => {
            console.log('Error', error);
        })
        
    }
    render() {
        return (
            <div>
                <Navbar bg="light">
                    <Navbar.Brand>
                        <img
                            alt=""
                            src={logo}
                            width="30"
                            height="30"
                            className="d-inline-block align-top"
                        />

                        <Link to="/adminHome">Edulib.com</Link>
                    </Navbar.Brand>

                    <Navbar.Collapse className="justify-content-end">
                        <Form inline>
                            <FormControl type="text" onChange={(event) => {
                                this.setState({
                                    searchId: event.target.value
                                })
                            }} value={this.state.searchId} placeholder="Search" className="mr-sm-2" />
                            <Button variant="outline-success" type="submit">Search</Button>
                        </Form>
                    </Navbar.Collapse>
                    <Navbar.Toggle />
                    <Navbar.Collapse className="justify-content-end">
                        <NavDropdown className="mr-5" title="Settings" id="basic-nav-dropdown">
                            <NavDropdown.Item>{this.props.name}</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item onClick={this.logout.bind(this)}>Logout</NavDropdown.Item>
                        </NavDropdown>
                    </Navbar.Collapse>

                </Navbar>
                <br />
            </div>
        )
    }
}

export default withRouter(AdminHomeNavbar)
