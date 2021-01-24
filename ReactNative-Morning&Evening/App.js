import * as React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import FlatListComponent from "./Components/FlatList";
import CardDetail from "./Components/CardDetail";
import SplashScreenComponent from "./Components/SplashScreen";

function SplashScreen({ navigation }) {
  return <SplashScreenComponent navigation = {navigation}></SplashScreenComponent>;
}

function ListView({ navigation }) {
  return <FlatListComponent navigation = {navigation}></FlatListComponent>;
}

const Stack = createStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Splash" component={SplashScreen} options={{headerShown: false}}/>
        <Stack.Screen name="Home" component={ListView} options={{headerShown: false}}/>
        <Stack.Screen name="Detail" component={CardDetail} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;
