package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll());
	}

	@Override
	public DataResult<JobPosition> getByName(String name) {
        return new SuccessDataResult<>(this.jobPositionDao.findByName(name));
    }
	 @Override
	public Result add (JobPosition jobPosition) {
	    if(getByName(jobPosition.getName()).getData() != null){
	         return new ErrorResult("Aynı pozisyon zaten var.");
	    }
	   this.jobPositionDao.save(jobPosition);
	   return new SuccessResult("Pozisyon eklendi");
	}

}
