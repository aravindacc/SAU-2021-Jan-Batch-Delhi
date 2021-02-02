// Parent of Form.js | TodoList.js

import React , { useState, useEffect } from 'react'
import "./App.css"
import Form from "./component/Form";
import TodoList from './component/TodoList'

function App() {
  
  // state stuff
  const [inputText, setInputText] = useState("");   //used for a particular todo 
  const [todos, setTodos] = useState([]);     //used for showing all todo list
  const [status,setStatus] = useState("all")    //used to set filter status 
  const [filteredTodos,setfilteredTodos] = useState([])
  

  // Run Only once when app starts
  useEffect(() => {
    getLocalTodos();
  },[]);      //empty array means ,run when app render
  // UseEffect  : it runs the function whenever state changes
  useEffect(() => {
    filterHandler();
    saveLocalTodos();
  }, [todos,status])     //second argument is telling on which state change u wnna run me


  // Function
  const filterHandler = () => {
    switch(status){
      case 'completed':
        setfilteredTodos(todos.filter(todo => todo.completed === true))
        break;
      case 'uncompleted':
        setfilteredTodos(todos.filter(todo => todo.completed === false))
        break;
      default:
        setfilteredTodos(todos)
        break;
    }  
  }

  // Save to local browser
  const saveLocalTodos = () => {
    localStorage.setItem("todos",JSON.stringify(todos));
  };
  const getLocalTodos = () => {
    if(localStorage.getItem("todos") === null)  {
      localStorage.setItem("todos",JSON.stringify([]));
    }
    else{
      let todoFromLocal = JSON.parse(localStorage.getItem("todos"));
      setTodos(todoFromLocal);
    }
  }



  return (
    <div className="App">
      <header>
         <h1>Aditi's Todo List</h1>
      </header>
      <Form 
        inputText = {inputText} 
        todos = {todos} 
        setTodos = {setTodos} 
        setInputText={setInputText}
        setStatus={setStatus}
      />
      <TodoList         
        filteredTodos={filteredTodos}   //passing filter todos based on selected filtered state
        setTodos ={setTodos} 
        todos={todos}
      />
    </div>
  );
} 

export default App;
