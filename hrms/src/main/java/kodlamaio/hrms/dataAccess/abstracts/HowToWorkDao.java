package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.HowToWork;

public interface HowToWorkDao extends JpaRepository<HowToWork, Integer>{

}
