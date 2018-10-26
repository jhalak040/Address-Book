<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter another contact</title>
<jsp:include page="header.jsp" />
</head>
<body>
<div>
		<form action="/AddressBook/addcontact/${student.studentId}" method="post">

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
					<td>ContactNum :</td>
					<td><input type="text" name="contactNum"
						 /></td>
				</tr>

			</table>

			<input type="submit" value="Save" />

		</form>
	</div>
</body>
</html>