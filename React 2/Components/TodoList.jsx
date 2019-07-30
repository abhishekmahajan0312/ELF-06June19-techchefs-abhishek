import React, {Component} from 'react'



class ToDoList extends Component{
    componentDidUpdate(){
        this.props.inputElement.current.focus()
    }
    render(){
        return(
            <div className="todoListMain">
                <div className="header">
                    <form onSubmit={this.props.addItem}>
                        <input placeholder="Task"
                                ref={this.props.inputElement}
                                value= {this.props.currentItem.text}
                                onChange={this.props.handleInput}
                                style={{backgroundColor:this.props.bgColor}}
                        />
                        <button className='btn btn-success' type="submit">Add Task</button>
                    </form>
                </div>
            </div>
        )
    }
}
export default ToDoList