package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageJobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageJobSeekerDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.LanguageJobSeeker;

@Service
public class LanguageJobSeekerManager implements LanguageJobSeekerService{

	private LanguageJobSeekerDao languageJobSeekerDao;
	
	@Autowired
	public LanguageJobSeekerManager(LanguageJobSeekerDao languageJobSeekerDao) {
		super();
		this.languageJobSeekerDao = languageJobSeekerDao;
	}

	@Override
	public DataResult<List<LanguageJobSeeker>> getAll() {
		return new SuccessDataResult<List<LanguageJobSeeker>>(languageJobSeekerDao.findAll());
	}

	@Override
	public Result add(LanguageJobSeeker languageJobSeeker) {
		this.languageJobSeekerDao.save(languageJobSeeker);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<LanguageJobSeeker>> getByjobSeeker_id(int id) {
		return new SuccessDataResult<List<LanguageJobSeeker>>(languageJobSeekerDao.getByjobseeker_id(id));

	}
	
	
}
