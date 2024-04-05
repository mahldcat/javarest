package us.hyperio.restlearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.hyperio.restlearning.database.ServersData;
import us.hyperio.restlearning.pojo.database.VMHost;
import java.util.List;

@RestController
@RequestMapping("servers")
public class ServersController {

    @Autowired
    private ServersData serversData;

    @GetMapping("")
    public List<VMHost> GetServers() throws Exception {
        return serversData.getServers();
    }

    @GetMapping("/{id}")
    public VMHost GetServer(@PathVariable int id) throws Exception {
        return serversData.getServer(id).orElseThrow();
    }
}
