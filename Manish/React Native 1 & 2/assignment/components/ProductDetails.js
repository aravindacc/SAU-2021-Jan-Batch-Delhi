import {
  View,
  Text,
  StyleSheet,
  Image,
  Alert,
  TouchableOpacity,
  ScrollView,
} from "react-native";
import React from "react";
import InfoListItem from "./InfoListItem";

export default function ProductDetails({ navigation }) {
  const handleViewDetails = () => {
    navigation.navigate("ViewDetails")
  };

  const handleClickMe = () => {
    Alert.alert(
      "You have pressed",
      navigation.getParam("title"),
      [
        {
          text: "Cancel",
          onPress: () => console.log("Cancel Pressed"),
        },
        { text: "OK", onPress: () => console.log("OK Pressed") },
      ],
      { cancelable: false }
    );
  };

  return (
    <View>
      <ScrollView>
        <Image
          source={{
            uri: navigation.getParam("image_url"),
          }}
          style={styles.image}
        />
        <View style={styles.buttons}>
          <TouchableOpacity
            style={{ ...styles.button, ...styles.button1 }}
            onPress={handleClickMe}
          >
            <Text style={styles.buText}>Click me</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.button} onPress={handleViewDetails}>
            <Text style={styles.buText}>View Details</Text>
          </TouchableOpacity>
        </View>
        <Text style={styles.title}>{navigation.getParam("title")}</Text>
        <View style={styles.infoContainer}>
          <InfoListItem
            itemKey={"Rank"}
            itemValue={navigation.getParam("rank")}
          />
          <InfoListItem
            itemKey={"ID"}
            itemValue={navigation.getParam("mal_id")}
          />
          <InfoListItem
            itemKey={"Title"}
            itemValue={navigation.getParam("title")}
          />
          <InfoListItem
            itemKey={"Type"}
            itemValue={navigation.getParam("type")}
          />
          <InfoListItem
            itemKey={"Start date"}
            itemValue={navigation.getParam("start_date")}
          />
          <InfoListItem
            itemKey={"End date"}
            itemValue={navigation.getParam("end_date")}
          />
          <InfoListItem
            itemKey={"Favourites"}
            itemValue={navigation.getParam("members")}
          />
          <InfoListItem
            itemKey={"Rating"}
            itemValue={navigation.getParam("score")}
          />
          <InfoListItem
            itemKey={"Web Url"}
            itemValue={navigation.getParam("url")}
          />
          <Text style={styles.infoItem}>
            <Text style={{ fontWeight: "bold" }}>Description</Text>
          </Text>
          <Text style={styles.description}>
            It is a long established fact that a reader will be distracted by
            the readable content of a page when looking at its layout. The point
            of using Lorem Ipsum is that it has a more-or-less normal
            distribution of letters, as opposed to using 'Content here, content
            here', making it look like readable English. Many desktop publishing
            packages and web page editors now use Lorem Ipsum as their default
            model text, and a search for 'lorem ipsum' will uncover many web
            sites still in their infancy. Various versions have evolved over the
            years, sometimes by accident, sometimes on purpose (injected humour
            and the like).
          </Text>
        </View>
      </ScrollView>
    </View>
  );
}

styles = StyleSheet.create({
  image: {
    height: 280,
    width: "100%",
  },
  title: {
    fontSize: 20,
    padding: 25,
    textAlign: "center",
  },
  buttons: {
    flexDirection: "row",
    justifyContent: "space-around",
    marginTop: 15,
  },
  button: {
    backgroundColor: "#8e44ad",
    width: 150,
    height: 50,
    justifyContent: "center",
    alignItems: "center",
  },
  button1: {
    backgroundColor: "#27ae60",
  },
  buText: {
    color: "white",
    fontSize: 16,
  },
  infoContainer: {
    padding: 10,
  },
  description: {
    textAlign: "justify",
    marginTop: 10,
    paddingHorizontal: 10,
  },
});
