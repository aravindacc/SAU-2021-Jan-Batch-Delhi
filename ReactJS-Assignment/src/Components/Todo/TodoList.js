import React from "react";
import PropTypes from "prop-types";

class Todolist extends React.Component {
  static propTypes = {
    todos: PropTypes.arrayOf(
      PropTypes.shape({
        todo: PropTypes.string,
        marked: PropTypes.bool,
      })
    ),
  };

  render() {
    const { todos, markTaskAsCompleted,
      deleteButton,duplicateButton, searchAll} = this.props;

    return (
      <div>
        <ul style={{ listStyle: "none", padding: 0, margin: 0 }}>
          {todos
            ? todos.map((value, index) => {
              if((searchAll==="Completed"&&value.marked)||
              (searchAll==="Show all") || 
              (searchAll==="Pending"&&!value.marked ))

               { return (
                  <li key={index} className="TaskRow">
                    
                    <label
                      style={
                        value.marked
                          ? {
                              textDecoration: "line-through",
                            }
                          : {}
                      }
                      className={value.marked ? "checked" : ""}
                    >
                      <input
                        type="checkbox"
                        checked={value.marked}
                        onChange={(event) => markTaskAsCompleted(event, index)}
                      />
                      {value.todo}
                    </label>
                    <label>     <pre></pre>                      </label>
                   
                    <button style={{margin:10,backgroundColor:'orange'}} 
                    className="hidden" onClick={()=>{duplicateButton(value.todo)}}>
                    Duplicate</button>

                    <button style={{margin:10,backgroundColor:'red'}}
                     className="hidden" onClick={()=>deleteButton(index)}>
                     Delete</button>
                  </li>
                );
                    }
                    else{
                      return (
                        <li key={index}></li>
                      );
                    }
              
              })
            : null}
        </ul>
      </div>
    );
  }
}



export default Todolist;
