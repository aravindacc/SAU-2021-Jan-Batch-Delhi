import React from 'react'

const Todos = ({todos, deleteTodo, duplicate, filterBy}) => {
    var todoList;
    if (filterBy==='pendingTasks') {
        todoList = todos.filter(todo => {
          return todo.marked === false;
        });
      }
    else if(filterBy==='completedTasks') {
    todoList = todos.filter(todo => {
        return todo.marked === true;
      });
    }
    else{
        todoList = [...todos];
    }

     todoList = todoList.length ? (
        todoList.map((task, index) => {
            return (
            <div className="collection-item task-row" key={task.id} style={ task.marked ? { textDecoration: "line-through" }: {}}>
                <table>
                    <tr> 
                        <td><span>{task.todo}</span></td>
                        <td>
                            <button className="waves-effect waves-light btn-small delete-button" onClick={() => {deleteTodo(task.id)}}>Delete</button>
                        </td>
                        <td>
                            <button className="waves-effect waves-light btn-small duplicate-button" onClick={() => {duplicate(index)}}>Duplicate</button>  
                        </td>
                    </tr>
                </table>
            </div>
            )
        })
    ) : (
            <p className="center">You have no pending tasks left!</p>
    )


    return(
        <div className="todos collection">
            {todoList}
        </div>
    )
}

export default Todos