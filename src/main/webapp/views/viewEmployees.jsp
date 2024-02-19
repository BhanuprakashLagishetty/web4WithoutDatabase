<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.web4.Model.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<h1>${res}<h1>
    <h1>Employee List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Designation</th>
            <th>Salary</th>

            <!-- Assuming you want to display Name and Role as well -->
            <!-- <th>Name</th>
            <th>Role</th> -->
        </tr>
        <%
            // Corrected import and data type
            ArrayList<Employee> employeeList = (ArrayList<Employee>) request.getAttribute("allEmployee");
            if (employeeList != null) {
                for (Employee employee : employeeList) {
        %>
            <tr>
                <td><%= employee.getEid() %></td>
                <td><%= employee.getEname() %></td>
                 <td><%= employee.getEdesignation() %></td>
                  <td><%= employee.getEsalary() %></td>


            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="3">No employees found</td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
