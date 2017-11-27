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

<title>Current Wait Times - Central</title>

<link href="css/.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h2 align="center">
						<span class="text-center"><img align="left"
							src="img/blank.gif">Current Wait Times - Central Unit (280 Broadway)<img
							align="right" alt="DOB" src="img/NYCDOB.svg.png"></span>
					</h2>
					<div class="time">
						<p align="center">Click on Central Inspections or Licensing
							for the detailed breakdown Information by queue</p>
					</div>
				</div>
			</div>

		</div>




		<%
			BranchStatusFromQueues cbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesDao("6")).read("6");
			BranchStatusFromQueues cibsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq)
					.getBsfqcd().get("4C"));
			BranchStatusFromQueues aeuRebsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq)
					.getBsfqcd().get("5ARe"));
			BranchStatusFromQueues aeuPobsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq)
					.getBsfqcd().get("5APo"));
			BranchStatusFromQueues laabsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq)
					.getBsfqcd().get("5L"));
			BranchStatusFromQueues cdbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq)
					.getBsfqcd().get("5C"));
			BranchStatusFromQueues lbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq)
					.getBsfqcd().get("6L"));
			BranchStatusFromQueues ccbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq)
					.getBsfqcd().get("6C"));
		%>

		<div class="row">

			<!-- 		<div class="col-md-3"></div> -->

			<div class="col-md-3"></div>
			<div class="col-md-6">

				<table class="table table-hover table-condensed table-bordered">
					<thead>
						<tr class="warning">
							<th class="text-center"><h5>
									<b>Unit</b>
								</h5></th>
							<th class="text-center"><h5>
									<b>Average Wait Time (mins)</b>
								</h5></th>
							<th class="text-center"><h5>
									<b>Customers Waiting</b>
								</h5></th>
						</tr>
					</thead>

					<%
							
						%>
					<tbody>

						<tr>
							<td><form name="submitFormCentral4C" method="post"
									action="CentralPerformance.view">
									<input type="hidden" name="groupId" value="4C">
									<center>
										<span class="text-center"> <a
											href="javascript:document.submitFormCentral4C.submit()">Central
												Inspections</a>
										</span>
									</center>
								</form></td>
							<td class="text-center">
								<%
									out.print(cibsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
							<td class="text-center">
								<%
									out.print(cibsfq.getBranchTotalWait());
								%>
							</td>
						</tr>

						<tr>
							<td class="text-center">AEU-Respondents</td>
							<td class="text-center">
								<%
								out.print(aeuRebsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
							<td class="text-center">
								<%
									out.print(aeuRebsfq.getBranchTotalWait());
								%>
							</td>
						</tr>

						<tr>
							<td class="text-center">AEU-Representatives</td>
							<td class="text-center">
								<%
								out.print(aeuPobsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
							<td class="text-center">
								<%
								out.print(aeuPobsfq.getBranchTotalWait());
								%>
							</td>
						</tr>

						<tr>
							<td class="text-center">Limited Alteration Applications
								(LAA)/Hub Authentication Unit</td>
							<td class="text-center">
								<%
								out.print(laabsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
							<td class="text-center">
								<%
								out.print(laabsfq.getBranchTotalWait());
								%>
							</td>
						</tr>

						<tr>
							<td class="text-center">Cranes and Derricks</td>
							<td class="text-center">
								<%
								out.print(cdbsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
							<td class="text-center">
								<%
								out.print(cdbsfq.getBranchTotalWait());
								%>
							</td>
						</tr>

						<tr>
							<td><form name="submitFormCentral6L" method="post"
									action="CentralPerformance.view">
									<input type="hidden" name="groupId" value="6L">
									<center>
										<span class="text-center"> <a
											href="javascript:document.submitFormCentral6L.submit()">Licensing</a>
										</span>
									</center>
								</form></td>
							<td class="text-center">
								<%
								out.print(lbsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
							<td class="text-center">
								<%
								out.print(lbsfq.getBranchTotalWait());
								%>
							</td>
						</tr>

						<tr>
							<td class="text-center">Central Cashier</td>
							<td class="text-center">
								<%
								out.print(ccbsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
							<td class="text-center">
								<%
								out.print(ccbsfq.getBranchTotalWait());
								%>
							</td>
						</tr>

					</tbody>
				</table>

			</div>
			<div class="col-md-3"></div>




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


		<div class="time">
			<center>
				<p>Average wait time is the average waiting time, in minutes, of
					all customers currently waiting at each branch</p>
			</center>
		</div>

		<center>
			<form name="refresh" method="post" action="Central.jsp">
				<input type="submit" name="Refresh" value="Refresh">
			</form>
		</center>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>