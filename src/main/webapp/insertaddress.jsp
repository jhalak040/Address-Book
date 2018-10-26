<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Another Address</title>
<jsp:include page="header.jsp"/>

<style>
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
		<form action="/AddressBook/add/${student.studentId}" method="post">

			<table cellpadding="3pt">
				<tr>
					<td>StudentID:</td>
					<td><input type="text" name="studentId" readonly="readonly"
						value="${student.studentId}" /></td>
				</tr>

				<tr>
					<td>FirstName :</td>
					<td><input type="text" name="firstName" readonly="readonly"
						value="${student.firstName}" /></td>
				</tr>
				<tr>
					<td>LastName :</td>
					<td><input type="text" name="lastName" readonly="readonly"
						value="${student.lastName}" /></td>
				</tr>
              
				<tr>
					<td>BuildingName :</td>
					<td><input type="text" name="buildingName"
						 /></td>
				</tr>

				<tr>
					<td>FlatNumber:</td>
					<td><input type="text" name="flatNum"
						 /></td>
				</tr>
				<tr>
					<td>StreetName:</td>
					<td><input type="text" name="streetName"
						/></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><input type="text" name="city"  /></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><input type="text" name="state"  /></td>
				</tr>
				<tr>
					<td>Pincode</td>
					<td><input type="text" name="pincode"
						 /></td>

				</tr>


			</table>

			<input type="submit" value="Save" />

		</form>
	</div>

</body>
</html>