package us.hyperio.restlearning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "file:${REST_CONFIG_PATH}/config.yaml")
public class RestApiConfig {

    private Logger logger =  LoggerFactory.getLogger(RestApiConfig.class);

    @Value("${hostingdb.dbhost}")
    private String Dbhost;
    @Value("${hostingdb.dbname}")
    private String Dbname;
    @Value("${hostingdb.dbuser}")
    private String Dbuser;
    @Value("${hostingdb.dbpassword}")
    private String Dbpassword;

    private String urlFormat="jdbc:sqlserver://%s;databaseName=%s;encrypt=true;trustServerCertificate=true;";

    @Bean
    public DataSource dataSource() {

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = String.format(urlFormat, Dbhost, Dbname);

        logger.info(String.format("Entering getDataSource url:'%s' User:%s",url,Dbuser));

        dataSourceBuilder.url(url);
        dataSourceBuilder.username(Dbuser);
        dataSourceBuilder.password(Dbpassword);

        return dataSourceBuilder.build();

    }
}

