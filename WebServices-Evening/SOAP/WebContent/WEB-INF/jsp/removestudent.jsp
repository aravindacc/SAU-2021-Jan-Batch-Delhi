<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Student Details</h3>
        <form:form method="POST" 
          action="deleteStudent">
             <table>
             <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
               <tr>
                    <td><input type="submit" value="Remove Student"/></td>
                </tr> 
            </table>
        </form:form>
    </body>
</html>