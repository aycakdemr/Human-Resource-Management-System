package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;


@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll());
	}
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActivatedTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActive(true));
	}
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActivatedFalse() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActive(false));
	}
	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByDate() {
		Sort sort = Sort.by(Sort.Direction.DESC,"createdDate");
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(sort));
	}
	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("İş ilanı silindi");
	}
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi");
	}
	@Override
	public DataResult<List<JobAdvertisement>> getByAdvertisementByCompany(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActiveAndEmployer_CompanyName(true,companyName));

	}
	@Override
	public DataResult<List<JobAdvertisement>> getTwoAdvert() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActiveAndEmployer_CompanyName(true,"deneme şirketi"));

	}
	@Override
	public Result closeAdvertisement(int id) {
		var value = jobAdvertisementDao.getById(id);
		if(!value.get(0).isActive()) {
			return new ErrorResult("İlan zaten kapalı!!!");
		}
		else {
			value.get(0).setActive(false);
			this.jobAdvertisementDao.save(value.get(0));
			return new SuccessResult("İlan kapatıldı.");
		}
	}
	@Override
	public DataResult<List<JobAdvertisement>> getbyId(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getById(id));

	}
	@Override
	public DataResult<List<JobAdvertisement>> getbyFilter(int jobPositionId, int companySectorId, int wayOfWorkingId,
			int positionLevelId, int educationLevelId, int cityId) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByjobPosition_idAndEmployer_companysector_idAndWayofworking_idAndPositionLevel_idAndEducationLevel_idAndCity_id
				(jobPositionId,companySectorId,wayOfWorkingId,positionLevelId,educationLevelId,cityId));

	}
	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByEmployer_id(id));
	}
	@Override
	public DataResult<List<JobAdvertisement>> getByisActive(int pageNumber, int pageSize) {
		 Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
	        return new SuccessDataResult<List<JobAdvertisement>>(
	                this.jobAdvertisementDao.getByisActive(true,pageable));
	}
	

	


}
