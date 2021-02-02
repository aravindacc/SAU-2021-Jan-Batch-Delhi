import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { StackNavigator } from 'react-navigation';
import ListScreen from './Components/ListScreen';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import ViewDetailScreen from './Components/ViewDetailScreen';
export default class App extends React.Component {
  Stack = createStackNavigator();
  render() {
    return (
      <NavigationContainer>
        <Stack.Navigator initialRouteName='ListScreen'>
          <Stack.Screen name="ListingScreen" component={ListScreen} options={{ headerShown: false }} />
          <Stack.Screen name="DetailsScreen" component={ViewDetailScreen} options={({ route }) => ({ title: route.params.title })} />
        </Stack.Navigator>
      </NavigationContainer>
    );
  }
}

const AppStackNavigator = StackNavigator({
  Main: {
    screen: ListScreen
  }
})

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
