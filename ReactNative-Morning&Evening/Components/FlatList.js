import React, { Component } from "react";
import { View, Text, FlatList, Button, StyleSheet } from "react-native";
import { SearchBar } from "react-native-elements";
import ListCardComponent from "./ListCards";

export default class FlatListComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      loading: false,
      data: [],
      temp: [],
      error: null,
      search: null,
      toggleOrder: true,
    };
  }

  componentDidMount() {
    this.getData();
  }

  getData = async () => {
    const url = "https://jsonplaceholder.typicode.com/comments";
    this.setState({ loading: true });

    try {
      const response = await fetch(url);
      const json = await response.json();
      this.setResult(json);
    } catch (e) {
      this.setState({ error: "Error Loading content", loading: false });
    }
  };

  setResult = (res) => {
    this.setState({
      data: [...this.state.data, ...res],
      temp: [...this.state.temp, ...res],
      error: res.error || null,
      loading: false,
    });
  };

  renderHeader = () => {
    return (
      <View style={styles.flatListHeader}>
        <SearchBar
          placeholder="Search Here..."
          lightTheme
          round
          editable={true}
          value={this.state.search}
          onChangeText={this.updateSearch}
        />

        <Button
          title="Sort List by Name"
          onPress={() => this.sortListByName()}
        />
      </View>
    );
  };

  updateSearch = (search) => {
    this.setState({ search }, () => {
      if ("" == search) {
        this.setState({
          data: [...this.state.temp],
        });
        return;
      }

      this.state.data = this.state.temp
        .filter(function (item) {
          return item.name.includes(search);
        })
        .map(function ({ id, name, email }) {
          return { id, name, email };
        });
    });
  };

  sortListByName() {
    var dataToOrder = this.state.data;
    var toggleOrder = this.state.toggleOrder;
    dataToOrder.sort(function (obj1, obj2) {
      if (toggleOrder) return obj1.name.localeCompare(obj2.name);
      else return obj2.name.localeCompare(obj1.name);
    });
    toggleOrder = !toggleOrder;

    this.setState({ data: dataToOrder, toggleOrder: toggleOrder });
  }

  render() {
    return (
      <View>
        <FlatList
          style={{}}
          ListHeaderComponent={this.renderHeader}
          stickyHeaderIndices={[0]}
          data={this.state.data}
          renderItem={({ item }) => (
            <ListCardComponent
              name={item.name}
              id={item.id}
              email={item.email}
              address={item.address}
              body={item.body}
              navigation={this.props.navigation}
            ></ListCardComponent>
          )}
          keyExtractor={(item) => item.id}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  flatListHeader: {
    flexDirection: "row",
    padding: 10,
    justifyContent: "center",
    backgroundColor: "#4A4544",
  },
});
