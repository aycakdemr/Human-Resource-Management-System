package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkPlaceJobSeeker;

public interface WorkPlaceJobSeekerDao extends JpaRepository<WorkPlaceJobSeeker, Integer>{

}
