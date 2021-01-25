import './App.css';
import HeaderComponent from './Components/HeaderComponents/header'
import Logo from './Components/HeaderComponents/Logo';
import Body from './Components/HeaderComponents/body'

function App() {
  return (
    <div className="App">
      <HeaderComponent></HeaderComponent>
      <header className="App-header">
        <Logo/>
        <Body/>
      </header>
    </div>
  );
}

export default App;
