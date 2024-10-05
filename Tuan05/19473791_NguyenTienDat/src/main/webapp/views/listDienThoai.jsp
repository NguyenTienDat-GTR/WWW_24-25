<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/dienthoai?action=new">Thêm
		điện thoại</a>
	<br />
	<a href="${pageContext.request.contextPath}/dienthoai">Danh sách
		điện thoại</a>
	<table border="1">
		<tr>
			<th>Mã điện thoại</th>
			<th>Tên điện thoại</th>
			<th>Năm sản xuất</th>
			<th>Cấu hình</th>
			<th>Mã nhà cung cấp</th>
		</tr>
		<c:forEach var="dt" items="${listDT}">
			<tr>
				<td>${dt.maDT}</td>
				<td>${dt.tenDT}</td>
				<td>${dt.namSX}</td>
				<td>${dt.cauHinh}</td>
				<td>${dt.nhaCungCap.maNCC}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>