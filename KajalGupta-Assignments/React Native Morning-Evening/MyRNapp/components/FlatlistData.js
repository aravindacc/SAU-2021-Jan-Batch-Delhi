import React, { Component } from 'react';
import { FlatList, TouchableOpacity, View, Text,Image, Button,Alert} from 'react-native';
import { StyleSheet } from 'react-native';
import { COLORS, SIZES } from "../constants";
import { withNavigation } from 'react-navigation';
import SearchBar from "./SearchBar";
import filter from 'lodash.filter';

class FlatlistData extends Component{

    constructor(props){
        super(props);
        this.state={
            loading:false,
            data:[],
            temp:[],
            error:null,
            search:null,
        };
        const { navigation } = this.props.navigation;
    }
    
    componentDidMount(){
        this.getData();
    };

    getData = async () => {
        const url = "https://jsonplaceholder.typicode.com/photos";
        this.setState({ loading: true });

        try {
            const response = await fetch(url);
            const json = await response.json();
            console.log(json);
            this.setResult(json);
        } catch (e) {
        this.setState({ error: "Error Loading content", loading: false });
        }
    };

    setResult=(res)=>{
        this.setState({
            data:[...this.state.data,...res],
            temp:[...this.state.temp,...res],
            error:res.error|| null,
            loading: false,
            fullData: res
            });
    };

    renderItem({item}, props) {
        return <TouchableOpacity style={{
            flex: 1,
            marginRight:24,}}onPress={() => alert('Movie clicked!')}
        >
                    <View>
                    <Image source={item.url} style={styles.Image} />
                    </View>
                    <View  style={styles.listItemContainer}>
                    <Text style={styles.ItemHeader}>Id : {item.id}</Text>
                    <Text style={styles.ItemHeader}>Title : {item.title}</Text>
                    <Button title="Details"  color= '#7E685A'  onPress={() => this.props.navigation.navigate("UserDetail", {
                            user: item
                        })} />
                    </View>
                   
                </TouchableOpacity>
    }

    sortListById(){
        this.state.data.sort(function(obj1, obj2) {
         return obj2.id - obj1.id;
       });
    
       this.setState(previousState => (
         { data: previousState.data }
       ))
     }

     sortListByName(){
        this.state.data.sort(function(obj1, obj2) {
         return obj1.name.localeCompare(obj2.name)
       });
    
       this.setState(previousState => (
         { data: previousState.data }
       ))
     }

    render(){
        return(
            <View>
            <View style={{flexDirection: 'row', justifyContent: 'space-between' , backgroundColor: 'white', margin:2,padding:5}}>
                <Text style={{  color: COLORS.black, padding:5}}> List of Movies : </Text>
                <Button title="Sort By ID"  color= '#7E685A'  onPress={() => this.sortListById()}/>
                <Button title="Sort By Title"  color= '#7E685A'  onPress={() => this.sortListByName()}/>
            </View>
             <View style={{ flex: 1, marginTop: SIZES.padding }}></View>
            <FlatList ListHeaderComponent={SearchBar.render}
            data={this.state.data}
            extraData={this.state}
            renderItem= {(item) => this.renderItem(item, this.props)}
            keyExtractor={(item) => item.id.toString()} />   
            </View> 
        );
    }
}

export default withNavigation(FlatlistData);

const styles = StyleSheet.create({
    listItemContainer: {
        borderStyle: 'solid',
        borderColor: '#fff',
        borderBottomWidth: 2,
        flexDirection: 'row',
        justifyContent: 'space-between',
        padding: 10,
        backgroundColor: 'white',
        marginBottom:20,
        
    },
    ItemHeader: {  
        color: 'black',
        fontSize: 12,
       fontWeight: 'bold',
       textAlign:'center',
     
    },
    Image: {
        backgroundColor: 'white',
        padding:20,
        margin:10,
        alignSelf:'center',
        width: 150,
        height: 200,
        borderRadius: 20
        
    },
})
