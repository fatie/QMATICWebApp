package gov.nyc.buildings.strategic.dataanalysis.qmatic.dao;

import java.util.Date;

import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.BranchStatusFromQueues;
import gov.nyc.buildings.strategic.dataanalysis.qmatic.model.BranchStatusFromQueuesCentralDivided;

public class testBranchStatuseFromQueuesDao {

	public static void main(String[] args) {
		System.out.println(new Date());
		BranchStatusFromQueues branchStatusFromQueues = (new BranchStatusFromQueuesDao("6")).read("6");
		System.out.println(branchStatusFromQueues);
		
		BranchStatusFromQueues tem4c =( new BranchStatusFromQueuesCentralDivided(branchStatusFromQueues)).getBsfqcd().get("4C");
		System.out.println("-----------------------------");
		System.out.println(tem4c);
		
		BranchStatusFromQueues tem5a =( new BranchStatusFromQueuesCentralDivided(branchStatusFromQueues)).getBsfqcd().get("5A");
		System.out.println("-----------------------------");
		System.out.println(tem5a);
		
		BranchStatusFromQueues tem5l =( new BranchStatusFromQueuesCentralDivided(branchStatusFromQueues)).getBsfqcd().get("5L");
		System.out.println("-----------------------------");
		System.out.println(tem5l);
		
		BranchStatusFromQueues tem5c =( new BranchStatusFromQueuesCentralDivided(branchStatusFromQueues)).getBsfqcd().get("5C");
		System.out.println("-----------------------------");
		System.out.println(tem5c);
		
		BranchStatusFromQueues tem6l =( new BranchStatusFromQueuesCentralDivided(branchStatusFromQueues)).getBsfqcd().get("6L");
		System.out.println("-----------------------------");
		System.out.println(tem6l);
		
		BranchStatusFromQueues tem6c =( new BranchStatusFromQueuesCentralDivided(branchStatusFromQueues)).getBsfqcd().get("6C");
		System.out.println("-----------------------------");
		System.out.println(tem6c);
		
		System.out.println(new Date());
		
		branchStatusFromQueues = (new BranchStatusFromQueuesDao("1")).read("1");
		System.out.println(branchStatusFromQueues);
		System.out.println(new Date());
		
		branchStatusFromQueues = (new BranchStatusFromQueuesDao("2")).read("2");
		System.out.println(branchStatusFromQueues);
		System.out.println(new Date());
		
		branchStatusFromQueues = (new BranchStatusFromQueuesDao("3")).read("3");
		System.out.println(branchStatusFromQueues);
		
		branchStatusFromQueues = (new BranchStatusFromQueuesDao("4")).read("4");
		System.out.println(branchStatusFromQueues);
		System.out.println(new Date());
		
		branchStatusFromQueues = (new BranchStatusFromQueuesDao("5")).read("5");
		System.out.println(branchStatusFromQueues);
		System.out.println(new Date());

	}
	
	
	
}
