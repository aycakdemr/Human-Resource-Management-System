package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkPlaceJobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkPlaceJobSeekerDao;
import kodlamaio.hrms.entities.concretes.WorkPlaceJobSeeker;

@Service
public class WorkPlaceJobSeekerManager implements  WorkPlaceJobSeekerService{

	private WorkPlaceJobSeekerDao workPlaceJobSeekerDao;

	@Autowired
	public WorkPlaceJobSeekerManager(WorkPlaceJobSeekerDao workPlaceJobSeekerDao) {
		super();
		this.workPlaceJobSeekerDao = workPlaceJobSeekerDao;
	}

	@Override
	public DataResult<List<WorkPlaceJobSeeker>> getAll() {
		return new SuccessDataResult<List<WorkPlaceJobSeeker>>(workPlaceJobSeekerDao.findAll());
	}

	@Override
	public Result add(WorkPlaceJobSeeker workPlaceJobSeeker) {
		this.workPlaceJobSeekerDao.save(workPlaceJobSeeker);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<WorkPlaceJobSeeker>> getByjobSeeker_id(int id) {
		return new SuccessDataResult<List<WorkPlaceJobSeeker>>(workPlaceJobSeekerDao.getByjobseeker_id(id));

	}

	@Override
	public Result update(WorkPlaceJobSeeker workPlaceJobSeeker, int id) {
		var value = workPlaceJobSeekerDao.getById(id);
		value.setDateOfEntry(workPlaceJobSeeker.getDateOfEntry());
		value.setDateOfLeaving(workPlaceJobSeeker.getDateOfLeaving());
		value.setJobseeker(workPlaceJobSeeker.getJobseeker());
		value.setResume(workPlaceJobSeeker.getResume());
		value.setWorkplaceName(workPlaceJobSeeker.getWorkplaceName());
		workPlaceJobSeekerDao.save(value);
		return new SuccessResult();
	}
	
}
