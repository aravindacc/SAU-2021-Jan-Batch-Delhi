import React, { Component } from "react";

import { View, Text, Button, StyleSheet, Linking, Modal } from "react-native";
import { Card } from "react-native-elements";
import Popup from "./Popup";


export default class CardDetail extends Component {
  //const id = this.props.navigation.state.param;

  render() {
    const params = this.props.route.params;
    
    return (
      <View> 
        <Card>
          <Card.Title
            style={styles.cardTitle}
          >
            id@{params.id}
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
                source={require("../assets/cat.jpeg")}
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
            Lorem Ipsum is simply dummy text of the printing and typesetting
            industry. Lorem Ipsum has been the industry's standard dummy text
            ever since the 1500s, when an unknown printer took a galley of type
            and scrambled it to make a type specimen book. It has survived not
            only five centuries, but also the leap into electronic typesetting,
            remaining essentially unchanged. It was popularised in the 1960s
            with the release of Letraset sheets containing Lorem Ipsum passages,
            and more recently with desktop publishing software like Aldus
            PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply
            dummy text of the printing and typesetting industry. Lorem Ipsum has
            been the industry's standard dummy text ever since the 1500s, when
            an unknown printer took a galley of type and scrambled it to make a
            type specimen book. It has survived not only five centuries, but
            also the leap into electronic typesetting, remaining essentially
            unchanged. It was popularised in the 1960s with the release of
            Letraset sheets containing Lorem Ipsum passages, and more recently
            with desktop publishing software like Aldus PageMaker including
            versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the
            printing and typesetting industry. Lorem Ipsum has been the
            industry's standard dummy text ever since the 1500s, when an unknown
            printer took a galley of type and scrambled it to make a type
            specimen book. It has survived not only five centuries, but also the
            leap into electronic typesetting, remaining essentially unchanged.
            It was popularised in the 1960s with the release of Letraset sheets
            containing Lorem Ipsum passages, and more recently with desktop
            publishing software like Aldus PageMaker including versions of Lorem
            Ipsum.Lorem Ipsum is simply dummy text of the printing and
            typesetting industry. Lorem Ipsum has been the industry's standard
            dummy text ever since the 1500s, when an unknown printer took a
            galley of type and scrambled it to make a type specimen book. It has
            survived not only five centuries, but also the leap into electronic
            typesetting, remaining essentially unchanged. It was popularised in
            the 1960s with the release of Letraset sheets containing Lorem Ipsum
            passages, and more recently with desktop publishing software like
            Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is
            simply dummy text of the printing and typesetting industry. Lorem
            Ipsum has been the industry's standard dummy text ever since the
            1500s, when an unknown printer took a galley of type and scrambled
            it to make a type specimen book. It has survived not only five
            centuries, but also the leap into electronic typesetting, remaining
            essentially unchanged. It was popularised in the 1960s with the
            release of Letraset sheets containing Lorem Ipsum passages, and more
            recently with desktop publishing software like Aldus PageMaker
            including versions of Lorem Ipsum.
          </Text>
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  cardTitle : { backgroundColor: "red", borderRadius: 10, margin: 10 },
  cardElementCenterAlign : {
    alignItems: "center",
    justifyContent: "center",
    backgroundColor: "rgba(0, 128, 0, 0.25)",
    margin: 10,
    borderRadius: 10,
  },
  cardFooter : {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
    backgroundColor: "rgba(0, 128, 0, 0.7)",
    margin: 10,
    padding: 10,
    borderRadius: 10,
  }
});