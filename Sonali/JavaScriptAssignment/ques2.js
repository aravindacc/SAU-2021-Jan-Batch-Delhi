
var isChange='false';
function highlightEven()
{
    var divno=document.getElementsByTagName("div");
    if(isChange)
    {
        for(var i=0;i<20;i++)
        {
                divno[i].style.backgroundColor="white";
            
        }
    }
        for(var i=0;i<20;i++)
        {
            if(i%2!=0)
            {
                divno[i].style.backgroundColor="red";
            }
        }
    isChange='true';
    
}
function highlightFive()
{
    var divno=document.getElementsByTagName("div");
    if(isChange)
    {
        for(var i=0;i<20;i++)
        {
                divno[i].style.backgroundColor="white";
            
        }
    }
    
        for(var i=0;i<20;i++)
        {
            if((i+1)%5==0)
            {
                divno[i].style.backgroundColor="red";
            }
        }
    isChange='true';
}

function resetAll()
{
    if(isChange)
    {
        var divno=document.getElementsByTagName("div");
        for(var i=0;i<20;i++)
        {
                divno[i].style.backgroundColor="white";
            
        }
    }
}
