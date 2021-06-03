package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.LanguageJobSeeker;

public interface LanguageJobSeekerDao extends JpaRepository<LanguageJobSeeker, Integer>{
	List<LanguageJobSeeker> getByjobseeker_id(int id);
}
