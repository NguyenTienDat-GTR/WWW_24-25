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
		<h2>Quản lí điện thoại</h2>
		<h4>
			<a href="${pageContext.request.contextPath}/dienthoai">Danh sách
				điện thoại</a>
		</h4>

		<form method="post" action="dienthoai?action=insert">
			<table boder=1>
				<tr>
					<th>Mã điện thoại</th>
					<td><input type="hidden" name="maDT"
						value="<c:out value='${dienthoai.maDT}'/>" /></td>
				</tr>
				<tr>
					<th>Tên điện thoại
					</td>
					<td><input type="text" name="txtTenDT" size="50"
						maxlength="50" value="<c:out value='${dienthoai.tenDT}'/>" /></td>
				</tr>
				<tr>
					<th>Năm sản xuất
					</td>
					<td><input type="text" name="txtNamSX" size="10" maxlength="5"
						value="<c:out value='${dienthoai.namSX}'/>" /></td>
				</tr>
				<tr>
					<th>Cấu hình
					</td>
					<td><input type="text" name="txtCauHinh" size="50"
						maxlength="50" value="<c:out value='${dienthoai.cauHinh}'/>" /></td>
				</tr>
				<tr>
					<th>Nhà cung cấp</th>
					<td><select name="txtMaNCC">
							<c:forEach var="ncc" items="${listNCC}">
								<option value="${ncc.maNCC}">${ncc.tenNCC}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Thêm" /></td>
				</tr>
				</form>

				</div>
</body>
</html>