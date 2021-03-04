<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<form action="Query" method="get">
		<fieldset>
			<legend>Query</legend>
			<p>
				Enter ID: <input type="text" name="id"><br> 
				<input type="submit">
			</p>
		</fieldset>	
	</form>
	${queryResult}
</body>
</html>