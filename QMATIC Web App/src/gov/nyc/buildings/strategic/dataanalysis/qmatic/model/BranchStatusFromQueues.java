package gov.nyc.buildings.strategic.dataanalysis.qmatic.model;

import java.util.List;

public class BranchStatusFromQueues {
	private List<Queue> queues;
	private int id;
	private String name;
	private String groupName;
	private String groupId;
	
	
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
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
		int counter = 0;
		for (Queue queue : this.getQueues()){
			if(queue.getQueueVisits().isWsReadFlag())
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
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for (Queue q : this.getQueues()){
			sb.append(q.getName());
			sb.append(";");
			sb.append(q.getAverageWaitTimeInMinute());
			sb.append(";");
			sb.append(q.getQueueVisitsSize());
			sb.append(";\n");
		}
		return this.getId()+";"+this.getName()+";"+this.getGroupId()+";"+this.getGroupName()+";"+this.getBranchAverageWaitTimeInMinute()+";" +this.getBranchTotalWait()+ ";\n"+sb;
	}

}
