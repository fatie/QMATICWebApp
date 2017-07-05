package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.BranchStatus;

public class BranchStatusDao extends Dao<BranchStatus, String> {
	private static final Logger logger = LogManager.getLogger(BranchStatusDao.class);
	private String branchId;
	
	
	public String getBranchId() {
		return branchId;
	}


	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	public BranchStatusDao(String branchId){
		this.setBranchId(branchId);
	}

	@Override
	public BranchStatus read(String branchId) {
		BranchStatus branchStatus = null;
		logger.trace("reading branch status");
//	    String response = this.getTarget().path("managementinformation").path("v2").path("branches").path(this.getBranchId()).request().accept(MediaType.APPLICATION_JSON).get(Response.class).toString();
//	    logger.trace(response);
	    branchStatus = this.getTarget().path("managementinformation").path("v2").path("branches").path(this.getBranchId()).request().accept(MediaType.APPLICATION_JSON).get(BranchStatus.class);
	    return branchStatus;
	}

	

}
