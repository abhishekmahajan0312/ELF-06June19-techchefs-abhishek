const name = "Abhishek"
const element = <h1> {name} </h1>

function Welcome(props) {
    return ( 
        <div>
        <h1 style={{color: 'red'}}> {props.name} </h1>
        {/* <button onClick={()=>alert('Button')}>Click</button> */} {/* This is 1st way to create an event on button*/}
        <button onClick={alert.bind(this,'This is Button')}>Click</button> {/* This is 2nd way to create an event on button*/}
        </div>
    )
}

class Message extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            name: 'Akshay'
        }
        // this.changeMessage = this.changeMessage.bind(this);
        this.clickLink = this.clickLink.bind(this);
    }

    changeMessage = ()=>{
        console.log("Change Message Method")
        this.setState({
            name: "Abhishek" 
        }) 
    }

    clickLink(event){
        event.preventDefault();
    }
    render(){
        console.log("Rendering");
        return(
            <div>
                <h1>{this.state.name}</h1>
                <h2>Render</h2>
                <button onClick={this.changeMessage}>Change Message</button>
                <a href="https://www.google.com" onClick={this.clickLink}>Link</a>
            </div>
        )
    }
}
// ReactDOM.render( < Welcome name="Abhishek" /> , document.getElementById('app'));
ReactDOM.render( < Message /> , document.getElementById('app'));