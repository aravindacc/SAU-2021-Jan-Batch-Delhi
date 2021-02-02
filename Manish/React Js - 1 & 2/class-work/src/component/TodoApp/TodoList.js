import TodoListitem from "./TodoListItem";

export default function TodoList(props) {
  return (
    <div className="list">
      {props.todos.map((todo, index) => {
        return (
          <TodoListitem
            key={index}
            deleteTodo={props.deleteTodo}
            duplicateTodo={props.duplicateTodo}
            markTask={props.markTask}
            todo={todo}
            index={index}
          />
        );
      })}
    </div>
  );
}
