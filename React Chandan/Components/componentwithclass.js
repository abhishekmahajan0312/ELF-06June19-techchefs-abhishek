class Header extends React.Component {
    constructor(props){
        super(props);
        console.log(this.props);
    }
    render() {
        return React.createElement("h1", null, "Header");
    }
}
class Footer extends React.Component {
    render() {
        return React.createElement("h1", null, "Footer");
    }
}
class Content extends React.Component {
    constructor(props){
        super(props);
    }
    render() {
        return React.createElement("ul",null,this.props.item.map((value,index)=>{
            return React.createElement("li",{key:index},value);
        }))
        // return React.createElement("p", null, "Content");
    }
}
const items= ['bag','pencil','book'];
const header = React.createElement(Header, { item: ['bag'] });
const content = React.createElement(Content,{item: items});
const footer = React.createElement(Footer);
const divElement = React.createElement('div', null, header, content, footer);
ReactDOM.render(divElement, document.getElementById('app'));