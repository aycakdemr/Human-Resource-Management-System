package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SchoolJobSeeker;
import kodlamaio.hrms.entities.concretes.SocialMedia;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer>{
	List<SocialMedia> getByjobseeker_id(int id);
	
	SocialMedia getById(int id);
}
