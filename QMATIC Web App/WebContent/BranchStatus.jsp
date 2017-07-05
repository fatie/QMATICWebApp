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




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QMATIC Borought Detailed Status</title>
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
				<h1 align="center">
					<span>QMATIC Borough Performance Details - <%out.print(qs.get(0).getBranchName());%><img
						align="right" alt="DOB" src="img/NYCDOB.svg.png"></span>
				</h1>
			</div>
		</div>

	</div>

	<table class="table table-hover table-condensed table-bordered">
		<tr>
		<tr class="warning">
			<th>Queue Name</th>
			<th>Customers Waiting</th>
			<th>Waiting Time (mins)</th>
			<th>Estimated Waiting Time (mins)</th>
			<th>Customers Served</th>

		</tr>

		<%
			for (Queue q : qs) {
				String ewt;
				if (q.getEstimatedWaitingTime() == -1) {
					ewt = "N/A";
				} else {
					ewt = String.valueOf(q.getEstimatedWaitingTime() / 60);
				}
				out.print("<tr><td>" + q.getName() + "</td><td>" + q.getCustomersWaiting() + "</td><td>"
						+ q.getWaitingTime() / 60 + "</td><td>" + ewt + "</td><td>" + q.getCustomersServed()
						+ "</td></tr>");
			}
			;
		%>
	</table>

</body>
</html>