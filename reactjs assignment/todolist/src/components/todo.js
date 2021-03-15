import React from 'react';
import TodoInput from './todoInput';
import TodoList from './todoList';
import filterHelper from './filterHelper'

class Todo extends React.Component{
    
    state={
        id:0,
        todo:"",
        todoList:[],
        filter:"showAll"
    }

    addNewTask =() =>
    {
        const { todo, todoList} = this.state;
        const newTodo =[...todoList];
        if(todo !=="")
        {
            newTodo.push({todo:todo , marked :false, id:this.state.id, delete:false});
            this.setState(
                {
                    id:this.state.id+1,
                    todoList:newTodo
                }
            )
        }
        console.log(newTodo);
    };

    deleteTodoHandle=(id)=>
    {
        const newTodo=this.state.todoList;
        newTodo[id]={
            ...newTodo[id],
           delete:true
        }
        this.setState({
            todoList:newTodo
        })
    }

    handleTaskCompleted=(id)=>
    {
        const newTodo=this.state.todoList;
        newTodo[id]={
            ...newTodo[id],
            marked:!newTodo[id].marked
        }

        this.setState({
            todoList:newTodo
        });

    }

    duplicateTodo=(id)=>{
        const newTodo=this.state.todoList;
        newTodo.push({
            ...newTodo[id],
            marked:false,
            id:this.state.id
        });
        this.setState({
            todoList:newTodo,
            id:this.state.id+1
        })
    }

    handleonchange=(event)=>
    {
        this.setState(
            {
                todo : event.target.value
            }
        );

    };

    
    
    render()
    {
            return <div className="TodoContainer" >
                    <h1  style={{"color":"teal",placeSelf:"center"}}>Todo List Application</h1>

                    <TodoInput placeholder="new Task" value={this.state.todo} changeinput={this.handleonchange} />
                    <button onClick={this.addNewTask}>Add Task</button>

                    <br/>
                    <div className="filterButtoncontainer">
                        <button onClick={()=>{this.setState({filter:"showAll"})}} >Show All Todos</button>
                        <button onClick={()=>{this.setState({filter:"checked"})}} >Checked Todos</button>
                        <button onClick={()=>{this.setState({filter:"unChecked"})}} >Unchecked Todos</button>
                        <button onClick={()=>{this.setState({filter:"delete"})}} >Deleted Todos</button>
                    </div>
                    <TodoList 
                    todos={filterHelper (this.state.todoList , this.state.filter )}
                    markcompleted={this.handleTaskCompleted} 
                    deletetodo={this.deleteTodoHandle}
                    duplicatetodo={this.duplicateTodo}></TodoList> 
            </div>
            
    }
}

export default Todo;