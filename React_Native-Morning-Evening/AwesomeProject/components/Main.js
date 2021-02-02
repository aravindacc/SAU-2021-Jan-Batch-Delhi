import React, { useEffect, useState ,useCallback} from "react";
import {FlatList,Button,Dimensions,ImageBackground, Image, SafeAreaView, StatusBar, StyleSheet, Text, TouchableOpacity, View } from "react-native";
import FitlterCountry from "./FilterCountry"
import ListCountry from "./ListCountry"

const Main = ({navigation}) => {
  const [Countries,setCountries] = useState([]);
  const [FilteredKey,setFilteredKey] = useState("");
  const [filterType,setFilteredType] = useState('country');


  useEffect(() => {
    async function fetchMyAPI() {
      let response = await fetch('https://corona.lmao.ninja/v2/countries')
      response = await response.json()
      setCountries(response)
    }
    fetchMyAPI()
  }, [])
 
  const onSearchFilter = useCallback( (value) =>{
    setFilteredKey(value);
  });

  const onFilter=useCallback(()=>{
    setFilteredType(filterType=='country'?'cases':'country');
    console.log(filterType)
  })

  function sortBasedOnKey(a,b)
  {
    return (a[filterType]) - (b[filterType]);
  }

  const navigateHandle = useCallback((details) => {
    console.log(122)
    navigation.navigate('CountryCoronaDetail',{data: details})
  })
  return(
    <View style={styles.container}>
      <FitlterCountry searchFilter={onSearchFilter}  ownFilter={onFilter}></FitlterCountry>
      <ListCountry navigateCountry={navigateHandle} CountryList={Countries.sort(sortBasedOnKey).filter(item => item.country.startsWith(FilteredKey) )}></ListCountry> 

    </View>
  )
  
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop:15,
    backgroundColor: 'grey',
    alignItems: 'center',
    justifyContent: 'center',
  },
});

export default Main;





























// class Main extends React.Component {
//   constructor() {
//     super();
//     this.state={
//       data:[]
//     }
//   }
//   // API fetch
//   componentDidMount() {
//     this.apiCall();
//   }
//   async apiCall() {
//     let resp = await fetch("https://corona.lmao.ninja/v2/countries")
//     let respJson = await resp.json()
//     // console.warn("data", respJson[0].cases)
//     this.setState({data : respJson})
//   }

  

//   render()  {
//     const renderItem = ({ item }) => {
//       return (
//         <View style={{flex:1, justifyContent:'center',alignItems:"center",margin:20}}>
//             <View style={{width:Dimensions.get('window').width *0.4 ,height:Dimensions.get('window').height*0.5}}>
//               <ImageBackground source={{uri:item.countryInfo.flag}} style={{width:'100%',height:'100%',justifyContent:"flex-end"}}>
//               <View style={{flex:0.1,flexDirection:"row",height:"10%",justifyContent:"space-between",alignItems:"center",backgroundColor:"black",borderBottomLeftRadius:10,borderBottomRightRadius:10,padding:10}}>
//                   <Text style={{fontWeight:"bold",fontSize:"25px",color:"white",flex:0.4,alignItems:"center",textAlign:"center"}}>{item.country} </Text>
//                   <Text style={{fontWeight:"bold",fontSize:"25px",color:"white",flex:0.25}}>{item.cases} </Text>
//                   <Button title="View Details" onPress={()=>{this.props.navigateProduct(item.country)}}  style={{padding:5}}></Button>
//                 </View>
//               </ImageBackground>        
//             </View>
//         </View>
//       )
//     }
  
//     return (
//       <SafeAreaView style={styles.container}>
//         <FlatList
//           data={this.state.data}
//           renderItem={renderItem}
//         />
//         </SafeAreaView>
//       // <div>{console.log(this.state.data[0])}</div>
//     )
//   }
// }


// const styles=StyleSheet.create({
//   container:{backgroundColor:"grey" }
// });


// export default Main



