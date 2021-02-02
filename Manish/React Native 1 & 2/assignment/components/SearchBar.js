import React, { Fragment, useState } from "react";
import {
  View,
  Text,
  TextInput,
  StyleSheet,
  TouchableOpacity,
  Button,
} from "react-native";
import { useDispatch, useSelector } from "react-redux";

export default function SearchBar(props) {
  const dispatch = useDispatch();
  const [query, setQuery] = useState("");

  const clearFilters = () => {
    console.log("Clearing filters...");
    setQuery("")
    dispatch({ type: "RESETFILTER" });
  };

  const sortList = () => {
    console.log("Applying sorting...");
    dispatch({ type: "SORT" });
  };

  const onChangeValue = (val) => {
    console.log("Searching...");
    setQuery(val);
    dispatch({ type: "SEARCH", payload: val });
  };

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.searchInp}
        placeholder="Search products..."
        value={query}
        onChangeText={onChangeValue}
        
      />

      <View style={styles.buttons}>
        <Button title=" X " onPress={clearFilters}></Button>
        <Button title=" S " onPress={sortList}></Button>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flexDirection: "row",
    padding: 10,
  },
  searchInp: {
    flex: 0.75,
    borderWidth: 1,
    borderColor: "#ddd",
    borderRadius: 10,
    paddingHorizontal: 10,
    paddingVertical: 5,
    marginEnd: 5,
  },
  buttons: {
    flexDirection: "row",
    justifyContent: "space-around",
    flex: 0.25,
  },
});
