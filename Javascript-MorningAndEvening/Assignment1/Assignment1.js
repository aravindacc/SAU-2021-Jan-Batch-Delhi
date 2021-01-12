function divisibleByTwo(){
    var container = document.getElementsByClassName("container")[0];
    for(i = 0;i < 20; i++)
    {
        if((i+1)%2 == 0)
            container.children[i].style.background = "green";
        else
            container.children[i].style.background = "white";
    }
}

function divisibleByThree(){
    var container = document.getElementsByClassName("container")[0];
    for(i = 0;i < 20; i++)
    {
        if((i+1)%3 == 0)
            container.children[i].style.background = "red";
        else
            container.children[i].style.background = "white";
    }
}

function divisibleByFive(){
    var container = document.getElementsByClassName("container")[0];
    for(var i = 0; i< 20; i++)
    {
        if((i+1)%5 == 0)
            container.children[i].style.background = "blue";
        else
            container.children[i].style.background = "white";
    }

}

function reset()
{
    var container = document.getElementsByClassName("container")[0];
    for(var i = 0; i < 20; i++)
        container.children[i].style.background = "white";
}