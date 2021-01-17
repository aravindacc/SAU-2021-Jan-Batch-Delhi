export default function TodoInput(props) {
  const { value, onChange, placeHolder } = props;
  return (
    <input 
    className="add-todo"
      type="text"
      placeholder={placeHolder}
      onChange={onChange}
      value={value}
    ></input>
  );
}
