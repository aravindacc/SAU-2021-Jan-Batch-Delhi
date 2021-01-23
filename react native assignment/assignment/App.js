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
const Stack=createStackNavigator();

export default function App() {

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
