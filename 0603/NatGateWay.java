public class NatGateWay implements GateWay {

    private int id;
    private Subnet subnet;

    @Override
    public void send() {

    }

    public NatGateWay(Subnet subnet) {
        this.subnet = subnet;
    }
}
