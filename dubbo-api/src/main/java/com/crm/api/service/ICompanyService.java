package com.crm.api.service;

import com.crm.api.entity.Company;

import java.util.List;

/**
 * com.crm.api.service
 *
 * @author linkt
 * @date 2021/02/20/14:36
 * @Description:
 */
public interface ICompanyService {
    List<Company> findAll();
    List<Company> findByCompanyName(String companyName);
    void deleteById(String id);
    void save(Company company);//更新和新增
}
