<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="gov.nyc.buildings.strategic.dataanalysis.qmatic.model.*"%>

<%@ page import="gov.nyc.buildings.strategic.dataanalysis.qmatic.dao.*"%>
	
<%@ page
	import="gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Queue"%>	

<%@ page
	import="java.util.*"%>
	
<%@ page
	import="java.text.DateFormat"%>
	
<%@ page
	import="java.text.SimpleDateFormat"%>

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
<title>Detailed Wait Times</title>
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

<div class="container-fluid">
	
	<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h2 align="center">
						<span><img align="left"
							 src="img/blank.gif">Detailed Wait Times - Bronx<img align="right"
							alt="DOB" src="img/NYCDOB.svg.png"></span>
					</h2>
				</div>
			</div>

		</div>
	<%
		List<Queue> qs = (List<Queue>) (new QueuesDao("2")).read("2");;
	%>
	<table class="table table-hover table-condensed table-bordered">
		<tr>
		<tr class="warning">
		<th>Queue Name</th>
		<th>Customers Waiting</th>
		<th>Waiting Time (mins)</th>
		
		
		</tr>
	
		<%
		
		for (Queue q: qs){
			String ewt;
			if (q.getEstimatedWaitingTime()== -1){
				ewt = "N/A";
			} else {
				ewt = String.valueOf(q.getEstimatedWaitingTime()/60);
			}
			out.print("<tr><td>"+q.getName()+"</td><td>"+q.getCustomersWaiting()+"</td><td>"+q.getWaitingTime()/60+"</td></tr>");
		};
		%>
	</table>
	
	<div class="time">
			<br> <br>
			<p align="center">
				<span>QMATIC Data As of: <%
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					out.print(dateFormat.format(date));
				%></span>
			</p>
		</div>
	
	<div class="time">
			<center>
				<p>Wait Time is average wait time, in minutes, of all customers currently waiting at each queue for specific branches</p>
			</center>
		</div>

		<center>
			<form name="refresh" method="post" action="Bronx.jsp">
				<input type="submit" name="Refresh" value="Refresh">
			</form>
		</center>
	</div>
</body>
</html>