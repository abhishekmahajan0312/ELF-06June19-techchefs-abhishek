function Header(props){
    console.log(props);
    return React.createElement("h1",null,"Header");
}
function Footer(){
    return React.createElement("h1",null,"Footer");
}
function Content(){
    return React.createElement("p",null,"Content");
}
const header = React.createElement(Header,{item:['bag']});
const content = React.createElement(Content);
const footer = React.createElement(Footer);
const divElement = React.createElement('div',null,header,content,footer);
ReactDOM.render(divElement,document.getElementById('app'));