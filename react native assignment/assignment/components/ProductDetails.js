import React,{useState} from 'react';
import {ScrollView, View ,Text,Dimensions, Image, Button , Linking,Alert,Modal,StyleSheet,TouchableHighlight,} from 'react-native';

 const ProductDetails = ({route})=>{
    const [modalVisible, setModalVisible] = useState(false);
        return (
                <View style={{flex:1,backgroundColor:'grey'}}>
                    <Modal
                        animationType="slide"
                        transparent={true}
                        visible={modalVisible}
                        onRequestClose={() => {Alert.alert("Modal has been closed.");}}>
                        <View style={styles.centeredView}>
                            <View style={styles.modalView}>
                                <Text style={styles.modalText}>
                                    Title : {route.params.data.title}    
                                </Text>
                                <Text style={styles.modalText}>
                                    Price : {route.params.data.price}    
                                </Text>
                                <Text style={styles.modalText}>
                                    Rating : {route.params.data.rating}    
                                </Text>
                                <Text style={styles.modalText}>
                                    Type : {route.params.data.type}    
                                </Text>
                                <TouchableHighlight
                                    style={{ ...styles.openButton, backgroundColor: "#2196F3" }}
                                    onPress={() => {setModalVisible(!modalVisible);}}>
                                    <Text style={styles.textStyle}>okay!</Text>
                                </TouchableHighlight>
                            </View>
                        </View>
                    </Modal>
                <Image source={{uri:'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg'}} style={{width:'100%' ,height :Dimensions.get('window').height*0.4}}></Image>
                <View style={{flexDirection:'row',justifyContent:'space-around',margin:20}}>
                    <Button style={{ flex:0.4 ,borderWidth:5 }} color='darkgrey' onPress={() => {setModalVisible(true);}} title="Click me!"></Button>
                    <Button style={{flex:0.4}} color='darkgrey' title="view Details" onPress={ ()=>{ Linking.openURL('https://www.accolite.com/')}}></Button>
                </View>
                    < ScrollView style={{margin:10,borderWidth:2,backgroundColor:'darkgrey'}}>
                    <Text style={{padding:5}} >
                    Milestone 2 
● On the header add a back button to navigate back to the listing screen.(Make sure this
header needs to be sticky)
● Show Image with height 0.4 of the total height of the device.
● On click of the Click Me! button open a dialog showing “you have pressed the
”
● On clicking the View Details button open this url (https://www.accolite.com/) into a
webview/web browser.
● Use redux to keep the list data in a global state and when user clicks same source for
more than once, instead of making an api request to fetch detail everytime use the data
from redux store(Optional)
● Below the buttons show a description of the product that can be any hardcoded text
(more than 500-600 words) so that the screen can be scrollable.
● On clicking the View Details button open this url (https://www.accolite.com/) into a
webview/web browser.
● Use redux to keep the list data in a global state and when user clicks same source for
more than once, instead of making an api request to fetch detail everytime use the data
from redux store(Optional)
● Below the buttons show a description of the product that can be any hardcoded text
(more than 500-600 words) so that the screen can be scrollable.
● On clicking the View Details button open this url (https://www.accolite.com/) into a
webview/web browser.
● Use redux to keep the list data in a global state and when user clicks same source for
more than once, instead of making an api request to fetch detail everytime use the data
from redux store(Optional)
● Below the buttons show a description of the product that can be any hardcoded text
(more than 500-600 words) so that the screen can be scrollable.

                    </Text>
                </ScrollView>

            </View>

        );
    
}

const styles = StyleSheet.create({
    centeredView: {
      flex: 1,
      justifyContent: "center",
      alignItems: "center",
      marginTop: 22
    },
    modalView: {
      margin: 20,
      backgroundColor: "white",
      borderRadius: 20,
      padding: 35,
      alignItems: "center",
      shadowColor: "#000",
      shadowOffset: {
        width: 0,
        height: 2
      },
      shadowOpacity: 0.25,
      shadowRadius: 3.84,
      elevation: 5
    },
    openButton: {
      backgroundColor: "#F194FF",
      borderRadius: 20,
      padding: 10,
      elevation: 2
    },
    textStyle: {
      color: "white",
      fontWeight: "bold",
      textAlign: "center"
    },
    modalText: {
      marginBottom: 15,
      textAlign: "center"
    }
  });
  

export default ProductDetails;