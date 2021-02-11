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
    const { todos, markTaskAsCompleted,deleteTodofromList, duplicateTodoFromList} = this.props;

    var filteredList = [];
    if (this.props.filterBy === "pending") {
      filteredList = todos.filter((todo) => {
        return todo.marked === false;
      });
    } else if (this.props.filterBy === "completed") {
      filteredList = todos.filter((todo) => {
        return todo.marked === true;
      });
    } else {
      filteredList = [...todos];
    }

    return (
      <div>
        <ul style={{ listStyle: "none", padding: 0, margin: 0 }}>
          {filteredList
            ? filteredList.map((value, index) => {
                return (
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
                    <button
                      className="hidden"
                      onClick={() => deleteTodofromList(value.id)}
                      style={{ backgroundColor: "blue" }}
                    >
                      Delete
                    </button>

                    <button
                      className="hidden"
                      onClick={() => duplicateTodoFromList(value.id)}
                      style={{ backgroundColor: "green" }}
                    >
                      Duplicate
                    </button>
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
