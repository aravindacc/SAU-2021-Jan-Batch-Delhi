import react from 'react';
import logo from "./logo.svg";

const displaySum = ({sum}) => {
    return <div>Sum is : {sum}</div>;
}

const Logo = function(){
    const name = "Hemant";
    const sum = 20;
    return(
        <div>
            <img src = {logo} className="App-logo" alt = "logo"/>
            <span>{name}</span>
            {sum === 20 ? <displaySum sum = {sum}></displaySum> : null}
        </div>
        );

    
};

export default Logo;