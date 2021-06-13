package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CompanySector;

public interface CompanySectorDao extends JpaRepository<CompanySector, Integer> {

}
