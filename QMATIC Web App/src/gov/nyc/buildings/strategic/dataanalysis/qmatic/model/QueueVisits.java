package gov.nyc.buildings.strategic.dataanalysis.qmatic.model;

import java.util.List;

public class QueueVisits {
	private List<QueueVisit> queueVisits;
	
	public QueueVisits(List<QueueVisit> queueVisits){
		this.setQueueVisits(queueVisits);
	}
	
	public List<QueueVisit> getQueueVisits() {
		return queueVisits;
	}

	public void setQueueVisits(List<QueueVisit> queueVisits) {
		this.queueVisits = queueVisits;
	}
	
	public int getTotalWaitTime(){
		int sum = 0;
		for (int i = 0; i<this.getQueueVisits().size(); i++){
			sum+=this.getQueueVisits().get(i).getWaitingTime();
		}
		return sum;
	}
	
	public int getQueueVisitsSize(){
		int count = 0;
		for (int i = 0; i<this.getQueueVisits().size(); i++){
			count++;
		}
		return count;
	}
	
	public int getAverageWaitTime(){
		int sum = 0;
		int count = 0;
		for (int i = 0; i<this.getQueueVisits().size(); i++){
			sum+=this.getQueueVisits().get(i).getWaitingTime();
			count++;
		}
		return count==0?0:sum/count;
	}
	
	public int getAverageWaitTimeInMinute(){
		return getAverageWaitTime()/60;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for (QueueVisit qv: queueVisits){
			sb.append(qv.getServiceName()+":"+qv.getWaitingTime()+"/n");
		}
		return sb.toString();
		
	}
	
}
