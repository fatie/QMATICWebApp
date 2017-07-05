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

import gov.nyc.buildings.strategic.dataanalysis.qmatic.dao.BranchStatusDao;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.dao.QueuesDao;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.BranchStatus;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Queue;

public class BoroughSummaryView extends HttpServlet{
	private static final Logger logger = LogManager.getLogger(BoroughSummaryView.class);
	private String branchId;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		String borough = request.getParameter("boroughName");
		logger.trace(borough + " is selected");
		switch (borough) {
		case "Bronx": 			branchId = "2";
								break;
		case "Brooklyn": 		branchId = "5";
								break;
		case "Manhattan": 		branchId = "3";
								break;
		case "Queens": 			branchId = "4";
								break;
		case "Central": 		branchId = "6";
								break;
		case "Staten Island": 	branchId = "1";
								break;
		default: 				branchId = "Invalid Branches";
								break;
		}
		
		if (!branchId.equals("Invalid Branches")){
			
//			BranchStatus bs = (new BranchStatusDao(branchId)).read(branchId);
//			logger.trace("client got updated branch status information, forwarding to jsp for demonstration");
//			request.setAttribute("bs", bs);
			List<Queue> qs = (new QueuesDao(branchId)).read(branchId);
			logger.trace("client got updated queues information, forwarding to jsp for demonstration");
			request.setAttribute("qs", qs);
			
			RequestDispatcher view = request.getRequestDispatcher("BranchStatus.jsp");
			view.forward(request, response);
		}
		
	}
	

}
