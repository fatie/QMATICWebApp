package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Queue;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.QueueVisit;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.QueueVisits;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.util.QueueNameCompare;

public class BranchStatusFromQueuesDao extends Dao<BranchStatusFromQueues, String> {

	private static final Logger logger = LogManager.getLogger(BranchStatusFromQueuesDao.class);
	private String branchId;

	private String getBranchId() {
		return branchId;
	}

	private void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public BranchStatusFromQueuesDao(String branchId) {
		this.setBranchId(branchId);
	}

	@Override
	public List<Queue> read(String branchId) {
		List<Queue> queues = new ArrayList<Queue>();
		logger.trace("reading queues informations");
		queues = this.getTarget().path("managementinformation").path("v2").path("branches").path(this.getBranchId())
				.path("queues").request().accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Queue>>() {
				});
		for (Queue q : queues) {
			List<QueueVisit> qv = null;
			if (q.getCustomersWaiting() != 0) {
				qv = this.getTarget().path("managementinformation").path("v2").path("branches")
						.path(String.valueOf(q.getBranchId())).path("queues").path(String.valueOf(q.getId()))
						.path("visits").request().accept(MediaType.APPLICATION_JSON)
						.get(new GenericType<List<QueueVisit>>() {
						});
			} else {
				QueueVisit temp = new QueueVisit();
				qv = new ArrayList<QueueVisit>();
				qv.add(temp);
			}
			QueueVisits qvs = new QueueVisits(qv);
			q.setQueueVisits(qvs);
		}

		QueueNameCompare queueNameCompare = new QueueNameCompare();
		Collections.sort(queues, queueNameCompare);
		return queues;
	}

}
