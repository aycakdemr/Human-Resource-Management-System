package kodlamaio.hrms.adapters;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface CheckService {
	boolean Check(JobSeeker jobSeeker);
}
