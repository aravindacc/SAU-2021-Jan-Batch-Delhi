import { StatusBar } from "expo-status-bar";
import Home from "./components/Home";
import React from "react";
import { StyleSheet, View } from "react-native";
import { Provider } from "react-redux";
import store from "./ListRedux/store";
import Navigator from "./routes/Navigator";

export default function App() {
  return (
    <Provider store={store}>
      <Navigator />
    </Provider>

    //   <View style={styles.container}>
    //     <View style={styles.statusBar}></View>
    //     <Provider store={store}>
    //       {/* <Home /> */}
    //       <Navigator />
    //     </Provider>
    //     <StatusBar style="auto" />
    //   </View>
  );
}

const styles = StyleSheet.create({
  statusBar: {
    paddingTop: 50,
    color: "#fff",
  },
});
