# dubbo
客户关系管理，可以查看修改公司具体信息和旗下对应的客户。技术栈 dubbo + zookeeper + spring data
dubbo-provider服务端，dubbo-api 存放公共接口，dubbo-consumer 调用远程服务。

company使用CrudRepository，Query  
CompanyMapper ——> service ——> serviceImpl -> controller  
customer使用MongoTemplate，没有mapper  
service ——> serviceImpl -> controller


