package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.AbilityJobSeeker;

public interface AbilityJobSeekerDao extends JpaRepository<AbilityJobSeeker, Integer>{
	List<AbilityJobSeeker> getByjobSeeker_id(int id);
}
