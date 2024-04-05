package us.hyperio.restlearning.pojo.database;

public record VMHost(
   int id,
   String Hostname,
  int BuildStatusId,
  int ServerStatusId
){
    public VMHost(){
        this(-1,"",-1,-1);
    }
}
