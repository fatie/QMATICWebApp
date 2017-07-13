package gov.nyc.buildings.strategic.dataanalysis.qmatic.model;

public class QueueVisit {
	private String serviceName;
	private String ticketNumber;
	private String customerName;
	private int waitingTime;
	private int appointmentWaitingTime;
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	
	@Override
	public String toString(){
		return (this.getServiceName()+";"+this.getWaitingTime());
	}

}
