import { StatusBar } from 'expo-status-bar';
import React, { useState, useEffect } from "react";
import { View, Text, FlatList, TouchableOpacity, Image, Dimensions, StyleSheet, ActivityIndicator, TextInput } from "react-native";
import { StackNavigator } from 'react-navigation';
import axios from "axios";

const URL = 'http://www.json-generator.com/api/json/get/ccLAsEcOSq?indent=1';
const ListScreen = (props) => {
    const [booksArray, setBookArray] = useState([]);
    const [searchText, setsearchText] = useState("");
    const [filterBookArray, setFilterArray] = useState([]);

    useEffect(() => {
    const url = 'http://www.json-generator.com/api/json/get/ccLAsEcOSq?indent=1'
    fetch(url)
            .then((response) => response.json())
            .then((responseInjson) => {
                setBookArray(responseInjson.book_array);
                setFilterArray(responseInjson.book_array);
            })
            .catch((error) => {
                console.log(error)
            })
    },[])

//     const componentDidMount=()=>{
//         const url = 'http://www.json-generator.com/api/json/get/ccLAsEcOSq?indent=1'
//         fetch(url)
//             .then((response) => response.json())
//             .then((responseInjson) => {
//                 setBookArray(responseInjson.book_array);
//                 setFilterArray(responseInjson.book_array);
//             })
//             .catch((error) => {
//                 console.log(error)
//             })
//     }
    const filterBookList = (text) => {

        const newArray = filterBookArray.filter(function (item) {
            const textData = text.toLowerCase();
            const itemData = item.book_title.toLowerCase()
            return itemData.includes(textData);

        });

        setbookArray(newArray);
        setsearchText(text)
    }
    const renderListItem = ({ item }) => {
        let bookItem = item;

        return <View
            style={{ justifyContent: "center" }}>
            <View style={{ paddingLeft: 10, marginTop: 10 }}>
                <Image
                    style={styles.imageStyle}
                    source={{ uri: bookItem.image }}
                    style={{ height: 300, width: 380, resizeMode: "cover" }}
                />
            </View>
            <View style={{ paddingLeft: 10, marginTop: 10 }}>
                <Text>Title : {bookItem.book_title}</Text>
                <Text>Author : {bookItem.author}</Text>
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
                    onPress={() => props.navigation.navigate("ViewDetailScreen", {
                        title: bookItem.book_title,
                        description: bookItem.overview,
                        image: bookItem.image
                    })}
                    style={{
                        height: 30,
                        width: 150,
                        backgroundColor: "black",
                        borderRadius: 4,
                        alignItems: "center",
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
                style={
                    {
                        height: 4,
                        backgroundColor: "gray",
                        marginTop: 10
                    }
                }
            ></View>
        </View>
    }
    const sortListByName = () => {
        setTimeout(() => {
            let tempArray = booksArray
            tempArray.sort(function (b1, b2) {
                return b1 > b2;
            });

            setBookArray(tempArray);
        }, 2000)

    }

    return (
        <View style={styles.styleView}>
            <View style={{ flexDirection: "row" }}>
                <TextInput
                    style={styles.textStyleOfInput}
                    onChangeText={(text) => {
                        filterBookList(text)
                    }}
                    value={searchText}
                    underlineColorAndroid="transparent"
                    placeholder="Search Here"
                />
                <View style={
                    { marginLeft: 25 }
                }>
                    <TouchableOpacity
                        style={{
                            height: 40,
                            width: 30,
                            backgroundColor: "gray",
                            borderRadius: 4,
                            marginRight: 15,
                            justifyContent: "center",
                        }}
                        onPress={() => {
                            setsearchText("")
                            filterBookList("")
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
                        onPress={() => sortListByName()}
                        style={{
                            height: 40,
                            width: 30,
                            backgroundColor: "gray",
                            borderRadius: 2,
                            justifyContent: "center",
                        }}
                    >
                        <Text
                            style={{
                                color: "white",
                                fontSize: 23,
                                alignSelf: "center",
                            }}
                        >
                            S
                </Text>
                    </TouchableOpacity>
                </View>
            </View>


            <FlatList
                data={booksArray)}
                contentContainerStyle={{ flexGrow: 1 }}
                renderItem={renderListItem}
            />
        </View>

    );

}

export default ListScreen;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        margin: 10,
        backgroundColor: "#FFF",
        borderRadius: 6,
    },
    textStyle: {
        padding: 10,
    },
    textStyleOfInput: {
        height: 40,
        borderWidth: 1,
        marginLeft: 10,
        marginRight: 10,
        borderColor: "#009688",
        backgroundColor: "#FFFFFF",
        flex: 1,
    },
    styleView: {
        justifyContent: "center",
        flex: 1,
        padding: 16,
    },
    imageStyle: {
        resizeMode: "center",
        width: "100%",
        height: "50%",
    },
    buttonStyle: {
        height: 40,
        width: 30,
        borderColor: "blue",
        borderWidth: 1,
        borderRadius: 5,
        marginRight: 10,
        alignItems: "center",
        justifyContent: "center",
    }
});
