package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolJobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolJobSeekerDao;
import kodlamaio.hrms.entities.concretes.SchoolJobSeeker;

@Service
public class SchoolJobSeekerManager implements SchoolJobSeekerService{

	private SchoolJobSeekerDao schoolJobSeekerDao;
	
	@Autowired
	public SchoolJobSeekerManager(SchoolJobSeekerDao schoolJobSeekerDao) {
		super();
		this.schoolJobSeekerDao = schoolJobSeekerDao;
	}

	@Override
	public DataResult<List<SchoolJobSeeker>> getAll() {
		return new SuccessDataResult<List<SchoolJobSeeker>>(schoolJobSeekerDao.findAll());

	}

	@Override
	public Result add(SchoolJobSeeker schoolJobSeeker) {
		this.schoolJobSeekerDao.save(schoolJobSeeker);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<SchoolJobSeeker>> getByjobSeeker_id(int id) {
		return new SuccessDataResult<List<SchoolJobSeeker>>(schoolJobSeekerDao.getByjobSeeker_id(id));
	}

	@Override
	public DataResult<List<SchoolJobSeeker>> getAllSorted(int jobSeekerId) {
		return new SuccessDataResult<List<SchoolJobSeeker>>(this.schoolJobSeekerDao.getByjobSeeker_idOrderByDateOfGraduationAsc(jobSeekerId));
	}
	


}
