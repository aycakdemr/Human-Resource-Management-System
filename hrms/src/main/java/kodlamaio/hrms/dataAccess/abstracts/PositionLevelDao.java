package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.PositionLevel;

public interface PositionLevelDao extends JpaRepository<PositionLevel, Integer>{

}
