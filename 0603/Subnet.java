public class Subnet {

    private int id;
    private String region;
    private String ip;
    private RouteTable routeTable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public RouteTable getRouteTable() {
        return routeTable;
    }

    public void setRouteTable(RouteTable routeTable) {
        this.routeTable = routeTable;
    }

    public void transfer(String msg){

        System.out.println(msg);
    }

    public Subnet(int id, String ip, String region) {
        this.id = id;
        this.ip = ip;
        this.region = region;
    }
}
