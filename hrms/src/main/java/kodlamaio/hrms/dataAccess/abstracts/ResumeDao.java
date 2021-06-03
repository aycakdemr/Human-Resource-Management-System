package kodlamaio.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dto.ResumeDetailDto;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	 //List<Resume> getByjobSeeker_id(int id);
	 
	 @Query("Select new kodlamaio.hrms.entities.dto.ResumeDetailDto(j.id) "
	 		+ "From JobSeeker j Inner Join j.resumes r Where j.id=:id")
	 ResumeDetailDto getResumeDetails(int id);
	 
}

