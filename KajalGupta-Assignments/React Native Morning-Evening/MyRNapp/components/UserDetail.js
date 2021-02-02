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
    console.log(height);
    const imageHeight= 0.4*height;
    const imageSectionHeight=1.5*imageHeight;
    const scrollSectionHeight=(height-imageSectionHeight);

    const [user, setUser] = useState(null);
    console.log(user);

    useEffect(() => {
        let { user } = route.params;
        setUser(user)
    }, [user])

    function renderUserInfoSection() {
        const name=user.name;
    
        return (
            <View style={{ flex: 2, backgroundColor:'white'}}>
                <View style={{ flexDirection: 'row', backgroundColor:'#E7717D', paddingHorizontal: SIZES.radius, height: 70, alignItems: 'flex-end', borderStyle:'solid', borderColor:'black', borderWidth:4 }}>
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
                        <Text style={{ ...FONTS.h1, color: 'black' }}>Movie Detail</Text>
                    </View>
                </View>
                <View style={{ flex: 5, alignItems: 'center' , backgroundColor:'#C2CAD0', height: imageSectionHeight }}>
                    <Image
                        source={user.url}
                        resizeMode="contain"
                        style={{
                            flex: 1,
                            width: 150,
                            height: imageHeight,
                            marginTop:10
                        }}
                    />
                    <View  style={{ flex: 1, flexDirection:'row', padding:5, alignItems: 'center', justifyContent:'space-around'}}>
                    <Button title="Click Me!"  color= '#7E685A'  onPress={() => Alert.alert("You have pressed the profile for : "+name)}/>
                    <Text>            </Text>
                    <Button title="Visit Accolite Website"  color= '#7E685A' onPress={() => {Linking.openURL('https://www.accolite.com/');}}/>
                    </View>
                </View>
               
                <View style={{ backgroundColor:'#E7717D', alignContent:'flex-start', justifyContent:'center'}}>
                    <Text style={{ ...FONTS.body3, color: 'white' , paddingLeft:24, paddingTop:15}}>Title : {user.title}</Text>
                    <Text style={{ ...FONTS.body3, color: 'white' , paddingLeft:24, paddingTop:5}}>Album ID: {user.id}</Text>
                    <View>
                    <ScrollView style={{flexGrow:1, backgroundColor:'white', margin:5}} showsHorizontalScrollIndicator='true'>
                    <View style={{height:scrollSectionHeight}}>
                    <Text style={{ ...FONTS.body3, color: 'black' , paddingLeft:24, paddingTop:5,paddingBottom:15, paddingRight:24, textAlign:'justify'}}>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).</Text>
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