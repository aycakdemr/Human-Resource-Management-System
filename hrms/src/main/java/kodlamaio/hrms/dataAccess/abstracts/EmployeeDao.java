package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employee;


public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	List<Employee> getByid(int id);
}
