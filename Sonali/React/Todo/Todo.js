import React from 'react';
import TodoInput from './TodoInput';
import './style.css';
import TodoList from './TodoList';
import { any } from 'prop-types';
class Todo extends React.Component{
    
    
/*    state={
        todo: "",
        todos:[
            "todos1","todos 2"
        ],
        title:"My Todos",
    }; */

    state={
        todo: "",
        todos:[
            {
                todo:"firsttodo",
                marked:false,
                deleted :false
            },
            {
                todo:"secondtodo",
                marked:true,
                deleted :false
            },     
        ],
        title:"My Todos",
        filterby : "",
        
    };


    handleOnChange=(event)=>
    {
        
        console.log(event.target.value);
        this.setState({todo:event.target.value});
  //      this.setState({title:event.target.value});
    }

    addTask=()=>{

        const{todo,todos}=this.state;

        const newTodos=[...todos];

        if(todo!=="")
        {
         //   newTodos.push(todo);
            newTodos.push({todo:todo,marked:false,deleted:false});
            this.setState({todos:newTodos,todo:""});
        }

       
    };
    DuplicateTask=(val)=>{

        const{todos}=this.state;

        const newTodos=[...todos];

        
        newTodos.push({todo:val,marked:false,deleted:false});
        this.setState({todos:newTodos});
        
        //console.log(val);

    };
    DeleteTask=(index)=>{
     //   console.log(todo);
      //  console.log(todomarkdeleted);
       // console.log(index);
      
       const{todos}=this.state;
        const newTodos=[...todos]; 
        newTodos[index]={
            ...newTodos[index],
            deleted: true
        };
   //     console.log(newTodos[index].todo);
    //    console.log(newTodos[index].deleted);
     //   console.log(index);
//console.log(newTodos[index]);
   //     this.setState({todos:newTodos},()=>{
    //        console.log(this.state.todos[index]);
      //  });
//console.log(todo);
//console.log(this.state.todos[index].deleted);
//console.log(todos[index]);

       
       const newTodosAfterFilter=newTodos.filter((item)=>{
            if(item.deleted===false)
                return true;
            else    
                return false;
        });
      //  console.log("result");
    console.log(newTodosAfterFilter);
        this.setState({
            todos:newTodosAfterFilter},()=>{
                console.log(this.state.todos)
            }); 
    };
    markTaskAsCompleted=(event,index)=>{
        

        const{todos}=this.state;
        //console.log(todos[index]);
        const newTodos=[...todos]; 
        newTodos[index]={
            ...newTodos[index],
            marked: event.target.checked
        };
        this.setState({
            todos:newTodos
        });
        console.log(todos[index]);

    };

        showAllTask=()=>{
            this.setState({filterby:'showall'})      
        };

        pendingTask=()=>{
           this.setState({filterby:'pending'})
        }

        completedTask=()=>{
            this.setState({filterby:'completed'})
        }
 

 
    
    render(){


        const h1styles={
            color: 'white',
            backgroundColor: 'black',

        }
     
        return(
            <div className="TodoContainer">
        <h1 style={h1styles}>TODO APPLICATON</h1>
        <TodoInput 
        placeholder="add a new task"
        value={this.state.todo}
       onChange={this.handleOnChange}
      
     />

        <button onClick={this.addTask}>Add Task</button>
        <button onClick={this.showAllTask}>Show All</button>
        <button onClick={this.pendingTask}>Pending</button>
        <button onClick={this.completedTask}>Completed</button>
         
   
        <TodoList title={this.state.title} todos={this.state.todos}
        markTaskAsCompleted={this.markTaskAsCompleted}
        DuplicateTask={this.DuplicateTask}
        DeleteTask={this.DeleteTask}
        filterby={this.state.filterby}
        />
    
</div>
        );
    }
}

export default Todo;