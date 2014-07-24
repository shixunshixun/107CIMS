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
    @RunWith(SpringJUnit4ClassRunner.class) //SpringJUnit֧�֣��ɴ�����Spring��Test���֧�֡�  
    @Transactional //����ǳ��ؼ���������������ע�����ã�������ƾͻ���ȫʧЧ  
    //�������������������ļ��е����������(transactionManager = "transactionManager")��ͬʱָ���Զ��ع�(defaultRollback = true).  
    //���������������ݿ�Ų�����Ⱦ���ݿ⣡  
      
    @TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)  
    //AbstractTransactionalDataSourceSpringContextTestsҪ�빹����һϵ�е�����Ⱦ����ɫ������Կ�ܾͱ����ҵ�������࣡  
    public abstract class AbstractTestCase extends  
        AbstractJUnit4SpringContextTests {  
  
}