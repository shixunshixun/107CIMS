package cims107.test;

import org.junit.runner.RunWith;  
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.springframework.test.context.transaction.TransactionConfiguration;  
import org.springframework.transaction.annotation.Transactional;  
  

@SuppressWarnings("deprecation")  
@ContextConfiguration({"classpath:src/ApplicationContext*.xml"})  
    @RunWith(SpringJUnit4ClassRunner.class) //SpringJUnit支持，由此引入Spring—Test框架支持。  
    @Transactional //这个非常关键，如果不加入这个注解配置，事务控制就会完全失效  
    //这里的事务关联到配置文件中的事务控制器(transactionManager = "transactionManager")，同时指定自动回滚(defaultRollback = true).  
    //这样做操作的数据库才不会污染数据库！  
      
    @TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)  
    //AbstractTransactionalDataSourceSpringContextTests要想构建这一系列的无污染纯绿色事务测试框架就必须找到这个基类！  
    public abstract class AbstractTestCase extends  
        AbstractJUnit4SpringContextTests {  
  
}