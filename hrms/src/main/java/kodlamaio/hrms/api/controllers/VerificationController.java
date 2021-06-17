package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Verification;

@RestController
@RequestMapping("/api/verifications")
@CrossOrigin
public class VerificationController {
	private VerificationService verificationService;

	@Autowired
	public VerificationController(VerificationService verificationService) {
		super();
		this.verificationService = verificationService;
	}
	@GetMapping("/getall")
	public DataResult<List<Verification>> getAll(){
		return verificationService.getAll();
	}
	@PostMapping("/add")
    public Result add(@RequestBody Verification verification){
        return this.verificationService.add(verification);
    }
}
