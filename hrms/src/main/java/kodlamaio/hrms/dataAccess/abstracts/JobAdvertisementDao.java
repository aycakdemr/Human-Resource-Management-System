package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;



public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByisActive(boolean status);
	
	List<JobAdvertisement> getById(int id);

	List<JobAdvertisement> getByIsActiveAndEmployer_CompanyName(boolean IsActive,String companyName);
	

}
