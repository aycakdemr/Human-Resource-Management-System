package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LanguageLevel;

public interface LanguageLevelService {
	DataResult<List<LanguageLevel>> getAll();
	Result add(LanguageLevel languageLevel);
}
