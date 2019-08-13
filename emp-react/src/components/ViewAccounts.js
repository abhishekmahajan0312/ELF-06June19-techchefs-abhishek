import React, { Component } from 'react'
import Axios from 'axios';
import { Modal, Button } from 'react-bootstrap'
export class ViewAccounts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            accounts: [],
            show: false,
            name: '',
            email: "",
            phoneno: "",
            password: "",
            id: "",
        };
    }
    componentDidMount() {
        Axios.get('https://emp-app-1-aaa9e.firebaseio.com/accounts.json').then((response) => {
            console.log('Response Data', response.data);
            let fetchedAccounts = [];
            for (let key in response.data) {
                console.log(response.data[key])
                fetchedAccounts.push(
                    {
                    ...response.data[key],
                    id: key
                }
                )
            }
            this.setState({
                accounts: fetchedAccounts
            })
            console.log('Fetched Accounts', this.state.accounts);
        }).catch((error) => {
            console.log('Error', error);
        })
    }
    validateForm = () => {
        if (this.state.email.trim() === "" || this.state.name.trim() === "" || this.state.phoneno.trim() === "" || this.state.password.trim() === "" || this.state.phoneno.trim().length !== 10) {
            return false;
        }
        return true;
    }

    deleteAccount(account) {
        Axios.delete('https://emp-app-1-aaa9e.firebaseio.com/accounts/' + account.id + "/.json").then((response) => {
            alert('Deleted Successfully!')
            let allAccounts = this.state.accounts;
            let index = allAccounts.indexOf(account);
            let newAccounts = allAccounts.splice(index, 1);
            console.log('New Accounts', newAccounts);
            this.setState({
                accounts: allAccounts
            })

        })
            .catch((error) => {
                alert('Deletion Failed')
            });
    }
    editAccount(account) {
        this.setState({
            name: account.name,
            email: account.email,
            phoneno: account.phoneno,
            password: account.password,
            show: !this.state.show,
            id: account.id
        });
    }
    handleClose() {
        this.setState({
            show: false
        })
    }
    updateAccountData() {
        if (this.validateForm()) {
            const { id, name, email, password, phoneno } = this.state; // Object Destructuring fields should match
            let accountnew = { name, email, password, phoneno };
            Axios.put('https://emp-app-1-aaa9e.firebaseio.com/accounts/' + id + "/.json", accountnew)
                .then((response) => {
                    let allAccounts = this.state.accounts;
                    allAccounts.forEach((account, index) => {
                        if (account.id === id) {
                            account.name = name;
                            account.email = email;
                            account.phoneno = phoneno;
                            account.password = password;
                        }
                    })
                    // account = { ...account, id: id }
                    // let index = allAccounts.indexOf(account);
                    // let newAccounts = allAccounts.splice(index, 1, account);

                    this.setState({
                        show: false,
                        accounts: allAccounts
                    })
                })
                .catch((error) => {
                    alert('Updation Failed')
                });
        }
        else {
            console.log("Validation", "Invalid Details");
        }
    }
    render() {
        return (
            <div>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone Number</th>
                            <th scope="col">Password</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.accounts.map((account) => {
                                return (
                                    <tr key={account.id}>
                                        <th>{account.name}</th>
                                        <td>{account.email}</td>
                                        <td>{account.phoneno}</td>
                                        <td>{account.password}</td>
                                        <td>
                                            <button onClick={this.editAccount.bind(this, account)} className="btn btn-info m-1">Edit</button>
                                            <button onClick={this.deleteAccount.bind(this, account)} className="btn btn-danger">Delete</button>
                                        </td>
                                    </tr>
                                )
                            })
                        }

                    </tbody>
                </table>
                <div>

                    <Modal show={this.state.show} onHide={this.handleClose.bind(this)}>
                        <Modal.Header closeButton>
                            <Modal.Title>Edit Employee</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <div className="row ">
                                <div className="col">
                                    <input type="text" onChange={(event) => {
                                        this.setState({
                                            name: event.target.value
                                        })
                                    }}
                                        value={this.state.name} className="form-control" placeholder="Name" />
                                </div>
                                <div className="col">
                                    <input type="text"
                                        onChange={(event) => {
                                            this.setState({
                                                email: event.target.value
                                            })
                                        }}
                                        value={this.state.email} className="form-control" placeholder="Email" />
                                </div>
                            </div>
                            <br />
                            <div className="row">
                                <div className="col">
                                    <input type="number"
                                        onChange={(event) => {
                                            this.setState({
                                                phoneno: event.target.value
                                            })
                                        }}
                                        value={this.state.phoneno} className="form-control" placeholder="Phone Number" />
                                </div>
                                <div className="col">
                                    <input type="password"
                                        onChange={(event) => {
                                            this.setState({
                                                password: event.target.value
                                            })
                                        }}
                                        value={this.state.password} className="form-control" placeholder="Password" />
                                </div>
                            </div>
                            <br />
                        </Modal.Body>
                        <Modal.Footer>
                            <Button variant="secondary" onClick={this.handleClose.bind(this)}>
                                Close
          </Button>
                            <Button variant="primary" onClick={this.updateAccountData.bind(this)}>
                                Save Changes
          </Button>
                        </Modal.Footer>
                    </Modal>
                </div>
            </div>
        )
    }
}

export default ViewAccounts
