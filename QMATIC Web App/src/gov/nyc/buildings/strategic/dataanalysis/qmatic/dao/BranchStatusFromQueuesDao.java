package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.BranchStatusFromQueues;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.LicensingProcess;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Queue;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.QueueVisit;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.QueueVisits;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.util.QueueNameCompare;

public class BranchStatusFromQueuesDao extends Dao<BranchStatusFromQueues, String> {

	private static final Logger logger = LogManager.getLogger(BranchStatusFromQueuesDao.class);
	private String branchId;
	private String branchName;
	private String groupName;
	private String groupId;
	
	

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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String centralName) {
		this.groupName = centralName;
	}

	private String getBranchId() {
		return branchId;
	}

	private void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public BranchStatusFromQueuesDao(String branchId) {

		switch (branchId) {
		case "2":
			this.setBranchId(branchId);
			this.setGroupId(branchId);
			this.branchName = "Bronx";
			this.setGroupName("Borough Office");
			break;
		case "5":
			this.setBranchId(branchId);
			this.setGroupId(branchId);
			this.branchName = "Brooklyn";
			this.setGroupName("Borough Office");
			break;
		case "3":
			this.setBranchId(branchId);
			this.setGroupId(branchId);
			this.branchName = "Manhattan";
			this.setGroupName("Borough Office");
			break;
		case "4":
			this.setBranchId(branchId);
			this.setGroupId(branchId);
			this.branchName = "Queens";
			this.setGroupName("Borough Office");
			break;
		case "6":
			this.setBranchId(branchId);
			this.setGroupId(branchId);
			this.branchName = "Central";
			this.setGroupName("Central");
			break;
		case "1":
			this.setBranchId(branchId);
			this.branchName = "Staten Island";
			this.setGroupId(branchId);
			this.setGroupName("Borough Office");
			break;
			
		case "4C":
			this.setBranchId("6");
			this.setGroupId(branchId);
			this.branchName = "Central Inspections";
			this.setGroupName("Central");
			break;
		
		case "5A":
			this.setBranchId("6");
			this.setGroupId(branchId);
			this.branchName = "Administrative Enforcement Unit (AEU)";
			this.setGroupName("Central");
			break;
			
		case "5L":
			this.setBranchId("6");
			this.setGroupId(branchId);
			this.branchName = "Limited Alteration Applications (LAA)/Hub Authentication Unit";
			this.setGroupName("Central");
			break;
		
		case "5C":
			this.setBranchId("6");
			this.setGroupId(branchId);
			this.branchName = "Cranes and Derricks";
			this.setGroupName("Central");
			break;
		
		case "6L":
			this.setBranchId("6");
			this.setGroupId(branchId);
			this.branchName = "Licensing";
			this.setGroupName("Central");
			break;
		
		case "6C":
			this.setBranchId("6");
			this.setGroupId(branchId);
			this.branchName = "Central Cashier";
			this.setGroupName("Central");
			break;
		
		default:
			this.setBranchId(branchId);
			this.setGroupId(branchId);
			this.branchName = "Invalid Branch Name";
			this.setGroupName("Invalide Group Name");
			break;
		}

	}

	@Override
	public BranchStatusFromQueues read(String branchId) {
		branchId = this.branchId;
		List<Queue> queues = new ArrayList<Queue>();
		logger.trace("reading branch " + branchName + " queue informations");
		queues = this.getTarget().path("managementinformation").path("v2").path("branches").path(this.getBranchId())
				.path("queues").request().accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Queue>>() {
				});
		if (this.getGroupId().equals("4C")){
			List<Queue> tem = new ArrayList<Queue>();
			for (Queue q: queues){
				if (q.getName().contains("4th-Elevator") || q.getName().contains("4th-Central Inspections Cashier") || q.getName().contains("4th-Boiler") || q.getName().contains("4th-Facades")){
					tem.add(q);
				}
			}
			queues.retainAll(tem);
		} else if (this.getGroupId().equals("5ARe")){
			List<Queue> tem = new ArrayList<Queue>();
			for (Queue q: queues){
				if (q.getName().contains("5th-AEU Representatives for Respondents") ){
					tem.add(q);
				}
			}
			queues.retainAll(tem);
		} else if (this.getGroupId().equals("5APo")){
			List<Queue> tem = new ArrayList<Queue>();
			for (Queue q: queues){
				if (q.getName().contains("5th-Administrative Enforcement Respondents") ){
					tem.add(q);
				}
			}
			queues.retainAll(tem);
		} else if (this.getGroupId().equals("5L")) {
			List<Queue> tem = new ArrayList<Queue>();
			for (Queue q: queues){
				if (q.getName().contains("5th-Appointments") || q.getName().contains("5th-LAA") || q.getName().contains("5th-Permit Renewal") || q.getName().contains("5th-Priority") ){
					tem.add(q);
				}
			}
			queues.retainAll(tem);
		} else if (this.getGroupId().equals("5C")) {
			List<Queue> tem = new ArrayList<Queue>();
			for (Queue q: queues){
				if (q.getName().contains("5th-Cranes and Derricks")){
					tem.add(q);
				}
			}
			queues.retainAll(tem);
		} else if (this.getGroupId().equals("6C")) {
			List<Queue> tem = new ArrayList<Queue>();
			for (Queue q: queues){
				if (q.getName().contains("6th-Central")){
					tem.add(q);
				}
			}
			queues.retainAll(tem);
		} else if (this.getGroupId().equals("6L")){
			List<Queue> tem = new ArrayList<Queue>();
			for (Queue q: queues){
				if (q.getName().contains("6th-") && (! q.getName().contains("Central"))){
					tem.add(q);
				}
			}
			queues.retainAll(tem);
			
		}
		
		
		for (Queue q : queues) {
			List<QueueVisit> qv = null;
			if (q.getCustomersWaiting() != 0) {
				qv = this.getTarget().path("managementinformation").path("v2").path("branches")
						.path(String.valueOf(q.getBranchId())).path("queues").path(String.valueOf(q.getId()))
						.path("visits").request().accept(MediaType.APPLICATION_JSON)
						.get(new GenericType<List<QueueVisit>>() {
						});
				QueueVisits qvs = new QueueVisits(qv);
				qvs.setWsReadFlag(true);
				q.setQueueVisits(qvs);
			} else {
				QueueVisit temp = new QueueVisit();
				qv = new ArrayList<QueueVisit>();
				qv.add(temp);
				QueueVisits qvs = new QueueVisits(qv);
				q.setQueueVisits(qvs);
			}
			
		}
		
		if (this.getGroupId().equals("6L")){
			LicensingProcess lp = new LicensingProcess(queues);
			queues = lp.processing();
			logger.debug("here");
			for (Queue q : queues){
				logger.debug(q.getName()+": "+q.getAverageWaitTimeInMinute() + ":"+q.getCustomersWaiting());
		
			}
		}
		
		QueueNameCompare queueNameCompare = new QueueNameCompare();
		Collections.sort(queues, queueNameCompare);

		BranchStatusFromQueues bsfq = new BranchStatusFromQueues();
		bsfq.setGroupId(groupId);
		bsfq.setId(Integer.parseInt(branchId));
		bsfq.setGroupName(groupName);
		bsfq.setName(branchName);
		bsfq.setQueues(queues);
		
		return bsfq;
	}

}
