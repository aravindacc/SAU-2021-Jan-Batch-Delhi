export default function TodoItemList(props) {
  return (
    <div key={props.index} style={!props.todo.show? {display: 'none'}:{}} className="list-item">
      <input
        type="checkbox"
        checked={props.todo.marked}
        onChange={() => props.markTask(props.index)}
        name="check"
      ></input>
      <label
        htmlFor="check"
        style={props.todo.marked ? { textDecoration: 'line-through' } : {}}
      >
        {props.todo.todo}
      </label>

      <div className="right-buttons">
        <button onClick={()=>{props.duplicateTodo(props.index)}} className="duplicate-bu">+</button>
        <button onClick={()=>{props.deleteTodo(props.index)}} className="delete-bu">X</button>
      </div>
    </div>
  );
}
