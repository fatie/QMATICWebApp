package gov.nyc.buildings.strategic.dataanalysis.qmatic.model;

import java.util.List;

public class BranchStatusFromQueues {
	private List<Queue> queues;
	private int id;
	private String name;
	
	public List<Queue> getQueues() {
		return queues;
	}
	public void setQueues(List<Queue> queues) {
		this.queues = queues;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBranchTotalWait(){
		int sum = 0;
		for (Queue queue : this.queues){
			sum+=queue.getQueueVisitsSize();
		}
		return sum;
	}
	
	public int getBranchAverageWaitTime(){
		int totalWaitTime = 0;
		for (Queue queue : this.queues){
			totalWaitTime+=queue.getTotalWaitTime();
		}
		return getBranchTotalWait()==0?0:totalWaitTime/getBranchTotalWait();
	}
	
	public int getBranchAverageWaitTimeInMinute(){
		return getBranchAverageWaitTime()/60;
	}

}
