package gov.nyc.buildings.strategic.dataanalysis.qmatic.model;

public class BranchStatus {
	private int id;
	private String name;
	private int customersWaiting;
	private int openServicePoints;
	private int maxWaitingTime;
	private int averageWaitingTime;
	private int totalWaitingTime;
	private int customersBeingServed;
	private Parameters parameters;
	
	public BranchStatus(){
		
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


	public int getMaxWaitingTime() {
		return maxWaitingTime;
	}


	public void setMaxWaitingTime(int maxWaitingTime) {
		this.maxWaitingTime = maxWaitingTime;
	}


	public int getAverageWaitingTime() {
		return averageWaitingTime;
	}
	
	public int getAverageWaitingTimeMin() {
		return averageWaitingTime/60;
	}


	public void setAverageWaitingTime(int averageWaitingTime) {
		this.averageWaitingTime = averageWaitingTime;
	}


	public int getTotalWaitingTime() {
		return totalWaitingTime;
	}


	public void setTotalWaitingTime(int totalWaitingTime) {
		this.totalWaitingTime = totalWaitingTime;
	}


	public int getCustomersBeingServed() {
		return customersBeingServed;
	}


	public void setCustomersBeingServed(int customersBeingServed) {
		this.customersBeingServed = customersBeingServed;
	}


	public Parameters getParameters() {
		return parameters;
	}


	public void setpParameters(Parameters parameters) {
		this.parameters = parameters;
	}


	public String toString(){
		return("id: "+id+"; name: "+name+"; Customers waiting: " + customersWaiting+"; openServicePoints: "+openServicePoints+"; maxWaitingTime: "+maxWaitingTime+"; averageWaitingTime: "+averageWaitingTime+"; customersBeingServed: "+customersBeingServed);
	}
	

}
