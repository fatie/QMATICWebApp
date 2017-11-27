package gov.nyc.buildings.strategic.dataanalysis.qmatic.util;

import java.util.Comparator;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Queue;

public class QueueNameCompare implements Comparator<Queue> {

	@Override
	public int compare(Queue o1, Queue o2) {
		return o1.getName().trim().compareTo(o2.getName().trim());
	}
 
}
