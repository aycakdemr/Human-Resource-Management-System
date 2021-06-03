package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dto.ResumeDetailDto;

public interface ResumeService {
	DataResult<List<Resume>> getAll();
	Result add(Resume resume);
	DataResult<ResumeDetailDto> getResumeWithDetails(int id) ;
	//DataResult<List<Resume>> getByCandidate_CandidateId(int candidateId);
}
