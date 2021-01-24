import { createAppContainer } from "react-navigation";
import { createStackNavigator } from "react-navigation-stack";

import Home from "../components/Home";
import ProductDetails from "../components/ProductDetails";
import ViewDetailsWebView from "../components/ViewDetailsWebView";


const AppNavigator = createStackNavigator(
  {
    Home: Home,
    Info: ProductDetails,
    ViewDetails: ViewDetailsWebView,
  },
  {
    initialRouteName: "Home",
  }
);

export default createAppContainer(AppNavigator);
