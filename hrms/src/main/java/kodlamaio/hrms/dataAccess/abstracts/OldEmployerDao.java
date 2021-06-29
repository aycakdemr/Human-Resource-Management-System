package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.OldEmployer;

public interface OldEmployerDao extends JpaRepository<OldEmployer, Integer>{
	OldEmployer getByEmployer_id(int id);
}
