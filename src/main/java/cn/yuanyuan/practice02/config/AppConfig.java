package cn.yuanyuan.practice02.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("cn.yuanyuan.practice02")
@EnableTransactionManagement
public class AppConfig {

    private final static String MYSQL_DRIVER="com.mysql.jdbc.Driver";
    private final static String MYSQL_USERNAME="root";
    private final static String MYSQL_PASSWORD="yuanyuan";
    private final static String MYSQL_URL="jdbc:mysql:///mybatis_stu?useSSL=false&serverTimezone=UTC";
    @Bean
    public DataSource dataSource() throws Exception {
        Map<String,String> map=new HashMap<>(4);
        map.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME,MYSQL_DRIVER);
        map.put(DruidDataSourceFactory.PROP_USERNAME,MYSQL_USERNAME);
        map.put(DruidDataSourceFactory.PROP_PASSWORD,MYSQL_PASSWORD);
        map.put(DruidDataSourceFactory.PROP_URL,MYSQL_URL);
        return DruidDataSourceFactory.createDataSource(map);
    }

    @Bean@Autowired
    public TransactionManager transactionManager(DataSource dataSource){
        final DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Bean@Autowired
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        final JdbcTemplate template = new JdbcTemplate(dataSource);
        return template;
    }
}
