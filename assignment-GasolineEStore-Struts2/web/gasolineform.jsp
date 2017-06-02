<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri ="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gasoline eStore</title>
</head>
<body>
	<h2>Gasoline Order Form</h2>
	<h4>Available:</h4>
	<ul>
		<li>Unlieded</li>
		<li>Diesel</li>
		<li>Premium</li>
	</ul>
	<s:form action ="compute.action" method ="post">
		<s:textfield label="Gasoline Type" key="gasType"/>
		<s:textfield label="Liters" key="liters"/>
		<s:radio label="Credit Card" name="creditCard" list="#{'Visa':'Visa','Mastercard':'Mastercard','JCB':'JCB','AmEx':'AmEx','Diners':'Diners'}" value="Visa"/>
		<s:textfield label="Credit Card Number" key="creditNumber"/>
		<s:submit type="submit" value="Order"/>
		<s:reset/>
	</s:form>
</body>
</html>