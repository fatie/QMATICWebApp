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
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>QMATIC Current Wait Times</title>

<link href="css/.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h2 align="center">
						<span>QMATIC Current Wait Times<img align="right"
							alt="DOB" src="img/NYCDOB.svg.png"></span>
					</h2>
					<div class="time"><p align = "center">Click on a borough name for the breakdown by queue</p></div>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-md-4">
				<form name="submitFormBronx" method="post"
					action="BoroughPerformance.view">
					<input type="hidden" name="boroughName" value="Bronx">
					<h3 class="text-center">
						<a href="javascript:document.submitFormBronx.submit()">Bronx</a>
					</h3>
				</form>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							BranchStatus bxbs = (BranchStatus) (new BranchStatusDao("2")).read("2");
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(bxbs.getAverageWaitingTimeMin());
								%>
							</td>
						</tr>
						<tr class="success">
							<td>Customers Being Served</td>
							<td>
								<%
									out.print(bxbs.getCustomersBeingServed());
								%>
							</td>
						</tr>
						<tr class="warning">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(bxbs.getCustomersWaiting());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-4">
				<form name="submitFormBrooklyn" method="post"
					action="BoroughPerformance.view">
					<input type="hidden" name="boroughName" value="Brooklyn">
					<h3 class="text-center">
						<a href="javascript:document.submitFormBrooklyn.submit()">Brooklyn</a>
					</h3>
				</form>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							BranchStatus bqbs = (BranchStatus) (new BranchStatusDao("5")).read("5");
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(bqbs.getAverageWaitingTimeMin());
								%>
							</td>
						</tr>
						<tr class="success">
							<td>Customers Being Served</td>
							<td>
								<%
									out.print(bqbs.getCustomersBeingServed());
								%>
							</td>
						</tr>
						<tr class="warning">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(bqbs.getCustomersWaiting());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-4">
				<form name="submitFormManhattan" method="post"
					action="BoroughPerformance.view">
					<input type="hidden" name="boroughName" value="Manhattan">
					<h3 class="text-center">
						<a href="javascript:document.submitFormManhattan.submit()">Manhattan</a>
					</h3>
				</form>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							BranchStatus mbs = (BranchStatus) (new BranchStatusDao("3")).read("3");
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(mbs.getAverageWaitingTimeMin());
								%>
							</td>
						</tr>
						<tr class="success">
							<td>Customers Being Served</td>
							<td>
								<%
									out.print(mbs.getCustomersBeingServed());
								%>
							</td>
						</tr>
						<tr class="warning">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(mbs.getCustomersWaiting());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<form name="submitFormQueens" method="post"
					action="BoroughPerformance.view">
					<input type="hidden" name="boroughName" value="Queens">
					<h3 class="text-center">
						<a href="javascript:document.submitFormQueens.submit()">Queens</a>
					</h3>
				</form>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							BranchStatus qbs = (BranchStatus) (new BranchStatusDao("4")).read("4");
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(qbs.getAverageWaitingTimeMin());
								%>
							</td>
						</tr>
						<tr class="success">
							<td>Customers Being Served</td>
							<td>
								<%
									out.print(qbs.getCustomersBeingServed());
								%>
							</td>
						</tr>
						<tr class="warning">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(qbs.getCustomersWaiting());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-4">
				<form name="submitFormStatenIsland" method="post"
					action="BoroughPerformance.view">
					<input type="hidden" name="boroughName" value="Staten Island">
					<h3 class="text-center">
						<a href="javascript:document.submitFormStatenIsland.submit()">Staten
							Island</a>
					</h3>
				</form>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							BranchStatus sibs = (BranchStatus) (new BranchStatusDao("1")).read("1");
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(sibs.getAverageWaitingTimeMin());
								%>
							</td>
						</tr>
						<tr class="success">
							<td>Customers Being Served</td>
							<td>
								<%
									out.print(sibs.getCustomersBeingServed());
								%>
							</td>
						</tr>
						<tr class="warning">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(sibs.getCustomersWaiting());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-4">
				<form name="submitFormCentral" method="post"
					action="BoroughPerformance.view">
					<input type="hidden" name="boroughName" value="Central">
					<h3 class="text-center">
						<a href="javascript:document.submitFormCentral.submit()">Manhattan
							Central - 4th 5th 6th</a>
					</h3>
				</form>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							BranchStatus cbs = (BranchStatus) (new BranchStatusDao("6")).read("6");
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(cbs.getAverageWaitingTimeMin());
								%>
							</td>
						</tr>
						<tr class="success">
							<td>Customers Being Served</td>
							<td>
								<%
									out.print(cbs.getCustomersBeingServed());
								%>
							</td>
						</tr>
						<tr class="warning">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(cbs.getCustomersWaiting());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
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

	</div>
	<div class="time">
	<center>
	<p>Average wait time is the average waiting time, in minutes, of all customers currently waiting at each branch</p></center></div>
	<br><br>
	<center>
		<form name="refresh" action="index.jsp">
			<input type="submit" name="Refresh" value="Refresh">
		</form>
	</center>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>