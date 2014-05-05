package in.designpatterns.java.broker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Broker {

private String name;

public String getName() {
  return name;
}

public Broker(String name) {
  this.name = name;
}

private Map<Company, Set<Job>> currentOpenings = new HashMap<Company, Set<Job>>();
private Map<Company, Set<Candidate>> companiesToCandidates = new HashMap<Company, Set<Candidate>>();

public void addJob(Job job) {
  if (!currentOpenings.containsKey(job.getCompany())) {
    currentOpenings.put(job.getCompany(), new HashSet<Job>());
  }

  currentOpenings.get(job.getCompany()).add(job);
  for (Candidate candidate : companiesToCandidates.get((job.getCompany()))) {
    candidate.jobOpeningPresent(job, this);
  }
}

public void followCompany(Company company, Candidate candidate) {
  if (!companiesToCandidates.containsKey(company)) {
    companiesToCandidates.put(company, new HashSet<Candidate>());
  }
  companiesToCandidates.get(company).add(candidate);
}

public void applyForJob(Candidate candidate, JobInterface job) {
  ((Job) job).getCompany().candidateForJob(candidate, (Job) job);
}

@Override
public boolean equals(Object obj) {
  return this.name.equals(((Broker) obj).getName());
}

@Override
public int hashCode() {
  return new HashCodeBuilder(11, 13).append(this.name).toHashCode();
}

}
