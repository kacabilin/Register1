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
                <div class="container">
				<div class="row">
					<div class="addstudent">
					<div class="details">xx</div>
                <form method="post" class="form-horizontal">
                <div class="control-group">
                <label class="control-label">Student-id</label>
                <div class="controls">
                <input type="text" id="inputEmail" readonly="readonly" value="<%=rs.getString("id")%>">
                </div>
                </div>
                
                <div class="control-group">
                <label class="control-label">First Name</label>
                <div class="controls">
                <input type="text" id="inputEmail" readonly="readonly" value="<%= rs.getString("firstname")%>">
                </div>
                </div>
                
                <div class="control-group">
                <label class="control-label">Last Name</label>
                <div class="controls">
                <input type="text" id="inputEmail" readonly="readonly" value="<%= rs.getString("lastname")%>">
                </div>
                </div>
                
                <div class="control-group">
                <label class="control-label">Username</label>
                <div class="controls">
                <input type="text" id="inputEmail" readonly="readonly" value="<%= rs.getString("username")%>">
                </div>
                </div>
                
                <div class="control-group">
                <label class="control-label">Password</label>
                <div class="controls">
                <input type="text" id="inputEmail" readonly="readonly" value="<%= rs.getString("password")%>"><br/>
                </div>
                </div>
                </div>
</div>
</div>
</form>
		<%
	}
%>

<%@ include file="footer.jsp"%>