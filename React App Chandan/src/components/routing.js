import { Route, Link, BrowserRouter } from 'react-router-dom'
import React from 'react'
import Home from './Home'
import User from './User'
import UserDetail from './UserDetail'
const routing = (
    <BrowserRouter>
        <ul>
            <li>
                <Link to="/">Home</Link>
            </li>
            <li>
                <Link to="/user">User</Link>
            </li>
            <li>
                <Link to="/contact">UserDetail</Link>
            </li>
        </ul>
        <div>
            <Route exact path="/" component={Home} />
            <Route path="/user" component={User} />
            <Route path="/contact" component={UserDetail} />
        </div>
    </BrowserRouter>
)

export default routing