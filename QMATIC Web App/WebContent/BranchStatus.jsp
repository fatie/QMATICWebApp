<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="gov.nyc.buildings.strategic.dataanalysis.qmatic.model.*"%>

<%@ page import="gov.nyc.buildings.strategic.dataanalysis.qmatic.dao.*"%>

<%@ page
	import="gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Queue"%>

<%@ page import="java.util.*"%>

<%@ page import="java.text.DateFormat"%>

<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">

<link href="css/.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QMATIC Detailed Wait Times</title>
<style>
.table {
	border-radius: 5px;
	width: 50%;
	margin: 0px auto;
	float: none;
}
font-family


:

 

'
Open

 

Sans


'
,
sans-serif


;
</style>
</head>
<body>
	<%
		List<Queue> qs = (List<Queue>) request.getAttribute("qs");
	%>

	<div class="row">
		<div class="col-md-12">
			<div class="page-header">
				<h2 align="center">
					<span>QMATIC Detailed Wait Times - <%
						out.print(qs.get(0).getBranchName());
					%><img
						align="right" alt="DOB" src="img/NYCDOB.svg.png"></span>
				</h2>
			</div>
		</div>

	</div>

	<table class="table table-hover table-condensed table-bordered">
		<tr>
		<tr class="warning">
			<th>Queue Name</th>
			<th>Customers Waiting</th>
			<th>Wait Time (mins)</th>
			<th>Customers Served</th>

		</tr>

		<%
			for (Queue q : qs) {
				
				String queueName = q.getName();
				if (q.getBranchName().equalsIgnoreCase("Queens") && queueName.equalsIgnoreCase("Construction Developmentt")){
					queueName = queueName.substring(0,24);
				}
				
				out.print("<tr><td>" + queueName + "</td><td>" + q.getCustomersWaiting() + "</td><td>"
						+ q.getAverageWaitTimeInMinute() + "</td><td>" + q.getCustomersServed()
						+ "</td></tr>");
			}
			;
		%>
	</table>
	<br>
	<div class="time">
	<center>
	<p>Wait Time is average wait time, in minutes, of all customers currently waiting at each queue for specific branches</p></center></div>
	<br><br>
	<center>
		<form name="movingBack" method="post" action="index.jsp">
			<input type="submit" name="Back" value="Back">
		</form>
	</center>
</body>
</html>