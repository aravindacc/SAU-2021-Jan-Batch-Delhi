import React from "react";
import TodoInput from "./TodoInput";
import "./styles.css";
import Todolist from "./TodoList";
import {v4 as uuid} from 'uuid';

class Todo extends React.Component {
  state = {
    todo: "",
    todos: [
      { id: 0, todo: "first todo", marked: false, delete: false },
      { id: 1, todo: "2nd todo", marked: true, delete: false },
    ],
    title: "Todo list webapp",
    filterBy: "All",
  };

  handleOnChange = (event) => {
    this.setState({ todo: event.target.value });
  };


  deleteTodofromList = (id) => {

    this.setState({
      todos: [...this.state.todos.filter(todo => 
        todo.id !== id)]
    });
  }

  duplicateTodoFromList = (id) =>{
    
    const { todos } = this.state;

      const newTodos = [...todos];
      
      const newtodo = {
        id: todos.length,
        todo: this.state.todos.filter(todo => todo.id === id)[0].todo,
        marked: false,
        delete: false
      }
      
      newTodos.push(newtodo);
      this.setState({ todos: newTodos, todo: "" });
  }

  addTask = () => {
    const { todo, todos } = this.state;

    const newTodos = [...todos];

    if (todo !== "") {
      newTodos.push({ id: todos.length, todo: todo, marked: false });
      this.setState({ todos: newTodos, todo: "" });
    }
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

  showCompleted = () => {
    this.setState({filterBy:"completed"});
  }
  showAll = () => {
    this.setState({filterBy:"all"});
  }
  showPending = () => {
    this.setState({filterBy:"pending"});
  }

  render() {
    return (
      <div className="TodoContainer">
        <h1 className="Header Header-Main">{this.props.title}</h1>
        <TodoInput
          taskPlaceholder="Add new Task"
          value={this.state.todo}
          onChange={this.handleOnChange}
        />
        <button onClick={this.addTask}>Add Task</button>
        <button onClick={this.showAll}>Show all</button>
        <button onClick={this.showCompleted}>Completed</button>
        <button onClick={this.showPending}>Pending</button>
        <Todolist
          title={this.state.title}
          todos={this.state.todos}
          filterBy={this.state.filterBy}
          markTaskAsCompleted={this.markTaskAsCompleted}
          deleteTodofromList = {this.deleteTodofromList}
          duplicateTodoFromList = {this.duplicateTodoFromList}
          
        />
      </div>
    );
  }
}

export default Todo;
