import React from 'react';
import '../assets/todo.css'

class TodoInput extends React.Component{
    render()
    {
       return <input type="text" className="todoInput" onChange={(event)=>this.props.changeinput(event)}  />
    }
};

export default TodoInput