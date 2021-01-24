import React, { Component } from 'react';
import { AppRegistry, TextInput, View, Button ,StyleSheet} from 'react-native';
import filter from 'lodash.filter';

export default class ChangeText extends Component {
  constructor(props) {
    super(props);
    this.state = { text: '' };
  }

  contains = ({ name}, query) => {
    if (
      name.includes(query) 
    ) {
      return true
    }
    return false
  }


  handleSearch = () => {
    const formattedQuery = text.toLowerCase()
    const data = filter(this.state.fullData, user => {
      return this.contains(user, formattedQuery)
    })
    this.setState({ data, query: text })
  }

  Cleartext = () => {
    this.setState({
        text: ''
    })
  }
render() {
    return (
            <View style={{ flex: 1, flexDirection: 'row'}}>
                <TextInput 
                    autoCapitalize='none'
                    style={styles.textInput}
                    onChangeText={(text) => this.setState({text})}
                    //onChangeText={(text) => this.handleSearch({text})}
                    value={this.state.text}
                    clearButtonMode='always'
                    placeholder='Enter text...'
                    />
                    <Button
                    onPress={this.Cleartext}
                    title='Clear'
                    color='#7E685A' />
                </View>
                      
    );
  }
}

AppRegistry.registerComponent('clear-text', () => ChangeText);

const styles = StyleSheet.create({
    textInput:{
       alignItems: 'center',
          backgroundColor: '#E6E8E9',
          borderRadius: 10,
          color: '#8E8E93',
          flexDirection: 'row',
          fontSize: 17,
          height: 40,
          width:227,
          marginRight:5,
          padding: 10
    },
  });
  
  