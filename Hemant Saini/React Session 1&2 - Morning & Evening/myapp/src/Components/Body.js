import React from 'react';
import logo from './logo.svg';

const Body = () =>{
    return (
        <div>
            Body Component :
            <img src={logo} className="App-logo" alt="logo" />
            <p>
            Edit <code>src/App.js</code> and save to reload.
            </p>
            <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
            >
            Learn React
            </a>
        
        </div>
    );
};

export default Body;