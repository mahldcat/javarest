package us.hyperio.restlearning.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import us.hyperio.restlearning.pojo.database.VMHost;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Service
@Repository
public class ServersDataImpl implements ServersData {

    private Logger logger =  LoggerFactory.getLogger(ServersDataImpl.class);
    private JdbcTemplate _jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate getJdbcTemplate(){
        if(_jdbcTemplate==null){
            _jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return _jdbcTemplate;
    }

    public List<VMHost> getServers() throws Exception {
        String sql = "SELECT * FROM Server";
        logger.info("Entering GetServers");
        return getJdbcTemplate().query(sql,
                BeanPropertyRowMapper.newInstance(VMHost.class));
    }

    public Optional<VMHost> getServer(int id) throws Exception{
        String sql = "SELECT * FROM Server where id= ?";
        logger.info("Entering GetServer");

        return getJdbcTemplate().query(sql,
                new Object[] {id},
                BeanPropertyRowMapper.newInstance(VMHost.class)
                ).stream().findFirst();


    }
}
