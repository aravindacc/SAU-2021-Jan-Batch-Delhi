import React, { useEffect, useState }from "react";
import {
    View,
    Text,
    TouchableOpacity,
    Image,
    ScrollView,
    Alert, Button, Linking
} from 'react-native';
import { FONTS, COLORS, SIZES, back_arrow_icon } from "../constants";
import { Dimensions } from 'react-native';

const UserDetail = ({ route, navigation }) => {
    const { height } = Dimensions.get('window');
    const imageHeight= 0.4*height;
    const imageSectionHeight=1.5*imageHeight;
    const userSectionHeight=60;
    const scrollSectionHeight=(height-(imageSectionHeight+userSectionHeight));
    

    const [user, setUser] = useState(null);
    console.log(user);

    useEffect(() => {
        let { user } = route.params;
        setUser(user)
    }, [user])

    function renderUserInfoSection() {
        const name=user.name;
    
        return (
            <View style={{ flex: 2, backgroundColor:'orange'}}>
                <View style={{ flexDirection: 'row', paddingHorizontal: SIZES.radius, height: 70, alignItems: 'flex-end', borderStyle:'solid', borderColor:'black', borderWidth:4 }}>
                    <TouchableOpacity
                        style={{ marginLeft: SIZES.base }}
                        onPress={() => navigation.goBack()}
                    >
                        <Image
                            source={back_arrow_icon}
                            resizeMode="contain"
                            style={{
                                width: 25,
                                height: 25,
                            }}
                        />
                    </TouchableOpacity>
                    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center'  }}>
                        <Text style={{ ...FONTS.h3, color: 'black' }}>User Detail</Text>
                    </View>
                </View>
                <View style={{ flex: 5, alignItems: 'center' , height: imageSectionHeight }}>
                    <Image
                        source={{uri: 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Gnome-stock_person.svg/1024px-Gnome-stock_person.svg.png'}}
                        resizeMode="contain"
                        style={{
                            flex: 1,
                            width: 150,
                            height: imageHeight,
                            marginTop:10
                        }}
                    />
                    <View  style={{ flex: 1, flexDirection:'row', padding:5, alignItems: 'center', justifyContent:'space-around'}}>
                    <Button title="Click Me!"  color= 'black'  onPress={() => Alert.alert("You have pressed the profile for : "+name)}/>
                    <Text>            </Text>
                    <Button title="Visit Accolite Website"  color= 'black' onPress={() => {Linking.openURL('https://www.accolite.com/');}}/>
                    </View>
                </View>
               
                <View style={{ backgroundColor:'black', alignContent:'flex-start', justifyContent:'center',}}>
                    <Text style={{ ...FONTS.body3, color: 'white' , paddingLeft:24, paddingTop:15}}>Name : {user.name}</Text>
                    <Text style={{ ...FONTS.body3, color: 'white' , paddingLeft:24, paddingTop:5}}>UserId: {user.id}</Text>
                    <Text style={{ ...FONTS.body3, color: 'white' , paddingLeft:24, paddingTop:5}}>UserName : {user.username}</Text>
                    <Text style={{ ...FONTS.body3, color: 'white' , paddingLeft:24, paddingTop:5}}>UserEmail: {user.email}</Text>
                    <Text style={{ ...FONTS.body3, color: 'white' , paddingLeft:24, paddingTop:5}}>Conatct Number: {user.phone}</Text>
                    <Text style={{ ...FONTS.body3, color: 'white' , paddingLeft:24, paddingTop:5}}>Website : {user.website}</Text>
                    <View>
                    <ScrollView style={{flexGrow:1, backgroundColor:'orange', margin:5}} showsHorizontalScrollIndicator='true'>
                    <View style={{height:scrollSectionHeight}}>
                    <Text style={{ ...FONTS.body3, color: 'black' , paddingLeft:24, paddingTop:5,paddingBottom:15, paddingRight:24, textAlign:'justify'}}>React Native lets you create truly native apps and doesn't compromise your users' experiences. It provides a core set of platform agnostic native components like View, Text, and Image that map directly to the platform’s native UI building blocks.
                    React components wrap existing native code and interact with native APIs via React’s declarative UI paradigm and JavaScript. This enables native app development for whole new teams of developers, and can let existing native teams work much faster.
                    Keep in mind that ScrollViews must have a bounded height in order to work, since they contain unbounded-height children into a bounded container (via a scroll interaction). In order to bound the height of a ScrollView, either set the height of the view directly (discouraged) or make sure all parent views have bounded height.</Text>
                    </View>
                    </ScrollView>
                    </View>
                </View>
               
            </View>
        )
    }
    if (user) {
        return (
            <View style={{ flex: 1, backgroundColor: COLORS.black }}>
                <View style={{ flex: 1 }}>
                    {renderUserInfoSection()}
                </View>
            </View>
        )
    } else {
        return (<></>)
    }

}

export default UserDetail;