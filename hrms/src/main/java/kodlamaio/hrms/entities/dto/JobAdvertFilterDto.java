package kodlamaio.hrms.entities.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertFilterDto {

	private Integer jobPositionId;
	private Integer companySectorId;
	private Integer wayOfWorkingId;
	private Integer positionLevelId;
	private Integer educationLevelId;
	private Integer cityId;


}
