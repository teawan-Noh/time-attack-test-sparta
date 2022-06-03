import java.util.ArrayList;
import java.util.List;

public class RouteTable {
    private int id;
    private GateWay gateWay;
    private List<Subnet> subnets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GateWay getGateWay() {
        return gateWay;
    }

    public void setGateWay(GateWay gateWay) {
        this.gateWay = gateWay;
    }

    public void addSubnet(Subnet subnet){
        this.subnets.add(subnet);
    }

    public RouteTable() {
        subnets = new ArrayList<>();
    }
}
