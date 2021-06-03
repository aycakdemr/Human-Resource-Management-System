package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.SchoolJobSeeker;

public interface SchoolJobSeekerDao  extends JpaRepository<SchoolJobSeeker, Integer> {
	List<SchoolJobSeeker> getByjobSeeker_id(int id);
}
