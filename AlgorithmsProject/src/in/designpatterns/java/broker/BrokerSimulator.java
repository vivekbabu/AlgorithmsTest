package in.designpatterns.java.broker;

public class BrokerSimulator {
public static void main(String[] args) {
  Company oracle = new Company("Oracle");
  Broker broker = new Broker("Naukri");
  oracle.addBroker(broker);
  Candidate raju = new Candidate("raju");
  Candidate radha = new Candidate("radha");
  broker.followCompany(oracle, raju);
  broker.followCompany(oracle, radha);
  Job job = new Job(121, "Software Engineer");
  oracle.addJob(job);
}
}
