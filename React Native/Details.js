import React from 'react';
import {AppRegistry , StyleSheet,TextInput , Button ,FlatList , Image,  Text,View,ActivityIndicator} from 'react-native';
import { ScrollView } from 'react-native-gesture-handler';

export default function Details() {
    const imageUrl ="https://image.ptgf.org/r/t/p/png"; 
   
  
       //  const{navigate} = this.props.navigation;

         return (
             <ScrollView>
                 <View>
                    <Image source={{uri: `${imageUrl}`}}/>
                 </View>

                 <View>

                 <TouchableOpacity onPress={() => alert(`You have clicked ${author}`)}>
                        <View >
                            <Text>Click Me !</Text>
                        </View>

                    </TouchableOpacity>
                
                    <Text>
                        <Button title='View Details' onPress={()=>{Linking.openURL("https://www.accolite.com/")}}/>
                    </Text>

                     
                 </View>
             </ScrollView>

         );
    
}