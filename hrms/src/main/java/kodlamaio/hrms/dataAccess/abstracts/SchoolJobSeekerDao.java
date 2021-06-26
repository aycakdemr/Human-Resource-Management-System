package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.LanguageJobSeeker;
import kodlamaio.hrms.entities.concretes.SchoolJobSeeker;
public interface SchoolJobSeekerDao  extends JpaRepository<SchoolJobSeeker, Integer> {
	List<SchoolJobSeeker> getByjobSeeker_id(int id);
	
	SchoolJobSeeker getById(int id);
	List<SchoolJobSeeker> getByjobSeeker_idOrderByDateOfGraduationAsc(int id);
	
}/* @Query("Select new kodlamaio.hrms.entities.dto.ResumeDetailDto(j.id) "
	 		+ "From JobSeeker j Inner Join j.resumes r Where j.id=:id")
	 ResumeDetailDto getResumeDetails(int id);
	 
	 *@Query("Select new kodlamaio.hrms.entities.dto.SchoolDetailDto(j.id)"
			+ "From JobSeeker j Inner Join j.schoolJobSeekers s Where j.id=:id"
			+ "ORDER BY s.dateOfGraduation DESC")*/
