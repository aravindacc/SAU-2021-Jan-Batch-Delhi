function submitAndValidateForm()
{
    var correctuser= /^[A-Za-z]+$/;
    var username=document.getElementById("uname").value;
    var  email=document.getElementById("email").value;
    var  password=document.getElementById("password").value;
    var  age=document.getElementById("age").value;
    var selectedCategory = document.getElementById('category').value;
    var chkd = document.userform.subject ;
    var gender = document.userform.gender ;
    var  isGenderChecked='false';
    var  isAlteastOneChecked='false';
    var subjectarr=[];
 
    
    if(username.length==0)
    {
        document.getElementById("uspan").innerHTML="**Please Enter Username";
            return false;
    }
    else if(username.length<3)
        {
            document.getElementById("uspan").innerHTML="**Username should be atleast 3 characters";
            return  false;
        }
    else if(!(username.match(correctuser)))
        {
            document.getElementById("uspan").innerHTML="**Only Alphabets are allowed";
            return false;
        }
    else
        {
            document.getElementById("uspan").innerHTML="";
        }

    if(email.length==0)
    {
        document.getElementById("emailspan").innerHTML="**Please Enter E-mail";
            return false;
    }
    else if(email.indexOf('@')<=0)
    {
        document.getElementById("emailspan").innerHTML="**Incorrect @ Position";
            return false;
    }
    else if((email.charAt(email.length-4)!=('.')) && (email.charAt(email.length-4)!=('.')))
    {
        document.getElementById("emailspan").innerHTML="**Incorrect . Position";
            return false;
    }
    else{
        document.getElementById("emailspan").innerHTML="";
    }
    if(password.length==0)
    {
        document.getElementById("passwordspan").innerHTML="**Please Enter Password";
            return false;
    }
    else if(password.length<3)
        {
            document.getElementById("passwordspan").innerHTML="**Password should be atleast 3 characters";
            return  false;
        }
    else{
        document.getElementById("passwordspan").innerHTML="";
    }
    if(age<0 || age>150 )
    {
        document.getElementById("agespan").innerHTML="**Incorrect Age";
            return false;
    }
    else if(age.length<=0 )
    {
        document.getElementById("agespan").innerHTML="**Please Fill Age";
            return false;
    }
    else{
        document.getElementById("agespan").innerHTML="";
    }
    for(var i=0;i<gender.length;i++)
    {
        if(gender[i].checked==true)
        {
            gendervalue=(gender[i].value);
            isGenderChecked='true';
            break;
        }
    }
    if (isGenderChecked=='false')
    {
            document.getElementById("genderspan").innerHTML="**Please select Gender";
            return false;
    }
    else
    {
        document.getElementById("genderspan").innerHTML="";
    }
    j=0;
    for(var i=0;i<chkd.length;i++)
    {
        if(chkd[i].checked==true)
        {
            subjectarr[j++]=chkd[i].value;
            isAlteastOneChecked='true';
        }
    }
    if (isAlteastOneChecked=='false')
    {
            document.getElementById("subjectspan").innerHTML="**Please select atleast one Subject";
            return false;
    }
    else
    {

        document.getElementById("subjectspan").innerHTML="";
        //alert(subjectspan);
    }
    
  //  alert(subjectarr);

    if (selectedCategory == '-1')
     {
      //      alert(selectedCategory);
                document.getElementById("categoryspan").innerHTML="**Please select one Category";
                return false;
    }
    else{
        document.getElementById("categoryspan").innerHTML="";
    } 

    var result={
        Username :  username,
        Email   :  email,
        Password :  password,
        Age : age,
        Gender : gendervalue,
        Subject : subjectarr,
        Category : selectedCategory
    }

        var resultstr=JSON.stringify(result,null,4);
        console.log(resultstr);            
  
        return false;                   //so that output in console window remain 
    
    
}