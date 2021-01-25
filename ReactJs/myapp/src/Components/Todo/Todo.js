import React from 'react';
import TodoInput from './TodoInput';
import TodoList from './TodoList';
class Todo extends React.Component{
    state ={todo:"",
    todos:[
        {todo:"first todo",marked:false},
        {todo:"Second todo",marked:true},
        {todo:"Third todo",marked:false},
        {todo:"Fourth todo",marked:false},
        {todo:"Fifth todo",marked:true}
        
    ],
    title:"My tasks",
    filter:"ShowAll"
    };

    handleOnChange = (event)=>{
        console.log(event.target.value);
        this.setState({todo:event.target.value})
    };

    addTask = ()=>{
        const {todo,todos} = this.state;
        const newTodos = [...todos];
        if(todo !== ""){
            newTodos.push({todo:todo,marked:false});
            this.setState({todos:newTodos,todo:""});
        }
    };

    delete = (index) =>{
        const {todos}=this.state;
        const newTodos = [...todos];
        if (index > -1) {
        newTodos.splice(index, 1);
        this.setState({todos:newTodos});
        }
    }

    duplicate = (index) =>{
        const {todos} = this.state;
        const newTodos = [...todos];
        const duplicateTodo = newTodos[index].todo;
        newTodos.push({todo:duplicateTodo,marked:false});
        this.setState({todos:newTodos});

    }

    markTasksAsCompleted = (index) =>{
        const {todos} = this.state;
        const newTodos = [...todos];
        newTodos[index] ={
            ...newTodos[index],
            marked: !newTodos[index].marked
        }
        this.setState({todos:newTodos});
    };

    changeFilter = (filterName)=>{
        this.setState({filter:filterName});
    };

    render(){
        var paddingStyle = {
            padding: 30,
            fontSize: 20
        };
       

        var localTodos = [...this.state.todos];

        if(this.state.filter ==="Pending"){
            localTodos = this.state.todos.filter((item)=>{
                if(item.marked === false)
                return true;
                else
                return false;
            });
        }

        if(this.state.filter ==="Completed"){
            localTodos = this.state.todos.filter((item)=>{
                if(item.marked === true)
                return true;
                else
                return false;
            });
        }

        
        return(
            <div style = {paddingStyle}>
            <h1>TodoApplications</h1>
            <TodoInput 
            placeholder = "Add new task" value = {this.state.todo} onChange = {this.handleOnChange}/>
            <button onClick = {this.addTask}>Add Task</button>
            <br></br>
            <br></br>
            <button onClick = {() => this.changeFilter("ShowAll")}>Show All</button>
            <button onClick = {() => this.changeFilter("Completed")}>Completed</button>
            <button onClick = {() => this.changeFilter("Pending")}>Pending</button>
            <br></br>
            <TodoList 
            title = {this.state.title} todos = {localTodos} markTasksAsCompleted={this.markTasksAsCompleted}
            delete ={this.delete} duplicate ={this.duplicate} />
            </div>
        );
    }
}
export default Todo;