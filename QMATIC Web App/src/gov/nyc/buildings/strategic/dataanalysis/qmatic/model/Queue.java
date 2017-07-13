package gov.nyc.buildings.strategic.dataanalysis.qmatic.model;

public class Queue {
	private int id;
	private int branchId;
	private String name;
	private String queueType;
	private String branchName;
	private int customersWaiting;
	private int openServicePoints;
	private int waitingTime;
	private int appointmentWaitingTime;
	private int estimatedWaitingTime;
	private int customersServed;
	private QueueVisits queueVisits;
	
	public Queue(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQueueType() {
		return queueType;
	}

	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getCustomersWaiting() {
		return customersWaiting;
	}

	public void setCustomersWaiting(int customersWaiting) {
		this.customersWaiting = customersWaiting;
	}

	public int getOpenServicePoints() {
		return openServicePoints;
	}

	public void setOpenServicePoints(int openServicePoints) {
		this.openServicePoints = openServicePoints;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	public int getAppointmentWaitingTime() {
		return appointmentWaitingTime;
	}

	public void setAppointmentWaitingTime(int appointmentWaitingTime) {
		this.appointmentWaitingTime = appointmentWaitingTime;
	}

	public int getEstimatedWaitingTime() {
		return estimatedWaitingTime;
	}

	public void setEstimatedWaitingTime(int estimateWaitingTime) {
		this.estimatedWaitingTime = estimateWaitingTime;
	}

	public int getCustomersServed() {
		return customersServed;
	}

	public void setCustomersServed(int customersServed) {
		this.customersServed = customersServed;
	}
	
	
	
//	public String toString(){
//		return("Branch Name: "+branchName+"; Unit Name: "+name+"; Customers waiting: " + customersWaiting+"; Waiting Time: "+waitingTime+"; Customer Served: "+customersServed + "; queue id: " + id);
//	}
	
	public QueueVisits getQueueVisits() {
		return queueVisits;
	}

	public void setQueueVisits(QueueVisits queueVisits) {
		this.queueVisits = queueVisits;
	}

	public String toString(){
		return("queue id: " + id + "; queue name: " + name + "; average wait time: " + this.getAverageWaitTimeInMinute());
	}
	
	public int getQueueVisitsSize(){
		return this.getQueueVisits().getQueueVisitsSize();
	}
	
	public int getTotalWaitTime(){
		return this.getQueueVisits().getTotalWaitTime();
	}
	
	public int getAverageWaitTime(){
		return this.getQueueVisits().getAverageWaitTime();
	}
	
	public int getAverageWaitTimeInMinute(){
		return this.getQueueVisits().getAverageWaitTimeInMinute();
	}
	

}
