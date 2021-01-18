import logo from './logo.svg';
import './App.css';
import Header from "./Components/Header";
import Logo from './Components/Logo';
import Body from "./Components/Body";

import Todo from "./Components/Todo/Todo";
import TodoInput from "./Components/Todo/TodoInput";

function App() {
  return (
    <div className="App">
      <Header></Header>
      <header className="App-header">
        <Logo/>
      </header>
      <Body></Body>
    </div>
  );
}

export default App;


/**
 * 
 */