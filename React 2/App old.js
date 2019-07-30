import React, { Component } from 'react';
// import TodoList from './Components/TodoList.jsx'
// import TodoItems from './Components/TodoItems';
// import DottedBox from './Components/DottedBox';
// import BootstrapComponent from './Components/BootstrapComponent';
import BsCarousel from './assignment/BsCarousel';
class App extends Component {
  inputElement = React.createRef()
  constructor() {
    super();
    this.state = {
      items: [],
      currentItem: { text: '', key: '' },
      color: 'green',
    };
  }
  handleInput = e => {
    const itemText = e.target.value
    console.log(itemText);
    const currentItem = { text: itemText, key: Date.now() }
    this.setState({ currentItem,color: 'red' })
    if(itemText===""){
      this.setState({ color: 'green' })
    }
    
  }


  addItem = e => {
    e.preventDefault()
    const newItem = this.state.currentItem
    if (newItem.text !== "") {
      console.log(newItem)
      const items = [...this.state.items, newItem]
      this.setState({
        items: items,
        currentItem: { text: '', key: '' },
      color:'green'
      })

    }

    console.log('Hello Add Item')
  }

  deleteItem = key => {
    const filteredItems = this.state.items.filter(item => {
      return item.key !== key
    })
    this.setState({
      items: filteredItems,
    });
  }
  render() {
    return (
      <div className="App">
        { <TodoList addItem={this.addItem}
          inputElement={this.inputElement}
          handleInput={this.handleInput}
          currentItem={this.state.currentItem} 
          bgColor = {this.state.color}/>
        <TodoItems entries={this.state.items} deleteItem={this.deleteItem} />
        <DottedBox/>
        <BootstrapComponent /> 
        // <BsCarousel images />
        }
      </div>
    )
  }
}

export default App;
