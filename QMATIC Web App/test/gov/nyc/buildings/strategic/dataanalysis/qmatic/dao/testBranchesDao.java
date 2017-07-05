package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import java.util.List;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.Branch;

public class testBranchesDao {

	public static void main(String[] args) {
		List<Branch> branchs = (new BranchesDao()).read();
		for (Branch branch : branchs) {
			System.out.println(branch);
		}
	}

}
