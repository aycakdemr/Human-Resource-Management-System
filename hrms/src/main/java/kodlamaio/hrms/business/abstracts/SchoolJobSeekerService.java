package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolJobSeeker;

public interface SchoolJobSeekerService {
	DataResult<List<SchoolJobSeeker>> getAll();
	Result add(SchoolJobSeeker schoolJobSeeker);
}
