import React from 'react';
import PropTypes from 'prop-types';
import ListGroup from 'react-bootstrap/ListGroup';
import './Todo.css';

class TodoList extends React.Component {
    static propTypes = {
        todos: PropTypes.arrayOf(
            PropTypes.shape({
                todo: PropTypes.string,
                marked: PropTypes.bool,
            })
        ),
    }

    render() {
        
        const { todos, markTaskAsCompleted, todoDeleteHandler, copyHandler } = this.props;
        return (
            <ListGroup>
                {todos ? todos.map((value)=> {
                    return <ListGroup.Item className={value.marked ? 'line' : ''} key = {value.id} >
                                <label style={{ marginRight : '1%' }}>
                                    <input onChange={() => markTaskAsCompleted(value.id)} type="checkbox" checked={value.marked} />
                                </label>
                                {value.todo}
                                <div className="d1">
                                    <button className="trash" onClick = {() => todoDeleteHandler(value.id)}><i className="far fa-trash-alt"></i></button>
                                    <button className="copy" onClick = {() => copyHandler(value.id)}><i className="far fa-copy"></i></button>  
                             </div>
                                                
                             </ListGroup.Item>;
                }) : null}
            </ListGroup>
        )
    }
}
export default TodoList;