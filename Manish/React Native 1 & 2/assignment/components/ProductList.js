import { View, Text, FlatList } from "react-native";
import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import ProductItem from "./ProductItem";

export default function ProductList(props) {
  const renderItem = ({ item }) => {
    if (item.show) {
      return (
        <ProductItem item={item} navigation={props.navigation}></ProductItem>
      );
    }
  };

  let list = useSelector((state) => state.list);
  let pageNum = useSelector((state) => state.pageNumber);

  const dispatch = useDispatch();
  useEffect(() => {
    console.log("Involing use effect");
    fetchNewItems();
  }, []);

  const fetchNewItems = () => {
    console.log("Fetching new items...");
    fetch(`https://api.jikan.moe/v3/top/manga/${pageNum}/manga`)
      .then((res) => res.json())
      .catch((res) => {
        console.log(res);
      })
      .then((obj) => {
        dispatch({ type: "APPEND", payload: obj.top });
      })
      .catch((res) => {
        console.log(res);
      });
  };

  return (
    <View>
      <FlatList
        data={list}
        renderItem={renderItem}
        keyExtractor={(item) => {
          return `${item.rank}-${item.title}`;
        }}
        onEndReached={fetchNewItems}
        onEndReachedThreshold={0.5}
      />
    </View>
  );
}
