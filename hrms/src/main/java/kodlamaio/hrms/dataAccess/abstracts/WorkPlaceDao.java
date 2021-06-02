package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkPlace;

public interface WorkPlaceDao extends JpaRepository<WorkPlace, Integer>{

}
