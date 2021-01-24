import React, {useEffect, useCallback ,useState} from 'react';
import Main from "./components/Main"
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import CountryCoronaDetail from "./components/CountryCoronaDetail"

const Stack = createStackNavigator()

export default function App(){
  return (
    <NavigationContainer>
      <Stack.Navigator >
        <Stack.Screen 
          name="All-Countries"
          component={Main}
        />
        <Stack.Screen 
          name="CountryCoronaDetail" 
          component={CountryCoronaDetail} 
        />
      </Stack.Navigator>
    </NavigationContainer>
  )
}


