import React from 'react';
import { View, Text, FlatList } from "react-native";
import { useCallback } from 'react/cjs/react.development';
import CardComponent from './cardComponent';

class ListComponent extends React.Component
{

     navigateHandler = (data) =>
     {
         this.props.navigateProduct(data);
     }
    
    render()
    {
       
        return(
              <FlatList
                data={this.props.dataProduct}
                renderItem={({item})=>(
                    <CardComponent data={item} navigateProduct={this.navigateHandler } > </CardComponent>
                )}/>           
        );
    }
}; 


export default ListComponent;