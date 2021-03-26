import React from 'react';
//import PropTypes from 'propTypes';

class TodoList extends React.Component{
  //  const {todos,title,markTaskAsCompleted,filterby} = this.props;
filterTasks=()=>{
    
     if(this.props.filterby==='pending')
      {
            return this.props.todos.filter((item)=>{
                      if(item.marked===false)
                          return true;
                      else    
                          return false;
              });
      }
      else if(this.props.filterby==='completed')
      {
          return this.props.todos.filter((item)=>{
              if(item.marked===true)
                  return true;
              else    
                  return false;
            });
        }
    else 
        return this.props.todos;
}
    render(){
       // const todos=["Task 1","Task 2","Task 3"];
        const {title,markTaskAsCompleted,DuplicateTask,DeleteTask} = this.props;

        return(
        <div>
            <h3>{title}</h3>
        <ul style={{
            listStyle : 'none'
        }}>
    {this.filterTasks()
    ? this.filterTasks().map((value,index)=>
    {
        return <li  className='TaskRow' style={ 
            value.marked ?
            {
                textDecoration: 'line-through'
            }: {} 
          
        }
        >
        <label>

            <input type="checkbox"
            checked={value.marked}
            onChange={(event)=>markTaskAsCompleted(event,index) }
            />
            {value.todo}
            
        </label>
        <button className='hidden' onClick={()=>DeleteTask(index)}>Delete</button>
        <button className='hidden' onClick={()=>DuplicateTask(value.todo)}>Duplicate</button>
        
            </li>;
    })
    :null}
    </ul>
        </div>       
        );
    }
};

export default TodoList;