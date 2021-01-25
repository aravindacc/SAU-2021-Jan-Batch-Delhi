import React from "react";
import TodoInput from "./TodoInput";
import "./styles.css";
import Todolist from "./TodoList";

class Todo extends React.Component {
  state = {
    todo: "",
    todos: [
      { todo: "first todo", marked: false, delete: false },
      { todo: "2nd todo", marked: true, delete: false },
    ],
    title: "My tasks",
    filterBy: "show all",
  };

  handleOnChange = (event) => {
    this.setState({ todo: event.target.value });
  };

  filterData = () => { };

  addTask = () => {
    const { todo, todos } = this.state;

    const newTodos = [...todos];

    if (todo !== "") {
      newTodos.push({ todo: todo, marked: false });
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


  // Task Deleting Function
  deleteTask = (index) => {
    const { todos } = this.state;
    const deleteTodo = todos[index];

    const newTodoList = todos.filter(todo => {
      return todo !== deleteTodo
    })

    this.setState({ todos: newTodoList });
  }

  // Task Duplicating Function
  duplicateTask = (todo) => {
    var { todos } = this.state;

    todos.push({ todo: todo, marked: false });
    this.setState({ todos: todos, todo: "" });
  }

  changeFilterBy = (filterName) => {
    this.setState({ filterBy: filterName });
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
        <button onClick={() => { this.changeFilterBy('show all') }}>Show all</button>
        <button onClick={() => { this.changeFilterBy('completed') }}>Completed</button>
        <button onClick={() => { this.changeFilterBy('pending') }}>Pending</button>
        <Todolist
          title={this.state.title}
          todos={this.state.todos}
          filterBy={this.state.filterBy}
          markTaskAsCompleted={this.markTaskAsCompleted}
          deleteTask={this.deleteTask}
          duplicateTask={this.duplicateTask}
        />
      </div>
    );
  }
}

export default Todo;
