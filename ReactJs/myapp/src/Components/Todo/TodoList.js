import React from 'react';
import PropTypes from 'prop-types';
class TodoList extends React.Component{
    static propTypes = {
        title: PropTypes.string,
        todos:PropTypes.arrayOf(PropTypes.shape({todo:PropTypes.string, marked:PropTypes.bool})),
    }

    // showHoverButtons = false;

    // toggle = () =>{
    //     console.log(this.showHoverButtons);
    //     if(this.showHoverButtons)
    //     this.setState({showHoverButtons:true});
    //     else{
    //         console.log("it ran");
    //         this.setState({showHoverButtons:true});
    //         console.log("ran2");
    //     }
    // }
    
    render(){
        const {todos} = this.props;
         
        return(
            <div>
                <h3>Title: {this.props.title}</h3>
                <ul
                
                 style = {{listStyle:"none", padding:0,margin:0,fontSize:30}}>
                {todos?todos.map((value,index)=>{
                    return <li key = {index}
                    // onMouseEnter = {this.toggle}
                    >
                        <label style = {value.marked?{
                            textDecoration:"line-through",
                            color:'green'
                        }:{
                            color:'red'
                        }
                        }>
                        <input 
                        type="checkbox" 
                        checked = {value.marked}
                        onChange = {() => this.props.markTasksAsCompleted(index)}>
                            
                        </input>
                        {value.todo}
                        <button
                        onClick = {()=>this.props.delete(index)}>Delete</button>
                        <button
                        onClick = {()=>this.props.duplicate(index)}>Duplicate</button>
                        
                            
                        </label>
                        </li>
                }):null}

            </ul>
            </div>
            
        );
    }
}
export default TodoList;