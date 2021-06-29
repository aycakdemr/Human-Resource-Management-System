package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;



public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByisActive(boolean status);
	
	List<JobAdvertisement> getByisActive(boolean status,Pageable pageable);
	
	List<JobAdvertisement> getById(int id);
	
	List<JobAdvertisement> getByEmployer_id(int id);

	List<JobAdvertisement> getByIsActiveAndEmployer_CompanyName(boolean IsActive,String companyName);
	
	List<JobAdvertisement> getByjobPosition_id
	(int jobPositionId);
	
	List<JobAdvertisement> getByjobPosition_idAndEmployer_companysector_id
	(int jobPositionId,int companySectorId);
	
	List<JobAdvertisement> getByjobPosition_idAndEmployer_companysector_idAndWayofworking_id
	(int jobPositionId,int companySectorId,int wayOfWorkingId);
	
	List<JobAdvertisement> getByjobPosition_idAndEmployer_companysector_idAndWayofworking_idAndPositionLevel_id
	(int jobPositionId,int companySectorId,int wayOfWorkingId, int positionLevelId);
	
	List<JobAdvertisement> getByjobPosition_idAndEmployer_companysector_idAndWayofworking_idAndPositionLevel_idAndEducationLevel_id
	(int jobPositionId,int companySectorId,int wayOfWorkingId, int positionLevelId,int educationLevelId);
	
	List<JobAdvertisement> getByjobPosition_idAndEmployer_companysector_idAndWayofworking_idAndPositionLevel_idAndEducationLevel_idAndCity_id
	(int jobPositionId,int companySectorId,int wayOfWorkingId, int positionLevelId,int educationLevelId,int cityId);

}
