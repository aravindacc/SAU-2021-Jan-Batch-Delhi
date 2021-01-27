import React from 'react';
import 'react-native-gesture-handler';
import {ScrollView,Linking, Image,ActivityIndicator,StyleSheet,Text, View,Button,Alert, TextInput, Dimensions,FlatList, TouchableOpacity} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';

const Stack = createStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Splash">
        <Stack.Screen name="Splash" component={SplashScreen}></Stack.Screen>
        <Stack.Screen name="MainScreen" component={MainScreen} />
        <Stack.Screen name="Details" component={DetailsScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}


class SplashScreen extends React.Component {
  performTimeConsumingTask = async() => {
    return new Promise((resolve) =>
      setTimeout(
        () => { resolve('result') },
        2000
      )
    )
  }

  async componentDidMount() {
    // Preload data from an external API
    // Preload data using AsyncStorage
    const data = await this.performTimeConsumingTask();

    if (data !== null) {
      this.props.navigation.navigate('MainScreen');
    }
  }

  render() {
    return (
      <View style={styles.viewStyles}>
        <TouchableOpacity onPress={()=>this.props.navigation.navigate("MainScreen")}>
        <Text style={styles.textStyles}>
          Assignment By:- Abhishek Kumar Sah
        </Text>
        </TouchableOpacity>
      </View>
    );
  }
}



 class MainScreen extends React.Component{
  
  constructor(props) {
    super(props);

    this.state = {
      data: [],
      isLoading: true,
      isFiltered:false,
      filtereddata:[]
    };
    
  }

  componentDidMount() {
    fetch('https://randomuser.me/api/?seed=3&page=5&results=20')
      .then((response) => response.json())
      .then((json) => {
        this.setState({ data: json.results });
      })
      .catch((error) =>{this.setState({data:[{
        name:{
          title:"Error Found",
          first:"Retry Again",
          last:"Or Restart the application"
        },
        gender:"Error",
        dob:{
          age:"Error"
        },
        picture:{
          large:"https://cdn0.iconfinder.com/data/icons/shift-free/32/Error-512.png"
        }
      }]})})
      .finally(() => {
        this.setState({ isLoading: false });
      });
  }
 
  

render(){
  const {data,isLoading,filtereddata,isFiltered } = this.state;
  const   renderItem=(({item})=>{
    return (
      <View style={styles.bar}>
        <View style={styles.barrow}>
          <Image style={{width:80,height:80}}source={{uri:item.picture.large}}></Image>
        </View>
        <View style={{flex:2}}>
          <Text>Name:- {item.name.title} {item.name.first} {item.name.last}</Text>
          <Text>Gender:- {item.gender} </Text>
          <Text>Age:- {item.dob.age} </Text>
        </View>
        <View style={styles.barrow}>
           <Button title="Details" onPress={()=>submit(item)}></Button>
        </View>
      </View>
    );
    });
    const submit=(item)=>{
      if(item.name.title==="Error"){
        Alert.alert("Error in Api.");
      }
      else{
        this.props.navigation.navigate("Details",{item})
      }
    }
  
  
  
   const Sort=((a,b)=>{
    if(a.dob.age > b.dob.age){
      console.log(a.dob.age,b.dob.age)
      return 1
    }
    else{
      return -1
    }
  
  });
  
  const filter=(text)=>{
    this.setState({isFiltered:true})
   this.setState({filtereddata:this.state.data.filter(item=>{
     const name=item.name.title+" "+item.name.first+" "+item.name.last
     if(name.toLowerCase().includes(text.toLowerCase())){
       return true;
     }
     else{
       return false;
     }
   })})
    console.log(text);

  }
  
  const clear=()=>{
    this.textInput.clear();
    this.setState({isFiltered:false,filtereddata:[]});
  }

  return (
      <View style={styles.grid}>
        <View style={styles.main}>      
        
          <View style={styles.input}>
          <TextInput  autoCapitalize="words" ref={input => { this.textInput = input }} onChangeText={(text)=>filter(text)}></TextInput>
          </View>
  
          <View style={styles.button}>
          <Button  title="Clear" onPress={()=>clear()} />
          </View>
  
          <View style={styles.button}>
          <Button  title="Sort" onPress={()=>this.setState({data:data.sort(Sort)})}/>
          </View>
  
        </View>
        
        <View style={styles.col}>
          {isLoading ? <ActivityIndicator size="large" color="#0000ff"/> : 
      
           <FlatList
          data={isFiltered ? filtereddata:data}
          renderItem={renderItem}
        />
      }
        </View>
  
      </View>
  
    );}


}
  
  function DetailsScreen({route, navigation})
  {
    const {item}=route.params;
    return(
    <View>

      <View>
        <Image style={{width:Dimensions.get("window").width,height:Dimensions.get("window").height*0.4}} source={{uri:item.picture.large}}></Image>
      </View>
      <View style={styles.main}>
      <View style={styles.button}>
        <Button title="Alert" onPress={()=>{Alert.alert(`Name is ${item.name.title+" "+item.name.first+" "+item.name.last}`)}}></Button>
      </View>
      <View style={styles.button}>
      <Button title="Accolite" onPress={()=>Linking.openURL("https://www.accolite.com")}></Button>
      </View>
      </View>

      <ScrollView style={styles.scrollView} 
        contentContainerStyle={styles.contentContainer}>
        <Text style={{fontSize:30}}>
Name:- {item.name.title} {item.name.first} {item.name.last} {"\n"}
Gender:- {item.gender} {"\n"}
Location:- {item.location.street.number+", "+item.location.street.name+", "+item.location.city+", "+item.location.state+", "+item.location.country+" ("+item.location.postcode+")"} {"\n"}
Email:-{item.email}{"\n"}
Phone Number:- {item.phone+" / "+item.cell}{"\n"}
DOB:- {item.dob.date}{"\n"}
Age:- {item.dob.age}{"\n"}

        </Text>
      </ScrollView>
    </View>
  )
  }

  

const styles = StyleSheet.create({
  viewStyles: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'green'
  },
  textStyles: {
    color: 'white',
    fontSize: 40,
    fontWeight: 'bold',
    textAlign:"center"
  },
  grid:{
    display:"flex",
    flexDirection:"column",
    marginBottom:200
  },
  main: {
    display:'flex',
    flexDirection:'row',
    backgroundColor: 'green',
    alignItems: 'center',
    justifyContent: 'flex-start',
    alignContent:"stretch",
    padding:10,
    marginBottom:10
  },
  bar:{
    display:'flex',
    flexDirection:'row',
    justifyContent:"flex-start",
    alignItems:"center",
    alignContent:"stretch",
    width: Dimensions.get('window').width,
    borderBottomWidth:10,
    borderTopWidth:2,
    marginBottom:10,
    paddingBottom:4,
    paddingTop:4,
    paddingRight:10
  },
  barrow:{
    flex:1,
  },
  input:{
    flex:2,
    backgroundColor:"white",
    margin:10
  },
  button:{
    color:'white',
    flex:1,
    borderRadius:50,
    margin:10
  },
  col:{
    display:"flex",
    flexDirection:"column",
    justifyContent:"center",
  },
  paragraph: {
    margin: 24,
    fontSize: 18,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  scrollView: {
    height: '50%',
    width: '100%',
    margin: 20,
    alignSelf: 'center',
    padding: 20,
    borderWidth: 5,
    borderRadius: 5,
    borderColor: 'black',
    backgroundColor: 'lightblue'
  },
  contentContainer: {
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'lightgrey',
    paddingBottom: 50
  }
});


    

export default App;