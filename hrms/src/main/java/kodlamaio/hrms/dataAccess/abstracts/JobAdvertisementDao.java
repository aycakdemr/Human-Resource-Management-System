package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;



public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByisActive(boolean status);
	
	List<JobAdvertisement> getById(int id);

	List<JobAdvertisement> getByIsActiveAndEmployer_CompanyName(boolean IsActive,String companyName);
	
	List<JobAdvertisement> getByjobPosition_idAndEmployer_companysector_idAndWayofworking_idAndPositionLevel_idAndEducationLevel_idAndCity_id
	(int jobPositionId,int companySectorId,int wayOfWorkingId, int positionLevelId,int educationLevelId,int cityId);

}
