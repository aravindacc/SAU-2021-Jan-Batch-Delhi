import React from 'react';

const Todo = ({text, todo, setTodos, todos, inputText, setInputText}) => {
    const deleteHandler = () => {
        setTodos(todos.filter((el) => el.id !== todo.id));
    };
    const completeHandler = () => {
        setTodos(
            todos.map((item) => { 
                if(item.id === todo.id){
                    return {
                        ...item, 
                        completed: !item.completed,
                    };
                }
            return item;
            })
        );
    };
    const duplicateHandler = (todoItem) => {
        setTodos([
            ...todos, {text: todoItem.text, completed: false, id: Math.random() *1000}
        ]);
    };
    return(
        <div className="todo">
            <li className={`todo-item ${todo.completed ? "completed" : ""}`}>{text}</li>
            <button onClick={completeHandler} className="complete-btn">
                Completed
            </button>&nbsp;
            <button onClick={deleteHandler} className="trash-btn">
                Delete
            </button>&nbsp;
            <button onClick={()=>duplicateHandler(todo)} className="duplicate-btn">
                Duplicate
            </button>
        </div>
    );
};

export default Todo;