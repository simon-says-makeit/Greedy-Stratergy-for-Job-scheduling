
import java.util.*;
import java.util.List;
import java.util.ArrayList;

import java.io.InputStream;

public class JobScheduling {
	// uncomment exactly one to indicate which strategy you are 
	// implementing for your group
	// public static final Strategy chosen = Strategy.SHORTEST_INTERVAL;
	public static final Strategy chosen = Strategy.EARLIEST_FINISH;
	// public static final Strategy chosen = Strategy.FEWEST_CONFLICTS;
	// public static final Strategy chosen = Strategy.EARLIEST_START;
	
	/**
	 * Returns a non-conflicting selection of jobs from the input list, 
	 * chosen according to the shortest interval strategy, i.e. jobs are 
	 * considered in order of shortest to longest interval length, each 
	 * job is included if and only if it doesn't conflict with previously 
	 * chosen jobs.
	 *
	 * @param jobs   the jobs which make up the job scheduling instance
	 * @return       a list containing the selected jobs
	 */
	public static List<Job> byShortestInterval(List<Job> jobs) {
		// TODO: implement this
		return null;
	}
	
	/**
	 * Returns a non-conflicting selection of jobs from the input list, 
	 * chosen according to the earliest finish time strategy, i.e. jobb	 * considered in order of earliest to latest finish time, each 
	 * job is included if and only if it doesn't conflict with previously 
	 * chosen jobs.
	 *
	 * @param jobs   the jobs which make up the job scheduling instance
	 * @return       a list containing the selected jobs
	 */
	
	public static List<Job> byEarliestFinish(List<Job> jobs){
		
		List<Job> jobsList = jobs;
		List<Job> orderdJob = new ArrayList<>();
		
		// comparator sorts jobslist in the order of the earliest finish time
		Comparator<Job> sorter = new Comparator<>() {
			@Override
			public int compare(Job first, Job second){
				if(first.getFinishTime() > second.getFinishTime()){
					return 1;
				}
				if(first.getFinishTime() < second.getFinishTime()){
					return -1;
				}
				return 0;
			}
		};
		Collections.sort(jobsList, sorter);
		
		/* adds an item to the orderedjobs if there is no clash each time a Job is added to the list
		the reference point is moved to the new Job to check for clashes*/
		
		orderdJob.add(jobsList.get(0));
		int index = 0;
		for(int i = 1; i < jobsList.size(); i++){
			if(jobsList.get(i).getStartTime() >= orderdJob.get(index).getFinishTime()){
			index++;
			orderdJob.add(jobsList.get(i));		
			}
		}
		return orderdJob;
		
		}
		
		
	
	/**
	 * Returns a non-conflicting selection of jobs from the input list, 
	 * chosen according to the fewest conflicts strategy, i.e. jobs are 
	 * considered in order of fewest to most conflicts with other jobs, each 
	 * job is included if and only if it doesn't conflict with previously 
	 * chosen jobs.
	 *
	 * @param jobs   the jobs which make up the job scheduling instance
	 * @return       a list containing the selected jobs
	 */
	public static List<Job> byFewestConflicts(List<Job> jobs) {
		// TODO: implement this
		return null;
	}
	
	/**
	 * Returns a non-conflicting selection of jobs from the input list, 
	 * chosen according to the earliest starting time strategy, i.e. jobs are 
	 * considered in order of earliest to latest starting time, each 
	 * job is included if and only if it doesn't conflict with previously 
	 * chosen jobs.
	 *
	 * @param jobs   the jobs which make up the job scheduling instance
	 * @return       a list containing the selected jobs
	 */
	public static List<Job> byEarliestStart(List<Job> jobs) {
		// TODO: implement this
		return null;
	}
	
	public static void main(String[] args) {
		/* This is here for you to optionally use for your own testing / running. 
		 * This method will NOT be tested. Feel free to experiment here.
		 */
		List<Job> jobs = loadJobs(System.in);
		List<Job> jobsList = jobs;
		List<Job> orderdJob = new ArrayList<>();
		
		// comparator sorts jobslist in the order of the earliest finish time
		Comparator<Job> sorter = new Comparator<>() {
			@Override
			public int compare(Job first, Job second){
				if(first.getFinishTime() > second.getFinishTime()){
					return 1;
				}
				if(first.getFinishTime() < second.getFinishTime()){
					return -1;
				}
				return 0;
			}
		};
		Collections.sort(jobsList, sorter);
		
		
		System.out.println(jobs);
		System.out.println(jobsList);
		List<Job> finalJobs = byEarliestFinish(jobs);
		System.out.print(finalJobs);
	}
	
	/**
	 * Loads a list of jobs from a specified input stream, such as standard input. 
	 * The input is expected to be a newline-separated sequence of jobs, each given 
	 * by a space-separated triplet of numbers, in order: id, startTime, finishTime.
	 * 
	 * @param stream   the input stream from which to read job data
	 * @return         the loaded list of jobs
	 */
	public static List<Job> loadJobs(InputStream stream) {
		Scanner scanner = new Scanner(stream);
		List<Job> jobs = new ArrayList<>();
		while (scanner.hasNext()) {
			int id = scanner.nextInt();
			float startTime = scanner.nextFloat();
			float finishTime = scanner.nextFloat();
			jobs.add(new Job(id, startTime, finishTime));
		}
		return jobs;
	}
	
	public static enum Strategy {
		SHORTEST_INTERVAL,
		EARLIEST_FINISH,
		FEWEST_CNFLICTS,
		EARLIEST_START
	}
}
