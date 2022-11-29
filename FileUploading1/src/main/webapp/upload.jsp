<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
</head>
<body>
	<h2>File Uploading</h2>
	<form action="upload" method="POST" enctype="multipart/form-data">
	Person Name:   <input type="text" name="name"/><br/><br/>
	person Image: <input type="file" name="image"><br/><br/>
	<input type="submit" value="Upload"/>
	</form>
	<br>
	<br>
	<h3>$(message)</h3>
</body>
</html>