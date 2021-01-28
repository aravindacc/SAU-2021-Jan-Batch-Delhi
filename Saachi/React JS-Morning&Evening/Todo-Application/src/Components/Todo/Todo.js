import React from "react";
import TodoInput from "./TodoInput";
import "./styles.css";
import Todolist from "./TodoList";
import FilterTodo from './FilterTodo'

class Todo extends React.Component {
  state = {
    todo: "",
    todos: [
      {id:101, todo: "Fill up the Form", marked: false, delete: false },
      {id:102, todo: "Comlpete Assignments", marked: true, delete: false },
    ],
    title: "My tasks",
    filterBy:'allTasks'
  };

  handleAddTask = (event) => {
    this.setState({ todo: event.target.value });
  };

  handleFilterChange = (event) => {
    this.setState({
        filterBy : event.target.value
    })
  }

  addTask = () => {
    const { todo, todos } = this.state;
    todos.id=Math.random();
    const newTodos = [...todos];
    if (todo !== "") {
      newTodos.push({ todo: todo, marked: false });
      this.setState({ todos: newTodos, todo: "" });
    }
  }

  deleteTask = (id) =>{
    const todos = this.state.todos.filter(todo => {
      return todo.id !==id
    });
    this.setState({
      todos
    })
  }

  duplicate = (index) => {
    const newTodos= Object.assign({}, this.state.todos[index]);
    newTodos.completed = false;
    newTodos.content = this.state.todos[index].content;
    newTodos.id = Math.random();
    const todos = [...this.state.todos, newTodos];
    this.setState({
      todos
    })
  }

  markTaskAsCompleted = (event, index) => {
    const { todos } = this.state;
    const newTodos = [...todos];
    newTodos[index] = {
      ...newTodos[index],
      marked: event.target.checked,
    };
    this.setState({ todos: newTodos });
  };

  render() {
    return (
      <div className='container'>
        <h1 className='mainheading'>Todo Application </h1>
        <h3 className='heading'>Submitted by- Saachi</h3>
          <h3 className='heading'>saachi.r@accolitedigital.com</h3>
           <div className='dropDown'>
              <label for="Filter"> Filter by :</label>
              <select className="browser-default" ref="ballManipuation" onChange={this.handleFilterChange}>
                    <option value="allTasks">Show all tasks</option>
                    <option value="completedTasks">Completed tasks</option>
                    <option value="pendingTasks">Pending tasks</option>   
                </select>
            </div>
        <div className='todoSection'>
        <FilterTodo todos={this.state.todos} deleteTodo={this.deleteTask} duplicate={this.duplicate} filterBy={this.state.filterBy}/></div>
        <div className='addTaskSection'>
        <table ><tr><td>
        <TodoInput
          taskPlaceholder="Add new Task"
          value={this.state.todo}
          onChange={this.handleAddTask}/></td><td>
        <button className='add-task-button' onClick={this.addTask}>Add Task</button></td></tr></table>
        <p className='listSection'>All tasks list : </p>
        <Todolist 
          title={this.state.title}
          todos={this.state.todos}
          filterBy={this.state.filterBy}
          markTaskAsCompleted={this.markTaskAsCompleted}
        />
        </div>
      </div>
    );
  }
}

export default Todo;
