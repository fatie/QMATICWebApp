package gov.nyc.buildings.strategic.dataanalysis.qmatic.web;



import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.dao.BranchStatusFromQueuesDao;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.BranchStatusFromQueues;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Queue;

public class CentralSummaryView extends HttpServlet{
	private static final Logger logger = LogManager.getLogger(CentralSummaryView.class);
	private static String branchId = "6";
	private String groupId;
	private String branchName;
	private static String groupName = "Central";
	
	
	
	public static String getBranchId() {
		return branchId;
	}



	public static void setBranchId(String branchId) {
		CentralSummaryView.branchId = branchId;
	}



	public static String getGroupName() {
		return groupName;
	}



	public static void setGroupName(String groupName) {
		CentralSummaryView.groupName = groupName;
	}



	public String getGroupId() {
		return groupId;
	}



	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}



	public String getBranchName() {
		return branchName;
	}



	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}



	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		groupId = request.getParameter("groupId");
		logger.trace(groupId + " is selected");
		switch (groupId) {
		case "4C":
			branchName = "Central Inspections";
			break;
		
		case "5A":
			branchName = "Administrative Enforcement Unit (AEU)";
			break;
			
		case "5L":
			branchName = "Limited Alteration Applications (LAA)/Hub Authentication Unit";
			break;
		
		case "5C":
			branchName = "Cranes and Derricks";
			break;
		
		case "6L":
			branchName = "Licensing";
			break;
		
		case "6C":
			branchName = "Central Cashier";
			break;
		
		default:
			setBranchId("Invalid Branch Name");
			branchName = "Invalid Branch Name";
			setGroupName("Invalide Group Name");
			break;
		}
		
		if (!branchId.equals("Invalid Branches")){
			
//			BranchStatus bs = (new BranchStatusDao(branchId)).read(branchId);
//			logger.trace("client got updated branch status information, forwarding to jsp for demonstration");
//			request.setAttribute("bs", bs);
			BranchStatusFromQueues bsfq = (new BranchStatusFromQueuesDao(groupId)).read(groupId);
			List<Queue> qs = bsfq.getQueues();
			logger.trace("client got updated queues information, forwarding to jsp for demonstration");
			for (Queue q: qs){
				logger.debug(q.getName());
			}
			request.setAttribute("qs", qs);
			qs.get(0).setBranchName(branchName);
			
			
			RequestDispatcher view = request.getRequestDispatcher("BranchStatus.jsp");
			view.forward(request, response);
		}
		
	}
	

}
