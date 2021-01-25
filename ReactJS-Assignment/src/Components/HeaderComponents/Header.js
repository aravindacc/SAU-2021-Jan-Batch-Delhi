import React from "react";
import logo from "./logo.svg";

class Header extends React.Component {
  render() {
    return (
      <div>
        <h1>Header Component</h1>
        <img src={logo} />
      </div>
    );
  }
}

export default Header;