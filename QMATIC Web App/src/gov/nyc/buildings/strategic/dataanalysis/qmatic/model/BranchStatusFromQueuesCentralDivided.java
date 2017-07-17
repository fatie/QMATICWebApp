package gov.nyc.buildings.strategic.dataanalysis.qmatic.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BranchStatusFromQueuesCentralDivided {
	
	private BranchStatusFromQueues bsfq;
	private Map<String, BranchStatusFromQueues> bsfqcd;
	
	

	public BranchStatusFromQueuesCentralDivided(BranchStatusFromQueues bsfq) {
		this.bsfq = bsfq;
		bsfqcd = new HashMap<String, BranchStatusFromQueues>();
		List<Queue> tem4c = new ArrayList<Queue>();
		List<Queue> tem5a = new ArrayList<Queue>();
		List<Queue> tem5l = new ArrayList<Queue>();
		List<Queue> tem5c = new ArrayList<Queue>();
		List<Queue> tem6c = new ArrayList<Queue>();
		List<Queue> tem6l = new ArrayList<Queue>();
		
		
		for (Queue queue: bsfq.getQueues()){
			if (queue.getName().contains("4th-Elevator") || queue.getName().contains("4th-Central Inspections Cashier") || queue.getName().contains("4th-Boiler") || queue.getName().contains("4th-Facades")){
				tem4c.add(queue);
			} else if (queue.getName().contains("5th-Appointments") || queue.getName().contains("5th-LAA") || queue.getName().contains("5th-Permit Renewal") || queue.getName().contains("5th-Priority")){
				tem5l.add(queue);
			} else if (queue.getName().contains("5th-AEU Representatives for Respondents") || queue.getName().contains("5th-Administrative Enforcement Respondents")){
				tem5a.add(queue);
			} else if (queue.getName().contains("5th-Cranes and Derricks")) {
				tem5c.add(queue);
			} else if (queue.getName().contains("6th-Central")) {
				tem6c.add(queue);
			} else if (queue.getName().contains("6th-") && (! queue.getName().contains("Central"))) {
				tem6l.add(queue);
			}
		}
		
		BranchStatusFromQueues bsfq4c = new BranchStatusFromQueues();
		bsfq4c.setGroupId("4C");
		bsfq4c.setId(6);
		bsfq4c.setGroupName("Central");
		bsfq4c.setName("Central Inspections");
		bsfq4c.setQueues(tem4c);
		
		BranchStatusFromQueues bsfq5a = new BranchStatusFromQueues();
		bsfq5a.setGroupId("5A");
		bsfq5a.setId(6);
		bsfq5a.setGroupName("Central");
		bsfq5a.setName("Administrative Enforcement Unit (AEU)");
		bsfq5a.setQueues(tem5a);
		
		BranchStatusFromQueues bsfq5l = new BranchStatusFromQueues();
		bsfq5l.setGroupId("5L");
		bsfq5l.setId(6);
		bsfq5l.setGroupName("Central");
		bsfq5l.setName("Limited Alteration Applications (LAA)/Hub Authentication Unit");
		bsfq5l.setQueues(tem5l);
		
		BranchStatusFromQueues bsfq5c = new BranchStatusFromQueues();
		bsfq5c.setGroupId("5C");
		bsfq5c.setId(6);
		bsfq5c.setGroupName("Central");
		bsfq5c.setName("Cranes and Derricks");
		bsfq5c.setQueues(tem5c);
		
		BranchStatusFromQueues bsfq6l = new BranchStatusFromQueues();
		bsfq6l.setGroupId("6L");
		bsfq6l.setId(6);
		bsfq6l.setGroupName("Central");
		bsfq6l.setName("Licensing");
		bsfq6l.setQueues(tem6l);
		
		BranchStatusFromQueues bsfq6c = new BranchStatusFromQueues();
		bsfq6c.setGroupId("6C");
		bsfq6c.setId(6);
		bsfq6c.setGroupName("Central");
		bsfq6c.setName("Central Cashier");
		bsfq6c.setQueues(tem6c);
		
		bsfqcd.put(bsfq4c.getGroupId(), bsfq4c);
		bsfqcd.put(bsfq5a.getGroupId(), bsfq5a);
		bsfqcd.put(bsfq5l.getGroupId(), bsfq5l);
		bsfqcd.put(bsfq5c.getGroupId(), bsfq5c);
		bsfqcd.put(bsfq6l.getGroupId(), bsfq6l);
		bsfqcd.put(bsfq6c.getGroupId(), bsfq6c);
		
		
	}

	public BranchStatusFromQueues getBsfq() {
		return bsfq;
	}

	public void setBsfq(BranchStatusFromQueues bsfq) {
		this.bsfq = bsfq;
	}

	public Map<String, BranchStatusFromQueues> getBsfqcd() {
		return bsfqcd;
	}

	public void setBsfqcd(Map<String, BranchStatusFromQueues> bsfqcd) {
		this.bsfqcd = bsfqcd;
	}
	
	

}
