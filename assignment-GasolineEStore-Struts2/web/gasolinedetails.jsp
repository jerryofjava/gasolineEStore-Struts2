<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri ="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Details</title>
</head>
<body>
	<h2>Gasoline Order Details</h2>
	<p><b>Fuel Type: </b>${gasType}</p>
	<p><b>Price per Liter Amount: </b>&#8369;${pricePerLiter}</p>
	<p><b>Purchase Amount: </b>&#8369;${purchase}</p>
	<p><b>VAT: </b>&#8369;${vat}</p>
	<p><b>TOTAL AMOUNT: </b>&#8369;${total} (${tagalog})</p>
	<br>
	<p>Credit card <b>${creditNumber}</b> successfully charged.</p>
	<s:form action="gasolineform.jsp" method ="post">
		<s:submit type="submit" value="Go Back"/>
	</s:form>
</body>
</html>