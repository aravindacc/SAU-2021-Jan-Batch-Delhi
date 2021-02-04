import React from "react";
import "./App.css";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      newItem: "",
      list: []
    };
  }

  addItem(todoValue) {
    if (todoValue !== "") {
      const newItem = {
        id: Date.now(),
        value: todoValue,
        isDone: false,
        show:false,
      };
      const list = [...this.state.list];
      list.push(newItem);

      this.setState({
        list,
        newItem: ""
      });
      alert("Task Added Successfully.");
    }
  }

  deleteItem(id) {
    const list = [...this.state.list];
    const updatedlist = list.filter(item => item.id !== id);
    this.setState({ list: updatedlist });
  }

  updateInput(input) {
    this.setState({ newItem: input });
  }

  updateItem(input){
    const list = [...this.state.list];
    list.forEach(item => {
      if(item.id===input){
        const val = item.value;
        this.addItem(val);
      }
    });

  }


  markItem(input){
    const list = [...this.state.list];
    list.forEach(item => {
      if(item.id===input){
        if(item.isDone){
          item.isDone = false;
        }
        else{
          item.isDone = true;
        }
        
      }
    });
    this.setState({
      list
    });

  }

  showMarkItem(){
    const list = [...this.state.list];
    list.forEach(item => {
      if(item.isDone===true){
        item.show = true;
      }
      else{
        item.show = false;
      }
    });
    this.setState({
      list
    });
  }
  showUnMarkItem(){
    const list = [...this.state.list];
    list.forEach(item => {
      if(item.isDone===true){
        item.show = false;
      }
      else{
        item.show = true;
      }
    });
    this.setState({
      list
    });
  }
  showAllItem(){
    const list = [...this.state.list];
    list.forEach(item => {
        item.show = true;
    });
    this.setState({
      list
    });
  }

  render() {
    return (
      <div>
        <img src="data:image/jpeg;base64,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" width="150" height="120" className="logo" />
        <h1 className="app-title">ToDo App</h1>
        <div className="container">
          Add an Item....
          <br />
          <input
            type="text"
            className="input-text"
            placeholder="Write a Todo"
            required
            value={this.state.newItem}
            onChange={e => this.updateInput(e.target.value)}
          />
          <button
            className="add-btn"
            onClick={() => this.addItem(this.state.newItem)}
            disabled={!this.state.newItem.length}
          >
            Add Todo
          </button>
          <div>
          <button
            className="add-btn"
            onClick={() => this.showMarkItem()}
          >
            Marked
          </button>
          <button
            className="add-btn"
            onClick={() => this.showUnMarkItem()}
          >
            Unmarked
          </button>
          <button
            className="add-btn"
            onClick={() => this.showAllItem()}
          >
            Show All
          </button>
          </div>
          <div className="list">
            <ul>
              {this.state.list.map(item => {
                if(item.show==false){
                  return null;
                }
                return (
                  <li key={item.id}>
                    <input
                      type="checkbox"
                      name="idDone"
                      checked={item.isDone}
                      onChange={() => this.markItem(item.id)}
                    />
                    {item.value}
                    <button
                      className="btn"
                      onClick={() => this.deleteItem(item.id)}
                    >
                      Delete
                    </button>
                    <button
                      className="btn"
                      onClick={() => this.updateItem(item.id)}
                    >
                      Duplicate
                    </button>
                  </li>
                );
              })} 
            </ul>
          </div>
        </div>
      </div>
    );
  }
}

export default App;
