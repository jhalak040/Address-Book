<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AddressBook</title>
<script type="text/javascript" language="javascript">
	function myaddress() {
		var add = document.getElementById("mytable");
		add.innerHTML = document.getElementById("myrows").innerHTML;
	}
	function mycontact() {
		var add = document.getElementById("addcontact");
		add.innerHTML = document.getElementById("contacttable").innerHTML;
	}
</script>

<style>
div {
	padding: 25px;
	margin: 2px;
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
		<br />
		<form action="<%=request.getContextPath()%>/insert" method="post">
			<table cellpadding="5pt" border="1px solid black ">
				<tr>
					<td>StudentID:</td>
					<td><input type="text" name="studentId"
						value="${student.studentId}" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>FirstName :</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>LastName:</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
			</table>

			<table cellpadding="5pt" border="1px solid black ">
				<tr>
					<table id="myrows">
						<tr>
							<td>FlatNumber:</td>
							<td><input type="text" name="flatNum" /></td>
						</tr>
						<tr>
							<td>BuildingName :</td>
							<td><input type="text" name="buildingName"></td>
						</tr>
						<tr>
							<td>StreetName:</td>
							<td><input type="text" name="streetName" /></td>
						</tr>
						<tr>
							<td>City:</td>
							<td><input type="text" name="city" /></td>
						</tr>
						<tr>
							<td>State:</td>
							<td><input type="text" name="state" /></td>
						</tr>
						<tr>
							<td>Pincode</td>
							<td><input type="text" name="pincode" /></td>
						</tr>
					</table>
				</tr>
				<tr>
					<table id="mytable">
					</table>
				</tr>
				<tr>
					<td><input type="button" value="myaddress"
						onClick="myaddress()"></td>
					<td>
					<td>
						<!-- <button onclick="myaddress()">add Another
							address</button> -->
				</tr>
				<tr>
					<table id="contacttable">

						<tr>
							<td>ContactNumber</td>
							<td><input type="text" name="contactNum" /></td>
						</tr>
					</table>
				<tr>
					<table id="addcontact">
					</table>
				</tr>
				<tr>
					<td><input type="button" value="mycontact"
						onClick="mycontact()"></td>
				</tr>
				<tr>
					<td><input type="submit" value="sumit" /></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="table-scroll">
		<table cellpadding="5pt" border="1px solid black ">
			<tr>
				<th colspan="8">Address Book</th>
			</tr>
			<tr>
				<th colspan="8">Search
					<form action="<%=request.getContextPath()%>/student/1"
						method="POST" name="frm1">
						<input type="text" name="idsearch" /> <input type="submit"
							value="studentId" />
					</form>

					<form name="frm2" action="<%=request.getContextPath()%>/searchname"
						method="POST" name="frm2">
						<input type="text" name="namesearch" /> <input type="submit"
							value="namesearch" />
					</form>
				</th>
			</tr>
			<tr>
				<th>StudentId</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Address</th>
				<th>contact</th>
				<th>Delete</th>
				<th>Update</th>
				<th>Add Another Address</th>
			</tr>
			<c:forEach items="${StudentList}" var="student">
				<tr>
					<td><c:out value="${student.studentId}"></c:out></td>
					<td><c:out value="${student.firstName}"></c:out></td>
					<td><c:out value="${student.lastName}"></c:out></td>
					<td><c:forEach items="${student.addresslist}" var="address">
							<c:out value="${address.flatNum}"></c:out>
							<c:out value="${address.buildingName}"></c:out>
							<c:out value="${address.streetName}"></c:out>
							<c:out value="${address.city}"></c:out>
							<c:out value="${address.state}"></c:out>
							<c:out value="${address.pincode}"></c:out>
							<br />
						</c:forEach></td>
					<td><c:forEach items="${student.contactlist}" var="contact">
							<c:out value="${contact.contactNum}"></c:out>
							<br />
						</c:forEach></td>
					<td><a href="delete/${student.studentId}"> Delete</a></td>
					<!-- 	onclick="return window.confirm('Are you sure ?')" -->
					<td><a href="getStudent/${student.studentId}"> Update</a></td>
					<td><a
						href="<%=request.getContextPath()%>/getaddress/${student.studentId}">
							add address</a></td>
					<td><a
						href="<%=request.getContextPath()%>/getcontact/${student.studentId}">
							add contact</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
