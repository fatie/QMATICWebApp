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
						<span>QMATIC Current Wait Times<img align="right" alt="DOB"
							src="img/NYCDOB.svg.png"></span>
					</h2>
					<div class="time">
						<p align="center">Click on a borough name for the breakdown by
							queue</p>
					</div>
				</div>
			</div>

		</div>

		<div class="time">
			<center>
				<h3>Borough Office</h3>
			</center>
		</div>
		<div class="row">
			<div class="col-md-4">
				<form name="submitFormBronx" method="post"
					action="BoroughPerformance.view">
					<input type="hidden" name="boroughName" value="Bronx">
					<h4 class="text-center">
						<a href="javascript:document.submitFormBronx.submit()">Bronx</a>
					</h4>
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
							BranchStatusFromQueues bxbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesDao("2")).read("2");
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(bxbsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
						</tr>
						<!-- 						<tr class="success"> -->
						<!-- 							<td>Customers Being Served</td> -->
						<!-- 							<td> -->
						<%-- 								<% --%>
						<!-- // 									out.print(bxbsfq.getCustomersBeingServed()); -->
						<%-- 								%> --%>
						<!-- 							</td> -->
						<!-- 						</tr> -->
						<!-- 						<tr class="warning"> -->
						<tr class="success">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(bxbsfq.getBranchTotalWait());
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
					<h4 class="text-center">
						<a href="javascript:document.submitFormBrooklyn.submit()">Brooklyn</a>
					</h4>
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
							BranchStatusFromQueues bqbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesDao("5")).read("5");
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(bqbsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
						</tr>
						<!-- 						<tr class="success"> -->
						<!-- 							<td>Customers Being Served</td> -->
						<!-- 							<td> -->
						<%-- 								<% --%>
						<!-- // 									out.print(bqbs.getCustomersBeingServed()); -->
						<%-- 								%> --%>
						<!-- 							</td> -->
						<!-- 						</tr> -->
						<!-- 						<tr class="warning"> -->
						<tr class="success">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(bqbsfq.getBranchTotalWait());
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
					<h4 class="text-center">
						<a href="javascript:document.submitFormManhattan.submit()">Manhattan</a>
					</h4>
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
							BranchStatusFromQueues mbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesDao("3")).read("3");
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(mbsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
						</tr>
						<!-- 						<tr class="success"> -->
						<!-- 							<td>Customers Being Served</td> -->
						<!-- 							<td> -->
						<%-- 								<% --%>
						<!-- // 									out.print(mbs.getCustomersBeingServed()); -->
						<%-- 								%> --%>
						<!-- 							</td> -->
						<!-- 						</tr> -->

						<!-- 						<tr class="warning"> -->
						<!-- 						<tr class="warning"> -->
						<tr class="success">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(mbsfq.getBranchTotalWait());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="col-md-4">
					<form name="submitFormQueens" method="post"
						action="BoroughPerformance.view">
						<input type="hidden" name="boroughName" value="Queens">
						<h4 class="text-center">
							<a href="javascript:document.submitFormQueens.submit()">Queens</a>
						</h4>
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
								BranchStatusFromQueues qbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesDao("4")).read("4");
							%>
							<tr class="active">
								<td>Average Wait Time (mins)</td>
								<td>
									<%
										out.print(qbsfq.getBranchAverageWaitTimeInMinute());
									%>
								</td>
							</tr>
							<!-- 						<tr class="success"> -->
							<!-- 							<td>Customers Being Served</td> -->
							<!-- 							<td> -->
							<%-- 								<% --%>
							<!-- // 									out.print(qbs.getCustomersBeingServed()); -->
							<%-- 								%> --%>
							<!-- 							</td> -->
							<!-- 						</tr> -->
							<!-- 						<tr class="warning"> -->
							<tr class="success">
								<td>Customers Waiting</td>
								<td>
									<%
										out.print(qbsfq.getBranchTotalWait());
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
						<h4 class="text-center">
							<a href="javascript:document.submitFormStatenIsland.submit()">Staten
								Island</a>
						</h4>
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
								BranchStatusFromQueues sibsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesDao("1")).read("1");
							%>
							<tr class="active">
								<td>Average Wait Time (mins)</td>
								<td>
									<%
										out.print(sibsfq.getBranchAverageWaitTimeInMinute());
									%>
								</td>
							</tr>
							<!-- 						<tr class="success"> -->
							<!-- 							<td>Customers Being Served</td> -->
							<!-- 							<td> -->
							<%-- 								<% --%>
							<!-- // 									out.print(sibs.getCustomersBeingServed()); -->
							<%-- 								%> --%>
							<!-- 							</td> -->
							<!-- 						</tr> -->
							<!-- 						<tr class="warning"> -->
							<tr class="success">
								<td>Customers Waiting</td>
								<td>
									<%
										out.print(sibsfq.getBranchTotalWait());
									%>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		

		<div class="time">
			<center>
				<h3>Central</h3>
			</center>
		</div>
		<%
							BranchStatusFromQueues cbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesDao("6")).read("6");
						%>
		
		<div class="row">
			<div class="col-md-4">
				<form name="submitFormCentral4C" method="post"
					action="CentralPerformance.view">
					<input type="hidden" name="groupId" value="4C">
					<h4 class="text-center">
						<a href="javascript:document.submitFormCentral4C.submit()">Central
							Inspections</a>
					</h4>
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
							BranchStatusFromQueues cibsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq).getBsfqcd().get("4C"));
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(cibsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
						</tr>
						<!-- 						<tr class="success"> -->
						<!-- 							<td>Customers Being Served</td> -->
						<!-- 							<td> -->
						<%-- 								<% --%>
						<!-- // 									out.print(cbs.getCustomersBeingServed()); -->
						<%-- 								%> --%>
						<!-- 							</td> -->
						<!-- 						</tr> -->
						<!-- 						<tr class="warning"> -->
						<tr class="success">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(cibsfq.getBranchTotalWait());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="col-md-4">
				<form name="submitFormCentral5A" method="post"
					action="CentralPerformance.view">
					<input type="hidden" name="groupId" value="5A">
					<h4 class="text-center">
						<a href="javascript:document.submitFormCentral5A.submit()">Administrative
							Enforcement Unit (AEU)</a>
					</h4>
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
							BranchStatusFromQueues aeubsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq).getBsfqcd().get("5A"));
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(aeubsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
						</tr>
						<!-- 						<tr class="success"> -->
						<!-- 							<td>Customers Being Served</td> -->
						<!-- 							<td> -->
						<%-- 								<% --%>
						<!-- // 									out.print(cbs.getCustomersBeingServed()); -->
						<%-- 								%> --%>
						<!-- 							</td> -->
						<!-- 						</tr> -->
						<!-- 						<tr class="warning"> -->
						<tr class="success">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(aeubsfq.getBranchTotalWait());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>


			<div class="col-md-4">
				<form name="submitFormCentral5L" method="post"
					action="CentralPerformance.view">
					<input type="hidden" name="groupId" value="5L">
					<h4 class="text-center">
						<a href="javascript:document.submitFormCentral5L.submit()">Limited
							Alteration Applications (LAA)/Hub Authentication Unit</a>
					</h4>
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
							BranchStatusFromQueues laabsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq).getBsfqcd().get("5L"));
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(laabsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
						</tr>
						<!-- 						<tr class="success"> -->
						<!-- 							<td>Customers Being Served</td> -->
						<!-- 							<td> -->
						<%-- 								<% --%>
						<!-- // 									out.print(cbs.getCustomersBeingServed()); -->
						<%-- 								%> --%>
						<!-- 							</td> -->
						<!-- 						</tr> -->
						<!-- 						<tr class="warning"> -->
						<tr class="success">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(laabsfq.getBranchTotalWait());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="col-md-4">
				<form name="submitFormCentral5C" method="post"
					action="CentralPerformance.view">
					<input type="hidden" name="groupId" value="5C">
					<h4 class="text-center">
						<a href="javascript:document.submitFormCentral5C.submit()">Cranes
							and Derricks</a>
					</h4>
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
							BranchStatusFromQueues cdbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq).getBsfqcd().get("5C"));
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(cdbsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
						</tr>
						<!-- 						<tr class="success"> -->
						<!-- 							<td>Customers Being Served</td> -->
						<!-- 							<td> -->
						<%-- 								<% --%>
						<!-- // 									out.print(cbs.getCustomersBeingServed()); -->
						<%-- 								%> --%>
						<!-- 							</td> -->
						<!-- 						</tr> -->
						<!-- 						<tr class="warning"> -->
						<tr class="success">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(cdbsfq.getBranchTotalWait());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="col-md-4">
				<form name="submitFormCentral6L" method="post"
					action="CentralPerformance.view">
					<input type="hidden" name="groupId" value="6L">
					<h4 class="text-center">
						<a href="javascript:document.submitFormCentral6L.submit()">Licensing</a>
					</h4>
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
							BranchStatusFromQueues lbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq).getBsfqcd().get("6L"));
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(lbsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
						</tr>
						<!-- 						<tr class="success"> -->
						<!-- 							<td>Customers Being Served</td> -->
						<!-- 							<td> -->
						<%-- 								<% --%>
						<!-- // 									out.print(cbs.getCustomersBeingServed()); -->
						<%-- 								%> --%>
						<!-- 							</td> -->
						<!-- 						</tr> -->
						<!-- 						<tr class="warning"> -->
						<tr class="success">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(lbsfq.getBranchTotalWait());
								%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="col-md-4">
				<form name="submitFormCentral6C" method="post"
					action="CentralPerformance.view">
					<input type="hidden" name="groupId" value="6C">
					<h4 class="text-center">
						<a href="javascript:document.submitFormCentral6C.submit()">Central
							Cashier</a>
					</h4>
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
							BranchStatusFromQueues ccbsfq = (BranchStatusFromQueues) (new BranchStatusFromQueuesCentralDivided(cbsfq).getBsfqcd().get("6C"));
						%>
						<tr class="active">
							<td>Average Wait Time (mins)</td>
							<td>
								<%
									out.print(ccbsfq.getBranchAverageWaitTimeInMinute());
								%>
							</td>
						</tr>
						<!-- 						<tr class="success"> -->
						<!-- 							<td>Customers Being Served</td> -->
						<!-- 							<td> -->
						<%-- 								<% --%>
						<!-- // 									out.print(cbs.getCustomersBeingServed()); -->
						<%-- 								%> --%>
						<!-- 							</td> -->
						<!-- 						</tr> -->
						<!-- 						<tr class="warning"> -->
						<tr class="success">
							<td>Customers Waiting</td>
							<td>
								<%
									out.print(ccbsfq.getBranchTotalWait());
								%>
							</td>
						</tr>
					</tbody>
				</table>
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
	
	<br>
	<div class="time">
		<center>
			<p>Average wait time is the average waiting time, in minutes, of
				all customers currently waiting at each branch</p>
		</center>
	</div>
	<br>
	<br>
	<center>
		<form name="refresh" method="post" action="index.jsp">
			<input type="submit" name="Refresh" value="Refresh">
		</form>
	</center>
</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>