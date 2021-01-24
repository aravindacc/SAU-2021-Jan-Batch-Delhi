import React, { Component } from "react";

import { View, Text, Button, StyleSheet, Linking, Modal } from "react-native";
import { Card } from "react-native-elements";


export default class CardDetail extends Component {
  

  render() {
    const params = this.props.route.params;
    
    return (
      <View> 
        <Card>
          <Card.Title
            style={styles.cardTitle}
          >
            id:{params.id}
          </Card.Title>
          <Card.Divider />
          <View
            style={{
              flexDirection: "column",
            }}
          >
            <View
              style={styles.cardElementCenterAlign}
            >
              <Card.Image
                source={require("../assets/user.png")}
                style={{
                  width: 400,
                  height: 400,
                }}
              ></Card.Image>
            </View>
            <View
              style={styles.cardFooter}
            >
              <Button
                buttonStyle={{
                  borderRadius: 10,
                }}
                title="Click Me!"
                onPress={() => {
                  alert(params.name);
                }}
              ></Button>
              <Button
                buttonStyle={{
                  borderRadius: 10,
                }}
                title="View Details"
                onPress={() => {
                  Linking.openURL('https://www.accolite.com/');
                }}
              ></Button>

            </View>
          </View>
        </Card>
        <View
          style={styles.cardElementCenterAlign}
        >
          <Text style={{ fontSize: 25, padding: 10 }}>
            {params.body}
          </Text>
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  cardTitle : { backgroundColor: "#DC143C", borderRadius: 10, margin: 10 },
  cardElementCenterAlign : {
    alignItems: "center",
    justifyContent: "center",
    margin: 10,
    borderRadius: 10,
  },
  cardFooter : {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
    backgroundColor: "#FF7F50",
    borderRadius: 10,
  }
});