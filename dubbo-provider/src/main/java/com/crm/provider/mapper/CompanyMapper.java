package com.crm.provider.mapper;

import com.crm.api.dto.CompanyDTO;
import com.crm.api.entity.Company;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * CompanyMapper
 *
 * @author linkt
 * @date 2021/02/20/15:49
 * @Description:
 */
public interface CompanyMapper  extends CrudRepository<Company, String> {

    List<Company> findAll();
    //@Query("{ 'companyName' : ?0 },fields="{ 'id' : 1, 'createTime' : 1}"")
        // 上例中结果Company对象中只会有companyName、createTime 和id 属性 ， 其他属性没有
    @Query("{ 'companyName' : ?0 }")
    List<Company> findByCompanyName(String companyName);

    void deleteById(String id);
    Company save(Company company);//更新和新增
    /*mongodb 语句，java实现请看 CustomerServiceImpl
    {
     "$lookup":{
        "from":"company",
                "localField":"companyName",
                "foreignField":"companyName",
                "as":"customer_detail"
            }
    },
   {
    "$match":{

           }
    }
  */
}
