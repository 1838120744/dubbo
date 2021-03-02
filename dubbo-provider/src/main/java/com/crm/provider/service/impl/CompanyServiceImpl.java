package com.crm.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.crm.api.entity.Company;
import com.crm.api.service.ICompanyService;
import com.crm.provider.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * com.crm.provider.service.impl
 *
 * @author linkt
 * @date 2021/02/20/15:32
 * @Description:
 */
@Service(version = "${demo.service.version}")

public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    public List<Company> findAll() {
        return companyMapper.findAll();
    }
    public List<Company> findByCompanyName(String companyName){
       return  companyMapper.findByCompanyName(companyName);
    }
    public void deleteById(String id){
         companyMapper.deleteById(id);
    }
    public void save(Company company){
         companyMapper.save(company);
    }

}
