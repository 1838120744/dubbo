package com.crm.api.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.Date;

/**
 * Customer
 *
 * @author linkt
 * @date 2021/02/20/14:28
 * @Description:
 */
@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 4390477357070979783L;
    @MongoId
    private String id;
    private Date createTime;
    private Date updateTime;
    private String name;
    private  String tel;
}
