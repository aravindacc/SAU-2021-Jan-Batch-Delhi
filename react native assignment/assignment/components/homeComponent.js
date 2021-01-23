import { StatusBar } from 'expo-status-bar';
import React, {useEffect, useCallback ,useState} from 'react';
import { render } from 'react-dom';
import { ActivityIndicator, StyleSheet, Text, View } from 'react-native';
import Filter from './FilterComponent';
import Listcomponent from './listComponent';


 const HomeComponent= ({navigation})=>{

    const [Product,setProduct]=useState([]);
    const [filteredProduct,stFilteredProduct]=useState("");
    const [isLoading, setLoading] = useState(true);
    const [filterType,setFilterType]=useState('price');    

    useEffect(() => {
      fetch('http://3f3d8912b23e.ngrok.io/products')
        .then((response) => response.json())
        .then((json)=>setProduct(json))
        .catch((error) => console.error(error))
        .finally(() => setLoading(false));
    }, []);
    
      const onSearchFilter = useCallback( (value) =>{
        stFilteredProduct(value);
      });
    
      function custom_sort(a, b) {
        return (a[filterType]) - (b[filterType]);
    }
    
      const onDateFilter=useCallback(()=>{
          setFilterType(filterType=='price'?'rating':'price');
        })

      const navigateHandler=useCallback((value)=>
      {
        navigation.navigate('ProductDetails',{data:value});
      })

    return (
    <View style={styles.container}>
      {isLoading ? <ActivityIndicator/> : (
        <View>
      <Filter searchFilter={onSearchFilter}  dateFilter={onDateFilter}></Filter>
      <Listcomponent navigateProduct={navigateHandler}  dataProduct={Product.sort(custom_sort).filter(product => product.title.startsWith(filteredProduct) )}></Listcomponent> 
      <StatusBar style="auto" />
      </View>
      )}
    </View>
    );
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      paddingTop:15,
      backgroundColor: 'black',
      alignItems: 'center',
      justifyContent: 'center',
    },
  });


export default HomeComponent;