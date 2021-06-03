package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.AbilityJobSeeker;

public interface AbilityJobSeekerService {
	DataResult<List<AbilityJobSeeker>> getAll();
	Result add(AbilityJobSeeker abilityJobSeeker);
	DataResult<List<AbilityJobSeeker>> getByjobSeeker_id(int id);
}
