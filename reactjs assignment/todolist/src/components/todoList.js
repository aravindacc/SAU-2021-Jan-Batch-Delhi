  
import React from "react";
import '../assets/todo.css'


class Todolist extends React.Component {
  

  render() {
    const { todos } = this.props;

    return (
      <div>
        <ul style={{ listStyle: "none", padding: 0, margin: 0 }}>
          {todos
            ? todos.map((value, index) => {
                return (
                  <li key={index}  className="TaskRow">
                    <label
                      style={
                        value.marked
                          ? {
                              flex:'0.6',
                              textDecoration: "line-through",
                            }
                          : {flex:'0.6'}
                      }
                      className={value.marked ? "checked" : ""}
                    >
                      <input
                        type="checkbox"
                        disabled={value.delete}
                        checked={value.marked}
                        onChange={() => this.props.markcompleted(value.id)}
                      />
                      {value.todo}
                    </label>
                    <div  style={{display:value.delete?'none':'inline-block',flex:'0.4'}}>
                        <button className="hidden" onClick={()=>this.props.duplicatetodo(value.id)}>Duplicate</button>
                        <button className="hidden" onClick={()=>this.props.deletetodo(value.id)}>Delete</button>
                    </div>
                  </li>
                );
              })
            : null}
        </ul>
      </div>
    );
  }
}


export default Todolist;