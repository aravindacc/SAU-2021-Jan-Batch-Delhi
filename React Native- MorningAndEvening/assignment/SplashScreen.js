import React, { useEffect } from 'react';
import { View, Text } from 'react-native';
import { StackActions, CommonActions } from '@react-navigation/native';
import {ListingScreen} from './ListingScreen';

const SplashScreen = (props) => {

 useEffect(
    () => {
    let timer1 = setTimeout(
      () => props.navigation.navigate('ListingScreen'),
      500,
    );

      return () => {
      clearTimeout(timer1);
      }
    },
    [] )


  return (
    <View style={{flex: 1, justifyContent: 'center', alignItems: 'center'}}>
      <Text>Top Rated Movies</Text>

    </View>

  );

}
export default SplashScreen;
