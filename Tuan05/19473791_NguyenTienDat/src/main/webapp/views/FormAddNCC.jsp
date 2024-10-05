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
	<div align="center">
		<h2>Quản lí nhà cung cấp</h2>
		<h4>
			<a href="${pageContext.request.contextPath}/nhacungcap">Danh sách
				nhà cung cấp</a>
		</h4>

		<form method="post" action="nhacungcap?action=insert">
			<table boder=1>
				<tr>
					<th>Mã nhà cung cấp</th>
					<td><input type="hidden" name="maNCC"
						value="<c:out value='${nhacungcap.maNCC}'/>" /></td>
				</tr>
				<tr>
					<th>Tên nhà cung cấp
					</td>
					<td><input type="text" name="txtTenNCC" size="50"
						maxlength="50" value="<c:out value='${nhacungcap.tenNCC}'/>" /></td>
				</tr>
				<tr>
					<th>Địa chỉ
					</td>
					<td><input type="text" name="txtDiaChi" size="50"
						maxlength="50" value="<c:out value='${nhacungcap.diaChi}'/>" /></td>
				</tr>
				<tr>
					<th>Số điện thoại
					</td>
					<td><input type="text" name="txtSdt" size="20" maxlength="10"
						value="<c:out value='${nhacungcap.sdt}'/>" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Thêm" /></td>
				</tr>
				</form>

				</div>
</body>
</html>