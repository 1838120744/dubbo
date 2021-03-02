package com.crm.api.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * CustomerDetailDTO
 *
 * @author linkt
 * @date 2021/02/24/0:07
 */
@Data
public class CustomerDetailDTO extends CustomerDTO {
    private String companyName;
    private String companyTrade;
    private String companySource;
    private String companyProperty;
    private String companyNotes;
    private String staffNum;
    private String postcode;
    private  String annualTurnover;
    private  Integer grade;
    private  String companyAddress;
    private  String companyTel;
}
