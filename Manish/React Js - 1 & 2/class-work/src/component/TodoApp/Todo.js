import React from "react";
import TodoInput from "./TodoInput";
import "./style.css";
import TodoList from "./TodoList";

class Todo extends React.Component {
  // state of app
  state = {
    todos: [
      {
        todo: "Todo 1",
        marked: true,
        show: true,
      },
      {
        todo: "Todo 2",
        marked: false,
        show: true,
      },
      {
        todo: "Todo 3",
        marked: true,
        show: true,
      },
    ],
    title: "My tasks",
    todo: "",
  };

  // when something is typed in input box
  handleChange = (event) => {
    this.setState({ todo: event.target.value });
  };

  // when add  button is pressed
  addTodos = () => {
    const { todos, todo } = this.state;

    if (todo === "") {
      return;
    }

    const newTodos = [...todos];
    const newTodo = {
      todo,
      marked: false,
      show: true,
    };

    newTodos.push(newTodo);

    this.setState({todos: newTodos});
    this.setState({todo:""})
  };

  // when checkbox is toggled
  markTask = (index) => {
    const newTodos = [...this.state.todos];

    newTodos[index].marked = !newTodos[index].marked;

    this.setState({ todos: newTodos });
    console.log(
      `Toogling task ${!this.state.todos[index].marked} to ${
        this.state.todos[index].marked
      }`
    );
  };

  // when delete button is pressed
  deleteTodo = (index) => {
    console.log(`deleting todo at index ${index}`);
    let newTodos = [...this.state.todos];

    newTodos = newTodos.filter((todo, ind) => ind !== index);

    this.setState({ todos: newTodos });
  };

  // when duplicate button is pressed
  duplicateTodo = (index) => {
    console.log(`making duplicate of todo at index ${index}`);
    const newTodos = [...this.state.todos];

    const newTodo = JSON.parse(JSON.stringify(newTodos[index]));
    newTodo.marked = false;

    newTodos.push(newTodo);

    this.setState({ todos: newTodos });
  };

  // apply filer
  applyFiler = (type) => {
    const todos = [...this.state.todos];

    const newTodos = todos.map((todo) => {
      if (type === "completed") {
        todo.show = todo.marked;
      } else if (type === "pending") {
        todo.show = !todo.marked;
      } else {
        todo.show = true;
      }
      return todo;
    });

    this.setState({ todos: newTodos });
  };

  render() {
    return (
      <div className="todo-container">
        <h1 className="header">Todo App</h1>

        <TodoInput
          placeHolder="Add new task"
          value={this.state.todo}
          onChange={this.handleChange}
        />

        <div className="buttons">
          <button onClick={this.addTodos}>Add task</button>
          <button onClick={() => this.applyFiler("all")}>All tasks</button>
          <button
            onClick={() => {
              this.applyFiler("pending");
            }}
          >
            Pending
          </button>
          <button
            onClick={() => {
              this.applyFiler("completed");
            }}
          >
            Completed
          </button>
        </div>

        <TodoList
          deleteTodo={this.deleteTodo}
          todos={this.state.todos}
          markTask={this.markTask}
          duplicateTodo={this.duplicateTodo}
        />
      </div>
    );
  }
}

export default Todo;
