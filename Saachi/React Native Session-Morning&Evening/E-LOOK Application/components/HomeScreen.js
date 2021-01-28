import React, { useState } from 'react';
import {
  SafeAreaView,
  View,
  Text,
  Image,} from 'react-native';

import FlatlistData from './FlatlistData';
import SearchBar from './SearchBar';
import { COLORS, search_icon} from "../constants";
import { render } from 'react-dom';
import { Dimensions } from 'react-native';



const HomeScreen = ({ navigation }) => {
  const AppHeader= { name: 'E-LOOK'}
  const AppFooter={contact: 'Submitted by- saachi@r.accolitedigital.com'}
  const [myHeader, setHeader] = useState(AppHeader);
  const [myFooter, setFooter] = useState(AppFooter);
  let deviceWidth = Dimensions.get('window').width


  function renderHeader(myHeader) {
    return (
        
        <View style={{ flex: 1, flexDirection: 'row', alignItems: 'center',  }}>
                <View>
                  <View style={{ backgroundColor:'rgba(0,0,0,0.2)',width:deviceWidth}}>
                    <Text style={{ fontWeight: 'italic',textAlign:'center', fontFamily:'serif', fontSize:30, color: COLORS.black, marginTop:25, padding:5, borderStyle:'solid', borderColor:'black'}}>{AppHeader.name}</Text>
                  </View>
                  <View style={{ flex: 1, flexDirection: 'row', alignItems: 'center' }}>
                    <View style={{ width: 45, height: 45, alignItems: 'center',margin:5, justifyContent: 'center', borderRadius: 25, backgroundColor: 'rgba(0,0,0,0.5)' }}>
                            <Image
                                source={search_icon}
                                resizeMode="contain"
                                style={{
                                    width: 27,
                                    height: 27,
                                    flex: 3, flexDirection: 'row'
                                }}
                            />
                    </View  >
                    <SearchBar style={{justifyContent: 'flex-start',}}></SearchBar>
                   </View>
                </View>
            </View>
    )
  }

  function renderFooter(myFooter){
    return(
      <View style={{ flex: 1, flexDirection: 'row', textAlign:'center', height:0 }}>
              <Text style={{ fontWeight: 'bold',textAlign:'center', fontSize:8, color: COLORS.black, marginTop:2, padding:5, paddingLeft:100, borderStyle:'solid', borderColor:'black'}}>{AppFooter.contact}</Text>
        </View>    
      )
  }

  return (
    <SafeAreaView style={{ flex: 1, backgroundColor: COLORS.black }}>
        <View style={{ height: 140,  backgroundColor:'orange' }}>
            {renderHeader(myHeader)}
        </View>
        <View style={{ flex: 1 }}>
                <FlatlistData navigation={navigation}></ FlatlistData>
        </View>
        <View style={{height: 30,  backgroundColor:'orange', textAlign:'center' }}>
          {renderFooter(myFooter)}
        </View>
    </SafeAreaView>
  )
}

export default HomeScreen;

