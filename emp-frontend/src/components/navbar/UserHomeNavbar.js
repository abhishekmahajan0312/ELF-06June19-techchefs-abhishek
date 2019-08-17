import React, { Component } from 'react'
import { Navbar, NavDropdown, Form, FormControl, Button } from 'react-bootstrap'
import { BrowserRouter as Link } from 'react-router-dom'
import logo from '../../assets/logo192.png';
import Axios from 'axios';
import { withRouter } from 'react-router-dom'
class UserHomeNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {
            searchId: ''
        }
    }

    searchEmployee = (event) => {
        event.preventDefault();
        Axios.get('http://localhost/emp-springrest/employee/searchEmployee?empId=' + this.state.searchId
        ).then((response) => {
            console.log('Response Data', response.data);
            const responseData = response.data;
            if (responseData.statusCode === 201 && responseData.message === "Successfull") {
                localStorage.removeItem('beans');
                localStorage.setItem('beans', JSON.stringify(responseData.beans))
                this.props.history.push("/searchEmployee")

            }
            // let fetchedAccounts = [];
            // for (let key in response.data) {
            //     console.log(response.data[key])
            //     fetchedAccounts.push(
            //         {
            //         ...response.data[key],
            //         id: key
            //     }
            //     )
            // }
            // this.setState({
            //     accounts: fetchedAccounts
            // })
            // console.log('Fetched Accounts', this.state.accounts);
        }).catch((error) => {
            console.log('Error', error);
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
                    <Navbar.Collapse className="justify-content-end">
                        <Form onSubmit={this.searchEmployee} inline>
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
                            <Link className="nav-link" to="/"><NavDropdown.Item>Update Employee</NavDropdown.Item></Link>
                            <Link className="nav-link" to="/info"><NavDropdown.Item>Logout</NavDropdown.Item></Link>
                        </NavDropdown>
                    </Navbar.Collapse>
                </Navbar>
                <br />
            </div>
        )
    }
}

export default withRouter(UserHomeNavbar)
