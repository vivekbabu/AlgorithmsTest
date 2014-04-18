package in.designpatterns.java.broker;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Job implements JobInterface {

	private String jobDescription;
	private long jobId;
	private boolean open = true;
	private Company company;

	public Job(long jobId, String jobDescription) {
		this.jobId = jobId;
		this.jobDescription = jobDescription;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public boolean isOpen() {
		return open;
	}

	public long getJobId() {
		return jobId;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public Company getCompany() {
		return company;
	}

	@Override
	public boolean equals(Object obj) {
		Job job = (Job) obj;
		return this.jobId == job.getJobId()
				&& this.company.equals(job.getCompany());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(3, 7).append(this.getJobDescription())
				.append(this.getCompany()).hashCode();
	}
	
	@Override
	public String toString() {
		return jobDescription + " at " + company.getNameOfCompany();
	}

	@Override
	public String getNameOfCompany() {
		return company.getNameOfCompany();
	}

	

}
