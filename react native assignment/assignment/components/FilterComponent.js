import React from 'react';
import {View, TextInput, Button} from 'react-native';


function Filter(props){
    const [value, setValue] = React.useState('');
    const {searchFilter} = props;
    return (
        <View >
            <View style={{flexDirection:'row',justifyContent:'center',alignItems:'center',margin:20,justifyContent:'space-around'}}>
            <TextInput onChangeText={(value) =>{setValue(value);searchFilter(value)} } value={value} placeholder="Search.." style={{width:'70%',backgroundColor:'grey',height:40,color:'white',padding:10,borderRadius:10}} ></TextInput>
            <Button color='grey' title ="S" onPress={()=>{props.dateFilter();}}></Button>
            <Button color='grey' title="X" onPress={()=>{setValue(" ");}} ></Button>
            </View>
        </View>
    );
}

export default Filter;