package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService{

	private SocialMediaDao socialMediaDao;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
		super();
		this.socialMediaDao = socialMediaDao;
	}

	@Override
	public DataResult<List<SocialMedia>> getAll() {
		return new SuccessDataResult<List<SocialMedia>>(socialMediaDao.findAll());
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<SocialMedia>> getByjobSeeker_id(int id) {
		return new SuccessDataResult<List<SocialMedia>>(socialMediaDao.getByjobseeker_id(id));
	}

	@Override
	public Result update(SocialMedia socialMedia, int id) {
		var value = socialMediaDao.getById(id);
		value.setLink(socialMedia.getLink());
		value.setJobseeker(socialMedia.getJobseeker());
		value.setLinkType(socialMedia.getLinkType());
		value.setResume(socialMedia.getResume());
		socialMediaDao.save(value);
		return new SuccessResult();
	}

}
