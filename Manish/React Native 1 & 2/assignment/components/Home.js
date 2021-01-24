import { View, Text } from "react-native";
import React from "react";
import SearchBar from "./SearchBar";
import ProductList from "./ProductList";

export default function Home(props) {
  return (
    <View>
      <SearchBar />
      <ProductList navigation={props.navigation} />
    </View>
  );
}
