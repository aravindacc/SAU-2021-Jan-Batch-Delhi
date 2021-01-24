import React from 'react'
import { useState } from 'react/cjs/react.development';
import { View, Text, Dimensions, Image, StyleSheet, Linking,ScrollView, TouchableOpacity } from 'react-native'

const windowWidth = Dimensions.get('window').width;
const windowHeight = Dimensions.get('window').height;

export default function DetailsScreen({ route }) {
    const imgUrl = "https://image.tmdb.org/t/p/original";

    const image = route.params.image;
    const movieName = route.params.title;

    return (
        <ScrollView>
            <View style={{ padding: 16,backgroundColor: '#c0c0c0' }}>
                <Image
                    source={{ uri: `${imgUrl}${image}` }}
                    style={styles.imageStyle}
                />
                <View style={{ flexDirection: "row", justifyContent: "space-between", marginVertical: 15 }}>
                    <TouchableOpacity onPress={() => alert(`You have Pressed: ${movieName}`)}>
                        <View style={styles.buttonStyle}>
                            <Text style ={{color: "white", fontWeight:'bold'}}>Click Me !</Text>
                        </View>

                    </TouchableOpacity>
                    <TouchableOpacity onPress={()=>{Linking.openURL("https://www.accolite.com/")}} >

                        <View style={styles.buttonStyle}>
                            <Text style ={{color: "white", fontWeight:'bold'}}>View Details </Text>
                        </View>
                    </TouchableOpacity>
                </View>

                <Text>A film, also called a movie, motion picture or moving picture, is a work 
                    of visual art used to simulate experiences that communicate ideas, stories, 
                    ceptions, feelings, beauty, or atmosphere through the use of moving images. 
                    These images are generally accompanied by sound, and more rarely, other sensory
                     stimulations.[1] The word "cinema", short for cinematography, is often used to
                      refer to filmmaking and the film industry, and to the art form that is the 
                      result of it.{'\n'}
                </Text>
                
                <Text>The moving images of a film are created by photographing actual scenes with
                     a motion-picture camera, by photographing drawings or miniature models using
                      traditional animation techniques, by means of CGI and computer animation, or
                       by a combination of some or all of these techniques, and other visual 
                       effects.{'\n'}
                </Text>
                
                <Text>Traditionally, films were recorded onto celluloid film stock through a 
                    photochemical process and then shown through a movie projector onto a large screen.
                     Contemporary films are often fully digital through the entire process of production, 
                     distribution, and exhibition, while films recorded in a photochemical form 
                     traditionally included an analogous optical soundtrack (a graphic recording of the 
                     spoken words, music and other sounds that accompany the images which runs along a 
                     portion of the film exclusively reserved for it, and is not projected).{'\n'}
                </Text>

                <Text>
                Films are cultural artifacts created by specific cultures. They reflect those 
                cultures, and, in turn, affect them. Film is considered to be an important art 
                form, a source of popular entertainment, and a powerful medium for educating—or
                 indoctrinating—citizens. The visual basis of film gives it a universal power of
                 communication. Some films have become popular worldwide attractions through 
                 the use of dubbing or subtitles to translate the dialog into other languages.
                </Text>
                

            </View>
        </ScrollView>
    )
}

const styles = StyleSheet.create({

    imageStyle: {
        height: 200,borderRadius: 20, resizeMode: "center" 
    },
    buttonStyle: {
        marginRight: 10,
        height: 40,
        borderRadius: 15,
        width: windowWidth * 0.4,
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: '#008080'
        
    }
});
