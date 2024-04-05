package us.hyperio.restlearning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import us.hyperio.restlearning.database.ServersDataImpl;

import java.io.IOException;
import java.util.Properties;

public class YamlPropertySourceFactory implements PropertySourceFactory {
    private Logger logger =  LoggerFactory.getLogger(YamlPropertySourceFactory.class);
    @Override
    public org.springframework.core.env.PropertySource<?> createPropertySource (String name, EncodedResource
    encodedResource)
                throws IOException {

        logger.info(String.format("createPropertySource name:%s",name));

        logger.info(String.format("content %s",
            encodedResource.getContentAsString()));

        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(encodedResource.getResource());

        Properties properties = factory.getObject();

        return new PropertiesPropertySource(encodedResource.getResource().getFilename(), properties);
    }
}

