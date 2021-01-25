import React from "react";
import TodoInput from "./TodoInput";
import "./styles.css";
import Todolist from "./TodoList";

class Todo extends React.Component {
  state = {
    todo: "",
    todos: [
      { todo: "Home Work", marked: false, 
      delete: false },
      { todo: "Project Work", marked: true,
       delete: false },
      { todo: "Assignment", marked: false,
       delete: false },
      
    ],
    title: "My tasks",
    searchAll: "Show all",
  };

  handleOnChange = (event) => {
    this.setState({ todo: event.target.value });
  };

  addTask = () => {
    const { todo, todos } = this.state;

    const newTodos = [...todos];

    if (todo !== "") {
      newTodos.push({ todo: todo, marked: false });

      this.setState({ todos: newTodos, todo: "" });
    }
  };

  deleteButton = (index)=>{
    const { todos } = this.state;
    const deletedTodo = todos[index];

    const newTodos = todos.filter(
      todo => todo!==deletedTodo
    )
    
    this.setState({ todos: newTodos, todo: "" });
  };

  markTaskAsCompleted = (event, index) => {
    const { todos } = this.state;

    const newTodos = [...todos];

    newTodos[index] = {
      ...newTodos[index],
      marked: event.target.checked,
    };

    this.setState({ todos: newTodos });
  };

  
  

  
  

  
  duplicateButton = (todo)=>{
    const { todos } = this.state;

    const newTodos = [...todos];

    if (todo !== "") {
      newTodos.push({ todo: todo, marked: false });
      this.setState({ todos: newTodos, todo: "" });
    }
  }


  changeFilter = (selectedFilter)=>{
    
    this.setState({searchAll:selectedFilter});
  }

  render() {
    return (
      <div style={{margin:10}} className="TodoContainer">
        <h1 className="Header Header-Main">
        {this.props.title}</h1>
        <TodoInput
          taskPlaceholder="Add new Task"
          value={this.state.todo}
          onChange={this.handleOnChange}
        />
        <button style={{margin:10,backgroundColor:'green'}}
         onClick={this.addTask}>Add Task</button>
        
        <button style={{margin:10,backgroundColor:'green'}}
         onClick={()=>{this.changeFilter("Pending")}}>Pending</button>
        <button style={{margin:10,backgroundColor:'green'}}
         onClick={()=>{this.changeFilter("Completed")}}>
         Completed</button>

        <button style={{margin:10,backgroundColor:'green'}} 
        onClick={()=>{this.changeFilter("Show all")}}>
        Show all</button>
        
        <Todolist
          title={this.state.title}
          todos={this.state.todos}
          searchAll={this.state.searchAll}
          markTaskAsCompleted={this.markTaskAsCompleted}
          deleteButton={this.deleteButton}
          duplicateButton={this.duplicateButton}
        />
      </div>
    );
  }
}

export default Todo;
