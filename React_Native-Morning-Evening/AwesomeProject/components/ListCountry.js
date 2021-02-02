import React from 'react';
import { View, Text, FlatList } from "react-native";
import { useCallback } from 'react/cjs/react.development';
import Country from './Country';
class ListCountry extends React.Component   {
    navigateHandle = (details) => {
        this.props.navigateCountry(details);
    }
    render()    {
        return(
              <FlatList
                data={this.props.CountryList}
                renderItem={({item})=>(
                    <Country 
                        data={item} 
                        navigateCountry={
                            this.navigateHandle 
                        } 
                    > 
                    </Country>
                )}/>           
        );
    }
}; 


export default ListCountry;