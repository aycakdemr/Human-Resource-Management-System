package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.AbilityJobSeeker;
import kodlamaio.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {
	DataResult<List<SocialMedia>> getAll();
	Result add(SocialMedia socialMedia);
	Result update(SocialMedia socialMedia,int id);
	DataResult<List<SocialMedia>>  getByjobSeeker_id(int id);
}
