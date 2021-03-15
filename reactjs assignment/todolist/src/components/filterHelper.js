
export default function filterHelper(list,filter) {
    if(filter==='showAll')
    {
        const newlist=list.filter( todo => !todo.delete)
        return newlist;
    }
    else if(filter==='checked')
    {
        const newlist=list.filter(todo => todo.marked && !todo.delete)
        return newlist;
    }    
    else if(filter==='unChecked')
    {
       const newlist=list.filter( todo => !todo.marked && !todo.delete)
        return newlist;
    } 
    else if(filter==='delete')
    {
       const  newlist=list.filter( todo => todo.delete);
        return newlist;
    }
} 