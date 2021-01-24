import { View, Text, Image, StyleSheet, Button } from "react-native";
import React from "react";

export default function ProductItem(props) {
  const moreHandler = () => {
    console.log(props.navigation.navigate("Info", props.item));
  };

  return (
    <View style={styles.container}>
      <Image
        source={{
          uri: props.item.image_url,
        }}
        style={styles.image}
      />
      <View style={styles.infoContainer}>
        <Text style={styles.heading} numberOfLines={2}>
          {props.item.title}
        </Text>
        <Text>Rank : {props.item.rank}</Text>
        {/* <Text>Start date : {props.item.start_date}</Text> */}
        <Text>Favourites : {props.item.members}</Text>
        <Text>Rating : {props.item.score}</Text>
        <View style={styles.buContainer}>
          <Button
            onPress={moreHandler}
            style={styles.moreBu}
            title="More >"
            color="#27a960"
          ></Button>
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    marginHorizontal: 15,
    marginVertical: 5,
    flex: 0.5,
    flexDirection: "row",
    backgroundColor: "#f5f5f5",
    shadowColor: "#000",
    shadowOffset: {
      width: 0,
      height: 0,
    },
    shadowOpacity: 0.3,
    shadowRadius: 4.65,

    elevation: 5,
  },
  image: {
    width: 120,
    height: 170,
  },
  infoContainer: {
    flex: 1,
    padding: 5,
  },
  heading: {
    fontSize: 16,
    paddingBottom: 5,
    borderBottomColor: "#ddd",
    borderBottomWidth: 1,
  },
  buContainer: {
    flexDirection: "row",
    flex: 1,
    justifyContent: "flex-end",
    alignItems: "flex-end",
  },
});
