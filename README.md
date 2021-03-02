# dubbo
客户关系管理，可以查看修改公司具体信息和旗下对应的客户。技术栈 dubbo + zookeeper + spring data  
dubbo-provider服务端，dubbo-api 存放公共接口，dubbo-consumer 调用远程服务。

company使用CrudRepository，Query  
CompanyMapper ——> service ——> serviceImpl -> controller  
customer使用MongoTemplate，直接写在serviceImpl里了
service ——> serviceImpl -> controller

![image](https://user-images.githubusercontent.com/72490439/109602347-eab5fb00-7b5a-11eb-9766-a9aa07c6d703.png)

![image](https://user-images.githubusercontent.com/72490439/109601937-bb06f300-7b5a-11eb-947e-aac7d162cc71.png)

![image](https://user-images.githubusercontent.com/72490439/109602633-729c0500-7b5b-11eb-8ecd-0b2e8cedaf9a.png)

![image](https://user-images.githubusercontent.com/72490439/109602688-8ba4b600-7b5b-11eb-8df1-1be73b0de684.png)






