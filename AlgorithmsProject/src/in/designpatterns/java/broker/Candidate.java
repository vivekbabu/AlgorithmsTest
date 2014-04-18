package in.designpatterns.java.broker;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Candidate implements JobListener {

	private String nameOfCandidate;

	public Candidate(String name) {
		this.nameOfCandidate = name;
	}
	
	public String getNameOfCandidate() {
		return nameOfCandidate;
	}

	@Override
	public void jobOpeningPresent(JobInterface job, Broker broker) {
		if (canApplyForJob(job)) {
			broker.applyForJob(this, job);
		} else {
			System.out.println(nameOfCandidate + " not appliying for"
					+ job.getJobDescription() + " at " + job.getNameOfCompany());
		}
	}

	public boolean canApplyForJob(JobInterface job) {
		return true;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return  this.nameOfCandidate.equals(((Candidate)obj).getNameOfCandidate());
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(7, 11).append(this.nameOfCandidate).toHashCode();
	}
	
	@Override
	public String toString() {
		return this.getNameOfCandidate();
	}

}
