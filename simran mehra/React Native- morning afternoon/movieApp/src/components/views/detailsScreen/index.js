import React from 'react'
import { View, Text, Dimensions, Image, StyleSheet, Linking,ScrollView, TouchableOpacity } from 'react-native'
import { useState } from 'react/cjs/react.development';

const windowHeight = Dimensions.get('window').height;
const windowWidth = Dimensions.get('window').width;
export default function detailsScreen({ route }) {
    const imgUrl = "https://image.tmdb.org/t/p/original";

    const image = route.params.image;
    const movieName = route.params.title;
    console.log("asdasd", image)

    return (
        <ScrollView>
            <View style={{ padding: 16 }}>
                <Image
                    style={styles.imageStyle}
                    source={{ uri: `${imgUrl}${image}` }}
                    style={{ height: windowHeight * 0.4, width: windowWidth * 0.9, resizeMode: "cover" }}
                />
                <View style={{ flexDirection: "row", justifyContent: "space-between", marginVertical: 15 }}>
                    <TouchableOpacity onPress={() => alert(`You have clicked ${movieName}`)}>
                        <View style={styles.buttonStyle}>
                            <Text>Click Me !</Text>
                        </View>

                    </TouchableOpacity>
                    <TouchableOpacity onPress={()=>{Linking.openURL("https://www.accolite.com/")}} >

                        <View style={styles.buttonStyle}>
                            <Text>View Details </Text>
                        </View>
                    </TouchableOpacity>
                </View>
                <Text>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metusPellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metusPellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</Text>

            </View>
        </ScrollView>
    )
}

const styles = StyleSheet.create({

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
