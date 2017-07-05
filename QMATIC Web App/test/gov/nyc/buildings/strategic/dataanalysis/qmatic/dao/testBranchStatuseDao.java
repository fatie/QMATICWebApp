package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.BranchStatus;

public class testBranchStatuseDao {

	public static void main(String[] args) {
		BranchStatus branchStatus = (new BranchStatusDao("6")).read("6");
		System.out.println(branchStatus);

	}

}
