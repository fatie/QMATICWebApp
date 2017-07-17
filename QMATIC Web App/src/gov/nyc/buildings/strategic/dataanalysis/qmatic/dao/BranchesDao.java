package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Branch;

public class BranchesDao extends Dao<List<Branch>,String> {
	private static final Logger logger = LogManager.getLogger(BranchesDao.class);
	private String branchId;
	
	public BranchesDao(String branchId) {
		this.branchId = branchId;
	}
	public BranchesDao(){
		
	}
	
	public List<Branch> read() {
		logger.trace("reading " + branchId + "informations");
		List<Branch> branches = this.getTarget().path("managementinformation").path("v2").path("branches").request().accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Branch>>(){});
	    return branches;
	}

	@Override
	public List<Branch> read(String branchId) {
		return read();
	}

}
