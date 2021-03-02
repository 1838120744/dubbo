package com.crm.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.Date;

/**
 * com.crm.api.entity
 *
 * @author linkt
 * @date 2021/02/20/14:28
 * @Description:
 */
@Data
public class Company implements Serializable {

    private static final long serialVersionUID = 6470195659775614518L;
    @MongoId
    private String id;
    //@JsonProperty("create_time")
    private Date createTime;
    private Date updateTime;
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
