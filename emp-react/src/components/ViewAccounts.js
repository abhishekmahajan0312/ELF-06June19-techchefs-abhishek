import React, { Component } from 'react'
import Axios from 'axios';

export class ViewAccounts extends Component {
    constructor(props){
        super(props);
        this.state={
            accounts:[]
        };
    }
    componentDidMount() {
        Axios.get('https://emp-app-1-aaa9e.firebaseio.com/accounts.json').then((response)=>{
            console.log('Response Data', response.data);
            let fetchedAccounts = [];
            for(let key in response.data){
                console.log(response.data[key])
                fetchedAccounts.push({
                    ...response.data[key],
                    id: key
                })
            }
            console.log('Fetched Accounts', fetchedAccounts);
        }).catch((error)=>{
            console.log('Error',error);
        })
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
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        )
    }
}

export default ViewAccounts
