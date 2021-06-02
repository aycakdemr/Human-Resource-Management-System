package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.AbilityJobSeeker;

public interface AbilityJobSeekerDao extends JpaRepository<AbilityJobSeeker, Integer>{

}
