package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.BranchStatusFromQueues;

public class testBranchStatuseFromQueuesDao {

	public static void main(String[] args) {
		BranchStatusFromQueues branchStatusFromQueues = (new BranchStatusFromQueuesDao("6")).read("6");
		System.out.println(branchStatusFromQueues);

	}

}
