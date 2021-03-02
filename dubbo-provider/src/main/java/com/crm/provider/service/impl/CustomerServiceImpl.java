package com.crm.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.crm.api.dto.CustomerDTO;
import com.crm.api.dto.CustomerDetailDTO;
import com.crm.api.entity.Customer;
import com.crm.api.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


@Service(version = "${demo.service.version}")
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private MongoTemplate mongoTemplate;

    // 设置集合名称
    private final static String COLLECTION_NAME = "customer";

    public String sayHello(String name) {

        return "Hello, " + mongoTemplate.getDb()+name + "(from Spring Boot)";
    }
    public List<CustomerDTO> list() {
        List<CustomerDTO> list =  mongoTemplate.findAll(CustomerDTO.class);
        return list;
    }
    public String dropCollection() {
        // 执行删除集合
        mongoTemplate.getCollection(COLLECTION_NAME).drop();
        // 检测新的集合是否存在，返回删除结果
        return !mongoTemplate.collectionExists(COLLECTION_NAME) ? "删除集合成功" : "删除集合失败";
    }
    public void insert(CustomerDTO customerDTO) {
        mongoTemplate.insert(customerDTO);
    }
    public List<Customer> findById(String id){
        List<Customer> result = mongoTemplate.find(new Query(Criteria.where("id").is(id)), Customer.class);
        return result;
    }
    public void update(Customer customer) {
        Query query = new Query(Criteria.where("id").is(customer.getId()));

        Update update = new Update();
        update.set("id", customer.getId());
        update.set("name", customer.getName());
        update.set("tel", customer.getTel());
        mongoTemplate.updateFirst(query, update, Customer.class);
    }
    public void delete(Collection<String> params) {
        mongoTemplate.remove(new Query(Criteria.where("id").in(params)), Customer.class);
    }
    // 一对一：两表关联查询
    public List<CustomerDetailDTO> twoTableQuery(String keyword, int pageNum, int pageSize) {
        // 构建 Aggregation：添加查询条件
        Aggregation aggregation = Aggregation.newAggregation(
                // 关联company表，每个客户都有对应的公司
                Aggregation.lookup(
                        "company",
                        "companyName",
                        "companyName",
                        "customerDetail"
                ),//三目
                null == keyword || "".equals(keyword.trim())
                        ?Aggregation.match(
                        // 公司等级5星，优质客户
                        Criteria.where("grade").is(5)
                        )
                        :
                        Aggregation.match(
                                // 根据顾客名称模糊搜索
                                //andOperator 可以再添加 Criteria
                                Criteria.where("name").regex(Pattern.compile(keyword, Pattern.CASE_INSENSITIVE))
                        ),
                // 分页：页码
                Aggregation.skip(Long.valueOf(pageNum)),
                // 分页：条数
                Aggregation.limit((long) pageSize),
                // 排序
                Aggregation.sort(Sort.Direction.DESC,"updateTime")
        );
        // 执行查询，这里的shop必须是查询的主表名
        AggregationResults<CustomerDetailDTO> results = mongoTemplate.aggregate(aggregation, "customer_detail", CustomerDetailDTO.class);
        return results.getMappedResults();
    }
}
