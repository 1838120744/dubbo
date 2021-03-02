package com.crm.api.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = -7611888404656375158L;

    @MongoId
    private  String id;
    private String name;
    private  String tel;
}