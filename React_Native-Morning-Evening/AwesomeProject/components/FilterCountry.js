import React from 'react';
import {View, TextInput, StyleSheet,Button} from 'react-native';
import { useEffect } from 'react/cjs/react.development';
function FitlterCountry(props){
    const updateNewResult=()=>{
        searchFilter('');
    }
    const [value, setValue] = React.useState('');
    const {searchFilter} = props;
    return (
        <View >
            <View  style={styles.container}>
                <TextInput 
                    style={styles.TextArea}  
                    placeholder="Type Country Name..."
                    value={value} 
                    onChangeText={(value) => {
                        setValue(value);
                        searchFilter(value)
                    } 
                }>
                </TextInput>
                <Button 
                    color='black' 
                    title ="Sort" 
                    onPress={
                        ()=>{props.ownFilter();}
                    }
                >
                </Button>
                <Button 
                    color='black' 
                    title="X" 
                    onPress={
                        ()=>{setValue(" ");updateNewResult()}
                    }
                >
                </Button>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flexDirection:'row',
        justifyContent:'center',
        alignItems:'center',
        margin:20,
        justifyContent:'space-around',
     },
    TextArea: {
        width:'200%',
        backgroundColor:'white',
        height:40,
        color:'black',
        padding:20,
        borderRadius:40 
    }
});
  

export default FitlterCountry;