import React from 'react';
import TodoInput from './TodoInput';
import TodoList from './TodoList';
import './Todo.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import Container from 'react-bootstrap/Container';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';

class Todo extends React.Component {

    state = {
        todo : '',
        todos : [
        {id : 1,  todo: "Buy fruits", marked: false},
        {id : 2,  todo: "Visit Grand ma", marked: true},
        {id : 3,  todo: "Meet Bank Manager at 5 pm", marked: false},
        {id : 4,  todo: "Pick up clothes from laundary", marked: true}
   
    ],
        filterBy: 'all',
        count: 4
    }

 

    todoDeleteHandler = (id) => {
        const { todos } = this.state;
      
        const newTodos = todos.filter((data) => {
           return id !== data.id;
        })

        this.setState({ todos: newTodos })
    }



    showAllHandler = () => {
        this.setState({filterBy : 'all'});
    }

    showCompletedHandler = () => {
        this.setState({filterBy : 'completed'});
    }

    showAPendingHandler = () => {
        this.setState({filterBy : 'pending'});
    }


    copyHandler = (id) => {
        const {todos, count} = this.state;

        const elementsIndex = todos.findIndex(element => element.id === id )
        const element = todos[elementsIndex];
      
        const newTodos = [...todos]

        newTodos.push({id : count+1, todo : element.todo, marked : false});
        this.setState((prevState) =>({ todos: newTodos, todo: "", count: prevState.count+1}))
    }

    markTaskAsCompleted = (id) => {
        const { todos } = this.state;

        const newTodos = [...todos];

        const elementsIndex = todos.findIndex(element => element.id === id )

        newTodos[elementsIndex] = {
            ...newTodos[elementsIndex],
             marked: !newTodos[elementsIndex].marked
            };

        this.setState({ todos: newTodos });
    }

    handleOnChnge = (event) => {
        this.setState({todo: event.target.value})
    }
    
    addTask = () => {
        const {todo, todos, count} = this.state;
    
        const newTodos = [...todos]
        if(todo !== "") {
            newTodos.push({id : count+1, todo : todo, marked : false});
            this.setState((prevState) =>({ todos: newTodos, todo: "", count: prevState.count+1}))
        }
    }

    render() {
       
        let filteredTodos = [];

        if(this.state.filterBy === 'all') {
            filteredTodos = this.state.todos;
        } else if(this.state.filterBy === 'completed') {
            filteredTodos = this.state.todos.filter(data => {
                return data.marked === true;
            })
        } else if(this.state.filterBy === 'pending') {
            filteredTodos = this.state.todos.filter(data => {
                return data.marked === false;
            })
        }


        return (
            <div className="container">
                <Container>
                  <div className="head">  <h1>Nipun's -ToDo Application</h1></div>
                    <Row className="row1">
                        <Col>
                            <Button variant="primary" onClick = {this.showAllHandler}>Show all </Button>
                        </Col>
                        <Col>
                            <Button variant="primary" onClick = {this.showCompletedHandler}>Show completed</Button>
                        </Col>
                        <Col>
                            <Button variant="primary" onClick = {this.showAPendingHandler}>Show pending </Button>
                        </Col>
                    </Row>
                    <TodoInput placeholder="Add new" value = {this.state.todo} onChange = {this.handleOnChnge} addTask={this.addTask}/>
                    <TodoList 
                        todos={filteredTodos}  
                        markTaskAsCompleted = {this.markTaskAsCompleted}
                        todoDeleteHandler = {this.todoDeleteHandler}
                        copyHandler = {this.copyHandler}
                        />
                </Container>
            </div>
        )
    }
}
export default Todo;