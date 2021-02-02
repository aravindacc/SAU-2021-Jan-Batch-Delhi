import React from "react";
import { Text, StyleSheet } from "react-native";

export default function InfoListItem(props) {
  return (
    <Text style={styles.infoItem}>
      <Text style={{ fontWeight: "bold" }}>{props.itemKey}</Text> :{" "}
      {props.itemValue}
    </Text>
  );
}

const styles = StyleSheet.create({
  infoItem: {
    padding: 5,
  },
});
