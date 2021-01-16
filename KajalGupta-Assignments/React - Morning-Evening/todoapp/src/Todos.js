import React from 'react'

const Todos = ({todos, deleteTodo, markCompleted, duplicate, filterBy}) => {

    var todoList;
    if (filterBy==='pending') {
        todoList = todos.filter(todo => {
          return todo.completed === false;
        });
      }
    else if(filterBy==='completed') {
    todoList = todos.filter(todo => {
        return todo.completed === true;
      });
    }
    else{
        todoList = [...todos];
    }

     todoList = todoList.length ? (
        todoList.map((todo, index) => {
            return (
            <div className="collection-item task-row" key={todo.id} style={ todo.completed ? { textDecoration: "line-through" }: {}}>
                <span onClick={() => {markCompleted(index)}}>{todo.content}</span>
                <button className="waves-effect waves-light btn-small delete-button" onClick={() => {deleteTodo(todo.id)}}>Delete</button>
                <button className="waves-effect waves-light btn-small duplicate-button" onClick={() => {duplicate(index)}}>Duplicate</button>
                    
            </div>
            )
        })
    ) : (
            <p className="center">You have no todo's left, yay!</p>
    )


    return(
        <div className="todos collection">
            {todoList}
        </div>
    )
}

export default Todos