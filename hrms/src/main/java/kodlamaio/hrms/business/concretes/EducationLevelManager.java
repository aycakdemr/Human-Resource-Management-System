package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationLevelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationLevelDao;
import kodlamaio.hrms.entities.concretes.EducationLevel;
import kodlamaio.hrms.entities.concretes.WayOfWorking;

@Service
public class EducationLevelManager implements EducationLevelService{

	private EducationLevelDao educationLevelDao;
	
	@Autowired
	public EducationLevelManager(EducationLevelDao educationLevelDao) {
		super();
		this.educationLevelDao = educationLevelDao;
	}
	@Override
	public DataResult<List<EducationLevel>> getAll() {
		return new SuccessDataResult<List<EducationLevel>>(educationLevelDao.findAll());
	}

}
