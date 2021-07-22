package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dto.JobAdvertFilterDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByIsActivatedTrue();
	DataResult<List<JobAdvertisement>> getByisActive(int pageNumber,int pageSize);
	DataResult<List<JobAdvertisement>> getByIsActivatedFalse();
	DataResult<List<JobAdvertisement>> getAllSortedByDate();
	DataResult<List<JobAdvertisement>> getbyId(int id);
	DataResult<List<JobAdvertisement>> getByEmployerId(int id);
	DataResult<List<JobAdvertisement>> getbyFilter(int pageNo, int pageSize, JobAdvertFilterDto filter);
	Result delete(JobAdvertisement jobAdvertisement);
	Result add(JobAdvertisement jobAdvertisement);
	Result closeAdvertisement(int id);
	DataResult<List<JobAdvertisement>> getByAdvertisementByCompany(String companyName);
	DataResult<List<JobAdvertisement>> getTwoAdvert();
	
}
