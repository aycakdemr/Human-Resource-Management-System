package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.LanguageJobSeeker;

public interface LanguageJobSeekerDao extends JpaRepository<LanguageJobSeeker, Integer>{

}
