function reset()
{
    var block = document.getElementsByClassName("wrapper")[0];
    for(var i=1;i<=20;i++)
    {
        block.children[i-1].style.background = "#b3b3ec";
    }
}
function evenNumber(){
    reset();
    var block = document.getElementsByClassName("wrapper")[0];
    for(var i=2;i<=20;i=i+2)
    {
        block.children[i-1].style.background = "white";
    }
}
function multipleOf5(){
    reset();
    var block = document.getElementsByClassName("wrapper")[0];
    for(var i=5;i<=20;i=i+5)
    {
        block.children[i-1].style.background = "white";
    }
}
