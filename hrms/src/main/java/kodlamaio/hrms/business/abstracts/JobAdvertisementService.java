package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByIsActivatedTrue();
	DataResult<List<JobAdvertisement>> getByIsActivatedFalse();
	DataResult<List<JobAdvertisement>> getAllSortedByDate();
	DataResult<List<JobAdvertisement>> getbyId(int id);
	DataResult<List<JobAdvertisement>> getByEmployerId(int id);
	DataResult<List<JobAdvertisement>> getbyFilter(int jobPositionId,int companySectorId,int wayOfWorkingId, int positionLevelId,int educationLevelId,int cityId);
	Result delete(JobAdvertisement jobAdvertisement);
	Result add(JobAdvertisement jobAdvertisement);
	Result closeAdvertisement(int id);
	DataResult<List<JobAdvertisement>> getByAdvertisementByCompany(String companyName);
	DataResult<List<JobAdvertisement>> getTwoAdvert();
}
