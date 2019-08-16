import React, { Component } from 'react'
import Axios from 'axios';

export class HomePage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: '',
            password: ''
        }
    }
    render(){
        return(
            <div>
                Hello
            </div>
        )
    }
}