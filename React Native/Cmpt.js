import React, {useState} from 'react';
import {
  SafeAreaView,
  StatusBar,
  StyleSheet,
  View,
  TextInput,
  TouchableOpacity,
  Image,Button
} from 'react-native';

const Cmpt = () => {
  const [text, setText] = useState('');
  return (
    <>


<View style={{alignContent:'center'}}>




<View style={{ flexDirection: 'row',padding:20,margin:1}}>
       <View style={{flex:4, width: 50,margin:1, height: 40, backgroundColor: 'powderblue'}} >
       <TextInput placeholder='search..'  style={{ fontSize:25,paddingLeft:15}} value={text}
            onChangeText={value => setText(value)} />
       </View>
       <View style={{ flex:1,width: 50, height: 40,margin:0, backgroundColor: 'skyblue'}} >
       <TouchableOpacity
            
            onPress={() => setText('')}>
            <Image style={{width:50,height:40}}
              
              source={require('./xx.png')}
            />
          </TouchableOpacity>
       </View>
       <View style={{ flex: 1,width: 50, height: 40, backgroundColor: 'steelblue'}} >
       <Button title="S"  style={{fontSize:25 }} />
       </View>
     </View>
</View>




     
        {/* <View >
          <TextInput placeholder='search'
            style={styles.textInput}
            value={text}
            onChangeText={value => setText(value)}
          />
          <TouchableOpacity
            
            onPress={() => setText('')}>
            <Image
              
              source={require('/Users/arun/Desktop/Accolite/React-Native/myproject/xx.png')}
            />
          </TouchableOpacity>
        </View> */}
      
    </>
  );
};




export default Cmpt;

