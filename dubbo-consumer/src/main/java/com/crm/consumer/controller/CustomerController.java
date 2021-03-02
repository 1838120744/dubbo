package com.crm.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crm.api.dto.CustomerDTO;
import com.crm.api.dto.CustomerDetailDTO;
import com.crm.api.entity.Company;
import com.crm.api.entity.Customer;
import com.crm.api.service.ICompanyService;
import com.crm.api.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * CustomerController
 *
 * @author linkt
 * @date 2021/02/22/9:53
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Reference(version = "${demo.service.version}")
    private ICustomerService iCustomerService;

    @RequestMapping("/sayHello")
    public String sayHello(String name) {
        return iCustomerService.sayHello(name);
    }

    @RequestMapping("/list")
    public List<CustomerDTO> list() {
        return iCustomerService.list();
    }

    @RequestMapping("/drop")
    public String dropCollection() {
        return iCustomerService.dropCollection();
    }

    @RequestMapping("/insert")
    public void insert(@RequestBody CustomerDTO customerDTO) {
        iCustomerService.insert(customerDTO);
    }

    @RequestMapping("/find")
    List<Customer> findById(String id) {
        return iCustomerService.findById(id);
    }

    @RequestMapping("/update")
    void update(@RequestBody Customer customer) {
        iCustomerService.update(customer);
    }

    @RequestMapping("/delete")
    void delete(Collection<String> params) {//根据id集合删除
        iCustomerService.delete(params);
    }

    @RequestMapping("/join")
    private List<CustomerDetailDTO> twoTableQuery(@RequestParam String keyword,
                                                  @RequestParam int pageNum,@RequestParam int pageSize) {
        return iCustomerService.twoTableQuery(keyword,pageNum,pageSize);
    }
}
