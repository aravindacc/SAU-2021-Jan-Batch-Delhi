import React, { useState, useEffect } from "react";
import {
  View,
  Text,
  FlatList,
  TouchableOpacity,
  Image,
  Dimensions,
  StyleSheet,
  ActivityIndicator,
  TextInput
} from "react-native";
import axios from "axios";

const URL =
  "https://api.themoviedb.org/3/discover/movie?api_key=ec22bcac3d47ff20ef15f6bb599acfb7&page=";
const imgUrl = "https://image.tmdb.org/t/p/original";

const windowWidth = Dimensions.get('window').width;

const listingScreen = (props) => {
  const [loader, setLoader] = useState(false);
  const [movieArray, setMovieArray] = useState([]);
  const [pageNo, setPageNo] = useState(1);
  const [searchText, setSearchText] = useState("");
  const [filterArray, setFilterArray] = useState([]);

  useEffect(() => {
    setLoader(true);
    axios.get(`${URL}${pageNo}`).then(res => {
      setMovieArray(res.data.results);
      setFilterArray(res.data.results);
      setPageNo(pageNo + 1);
      setLoader(false);
    }).catch(err => {
      console.error("ERROR", err)
    });

  }, [])



  const movieApiCall = () => {

    setLoader(true);
    axios.get(`${URL}${pageNo}`).then(res => {
      setMovieArray(prev => [...prev, ...res.data.results])
      setFilterArray(prev => [...prev, ...res.data.results]);
      setPageNo(pageNo + 1);
      setLoader(false);
    }).catch(err => {
      console.error("ERROR", err)
    });
  }

  const filterMovieList = text => {
    console.log("inner text", text);
    // const newData = filterArray.filter(function (item) {
    //   //applying filter for the inserted text in search bar
    //   const itemData = item.title.toLowerCase()
    //   console.log("item title", item.title);
    //   console.log("item original_title", item.original_title);
    //   const textData = text.toLowerCase();
    //   return itemData.includes(textData);

    // });


    let newArr = [];
    for (let i = 0; i < filterArray.length; i++) {
      const itemData = filterArray[i].title.toLowerCase()
      const textData = text.toLowerCase();
      if (itemData.includes(textData)) {
        newArr.push(filterArray[i])
      }
    }
    console.log("newArr", newArr);
    setMovieArray(newArr);

  }


  const renderListItem = ({ item, index }) => {
    let movieItem = item;
    if (movieArray.length - 1 == index) {
      return <>
        <View
          style={{

            justifyContent: "center",
          }}
        >
          <View style={{ paddingLeft: 10, marginTop: 10 }}>
            <Image
              style={styles.imageStyle}
              source={{ uri: `${imgUrl}${movieItem.backdrop_path}` }}
              style={{ height: 300, width: 380, resizeMode: "cover" }}
            />
          </View>
          <View style={{ paddingLeft: 10, marginTop: 10 }}>
            <Text>Title : {movieItem.title}</Text>
            <Text>popularity : {movieItem.popularity}</Text>
            <Text>Release Date : {movieItem.release_date}</Text>
          </View>

          <View
            style={{
              flexDirection: "row",
              justifyContent: "flex-end",
              paddingRight: 10,
              marginTop: 20,
            }}
          >
            <TouchableOpacity
              onPress={() => props.navigation.navigate("DetailsScreen", {
                title: movieItem.original_title,
                description: movieItem.overview,
                image: movieItem.backdrop_path
              })}
              style={{
                height: 40,
                width: 180,
                backgroundColor: "blue",
                borderRadius: 5,
                alignItems: "center",
                justifyContent: "center",
                alignSelf: "flex-end",
              }}
            >
              <Text
                style={{
                  color: "white",
                  fontSize: 20,
                }}
              >
                View Details
    </Text>
            </TouchableOpacity>
          </View>

          <View
            style={{ height: 3, backgroundColor: "gray", marginTop: 10 }}
          ></View>
        </View>


        <View style={{ flexDirection: "row", margin: 15, justifyContent: "center" }}>
          <TouchableOpacity style={styles.buttonStyle} onPress={() => movieApiCall()} >
            <Text>Load More</Text>
          </TouchableOpacity>
        </View>

      </>
    } else {
      return <View
        style={{

          justifyContent: "center",
        }}
      >
        <View style={{ paddingLeft: 10, marginTop: 10 }}>
          <Image
            style={styles.imageStyle}
            source={{ uri: `${imgUrl}${movieItem.backdrop_path}` }}
            style={{ height: 300, width: 380, resizeMode: "cover" }}
          />
        </View>
        <View style={{ paddingLeft: 10, marginTop: 10 }}>
          <Text>Title : {movieItem.title}</Text>
          <Text>popularity : {movieItem.popularity}</Text>
          <Text>Release Date : {movieItem.release_date}</Text>
        </View>

        <View
          style={{
            flexDirection: "row",
            justifyContent: "flex-end",
            paddingRight: 10,
            marginTop: 20,
          }}
        >
          <TouchableOpacity
            onPress={() => props.navigation.navigate("DetailsScreen", {
              title: movieItem.original_title,
              description: movieItem.overview,
              image: movieItem.backdrop_path
            })}
            style={{
              height: 40,
              width: 180,
              backgroundColor: "blue",
              borderRadius: 5,
              alignItems: "center",
              justifyContent: "center",
              alignSelf: "flex-end",
            }}
          >
            <Text
              style={{
                color: "white",
                fontSize: 20,
              }}
            >
              View Details
    </Text>
          </TouchableOpacity>
        </View>

        <View
          style={{ height: 3, backgroundColor: "gray", marginTop: 10 }}
        ></View>
      </View>

    }

  }

  const sortListById = () => {
    setLoader(true);
    setTimeout(() => {
      //Sort ArrayList by ascending order
      let tempArray = movieArray
      tempArray.sort(function (obj1, obj2) {
        // Ascending: first id less than the previous
        return obj1.id - obj2.id;
      });

      // this.setState((previousState) => ({ data: previousState.data }));
      setMovieArray(tempArray);
      setLoader(false);
    }, 2000)

  }

  if (loader) {
    return (
      <View style={{ flex: 1, backgroundColor: "#fff", justifyContent: "center" }}>
        <ActivityIndicator color={"blue"} />
      </View>
    )
  }

  return (
    <View style={styles.viewStyle}>
      <View style={{ flexDirection: "row" }}>
        <TextInput
          style={styles.textInputStyle}
          onChangeText={(text) => {
            setSearchText(text)
            filterMovieList(text)
          }}
          value={searchText}
          underlineColorAndroid="transparent"
          placeholder="Search Here"
        />
        <View style={{ flexDirection: "row" }}>

          <View>
            <TouchableOpacity
              onPress={() => {
                setSearchText("")
                filterMovieList("")
              }}
              style={{
                height: 40,
                width: 30,
                backgroundColor: "blue",
                borderRadius: 2,
                marginRight: 10,
                justifyContent: "center",
              }}
            >
              <Text
                style={{
                  color: "white",
                  fontSize: 20,
                  alignSelf: "center",
                }}
              >
                X
          </Text>
            </TouchableOpacity>
          </View>

          <View>
            <TouchableOpacity
              onPress={() => sortListById()}
              style={{
                height: 40,
                width: 30,
                backgroundColor: "blue",
                borderRadius: 2,
                justifyContent: "center",
              }}
            >
              <Text
                style={{
                  color: "white",
                  fontSize: 20,
                  alignSelf: "center",
                }}
              >
                S
          </Text>
            </TouchableOpacity>
          </View>

        </View>
      </View>


      <FlatList
        data={movieArray}
        contentContainerStyle={{ flexGrow: 1 }}
        ListEmptyComponent={() => (<View><Text>empty</Text></View>)}
        renderItem={renderListItem}
        // onEndReached={movieApiCall}
        // onEndReachedThreshold={0.5}
        keyExtractor={(item, index) => index.toString()}
      />
    </View>

  );
}

export default listingScreen;

const styles = StyleSheet.create({
  viewStyle: {
    justifyContent: "center",
    flex: 1,
    padding: 16,
  },
  textStyle: {
    padding: 10,
  },
  textInputStyle: {
    height: 40,
    borderWidth: 1,
    marginLeft: 10,
    marginRight: 10,
    borderColor: "#009688",
    backgroundColor: "#FFFFFF",
    flex: 1,
  },
  container: {
    flex: 1,
    margin: 10,
    backgroundColor: "#FFF",
    borderRadius: 6,
  },
  imageStyle: {
    resizeMode: "center",
    width: "100%",
    height: "50%",
  },
  buttonStyle: {
    height: 40,
    width: windowWidth * 0.4,
    borderColor: "blue",
    borderWidth: 1,
    borderRadius: 5,
    marginRight: 10,
    alignItems: "center",
    justifyContent: "center",
  }
});