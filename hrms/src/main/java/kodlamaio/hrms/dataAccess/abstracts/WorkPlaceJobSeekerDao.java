package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.WorkPlaceJobSeeker;

public interface WorkPlaceJobSeekerDao extends JpaRepository<WorkPlaceJobSeeker, Integer>{
	List<WorkPlaceJobSeeker> getByjobseeker_id(int id);
}
