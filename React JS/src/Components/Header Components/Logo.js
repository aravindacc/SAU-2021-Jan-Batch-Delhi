import React from 'react'
import logo from '../../logo.svg'
// const Header =()=>{

//     return(
//         <div>
//             <h1>Header function Component</h1>
//         </div>
//     );

    
// };

class Image extends React.Component{
    render(){
        return <img src={logo} alt="Sorry!"></img>
    }
}
export default Image;