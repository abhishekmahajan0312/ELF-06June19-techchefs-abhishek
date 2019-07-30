import React, { Component } from 'react';
// import TodoList from './Components/TodoList.jsx'
// import TodoItems from './Components/TodoItems';
// import DottedBox from './Components/DottedBox';
// import BootstrapComponent from './Components/BootstrapComponent';
// import {} from '../public/img/img1'
 import img from './assets'
import BsCarousel from './assignment/BsCarousel';
class App extends Component {
  inputElement = React.createRef()
  constructor() {
    super();
    const path = require('./assets/1.jpg')
    this.state = {
      items: [{img},'https://cdn.pixabay.com/photo/2019/07/06/03/26/yellowstone-4319675__340.jpg','https://cdn.pixabay.com/photo/2019/07/26/15/18/macro-4364962__340.jpg']
    };
  }
  
  render() {
    return (
      
      <div className="App">
        
       <img src={path} />
        {
        <BsCarousel images={this.state.items}/>
        }
      </div>
    )
  }
}

export default App;
