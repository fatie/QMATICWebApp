package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Queue;

public class QueuesDao extends Dao<List<Queue>, String> {
	
	private static final Logger logger = LogManager.getLogger(QueuesDao.class);
	private String branchId;
	
	
	
	private String getBranchId() {
		return branchId;
	}

	private void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public QueuesDao(String branchId) {
		this.setBranchId(branchId);
	}

	@Override
	public List<Queue> read(String branchId) {
		List<Queue> queues = null;
		logger.trace("reading queues informations");
		queues = this.getTarget().path("managementinformation").path("v2").path("branches").path(this.getBranchId())
					.path("queues").request().accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Queue>>() {
					});
		
		return queues;
	}

}
