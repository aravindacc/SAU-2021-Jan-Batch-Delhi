// In App.js in a new project

import * as React from "react";
import { View } from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import FlatListComponent from "./Components/FlatListComponent";
import CardDetail from "./Components/CardDetail";
import SplashScreenComponent from "./Components/SplashScreenComponent";

function SplashScreen({ navigation }) {
  return <SplashScreenComponent navigation = {navigation}></SplashScreenComponent>;
}

function HomeScreen({ navigation }) {
  return <FlatListComponent navigation = {navigation}></FlatListComponent>;
}

const Stack = createStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Splash" component={SplashScreen} options={{headerShown: false}}/>
        <Stack.Screen name="Home" component={HomeScreen} options={{headerShown: false}}/>
        <Stack.Screen name="Detail" component={CardDetail} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;
