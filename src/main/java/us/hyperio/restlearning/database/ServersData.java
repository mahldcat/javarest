package us.hyperio.restlearning.database;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import us.hyperio.restlearning.pojo.database.VMHost;

import java.util.List;
import java.util.Optional;

public interface ServersData {
    public List<VMHost> getServers() throws Exception;
    public Optional<VMHost> getServer(int id) throws Exception;

}
