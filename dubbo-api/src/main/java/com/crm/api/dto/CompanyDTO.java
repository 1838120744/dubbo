package com.crm.api.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;


@Data
public class CompanyDTO implements Serializable{

    private static final long serialVersionUID = -5259630916789279875L;
    @MongoId
    private  String id;
    private String companyName;
    private  String staffNum;
}
