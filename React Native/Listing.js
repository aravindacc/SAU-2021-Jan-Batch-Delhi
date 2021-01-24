import React from 'react';
import {useState,Component} from 'react';
import Cmpt from './Cmpt.js';
import {AppRegistry ,
   StyleSheet,
   TextInput ,
    Button ,FlatList ,
     Image,  Text,View,
     ActivityIndicator, Linking, 
     Touchable} from 'react-native';
import { TouchableOpacity } from 'react-native-gesture-handler';



import Details from './Details';




export default class Listing extends React.Component {
  // text="search";
  static navigatioOptions = ({navigation}) => {
    return {
      title: 'Listing',
    }
    
  };

 
  
  constructor(){
    super();
    

   
    this.state = {
      dataSource: []
    }
  }
  sayHello() {
    alert('Hello!');
  }
  
  renderItem = ({item}) => {
    
   //const {navigate} = this.props.navigation;
   
   
    return (
      <View style={{alignItems:"center", backgroundColor:"gray",padding:20,margin:1}}>
      <Text style={{fontWeight:'bold', fontSize:30}}>
        TITLE
      </Text>
      <Text  style={{fontWeight:'bold',fontSize:20}}>
            {item.book_title}
          </Text>
        <Image style={{alignContent:"center", width: 300, height:300 ,marginLeft:40}}
            source={{uri : item.image}}/>
      
          <View style={{flex:2}}>
              <Text style={{marginRight:140}}>
                  BY. {item.author}
              </Text>
          </View>
         <View style={{flex:2}}>
            <Text style={{fontSize:15}}>
                <Button title='View Details' onPress={()=>{Linking.openURL("https://www.accolite.com/")}} />
                 
                
              </Text>
          </View>
        
    </View>

    )
    

  }

  componentDidMount(){
    const url='http://www.json-generator.com/api/json/get/ccLAsEcOSq?indent=1'
    fetch(url)
    .then((response) => response.json())
    .then((responseJson) => {
        this.setState({
          dataSource: responseJson.book_array
        })
    })
    .catch((error) => {
      console.log(error)
    })
  }
  
  render(){
  
    const text="search";
   
   
    return (


     
      <View style={{alignContent:'center'}}>    
      
     {/* <View style={{ flexDirection: 'row',padding:20,margin:1}}>
       <View style={{flex:4, width: 50,margin:1, height: 40, backgroundColor: 'powderblue'}} >
       <TextInput placeholder='search..'  style={{ fontSize:25,paddingLeft:15}} />
       </View>
       <View style={{ flex:1,width: 50, height: 40,margin:0, backgroundColor: 'skyblue'}} >
       <Button title="X"   style={{fontSize:25,margin:10 }} />
       </View>
       <View style={{ flex: 1,width: 50, height: 40, backgroundColor: 'steelblue'}} >
       <Button title="S"  style={{fontSize:25 }} />
       </View>
     </View> */}
     <Cmpt/>
        <FlatList
        data={this.state.dataSource}
        renderItem={this.renderItem}
        />
      </View>
    )
    
    }
}


 

