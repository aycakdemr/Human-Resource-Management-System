package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WayOfWorking;

public interface WayOfWorkingDao extends JpaRepository<WayOfWorking, Integer>{

}
