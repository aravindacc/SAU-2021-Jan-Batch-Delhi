// Parent of Todo.js
import React from 'react'
import Todo from "./Todo"

const TodoList = ({ todos,setTodos, filteredTodos }) => {
    // console.log(filteredTodos)  
    return ( 
        <div className="todo-container">
        <ul className="todo-list">
            {                               //writing js code in jsx
                filteredTodos.map(todo => (         //iterate for n times | n : todo's size      
                    <Todo 
                        setTodos ={setTodos} 
                        todos={todos}   //passing all todos
                        todo={todo}      //pasing single todo
                        key={todo.id}  //giving to fix error in react 
                        text = {todo.text} 
                    />
                ))
            }
        </ul>
        
      </div>
    )
}

export default TodoList;