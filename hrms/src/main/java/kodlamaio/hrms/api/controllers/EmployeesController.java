package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll(){
		return employeeService.getAll();
	}
	@GetMapping("/getById")
	public DataResult<List<Employee>> getById(int id) {
		return employeeService.getById(id);
	}
	@PostMapping("/add")
	public Result add(@RequestBody Employee employee) {
		return employeeService.add(employee);
	}
	@PostMapping("/update")
	public Result update(@RequestBody Employee employee,@RequestParam int id) {
		return employeeService.update(employee,id);
	}
}

