<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<form action="insert" method="post">
		<fieldset>
			<legend>Insert</legend>
			<p>
				Enter ID: <input type="text" name="id"><br> Enter
				Enter Description:<input type="text" name="description"><br>
				Enter name:<input type="text" name="name"><br> 
				Enter price:<input type="text" name="price"><br> 
				<input type="submit">
			</p>
		</fieldset>
	</form>
	<form action="Query" method="get">
		<fieldset>
			<legend>Query</legend>
			<p>
				Enter ID: <input type="text" name="id"><br> <input
					type="submit">
			</p>
		</fieldset>
	</form>
	${queryResult}
</body>
</html>