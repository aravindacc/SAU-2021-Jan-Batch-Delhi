import React from 'react';


const Form = ({ setInputText, todos, setTodos, inputText, setStatus }) => {
    const inputTextHandler = (e) => {
        setInputText(e.target.value);
    };
    const submitTodoHandler = (e) => {
        e.preventDefault();
        setTodos([
            ...todos, {text: inputText, completed: false, id: Math.random() *1000}
        ]);
        setInputText("");
    };
    const statusHandler = (e) => {
        setStatus(e.target.value);
    }
    return (
        <form>
        <input 
            value= {inputText}
            onChange= {inputTextHandler} 
            type="text" 
            className="todo-input"
        />&nbsp;
            <button onClick= {submitTodoHandler} className="todo-button" type="submit">
                Add
            </button>&nbsp;
            <div>
                <button value="all" onClick={statusHandler} className="todos" type="button">Show All</button>&nbsp;
                <button value="completed" onClick={statusHandler} className="todos" type="button">Completed Tasks</button>&nbsp;
                <button value="uncompleted" onClick={statusHandler} className="todos" type="button">Pending Tasks</button>
                {/* <select onChange={statusHandler} name="todos" className="filter-todo">
                <option value="all">All</option>
                <option value="completed">Completed</option>
                <option value="uncompleted">Uncompleted</option>
                </select> */}
            </div>
        </form>
    );
};

export default Form;
