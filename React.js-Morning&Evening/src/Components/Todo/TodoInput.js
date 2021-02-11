import React from "react";

class TodoInput extends React.Component {
  render() {
    const { value, onChange, taskPlaceholder } = this.props;

    return (
      <input
        type="text"
        placeholder={taskPlaceholder}
        value={value}
        onChange={(event) => onChange(event)}
        className = "filterButton"
      />
    );
  }
}

export default TodoInput;
