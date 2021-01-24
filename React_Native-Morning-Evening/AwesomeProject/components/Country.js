import { NavigationContainer } from "@react-navigation/native";
import React from "react";
import {View,Text,Button,StyleSheet,Dimensions,Image, ImageBackground} from "react-native";
class Country extends React.Component   {
    render()
    {
            return (
              <View style={styles.oneContry}>
                  <View style={styles.settingView}>
                    <ImageBackground 
                        source={
                                {uri:this.props.data.countryInfo.flag}
                            } 
                        style= {
                            styles.imgSet
                        }
                    >
                    <View style={styles.viewSet}>
                        <Text 
                            style={
                                {
                                    fontWeight:"bold",
                                    fontSize:"25px",
                                    color:"white",
                                    flex:0.4,
                                    alignItems:"center",
                                    textAlign:"center"
                                    }
                                }
                        >
                            {this.props.data.country} </Text>
                        <Text style={{fontWeight:"bold",fontSize:"25px",color:"white",flex:0.25}}>{this.props.data.cases} </Text>
                        <Button title="View Details" onPress={()=>{this.props.navigateCountry(this.props.data)}}  style={{padding:5}}></Button>
                      </View>
                    </ImageBackground>        
                  </View>
              </View>
            )
        
    }
}
const styles=StyleSheet.create({
    oneContry:{
        flex:1, 
        justifyContent:'center',
        alignItems:"center",
        margin:30
    },
    settingView: {
        width: Dimensions.get('window').width *0.4, 
        height:Dimensions.get('window').height*0.5
    },
    imgSet: {
        width:'100%',
        height:'100%',
        justifyContent:"flex-end"
    },
    viewSet:{
        flex:0.1,
        flexDirection:"row",
        height:"10%",
        justifyContent:"space-between",
        alignItems:"center",
        backgroundColor:"black",
        borderBottomLeftRadius:10,
        borderBottomRightRadius:10,
        padding:10
    }
});

export default Country;