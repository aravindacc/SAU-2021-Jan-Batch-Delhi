import React from 'react';
import { View, Text, Button,Component } from 'react-native';
import { createAppContainer } from 'react-navigation';
import { createStackNavigator } from 'react-navigation-stack';


import Listing from './Listing';



const splashScreen = (props) => {
    ;
    
     
      useEffect(
        () => {
          let timer1 = setTimeout(() => props.navigation.navigate("ListingScreen"), 500)
    
          return () => {
            clearTimeout(timer1)
          }
        },
        [] )
    
    
      return (
        <View style={{ flex: 1,justifyContent:"center",alignItems:"center" }}>
          <Text>REACT NATIVE ASSIGNMENT</Text>
    
        </View>
    
      );
    
    }

const Navigator = createStackNavigator({
   
    Listing: { screen: Listing},
   
    
});


const App = createAppContainer(Navigator);

export default App;
