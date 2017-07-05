package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import java.util.List;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Queue;

public class testQueueDao {

	public static void main(String[] args) {
	List<Queue> queues = (new QueuesDao("6")).read("6");
		for (Queue queue : queues) {
			System.out.println(queue);
		}
	}

}
