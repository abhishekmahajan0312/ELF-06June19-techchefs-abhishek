import React, { Component } from 'react'
import UserHomeNavbar from '../navbar/UserHomeNavbar';

export class SearchEmployee extends Component {

    constructor(props) {
        super(props);
        this.state = {
            beans: JSON.parse(localStorage.getItem("beans"))
        }
        // this.updatedValue.bind(this)
    }
    updatedValue=(data)=>{
        console.log(data)
        
        this.setState({
            beans: JSON.parse(data)
        })
    }
    // componentDidUpdate() {
    //     this.setState({
    //         beans: JSON.parse(localStorage.getItem("beans"))
    //     })
    // }
     componentDidMount(){
        /* this.setState({
            beans: JSON.parse(localStorage.getItem("beans"))
       }) */
       debugger
    }
    render() {
        return (
            <div>
                <UserHomeNavbar func={this.updatedValue} name={localStorage.getItem("username")} />
                <div className='row'>
                    <div className='col-md-12 card '>
                        <table className='table table-striped'>
                            <thead>
                                <tr>
                                    <th>Employee Id</th>
                                    <th>Employee Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.beans.map((bean) => {
                                        return (
                                            <tr key={bean.id}>
                                                <th>{bean.id}</th>
                                                <td>{bean.name}</td>

                                            </tr>
                                        )
                                    })
                                }

                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        )
    }
}