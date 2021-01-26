<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
  
<h1>Student List</h1>  
<table border="1" width="70%" cellpadding="2">  
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="student" items="${list}">   
   <tr>  
   <td>${student.id}</td>  
   <td>${student.firstName}</td>  
   <td>${student.lastName}</td>  
   <td>${student.department}</td>  
   <td><a href="/editstudent/${student.id}">Edit</a></td>  
   <td><a href="/deletestudent/${student.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
    