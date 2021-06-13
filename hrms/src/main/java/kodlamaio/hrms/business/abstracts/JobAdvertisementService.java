package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByIsActivated();
	DataResult<List<JobAdvertisement>> getAllSortedByDate();
	DataResult<List<JobAdvertisement>> getbyId(int id);
	Result delete(JobAdvertisement jobAdvertisement);
	Result add(JobAdvertisement jobAdvertisement);
	Result closeAdvertisement(int id);
	DataResult<List<JobAdvertisement>> getByAdvertisementByCompany(String companyName);
	DataResult<List<JobAdvertisement>> getTwoAdvert();
}
