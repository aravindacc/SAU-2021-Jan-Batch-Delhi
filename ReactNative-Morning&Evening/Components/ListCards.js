import React, { Component } from "react";
import { View, Text, StyleSheet } from "react-native";
import { Card, Button, Icon } from "react-native-elements";

export default class ListCardComponent extends Component {
  name = this.props.name;
  id = this.props.id;
  email = this.props.email;
  address = this.props.address;
  body=this.props.body;

  render() {
    
    return (
      <View style={{backgroundColor:"#7FFFD4"}}>
        <Card>
          <Card.Title style={styles.cardTitle}>{this.id}</Card.Title>

          <Card.Divider />

          <View
            style={{
              flexDirection: "column",
            }}
          >
            <View style={styles.cardImage}>
              <Card.Image
                source={require("../assets/user.png")}
                style={styles.imageSize}
              ></Card.Image>
            </View>

            <View style={styles.cardFooter}>
              <Text style={{ fontSize: 15 }} >{this.name}</Text>
              <Text style={{ fontSize: 15 }}>{this.email}</Text>
              <Button
                title="Show Description"
                onPress={() =>
                  this.props.navigation.navigate("Detail", {
                    id: this.id,
                    name: this.name,
                    email: this.email,
                    body:this.body,
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
  cardTitle: { backgroundColor: "#DC143C", borderRadius: 10, margin: 10 },
  cardImage: {
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    margin: 10,
    borderRadius: 10,
  },
  cardFooter: {
    display:"flex",
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
    backgroundColor: "#FF7F50",
    margin: 5,
    padding: 10,
    borderRadius: 10,
  },
  imageSize:{
    width: 400,
    height: 400,
  },
  text:{
    font: "Lucida Console"
    
  }
});
