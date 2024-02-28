package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import in.ineuron.dao.InsurancePolicyDao;
import in.ineuron.dao.InsurancePolicyDaoImpl;
import in.ineuron.dto.InsurancePolicyDto;
import in.ineuron.model.InsurancePolicy;

public class InsurancePolicyServiceImpl implements InsurancePolicyService {
	
	InsurancePolicyDao dao;
	
	public InsurancePolicyServiceImpl() {
		dao=new InsurancePolicyDaoImpl();
	}

	@Override
	public long fetchPageCount(int pageSize) {
		Long totalRecords=dao.getTotalReocordsCount();
		Long pagesCount=totalRecords/pageSize;
		if(totalRecords%pageSize!=0) {
			pagesCount++;
		}
		return pagesCount;
	}

	@Override
	public List<InsurancePolicyDto> fetchPageData(int pageSize, int pageNo) {
		int startPos=0;
		startPos=(pageNo*pageSize)-pageSize;
		List<InsurancePolicyDto> list=new ArrayList<InsurancePolicyDto>();
		List<InsurancePolicy> entities=dao.getPageData(pageSize, startPos);
		entities.forEach(entity->{
			InsurancePolicyDto dto=new InsurancePolicyDto();
			dto.setPolicyId(entity.getPolicyId());
			dto.setCompany(entity.getCompany());
			dto.setPolicyName(entity.getPolicyName());
			dto.setPolicyType(entity.getPolicyType());
			dto.setTenure(entity.getTenure());
			list.add(dto);
		});
		return list;
	}

}
