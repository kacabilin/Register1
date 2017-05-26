<%-- 
    Document   : view_register
    Created on : May 26, 2017, 12:37:46 PM
    Author     : ADI
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Commands.SQLOperations"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp"%>

<%
	

	Connection connection = SQLOperations.getConnection();
	ResultSet rs=SQLOperations.getAllProfile(connection);
	

	while (rs.next()){
		%>
		<h4>Student-ID: <%=rs.getString("id")%></h4>
		<h4>first name: <%= rs.getString("firstname") %></h4>
		<h4>last name: <%= rs.getString("lastname") %></h4>
		<h4>Username: <%= rs.getString("username") %></h4>
                <h4>Password: <%= rs.getString("password") %></h4><br/>
		
		<%
	}
%>

<%@ include file="footer.jsp"%>