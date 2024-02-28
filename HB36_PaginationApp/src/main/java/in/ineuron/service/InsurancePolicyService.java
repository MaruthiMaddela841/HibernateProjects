package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.InsurancePolicyDto;

public interface InsurancePolicyService {
	
	public long fetchPageCount(int pageSize);
	public List<InsurancePolicyDto> fetchPageData(int pageSize, int pageNo);

}
