package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.AbilityJobSeeker;
import kodlamaio.hrms.entities.concretes.LanguageJobSeeker;

public interface LanguageJobSeekerService {
	DataResult<List<LanguageJobSeeker>> getAll();
	Result add(LanguageJobSeeker languageJobSeeker);
	Result update(LanguageJobSeeker languageJobSeeker,int id);
	DataResult<List<LanguageJobSeeker>> getByjobSeeker_id(int id);
}
