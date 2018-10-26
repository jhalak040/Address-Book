
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Record</title>
<jsp:include page="header.jsp" />

<style>
.header {
	overflow: hidden;
	background-color: #f1f1f1;
	padding: 20px 10px;
}

a {
	color: black;
	text-align: center;
	padding: 	10px;
	text-decoration: none;
	font-size: 18px;
	line-height: 25px;
}

a:hover {
	background-color: #ddd;
	color: black;
}

div {
	padding: 25px;
	margin: 25px;
	border: 1px solid black;
}

#table-scroll {
	height: 350px;
	overflow: auto;
	margin-top: 20px;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}
</style>

</head>
<body>

	<div>
		<form action="/AddressBook/update/${student.studentId}" method="post">

			<table cellpadding="3pt">
				<tr>
					<td>StudentID:</td>
					<td><input type="text" name="studentId"
						value="${student.studentId}" readonly="readonly" /></td>
				</tr>

				<tr>
					<td>FirstName :</td>
					<td><input type="text" name="firstName"
						value="${student.firstName}" /></td>
				</tr>
				<tr>
					<td>LastName :</td>
					<td><input type="text" name="lastName"
						value="${student.lastName}" /></td>
				</tr>
			</table>
			<c:forEach items="${student.addresslist}" var="address">
				<input type="hidden" value="${address.addressId}" name="addId" />

				<table cellpadding="3pt">

					<tr>

						<td>BuildingName :</td>
						<td><input type="text" name="buildingName"
							value="${address.buildingName}" /></td>
					</tr>

					<tr>
						<td>FlatNumber:</td>
						<td><input type="text" name="flatNum"
							value="${address.flatNum}" /></td>
					</tr>
					<tr>
						<td>StreetName:</td>
						<td><input type="text" name="streetName"
							value="${address.streetName}" /></td>
					</tr>
					<tr>
						<td>City:</td>
						<td><input type="text" name="city" value="${address.city}" /></td>
					</tr>
					<tr>
						<td>State:</td>
						<td><input type="text" name="state" value="${address.state}" /></td>
					</tr>
					<tr>
						<td>Pincode</td>
						<td><input type="text" name="pincode"
							value="${address.pincode}" /></td>
					</tr>
					<tr><td><a href="/AddressBook/delecteaddress/${address.addressId}"> Delete</a></td>
					</tr>
				</table>
			</c:forEach>

			<c:forEach items="${student.contactlist}" var="contact">
				<input type="hidden" name="contId" value="${contact.contactId}" />
				<table>

					<tr>

						<td>contactNumber</td>
						<td><input type="text" name="contactNum"
							value="${contact.contactNum}" /></td>
							<td><a href="/AddressBook/deletecontact/${contact.contactId}"> Delete</a></td>
					</tr>
				</table>
			</c:forEach>

			<div>
				<a
					href="<%=request.getContextPath()%>/getaddress/${student.studentId}">
					add address</a> <a
					href="<%=request.getContextPath()%>/getcontact/${student.studentId}">

					add contact</a> <input type="submit" value="Save" />
			</div>
		</form>
	</div>



</body>
</html>