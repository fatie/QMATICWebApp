package gov.nyc.buildings.strategic.dataanalysis.qmatic.model;

public class QueueGroups extends Queue {
	private int queueGroupsCustomerWaitings; 
	private int queueGroupsCustomerAverageWaitTimeInMinute;
	
	
	
	public int getQueueGroupsCustomerWaitings() {
		return queueGroupsCustomerWaitings;
	}



	public void setQueueGroupsCustomerWaitings(int queueGroupsCustomerWaitings) {
		this.queueGroupsCustomerWaitings = queueGroupsCustomerWaitings;
	}



	public int getQueueGroupsCustomerAverageWaitTimeInMinute() {
		return queueGroupsCustomerAverageWaitTimeInMinute;
	}



	public void setQueueGroupsCustomerAverageWaitTimeInMinute(int queueGroupsCustomerAverageWaitTimeInMinute) {
		this.queueGroupsCustomerAverageWaitTimeInMinute = queueGroupsCustomerAverageWaitTimeInMinute;
	}



	public QueueGroups(int queueGroupsCustomerWaitings, int queueGroupsCustomerAverageWaitTimeInMinute){
		super();
		this.setQueueGroupsCustomerWaitings(queueGroupsCustomerWaitings);
		this.setQueueGroupsCustomerAverageWaitTimeInMinute(queueGroupsCustomerAverageWaitTimeInMinute);
		
	}



	@Override
	public int getCustomersWaiting() {
		return this.getQueueGroupsCustomerWaitings();
	}



	@Override
	public int getAverageWaitTimeInMinute() {
		return this.getQueueGroupsCustomerAverageWaitTimeInMinute();
	}
	
	
	
}
