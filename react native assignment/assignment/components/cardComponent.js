import { NavigationContainer } from "@react-navigation/native";
import React from "react";
import {View,Text,Button,StyleSheet,Dimensions,Image, ImageBackground} from "react-native";

class CardComponent extends React.Component
{
    render()
    {
      return (  
        <View style={{flex:1, justifyContent:'center',alignItems:"center",margin:20}}>
            <View style={{width:Dimensions.get('window').width *0.9 ,height:Dimensions.get('window').height*0.2}}>
           <ImageBackground source={{uri:'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg'}} style={{width:'100%',height:'100%',justifyContent:"flex-end"}}>
           <View style={{flex:0.3,flexDirection:"row",height:"20%",justifyContent:"space-between",alignItems:"center",backgroundColor:"grey",borderBottomLeftRadius:10,borderBottomRightRadius:10,padding:10}}>
                <Text style={{flex:0.4,alignItems:"center",textAlign:"center"}}>{this.props.data.title} </Text>
                <Text style={{flex:0.25}}>{'\u20B9'}{this.props.data.price} </Text>
                <Button title="View Details" onPress={()=>{this.props.navigateProduct(this.props.data)}}  style={{padding:5}}></Button>
            </View>
           </ImageBackground>        
            </View>
        </View>
        );
    }
}

const styles=StyleSheet.create({
    card:{backgroundColor: "grey",
    borderWidth:5,
    borderRadius:4,
    margin:10,
    padding:10,
    width:80,
    height:80
    }
});

export default CardComponent;