package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AbilityJobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AbilityJobSeekerDao;
import kodlamaio.hrms.entities.concretes.AbilityJobSeeker;

@Service
public class AbilityJobSeekerManager implements AbilityJobSeekerService{

	private AbilityJobSeekerDao abilityJobSeekerDao;
	
	@Autowired
	public AbilityJobSeekerManager(AbilityJobSeekerDao abilityJobSeekerDao) {
		super();
		this.abilityJobSeekerDao = abilityJobSeekerDao;
	}

	@Override
	public DataResult<List<AbilityJobSeeker>> getAll() {
		return new SuccessDataResult<List<AbilityJobSeeker>>(abilityJobSeekerDao.findAll());
	}

	@Override
	public Result add(AbilityJobSeeker abilityJobSeeker) {
		this.abilityJobSeekerDao.save(abilityJobSeeker);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<AbilityJobSeeker>> getByjobSeeker_id(int id) {
		return new SuccessDataResult<List<AbilityJobSeeker>>(abilityJobSeekerDao.getByjobSeeker_id(id));
	}

	@Override
	public Result delete(AbilityJobSeeker abilityJobSeeker) {
		var value = abilityJobSeekerDao.getById(abilityJobSeeker.getId());
		this.abilityJobSeekerDao.delete(value);
		return new SuccessResult();
	}

	@Override
	public Result update(AbilityJobSeeker abilityJobSeeker,int id) {
		var value = abilityJobSeekerDao.getById(id);
		value.setAbility(abilityJobSeeker.getAbility());
		value.setJobSeeker(abilityJobSeeker.getJobSeeker());
		value.setResume(abilityJobSeeker.getResume());
		abilityJobSeekerDao.save(value);
		return new SuccessResult();
		
	}

	

}
