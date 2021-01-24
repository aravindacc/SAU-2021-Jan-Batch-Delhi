import React from "react";
import TodoInput from "./TodoInput";
import "./styles.css";
import Todolist from "./TodoList";
import {v4 as uuid} from 'uuid';

class Todo extends React.Component {
  state = {
    todo: "",
    todos: [
      { id: uuid(), todo: "first todo", marked: false, delete: false },
      { id: uuid(), todo: "2nd todo", marked: true, delete: false },
    ],
    title: "My tasks",
    filterBy: "All",
  };

  handleOnChange = (event) => {
    this.setState({ todo: event.target.value });
  };

  filterData = () => {};

  delTodo = (id) => {

    this.setState({
      todos: [...this.state.todos.filter(todo => 
        todo.id !== id)]
    });
  }

  duplicateTodo = (id) =>{
    
    const { todos } = this.state;

      const newTodos = [...todos];
      
      const newtodo = {
        id: uuid(),
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
      newTodos.push({ id: uuid(), todo: todo, marked: false });
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

  changeFilter = (e) =>{
    console.log(e.target.value);
    this.setState({
      filterBy : e.target.value
    });
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
        <button className = "filterButton" onClick={this.addTask}>Add Task</button>
        <button className = "filterButton" onClick = {this.changeFilter} value = 'all'>Show all</button>
        <button className = "filterButton" onClick = {this.changeFilter} value = 'completed'>Completed</button>
        <button className = "filterButton" onClick = {this.changeFilter} value = 'pending'>Pending</button>
        <Todolist
          title={this.state.title}
          todos={this.state.todos}
          filterBy={this.state.filterBy}
          markTaskAsCompleted={this.markTaskAsCompleted}
          delTodo = {this.delTodo}
          duplicateTodo = {this.duplicateTodo}
          
        />
      </div>
    );
  }
}

export default Todo;
