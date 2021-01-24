const initialState = {
  list: [],
  pageNumber: 1,
};

const listReducer = (state = initialState, action) => {
  switch (action.type) {
    // add new data at the end list
    case "APPEND": {
      const newData = action.payload.map((item) => {
        item.show = true; // adding one more property on basis we can show element
        return item;
      });
      const preItems = JSON.parse(JSON.stringify(state.list));
      return {
        list: [...preItems, ...newData],
        pageNumber: state.pageNumber + 1,
      };
    }

    // search on basis of text
    case "SEARCH": {
      let filteredList = JSON.parse(JSON.stringify(state.list));
      filteredList = state.list.map((item) => {
        item.show = item.title
          .toLowerCase()
          .includes(action.payload.toLowerCase())
          ? true
          : false;
        return item;
      });
      return {
        list: filteredList,
      };
    }

    // sort my members
    case "SORT": {
      // const s = Date.now()
      const sortedOnMembers = JSON.parse(JSON.stringify(state.list));
      sortedOnMembers.sort((a, b) => b.members - a.members);

      // const e = Date.now()
      // console.log(e-s);
      return {
        list: sortedOnMembers,
        pageNumber: state.pageNumber,
      };
    }

    // reset sorting and seach filter
    case "RESETFILTER": {
      const defaultSort = JSON.parse(JSON.stringify(state.list));
      defaultSort.sort((a, b) => (a.rank > b.rank ? 1 : -1));
      defaultSort.forEach((item) => {
        item.show = true;
      });
      return {
        list: defaultSort,
        pageNumber: state.pageNumber,
      };
    }
    default:
      return state;
  }
};

export default listReducer;
