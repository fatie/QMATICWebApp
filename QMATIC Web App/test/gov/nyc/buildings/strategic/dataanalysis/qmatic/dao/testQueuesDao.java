package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import java.util.Collections;
import java.util.List;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Queue;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.util.QueueIdCompare;

public class testQueuesDao {

	public static void main(String[] args) {
		List<Queue> queues = (new QueuesDao("1")).read("1");
		 for (Queue queue : queues) {
		 System.out.println(queue);
		 }

//		Collections.sort(queues, (new QueueIdCompare()));
//		for (int i = 0; i < queues.size(); i++) {
//			System.out.println(queues.get(i));
//		}

	}

}
