package in.designpatterns.java.broker;

public interface JobListener {
	
	public void jobOpeningPresent(JobInterface job, Broker broker);
}
