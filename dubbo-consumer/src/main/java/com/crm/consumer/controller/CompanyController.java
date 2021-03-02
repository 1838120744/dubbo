package com.crm.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crm.api.entity.Company;
import com.crm.api.service.ICompanyService;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * DemoConsumerController
 * 消费者控制层
 */

@RestController
@Slf4j
@RequestMapping("/company")
public class CompanyController {

    @Reference(version = "${demo.service.version}")
    private ICompanyService iCompanyService;

    @RequestMapping("/list")
    public String list(){
        return iCompanyService.findAll().toString();
    }
    @RequestMapping("/find")
    List<Company> findByCompanyName(@RequestParam String companyName){
      return  iCompanyService.findByCompanyName(companyName);
    }
    @RequestMapping("/delete")
    void deleteById(@RequestParam String id){
        iCompanyService.deleteById(id);
    }
    @RequestMapping("/save")
    void save(@RequestBody Company company){
        iCompanyService.save(company);
    }
}
