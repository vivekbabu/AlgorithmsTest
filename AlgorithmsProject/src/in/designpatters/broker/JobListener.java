package in.designpatters.broker;

public interface JobListener {
	
	public void jobOpeningPresent(JobInterface job, Broker broker);
}
