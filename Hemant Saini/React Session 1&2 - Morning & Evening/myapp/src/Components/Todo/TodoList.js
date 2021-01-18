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

  handleDelete = (index) => {
      alert("deleted");
  };

  render() {
    const { title, todos, filter, markTaskAsCompleted, deleteTodo, duplicateTodo} = this.props;

    var filteredTodos = [];
    if(filter === "showCompleted"){
        todos.forEach((todo) => {
            if(todo.value.marked)
                filteredTodos.push(todo);
          });
    }
    else if(filter === "showPending"){
        todos.forEach((todo) => {
            if(!todo.value.marked)
                filteredTodos.push(todo);
          });
    }
    else if(filter === "showAll"){
        filteredTodos = todos;
    }

    return (
      <div>
        <h2>{title}</h2>
        <ul style={{ listStyle: "none", padding: 5, margin: 5 }}>
          {filteredTodos
            ? filteredTodos.map((todoObject, index) => {
                return (
                    <li key={index} className="TaskRow">
                        <input
                            type="checkbox"
                            checked={todoObject.value.marked}
                            onChange={(event) => markTaskAsCompleted(event, todoObject.id)}
                        />

                        <label  style={ todoObject.value.marked ? { textDecoration: "line-through",}: {}}
                                className={todoObject.value.marked ? "checked" : ""}
                        >
                            {todoObject.value.todo}
                        </label>

                        <button className="hidden" onClick={() => deleteTodo(todoObject.id)}>Delete</button>
                        <button className="hidden" onClick={() => duplicateTodo(todoObject.id)}>Duplicate</button>
                    </li>
                );
              })
            : null}
        </ul>
      </div>
    );
  }
}

// const Todolist = (props) => {
//     const { todos, title } = props;

//     return (
//       <div>
//         <h3>{title}</h3>
//         <ul>
//           {todos
//             ? todos.map((todo, index) => {
//                 return <li>{todo}</li>;
//               })
//             : null}
//         </ul>
//       </div>
//     );
// }

export default Todolist;
