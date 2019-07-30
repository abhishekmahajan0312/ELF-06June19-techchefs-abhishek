import React, { Component } from 'react';
import Button from 'react-bootstrap/Button';
class BootstrapComponent extends Component {
    render() {
        return (
            <div>
                <Button variant="danger">Primary</Button>
                <Button variant="success">Success</Button>
            </div>
        )
    }
}
export default BootstrapComponent