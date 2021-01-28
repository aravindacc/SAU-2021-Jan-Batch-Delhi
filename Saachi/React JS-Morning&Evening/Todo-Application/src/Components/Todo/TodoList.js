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
    const { todos, markTaskAsCompleted } = this.props;

    return (
      <div className='listSection'>
        <ul style={{ listStyle: "none", padding: 0, margin: 0 , }}>
          {todos
            ? todos.map((value, index) => {
                return (
                  <li key={index}>
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
