package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.helpers.PhotoUploadHelper;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	PhotoUploadHelper photoUploadHelper;
	JobSeekerService jobSeekerService; 
	
	@Autowired
	public ImageManager(ImageDao imageDao, PhotoUploadHelper photoUploadHelper, JobSeekerService jobSeekerService) {
		super();
		this.imageDao = imageDao;
		this.photoUploadHelper = photoUploadHelper;
		this.jobSeekerService = jobSeekerService;
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(imageDao.findAll());
	}

	

	@Override
	public Result add(MultipartFile image, int jobseekerId) {
		
		DataResult<Map<String, String>> result = this.photoUploadHelper.upload(image);
		if(result.isSuccess()) {

			Image photo = new Image();
			photo.setJobseeker(jobSeekerService.getByjobSeeker_id(jobseekerId).getData());
			photo.setImagePath(result.getData().get("url"));
			this.imageDao.save(photo);
			return new SuccessResult();
			
		}
		return new ErrorResult();
		
	}

	@Override
	public DataResult<Image> getByjobSeeker_id(int id) {
		return new SuccessDataResult<Image>(imageDao.getByjobseeker_id(id));

	}

}
