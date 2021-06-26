package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ApprovedJobAdvertService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ApprovedJobAdvertDao;
import kodlamaio.hrms.entities.concretes.ApprovedJobAdvert;
import kodlamaio.hrms.entities.concretes.WayOfWorking;

@Service
public class ApprovedJobAdvertManager implements ApprovedJobAdvertService{

	private ApprovedJobAdvertDao approvedJobAdvertDao;
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public ApprovedJobAdvertManager(ApprovedJobAdvertDao approvedJobAdvertDao,JobAdvertisementService jobAdvertisementService) {
		super();
		this.approvedJobAdvertDao = approvedJobAdvertDao;
		this.jobAdvertisementService = jobAdvertisementService;
	}


	@Override
	public DataResult<List<ApprovedJobAdvert>> getAll() {
		return new SuccessDataResult<List<ApprovedJobAdvert>>(approvedJobAdvertDao.getByisApproved(true));
	}


	@Override
	public Result add(ApprovedJobAdvert approvedJobAdvert) {
		this.approvedJobAdvertDao.save(approvedJobAdvert);
		var advert =this.jobAdvertisementService.getbyId(approvedJobAdvert.getJobAdvertisement().getId());
		advert.getData().get(0).setActive(true);
		this.jobAdvertisementService.add(advert.getData().get(0));
		return new SuccessResult();
	}

}
