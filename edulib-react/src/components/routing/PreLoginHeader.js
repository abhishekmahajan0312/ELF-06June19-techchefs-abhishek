import React from 'react'
import { BrowserRouter as Router, Route} from 'react-router-dom'
import Login  from '../login/Login'
import { AdminHomePage } from '../homepage/AdminHomePage'
import AddUser from '../createaccount/AddUser';
import UserHomePage from '../homepage/UserHomePage';
import BookPage from '../homepage/BookPage';
import LibrarianHomePage from '../homepage/LibrarianHomePage';
import IssueRequests from '../homepage/IssueRequests';
import AddBook from '../createaccount/AddBook';
import ViewBooks from '../createaccount/ViewBooks';
import SearchBook from '../createaccount/SearchBook';
// import { SearchEmployee} from '../searchEmployee/SearchEmployee'
export const PreLoginHeader = (props) => {
    return (
        <Router>
            <Route exact path="/" component={Login} />
            <Route exact path="/adminHome" component={AdminHomePage} />
            <Route exact path="/addUser" component={AddUser} />
            <Route exact path="/addBook" component={AddBook} />
            <Route exact path="/home" component={UserHomePage} />
            <Route exact path="/displayBook" component={BookPage}/>
            <Route exact path="/libraryHome" component={LibrarianHomePage}/>
            <Route exact path="/issueRequests" component={IssueRequests}/>
            <Route exact path="/viewBooks" component={ViewBooks}/>
            <Route exact path="/searchBook" component={SearchBook}/>
        </Router>
    )
}