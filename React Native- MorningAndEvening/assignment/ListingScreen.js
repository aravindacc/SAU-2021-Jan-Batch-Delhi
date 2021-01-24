import React, { useState, useEffect } from "react";
import { View,Text, FlatList, TouchableOpacity, Image, Dimensions,
         StyleSheet, ActivityIndicator, TextInput} from "react-native";
import axios from "axios";
import { SafeAreaView } from 'react-native-safe-area-context';


import DetailsScreen from './DetailsScreen';


const URL = "https://api.themoviedb.org/3/movie/top_rated?api_key=5deeab9fe5f6217459b933ee8e9a133b&page=";
const imgUrl = "https://image.tmdb.org/t/p/original";

const windowWidth = Dimensions.get('window').width;

const ListingScreen = (props) => {

    const [filterArray, setFilterArray] = useState([]);
    const [loader, setLoader] = useState(false);
    const [movieArray, setMovieArray] = useState([]);
    const [pageNo, setPageNo] = useState(1);
    const [searchText, setSearchText] = useState("");

  useEffect(() => {
    setLoader(true);
    axios.get(`${URL}${pageNo}`).then(res => {
        setPageNo(pageNo + 1);
        setLoader(false);
        setFilterArray(res.data.results);
        setMovieArray(res.data.results);
    }).catch(err => {
      console.error("ERROR", err)
    });

  }, [])



  const movieApiCall = () => {

    setLoader(true);
    axios.get(`${URL}${pageNo}`).then(res => {
        setPageNo(pageNo + 1);
        setMovieArray(prev => [...prev, ...res.data.results])
        setLoader(false);
        setFilterArray(prev => [...prev, ...res.data.results]);
    }).catch(err => {
      console.error("ERROR", err)
    });
  }

  const sortListByName = () => {
    setLoader(true);
    setTimeout(() => {
      let tempArray = movieArray
      tempArray.sort(function (obj1, obj2) {
        return obj1.title > obj2.title;
      });

      setMovieArray(tempArray);
      setLoader(false);
    }, 2000)
  }

  const filterMovieList = text => {
    console.log("inner text", text);

    let newArr = [];
    for (let i = 0; i < filterArray.length; i++) {
      const itemData = filterArray[i].title.toLowerCase()
      const textData = text.toLowerCase();
      if (itemData.includes(textData)) {
        newArr.push(filterArray[i])
      }
    }
    setMovieArray(newArr);
  }


  const renderListItem = ({ item, index }) => {
    let movieItem = item;
    if (movieArray.length - 1 == index) {
      return <>
        <View
          style={{   
            backgroundColor: "rosybrown",
          justifyContent: "center",
          marginBottom: "2%",
          borderRadius: 30
          }}
        >
          <View style={{ paddingLeft: 10, marginTop: 10 }}>
          <Text style = {{fontWeight:'bold', fontSize: 25 ,fontStyle: 'italic', textAlign: 'center'}}>
            {movieItem.title}</Text>
            <Image
              style={styles.imageStyle}
              source={{ uri: `${imgUrl}${movieItem.backdrop_path}` }}
              style={{ height: 300, borderRadius: 20, resizeMode: "cover" }}
            />
          </View>

          <View style ={{flexDirection: "row", justifyContent: "space-between",flex: 1, flexWrap: "wrap"}}>
          <View style={{ paddingLeft: 10, marginTop: 10 }}>
            
            <Text>Released On : {movieItem.release_date}</Text>
            <Text>Popularity : {movieItem.popularity}</Text>
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
                title: movieItem.title,
                description: movieItem.overview,
                image: movieItem.backdrop_path
              })}
              style={{
                backgroundColor: "#008080",
              padding:5,
              borderRadius: 8,
              alignItems: "center",
              justifyContent: "center",
              alignSelf: "flex-end",
              }}
            >
                <Text
              style={{
                color: "white",
                fontSize: 20,
                marginLeft: "1%"
              }}
            >
            Get Details
            </Text>
            </TouchableOpacity>
        </View>
        </View>

          <View
            style={{ height: 3, backgroundColor: "gray", marginTop: 10 }}
          ></View>
        </View>


        <View style={{ flexDirection: "row", margin: 15, justifyContent: "center" }}>
          <TouchableOpacity style={styles.buttonStyle} onPress={() => movieApiCall()} >
            <Text style = {{fontSize: 15, fontWeight: 'bold'}}>Load More</Text>
          </TouchableOpacity>
        </View>

      </>
    } else {
      return <View
        style={{
            backgroundColor: "rosybrown",
          justifyContent: "center",
          marginBottom: "2%",
          borderRadius: 30
          
        }}
      >
        <View style={{ margin:"2%"}}>
        <Text style = {{fontWeight:'bold', fontSize: 25 ,fontStyle: 'italic', textAlign: 'center'}}>
            {movieItem.title}</Text>
          <Image
            style={styles.imageStyle}
            source={{ uri: `${imgUrl}${movieItem.backdrop_path}` }}
            style={{ height: 200,borderRadius: 20, resizeMode: "cover" }}
          />
        </View>

        <View style ={{flexDirection: "row", justifyContent: "space-between",flex: 1, flexWrap: "wrap"}}>
        <View style={{ paddingLeft: 10, marginTop: 10 }}>
          
            <Text>Released On : {movieItem.release_date}</Text>
            <Text>Popularity : {movieItem.popularity}</Text>
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
              title: movieItem.title,
              description: movieItem.overview,
              image: movieItem.backdrop_path
            })}
            style={{
              backgroundColor: "#008080",
              padding:5,
              borderRadius: 8,
              alignItems: "center",
              justifyContent: "center",
              alignSelf: "flex-end",
            }}
          >
            <Text
              style={{
                color: "white",
                fontSize: 20,
                marginLeft: "1%"
              }}
            >
            Get Details
            </Text>
          </TouchableOpacity>
        </View>
        </View>

        <View
          style={{ height: 3, backgroundColor: "gray", marginTop: 10 }}
        ></View>
      </View>

    }

  }


  if (loader) {
    return (
      <View style={{ flex: 1, backgroundColor: "#fff", justifyContent: "center" }}>
        <ActivityIndicator color={"blue"} />
      </View>
    )
  }

  return (
    <SafeAreaView style={styles.viewStyle}>

        <View style ={{backgroundColor: '#c0c0c0', borderRadius: 20}}>
            <Text style = {{fontSize: 20, alignSelf: 'center',fontWeight: "bold"}}>Top Rated Movies</Text>
        </View>

      <View style={{ flexDirection: "row", marginBottom: "1%", marginTop:"1%"}}>
        <TextInput
          style={styles.textInputStyle}
          onChangeText={(text) => {
            setSearchText(text)
            filterMovieList(text)
          }}
          value={searchText}
          underlineColorAndroid="transparent"
          placeholder=" Search"
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
                width: 40,
                backgroundColor: "#ba0000",
                borderRadius: 20,
                marginRight: 10,
                justifyContent: "center",
              }}
            >
              <Text
                style={{
                  color: "white",
                  fontSize: 27,
                  alignSelf: "center",
                  
                }}
              >
                X
          </Text>
            </TouchableOpacity>
          </View>

          <View>
            <TouchableOpacity
              onPress={() => sortListByName()}
              style={{
                height: 40,
                width: 40,
                backgroundColor: "seagreen",
                borderRadius: 19,
                justifyContent: "center",
              }}
            >
              <Text
                style={{
                  color: "white",
                  fontSize: 27,
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
        keyExtractor={(item, index) => index.toString()}
      />
    </SafeAreaView>

  );
}

export default ListingScreen;

const styles = StyleSheet.create({
  viewStyle: {
    justifyContent: "center",
    backgroundColor: 'gray',
    flex: 1,
    padding: 16,
  },
  textStyle: {
    padding: 10,
  },
  textInputStyle: {
    height: 40,
    borderWidth: 2,
    marginRight: 10,
    borderColor: "green",
    backgroundColor: "#c0c0c0",
    paddingLeft:6,
    borderRadius:20,
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
    height: "40%",
    
  },
  buttonStyle: {
    height: 40,
    width: windowWidth - 50,
    borderColor: "green",
    backgroundColor: '#c0c0c0',
    borderWidth: 2,
    borderRadius: 20,
    marginRight: 10,
    marginLeft:10,
    alignItems: "center",
    justifyContent: "center",
    

  }
});