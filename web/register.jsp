<%-- 
    Document   : footer
    Created on : May 25, 2017, 10:06:29 PM
    Author     : ADI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp"%>

<div class="container">
<div class="margin-top">
<div class="row">
<div class="span12">

<div class="alert alert-info" align="center"><b>Register</b></div>
<div class="addstudent">
<div class="details">Please Enter Details Below</div>
<form class="form-horizontal" method="POST" action="insert.php">
    
<div class="control-group">
<label class="control-label">Firstname:</label>
<div class="controls">
<input type="text" name="first_name" pattern="[A-Za-z  0-9\s]{1,200}" placeholder="Firstname" required>

</div>
</div>

<div class="control-group">
<label class="control-label">Lastname:</label>
<div class="controls">
<input type="text" name="last_name" pattern="[A-Za-z\s]{1,200}" placeholder="Lastname" required>

</div>
</div>

<div class="control-group">
<label class="control-label">Username:</label>
<div class="controls">
<input type="text" name="username" pattern="[A-Za-z]{1,200}" placeholder="Firstname">

</div>
</div>

<div class="control-group">
<label class="control-label">Password:</label>
<div class="controls">
<input type="password" name="password" pattern="[A-Za-z]{6,200}" placeholder="password" required>

</div>
</div>

<div class="control-group">
<label class="control-label">Confirm Password:</label>
<div class="controls">
<input type="password" name="confirm_password" pattern="[A-Za-z 0-9]{6,200}" placeholder="password">

</div>
</div>




<div class="control-group">
<div class="controls">
<button name="submit" type="submit" class="btn btn-success"><i class="icon-save icon-large"></i>&nbsp;Save</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button name="submit" type="reset" class="btn btn-danger"><i class="icon-trash icon-large"></i>&nbsp;Reset</button>
</div>
</div>
</form>
</div>
</div>
</div>
</div>
</div>

<%@ include file="footer.jsp"%>

