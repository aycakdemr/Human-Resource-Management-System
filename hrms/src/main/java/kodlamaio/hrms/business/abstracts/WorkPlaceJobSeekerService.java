package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkPlaceJobSeeker;

public interface WorkPlaceJobSeekerService {
	DataResult<List<WorkPlaceJobSeeker>> getAll();
	Result add(WorkPlaceJobSeeker workPlaceJobSeeker);
	DataResult<List<WorkPlaceJobSeeker>> getByjobSeeker_id(int id);
}
