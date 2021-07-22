package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dto.JobAdvertFilterDto;



public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByisActive(boolean status);
	
	List<JobAdvertisement> getByisActive(boolean status,Pageable pageable);
	
	List<JobAdvertisement> getById(int id);
	
	List<JobAdvertisement> getByEmployer_id(int id);

	List<JobAdvertisement> getByIsActiveAndEmployer_CompanyName(boolean IsActive,String companyName);
		
	
	
	@Query("Select j from kodlamaio.hrms.entities.concretes.JobAdvertisement j where "
			+ "((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
	        +" and ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
	        +" and ((:#{#filter.companySectorId}) IS NULL OR j.employer.companysector.id IN (:#{#filter.companySectorId}))"
	        +" and ((:#{#filter.wayOfWorkingId}) IS NULL OR j.wayofworking.id IN (:#{#filter.wayOfWorkingId}))"
	        +" and ((:#{#filter.positionLevelId}) IS NULL OR j.positionLevel.id IN (:#{#filter.positionLevelId}))"
	        +" and ((:#{#filter.educationLevelId}) IS NULL OR j.educationLevel.id IN (:#{#filter.educationLevelId}))"
	        +" and j.isActive=true")
	List<JobAdvertisement> getByFilteredAdverts(@Param("filter") JobAdvertFilterDto jobAdvertFilterDto, Pageable pageable);

}
