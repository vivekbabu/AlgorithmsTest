package in.designpatterns.broker;

public interface JobListener {
	
	public void jobOpeningPresent(JobInterface job, Broker broker);
}
