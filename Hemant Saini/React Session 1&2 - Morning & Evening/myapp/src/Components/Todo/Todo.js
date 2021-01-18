import React from "react";
import TodoInput from "./TodoInput";
import "./style.css";
import Todolist from "./TodoList";

class Todo extends React.Component {
  state = {
    todo: "",
    todos: [
      {id : 1, value :{ todo: "First todo", marked: false}},
      {id : 2, value :{ todo: "Second todo", marked: true}},
    ],
    title: "Todo Original List",
    filter : "",
    cacheTodos : []
  };

  handleOnChange = (event) => {
    this.setState({ todo: event.target.value });
  };


  addTask = () => {
    const { todo, todos } = this.state;

    const newTodos = [...todos];

    if (todo !== "") {
      var lastId = (newTodos.length == 0) ? -1 :(newTodos[newTodos.length-1].id);
      var newId = lastId + 1;
      newTodos.push({id : newId, value:{ todo: todo, marked: false }});
      this.setState({ todos: newTodos, todo: "" });
    }
  };

  /*
  markAsCompleted = (event, index) => {
    const { todos } = this.state;

    const newTodos = [...todos];

    newTodos[index] = {
      ...newTodos[index],
      marked: event.target.checked,
    };

    this.setState({ todos: newTodos });
  };
  
  
  showAll = () => {
    const {todos} = this.state;
    const filteredTodosNew = [...todos];
    this.setState({filteredTodos : filteredTodosNew});
  };

  showCompleted = () => {
      const {todos} = this.state;
      const filteredTodosNew = [];
      todos.forEach((todo) => {
        if(todo.marked)
            filteredTodosNew.push(todo);
      });
      this.setState({filteredTodos : filteredTodosNew});
  }

  showPending = () => {
    const {todos} = this.state;
    const filteredTodosNew = [];
    todos.forEach((todo) => {
      if(!todo.marked)
          filteredTodosNew.push(todo);
    });
    this.setState({filteredTodos : filteredTodosNew});
  }
  */
  
  showCompleted = () => {
    this.setState({filter:"showCompleted"});
  }
  showAll = () => {
    this.setState({filter:"showAll"});
  }
  showPending = () => {
    this.setState({filter:"showPending"});
  }

  deleteTodoFromList = (id) => {
    const newTodos = this.state.todos;
    var indexOfTodoToBeDeleted = 0;
    while(indexOfTodoToBeDeleted < newTodos.length){
        if(newTodos[indexOfTodoToBeDeleted].id === id){ break; }
        indexOfTodoToBeDeleted++;
    }
    newTodos.splice(indexOfTodoToBeDeleted, 1);
    this.setState({todos : newTodos});
  }

  duplicateTodo = (id) => {
    const newTodos = this.state.todos;
    var indexOfTodoToBeDuplicated = 0;
    while(indexOfTodoToBeDuplicated < newTodos.length){
        if(newTodos[indexOfTodoToBeDuplicated].id === id){ break; }
        indexOfTodoToBeDuplicated++;
    }
    var lastId = newTodos[newTodos.length-1].id;
    var newId = lastId + 1;
    newTodos.push({id : newId, value:{ todo: newTodos[indexOfTodoToBeDuplicated].value.todo, marked: newTodos[indexOfTodoToBeDuplicated].value.marked }});
    this.setState({ todos: newTodos, todo: "" });
  }

  markAsCompleted2 = (event, id) =>{
    const { todos } = this.state;
    const newTodos = [...todos];
    var indexOfTodoToBeUpdated = 0;
    while(indexOfTodoToBeUpdated < newTodos.length){
        if(newTodos[indexOfTodoToBeUpdated].id === id){ break; }
        indexOfTodoToBeUpdated++;
    }
    //console.log("Index : "+ indexOfTodoToBeUpdated);
    //console.log("before" + newTodos[indexOfTodoToBeUpdated].value.marked);
    newTodos[indexOfTodoToBeUpdated].value.marked = event.target.checked;
    //console.log("after" + newTodos[indexOfTodoToBeUpdated].value.marked);
    this.setState({ todos: newTodos });
  }



  render() {
    return (
      <div className="TodoContainer">
        <h1 className="Header Header-Main">Todo Application</h1>
        <TodoInput
          taskPlaceholder="Add new Task"
          value={this.state.todo}
          onChange={this.handleOnChange}
        />
        
        <div>
            <button onClick={this.addTask}>Add Task</button>
            <button onClick={this.showAll}>Show all</button>
            <button onClick={this.showCompleted}>Completed</button>
            <button onClick={this.showPending}>Pending</button>
        </div>
        
        
        <Todolist
          title="Todo Show All List"
          todos={this.state.todos}
          filter={this.state.filter}
          markTaskAsCompleted={this.markAsCompleted2}
          deleteTodo={this.deleteTodoFromList}
          duplicateTodo={this.duplicateTodo}
        />

      </div>
    );
  }
}

export default Todo;
