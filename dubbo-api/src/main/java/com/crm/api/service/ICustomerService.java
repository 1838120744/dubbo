package com.crm.api.service;

import com.crm.api.dto.CustomerDTO;
import com.crm.api.dto.CustomerDetailDTO;
import com.crm.api.entity.Customer;

import java.util.Collection;
import java.util.List;

public interface ICustomerService {

     String sayHello(String name);
     List<CustomerDTO> list();
     String dropCollection();
     void insert(CustomerDTO customerDTO);
     List<Customer> findById(String id) ;
     void update(Customer customer) ;
     void delete(Collection<String> params);
     List<CustomerDetailDTO> twoTableQuery(String keyword, int pageNum, int pageSize);

 }
