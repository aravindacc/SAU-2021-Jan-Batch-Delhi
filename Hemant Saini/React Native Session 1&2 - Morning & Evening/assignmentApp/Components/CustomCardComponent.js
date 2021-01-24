import React, { Component } from "react";
import { View, Text, StyleSheet } from "react-native";
import { Card, Button, Icon } from "react-native-elements";

export default class CustomCardComponent extends Component {
  name = this.props.name;
  id = this.props.id;
  email = this.props.email;
  address = this.props.address;

  render() {
    //console.log(this.props);
    return (
      <View style={{backgroundColor:"#D9B382"}}>
        <Card>
          <Card.Title style={styles.cardTitle}>id@{this.id}</Card.Title>

          <Card.Divider />

          <View
            style={{
              flexDirection: "column",
            }}
          >
            <View style={styles.cardImage}>
              <Card.Image
                source={require("../assets/cat.jpeg")}
                style={styles.imageSize}
              ></Card.Image>
            </View>

            <View style={styles.cardFooter}>
              <Text>{this.name}</Text>
              <Text>{this.email}</Text>
              <Button
                icon={<Icon name="code" color="#ffffff" />}
                buttonStyle={{
                  borderRadius: 10,
                }}
                title="Show Description"
                onPress={() =>
                  this.props.navigation.navigate("Detail", {
                    id: this.id,
                    name: this.name,
                    email: this.email,
                  })
                }
              />
            </View>
          </View>
        </Card>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  cardTitle: { backgroundColor: "red", borderRadius: 10, margin: 10 },
  cardImage: {
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    backgroundColor: "rgba(0, 128, 0, 0.25)",
    margin: 10,
    borderRadius: 10,
  },
  cardFooter: {
    display:"flex",
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
    backgroundColor: "rgba(0, 128, 0, 0.7)",
    margin: 10,
    padding: 10,
    borderRadius: 10,
  },
  imageSize:{
    width: 400,
    height: 400,
  }
});
