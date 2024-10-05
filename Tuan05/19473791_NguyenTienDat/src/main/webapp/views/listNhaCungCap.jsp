<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhà cung cấp</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/nhacungcap?action=new">Thêm
		nhà cung cấp</a>
	<br />
	<a href="${pageContext.request.contextPath}/nhacungcap">Danh sách
		nhà cung cấp</a>
	<br />
	<table border="1">
		<tr>
			<th>Mã NCC</th>
			<th>Tên NCC</th>
			<th>Địa chỉ</th>
			<th>Số điện thoại</th>
			<th>Điện thoại</th>
		</tr>
		<c:forEach var="ncc" items="${listNCC}">
			<tr>
				<td>${ncc.maNCC}</td>
				<td>${ncc.tenNCC}</td>
				<td>${ncc.diaChi}</td>
				<td>${ncc.sdt}</td>
				<td><c:forEach var="dt" items="${ncc.dienThoais}">
                        ${dt.tenDT},
                    </c:forEach></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
