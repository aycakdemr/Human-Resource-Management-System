package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LanguageJobSeeker;
import kodlamaio.hrms.entities.concretes.SchoolJobSeeker;

public interface SchoolJobSeekerService {
	DataResult<List<SchoolJobSeeker>> getAll();
	Result add(SchoolJobSeeker schoolJobSeeker);
	Result update(SchoolJobSeeker schoolJobSeeker,int id);
	DataResult<List<SchoolJobSeeker>> getByjobSeeker_id(int id);
	DataResult<List<SchoolJobSeeker>> getAllSorted(int jobSeekerId);
}
