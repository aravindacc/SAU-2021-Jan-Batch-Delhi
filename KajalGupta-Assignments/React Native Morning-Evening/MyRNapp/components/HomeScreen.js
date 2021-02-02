import React, { useState } from 'react';
import {
  SafeAreaView,
  View,
  Text,
  Image,} from 'react-native';

import FlatlistData from './FlatlistData';
import SearchBar from './SearchBar';
import { COLORS, search_icon} from "../constants";


const HomeScreen = ({ navigation }) => {
  const AppHeader= {
      name: 'Movies',
  }

  const [myHeader, setHeader] = useState(AppHeader);

  function renderHeader(myHeader) {
    return (
        
        <View style={{ flex: 1, flexDirection: 'row',color: '#AFD275', paddingHorizontal:8, alignItems: 'center',  }}>
                <View style={{ margin: 0 }}>
                    <Text style={{ fontWeight: 'bold', fontSize:30, color: COLORS.black, marginTop:25, padding:5, borderStyle:'solid', borderColor:'black'}}>{AppHeader.name}</Text>
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
  return (
    <SafeAreaView style={{ flex: 1, backgroundColor:'#C2CAD0' }}>
        <View style={{ height: 140,  backgroundColor:COLORS.pink }}>
            {renderHeader(myHeader)}
        </View>
        <View style={{ flex: 1 }}>
                <FlatlistData navigation={navigation}></ FlatlistData>
            </View>
    </SafeAreaView>
  )
}

export default HomeScreen;

