import React, { useEffect } from 'react';
import { View, Text } from 'react-native';
import { StackActions, CommonActions } from '@react-navigation/native';

const splashScreen = (props) => {
;

  // useEffect(() => {
  //   setTimeout(
  //     () => {
  //       props.navigation.navigate("ListingScreen");
  //     },
  //     6000
  //   );
  // }, [])

  useEffect(
    () => {
      let timer1 = setTimeout(() => props.navigation.navigate("ListingScreen"), 500)

      return () => {
        clearTimeout(timer1)
      }
    },
    [] )


  return (
    <View style={{ flex: 1,justifyContent:"center",alignItems:"center" }}>
      <Text>REACT NATIVE ASSIGNMENT</Text>

    </View>

  );

}
export default splashScreen;
