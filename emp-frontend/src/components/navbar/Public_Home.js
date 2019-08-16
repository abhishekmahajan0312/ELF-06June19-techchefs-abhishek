import React from 'react'
import { BrowserRouter as Router, Route, Link } from 'react-router-dom'
import { Login } from '../login/Login'
import { HomePage } from '../homePage/HomePage'
import { SearchEmployee} from '../searchEmployee/SearchEmployee'
export const PublicHome = (props) => {
    return (
        <Router>
            <Route exact path="/" component={Login} />
            <Route exact path="/homePage" component={HomePage}/>
            <Route exact path="/searchEmployee" component={SearchEmployee}/>
            {/* <Route exact path="/info" component={Info}/> */}
        </Router>
    )
}