/* eslint-disable prettier/prettier */
/* eslint-disable react/self-closing-comp */
/* eslint-disable react-native/no-inline-styles */
/* eslint-disable prettier/prettier */
import React, {useEffect, useState} from 'react';
import {
  FlatList,
  Text,
  View,
  Image,
  StyleSheet,
  Dimensions,
  TouchableOpacity,
  ActivityIndicator,
  // StatusBar,
  // Platform,
  // Alert,
  TextInput,
} from 'react-native';

const FlatListComponent = () => {
  const [isLoading, setLoading] = useState(true);
  const [data, setData] = useState([]);
  //  const [query, setQuery] = useState('');
  //  const [fullData, setFullData] = useState([]);

  console.log(data);
  // function renderHeader() {
  //   return (
  //     <View
  //       style={{
  //         backgroundColor: '#fff',
  //         padding: 10,
  //         marginVertical: 10,
  //         borderRadius: 20,
  //       }}>
  //       <TextInput
  //         autoCapitalize="none"
  //         autoCorrect={false}
  //         clearButtonMode="always"
  //         value={query}
  //         //    onChangeText={queryText => handleSearch(queryText)}
  //         placeholder="Search"
  //        style={{backgroundColor: '#fff', paddingHorizontal: 20}}
  //       />
  //     </View>
  //   );
  // }
  useEffect(() => {
    const url =
      'http://www.json-generator.com/api/json/get/cfBgODcXoy?indent=2';
    fetch(url)
      .then((response) => response.json())
      .then((json) => {
        setData(json);
        //  setFullData(json);
      })
      .catch((error) => console.error(error))
      .finally(() => setLoading(false));
  }, []);
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
  const renderItem = ({item}) => (
    <View
      style={{
        paddingBottom: 25,
        margin: 10,
        backgroundColor: '#8e939c',
        width: 300,
        height: 280,
        borderRadius: 20,
      }}>
      <Image
        style={{width: Dimensions.get('window').width, height: 200}}
        source={{uri: item.image}}
      />
      <View style={{width: 300}}>
        <View style={{flexDirection: 'row', paddingTop: 10}}>
          <Text style={{color: 'white', fontSize: 18, paddingLeft: 20}}>
            {item.author}
          </Text>
          <TouchableOpacity
            style={{
              borderRadius: 10,
              borderColor: 'white',
              borderWidth: 2,
              marginLeft: 15,
              height: 30,
            }}>
            <Text
              style={{color: 'blue', padding: 8, paddingTop: 2, fontSize: 18}}>
              View Details
            </Text>
          </TouchableOpacity>
        </View>

        <Text style={{paddingLeft: 10, color: 'white'}}>
          {' '}
          <Text style={{fontSize: 20, color: 'white'}}>Title :</Text>{' '}
          {item.book_title}
        </Text>
      </View>
    </View>
  );

  return (
    <View style={{flex: 1, padding: 24, backgroundColor: 'grey'}}>
      {isLoading ? (
        <ActivityIndicator size="large" />
      ) : (
        <View style={StyleSheet.container}>
          <View style={{flexDirection: 'row', padding: 10}}>
            <TextInput
              placeholder="Search BookApp"
              placeholderTextColor="white"
              style={{
                width: 200,
                height: 60,
                backgroundColor: '#8e939c',
                borderRadius: 10,
                padding: 20,
              }}></TextInput>
            <TouchableOpacity style={styles.xsbox}>
              <Text style={styles.xstext}>X</Text>
            </TouchableOpacity>
            <TouchableOpacity style={styles.xsbox}>
              <Text style={styles.xstext}>S</Text>
            </TouchableOpacity>
          </View>
          <FlatList
            data={data.book_array}
            keyExtractor={(item, index) => index}
            renderItem={renderItem}
            //  renderItem={({ item }) => ()}
            //ListHeaderComponent={renderHeader}
          />
        </View>
      )}
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  xsbox: {
    width: 40,
    height: 55,
    backgroundColor: '#8e939c',
    marginLeft: 13,
    marginTop: 3,
  },
  xstext: {
    fontSize: 20,
    color: 'white',
    fontWeight: '700',
    padding: 12,
  },
});
export default FlatListComponent;
