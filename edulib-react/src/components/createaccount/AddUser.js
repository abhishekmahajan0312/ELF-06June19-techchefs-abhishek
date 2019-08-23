import React, { Component } from 'react'
import { Form, Button, Col, Alert } from 'react-bootstrap'
import AdminHomeNavbar from '../navbar/AdminHomeNavbar'
import Axios from 'axios';
export class AddUser extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: JSON.parse(localStorage.getItem("userBean")).name,
            newUser: {
                name: "",
                userType: "",
                phone: "",
                email: "",
                currentAddress: ""
            },
            show: false,
            id: "",
            password: ""
        }
        this.saveData = this.saveData.bind(this);
    }

    saveData(event) {
        event.preventDefault();
        console.log("this.state", this.state);
        const userDetails = this.state.newUser;
        Axios.post('http://localhost/admin/createUser', userDetails)
            .then((response) => {
                console.log('Response object', response);
                const responseData = response.data;
                this.setState({
                    newUser: {
                        name: "",
                        userType: "",
                        phone: "",
                        email: "",
                        currentAddress: ""
                    },
                    show: true,
                    password: responseData.beans[0].password,
                    id: responseData.beans[0].id
                })


            })
            .catch((error) => {
                console.log('Error Object', error);
            })

    }

    render() {
        return (
            <div>
                <AdminHomeNavbar name={this.state.username} />
                <div className="container">
                    <div className="col-md-6 offset-3 card">

                        <div className="card-body">
                            <Alert show={this.state.show} variant="success" onClose={() => this.setState({ show: false })} dismissible>
                                Id: {this.state.id}
                                <br />
                                Password: {this.state.password}
                            </Alert>

                            <h3>Add User</h3>
                            <hr />
                            <Form onSubmit={this.saveData}>
                                <Form.Row>
                                    <Form.Group as={Col}>
                                        <Form.Label>Name</Form.Label>
                                        <Form.Control type="text" onChange={(event) => {
                                            this.setState({
                                                newUser: {
                                                    name: event.target.value,
                                                    userType: this.state.newUser.userType,
                                                    phone: this.state.newUser.phone,
                                                    email: this.state.newUser.email,
                                                    currentAddress: this.state.newUser.currentAddress
                                                }
                                            })
                                        }}
                                            value={this.state.newUser.name} placeholder="Name" />
                                    </Form.Group>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Group as={Col}>
                                        <Form.Label>User Type</Form.Label>
                                        <Form.Control as="select" onChange={(event) => {
                                            this.setState({
                                                newUser: {
                                                    name: this.state.newUser.name,
                                                    userType: event.target.value,
                                                    phone: this.state.newUser.phone,
                                                    email: this.state.newUser.email,
                                                    currentAddress: this.state.newUser.currentAddress
                                                }
                                            })
                                        }}
                                            value={this.state.newUser.userType}>
                                            <option>Librarian</option>
                                            <option>User</option>
                                        </Form.Control>
                                        
                                    </Form.Group>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Group as={Col}>
                                        <Form.Label>Address 1</Form.Label>
                                        <Form.Control as="textarea" rows="3" onChange={(event) => {
                                            this.setState({
                                                newUser: {
                                                    name: this.state.newUser.name,
                                                    userType: this.state.newUser.userType,
                                                    phone: this.state.newUser.phone,
                                                    email: this.state.newUser.email,
                                                    currentAddress: event.target.value
                                                }
                                            })
                                        }}
                                            value={this.state.newUser.currentAddress} placeholder="Current Address" />
                                    </Form.Group>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Group as={Col}>
                                        <Form.Label>Phone Number</Form.Label>
                                        <Form.Control type="text" required onChange={(event) => {
                                            this.setState({
                                                newUser: {
                                                    name: this.state.newUser.name,
                                                    userType: this.state.newUser.userType,
                                                    phone: event.target.value,
                                                    email: this.state.newUser.email,
                                                    currentAddress: this.state.newUser.currentAddress
                                                }
                                            })
                                        }}
                                            value={this.state.newUser.phone} placeholder="Phone Number" />
                                    </Form.Group>
                                </Form.Row>
                                <Form.Row>
                                    <Form.Group as={Col}>
                                        <Form.Label>Email ID</Form.Label>
                                        <Form.Control type="email" onChange={(event) => {
                                            this.setState({
                                                newUser: {
                                                    name: this.state.newUser.name,
                                                    userType: this.state.newUser.userType,
                                                    phone: this.state.newUser.phone,
                                                    email: event.target.value,
                                                    currentAddress: this.state.newUser.currentAddress
                                                }
                                            })
                                        }}
                                            value={this.state.newUser.email} placeholder="Email Id" />
                                    </Form.Group>
                                </Form.Row>
                                <Form.Row >
                                    <Form.Group as={Col}>
                                        <Button className="col" variant="primary" type="submit">
                                            Submit
  </Button></Form.Group></Form.Row>
                            </Form>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default AddUser
