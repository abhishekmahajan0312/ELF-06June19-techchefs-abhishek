class Lifecycle extends React.Component {
    constructor(props) {
        super(props)
        console.log("constructor lifecycle")
        this.state = {
            name: 'Abhishek',
            checked: true
        }
    }
    static getDerivedStateFromProps() {
        console.log("GetDerivedStateFromProps Lifecycle");
        return null;
        // return { name1: 'Mahajan'}
    }
    render() {
        console.log("Render Lifecycle");
        if (this.state.checked) {
            return (
                <div>
                    <h1>{this.state.name}</h1>
                    <h1>{this.state.name1}</h1>
                    <button onClick={this.changeName.bind(this)}>Change Name</button>
                
                <Child />
                </div>
            )
        }
        return <h1> checked is false</h1>
        // return null

    }
    componentDidMount() {
        console.log("Component Did Mount Lifecycle");

    }
    shouldComponentUpdate() {
        console.log('Should Component Update Lifecycle');
        return true;
    }
    getSnapshotBeforeUpdate() {
        console.log('Snapshot Before Update Lifecycle');
        // return null;
        return "Snapshot Data";
    }
    componentDidUpdate(props, state, snapshot) {
        console.log("Component Updated Lifecycle");
        console.log("Snapshot::::" + snapshot);
    }
    changeName() {
        this.setState({
            name: 'Mahajan'
        })
    }
}
class Child extends React.Component {
    constructor(props) {
        super(props)
        console.log("constructor Child")
        this.state = {
            name: 'Abhishek',
            checked: true
        }
    }
    static getDerivedStateFromProps() {
        console.log("GetDerivedStateFromProps Child");
        return null;
        // return { name1: 'Mahajan'}
    }
    render() {
        console.log("Render Child");
        if (this.state.checked) {
            return (
                <div>
                <h1> Child Component</h1>
                
                    <h1>{this.state.name}</h1>
                    <h1>{this.state.name1}</h1>
                    <button onClick={this.changeName.bind(this)}>Change Name</button>
                </div>
            )
        }
        return <h1> checked is false</h1>

    }
    componentDidMount() {
        console.log("Component Did Mount Child");

    }
    shouldComponentUpdate() {
        console.log('Should Component Update Child');
        return true;
    }
    getSnapshotBeforeUpdate() {
        console.log('Snapshot Before Update Child');
        return null;
        // return "Snapshot Data";
    }
    componentDidUpdate(props, state, snapshot) {
        console.log("Component Updated Child");
        console.log("Snapshot::::" + snapshot);
    }
    changeName() {
        this.setState({
            name: 'Mahajan'
        })
    }
}
ReactDOM.render(<div><Lifecycle /></div>, document.getElementById("app"));