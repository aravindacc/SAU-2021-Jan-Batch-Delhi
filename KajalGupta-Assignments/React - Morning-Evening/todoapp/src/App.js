import React, { Component } from 'react';
import Todos from './Todos'
import AddToDo from './AddToDo'


class App extends Component{
  state = {
    todos: [
      {id:1, content:'buy some milk', completed:false}
    ],
    filterBy:'all'
  }

  handleChange = (e) => {
    this.setState({
        filterBy : e.target.value
    })
  }

  deleteTodo = (id) =>{
    const todos = this.state.todos.filter(todo => {
      return todo.id !==id
    });
    this.setState({
      todos
    })
  }

  addToDo = (todo) => {

    todo.id = Math.random();
    let todos = [...this.state.todos, todo];
    this.setState({
      todos
    })

  }

  duplicate = (index) => {

    let newTodo = Object.assign({}, this.state.todos[index]);
    newTodo.completed = false;
    newTodo.content = this.state.todos[index].content;
    newTodo.id = Math.random();
    let todos = [...this.state.todos, newTodo];
    this.setState({
      todos
    })

  }

  markCompleted = (index) => {

    const { todos } = this.state;
    const newTodos = [...todos];
    newTodos[index] = {
      ...newTodos[index],
      completed:true,
    };
    this.setState({ todos: newTodos });
  };
     
  
  render(){
    return(
      <div className="to-app my-container ">
        <h1 className="center blue-text">Todo's </h1>
          <table>
            <tr>
              <td>
                Filter by :
              </td>
              <td>
              <select className='dropdown-trigger btn' id="filter" name="filter" onChange={this.handleChange}>
                    <option value="all">Show all</option>
                    <option value="completed">Completed</option>
                    <option value="pending">Pending</option>   
                </select>
              </td>
            </tr>
          </table>
        
        <Todos todos={this.state.todos} deleteTodo={this.deleteTodo} markCompleted={this.markCompleted} duplicate={this.duplicate} filterBy={this.state.filterBy}/>
        <AddToDo addToDo={this.addToDo}/>
      </div>
    )
  }

}


export default App;
