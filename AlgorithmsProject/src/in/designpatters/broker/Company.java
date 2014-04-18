package in.designpatters.broker;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Company implements CandidateListener {
	private Set<Broker> brokers = new HashSet<Broker>();
	private Set<Job> jobs = new HashSet<Job>(); 
	private String nameOfCompany;

	public String getNameOfCompany() {
		return nameOfCompany;
	}

	public Company(String name) {
		this.nameOfCompany = name;
	}
	
	public Company addBroker(Broker broker) {
		brokers.add(broker);
		return this;
	}
	
	public Company addJob(Job job) {
		job.setCompany(this);
		jobs.add(job);
		for(Broker broker : brokers) {
			broker.addJob(job);
		}
		return this;
	}
	
	@Override
	public void candidateForJob(Candidate candidate, Job job) {
		if(!jobs.contains(job)) {
			System.out.println("Wrong job sir");
		}
		else if (!job.isOpen()) {
			System.out.println("Sorry Job Closed");
		}
		else {
			this.startInterviewProcessWithCandidate(candidate, job);
		}
		
	}

	private void startInterviewProcessWithCandidate(Candidate candidate, Job job) {
		System.out.println(job.getCompany()+ " interview started for " + candidate.getNameOfCandidate());
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.nameOfCompany.equals(obj);
	}
	
	@Override
	public int hashCode() {
		 return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
		            // if deriving: appendSuper(super.hashCode()).
		            append(nameOfCompany).
		            toHashCode();
	}
	
	@Override
	public String toString() {
		return this.getNameOfCompany();
	}
}
