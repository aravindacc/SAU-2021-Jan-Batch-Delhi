function even(){
    var c = document.getElementsByClassName("store")[0];
    for(var i=1;i<=20;i++)
    {
        if(i%2==0)
        {
            c.children[i-1].style.background = "red";
        }
        else
        {
            c.children[i-1].style.background = "white";
        }
    }
}
function five(){
    var c = document.getElementsByClassName("store")[0];
    for(var i=1;i<=20;i++)
    {
        if(i%5==0)
        {
            c.children[i-1].style.background = "blue";
        }
        else
        {
            c.children[i-1].style.background = "white";
        }
    }

}
function reset()
{
    var c = document.getElementsByClassName("store")[0];
    for(var i=1;i<=20;i++)
    {
        c.children[i-1].style.background = "white";
    }
}