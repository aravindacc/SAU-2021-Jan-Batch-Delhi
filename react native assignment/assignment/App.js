import { StatusBar } from 'expo-status-bar';
import React, {useEffect, useCallback ,useState} from 'react';
import { ActivityIndicator, StyleSheet, Text, View } from 'react-native';
import Filter from './components/FilterComponent';
import Listcomponent from './components/listComponent';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import HomeComponent from './components/homeComponent';
import ProductDetails from './components/ProductDetails'
import { Header } from 'react-native/Libraries/NewAppScreen';
// import * as SplashScreen from 'expo-splash-screen';


function SplashScreen()
{
  return (
    <View style={{ flexDirection:'column' ,height:'100%',widht:'100%',justifyContent:'center'}}>
      <Text style={{flex:0.5,fontSize:20,color:'teal',textAlign:'center',textAlignVertical:'center'}}>React Native Assignment</Text>
      <Text style={{flex:0.4,fontSize:15,color:'teal',textAlign:'center',textAlignVertical:'center'}}>By Jatin</Text>
    </View>

  );
}


const Stack=createStackNavigator();

export default function App() {

  const[isLoading,setIsLoading]=useState(true);


  performTimeConsumingTask = () => {
      setTimeout(
        () => { setIsLoading(false) },
        2000
      );
  }

  performTimeConsumingTask();

  if(isLoading)
  {
    return <SplashScreen/>;
  }


  return (
    <NavigationContainer>
      <Stack.Navigator >
        <Stack.Screen 
          name="product"
          component={HomeComponent}
          options={{headerShown:false}}
        />
        <Stack.Screen name="ProductDetails" component={ProductDetails} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
