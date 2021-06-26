package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.concretes.WorkPlaceJobSeeker;

public interface WorkPlaceJobSeekerService {
	DataResult<List<WorkPlaceJobSeeker>> getAll();
	Result add(WorkPlaceJobSeeker workPlaceJobSeeker);
	Result update(WorkPlaceJobSeeker workPlaceJobSeeker,int id);
	DataResult<List<WorkPlaceJobSeeker>> getByjobSeeker_id(int id);
}
