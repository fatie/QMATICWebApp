package gov.nyc.buildings.strategic.dataanalysis.qmatic.model;

import java.util.ArrayList;
import java.util.List;

public class LicensingProcess {
	private List<Queue> queues;

	public LicensingProcess(List<Queue> queues) {
		this.queues = queues;
	}

	public List<Queue> processing() {
		BranchStatusFromQueues morning = new BranchStatusFromQueues();
		List<Queue> morningQueues = new ArrayList<Queue>();
		BranchStatusFromQueues afternoon = new BranchStatusFromQueues();
		List<Queue> afternoonQueues = new ArrayList<Queue>();
		BranchStatusFromQueues wholeday = new BranchStatusFromQueues();
		List<Queue> wholedayQueues = new ArrayList<Queue>();

		for (Queue q : this.queues) {
			if (q.getName().contains("Welder") || q.getName().contains("Site Safety")
					|| q.getName().contains("Elevator") || q.getName().contains("Rigger")
					|| q.getName().contains("Fire Suppression") || q.getName().contains("Stationary Engineer")
					|| q.getName().contains("Electrician") || q.getName().contains("Oil Burner")
					|| q.getName().contains("Concrete") || q.getName().contains("Journeyman")
					|| q.getName().contains("Superintendent") || q.getName().contains("Hoist")) {
				morningQueues.add(q);

			} else if (q.getName().contains("Insurance") || q.getName().contains("LIC7") || q.getName().contains("LIC6")){
				afternoonQueues.add(q);
			} else if (q.getName().contains("Filing Representative") || q.getName().contains("Interagency") ){
				wholedayQueues.add(q);
			}
			
		}
		
		morning.setQueues(morningQueues);
		afternoon.setQueues(afternoonQueues);
		wholeday.setQueues(wholedayQueues);
		
		int morningWaiting = morning.getBranchTotalWait();
		int afternoonWaiting = afternoon.getBranchTotalWait();
		int wholedayWaiting = wholeday.getBranchTotalWait();
		
		int morningWaitTime = morning.getBranchAverageWaitTimeInMinute();
		int afternoonWaitTime = afternoon.getBranchAverageWaitTimeInMinute();
		int wholedayWaitTime = wholeday.getBranchAverageWaitTimeInMinute();
		
		Queue m = new QueueGroups(morningWaiting, morningWaitTime);
		Queue a = new QueueGroups(afternoonWaiting, afternoonWaitTime);
		Queue w = new QueueGroups(wholedayWaiting, wholedayWaitTime);
		
		m.setName("Q-Matic Morning Transaction Tickets");
		a.setName("Q-Matic Afternoon Transaction Tickets");
		w.setName("Q-Matic All Day Transaction Tickets");
		
		
		m.setBranchName("Licensing");
		a.setBranchName("Licensing");
		w.setBranchName("Licensing");
		
		
		List<Queue> result = new ArrayList<Queue>();
		result.add(m);
		result.add(a);
		result.add(w);
		
		return result;
	}

}
