package entities;

import com.github.britooo.looca.api.group.rede.RedeInterface;

public class Network {

    private Integer id;
    private Computer computer;
    private String name;
    private String macAddress;
    private Integer packagesReceived;
    private Integer packagesSent;

    public Network (){
    }

    public Network(Computer computer, String name, String ipv4, String macAddress, Integer packagesReceived, Integer packagesSent) {
        this.computer = computer;
        this.name = name;
        this.macAddress = macAddress;
        this.packagesReceived = packagesReceived;
        this.packagesSent = packagesSent;
    }

    public Network(Computer computer, RedeInterface redeInterface) {
        this.computer = computer;
        this.name = redeInterface.getNome();
        this.macAddress = redeInterface.getEnderecoMac();
        this.packagesReceived = redeInterface.getPacotesRecebidos().intValue();
        this.packagesSent = redeInterface.getPacotesEnviados().intValue();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Integer getPackagesReceived() {
        return packagesReceived;
    }

    public void setPackagesReceived(Integer packagesReceived) {
        this.packagesReceived = packagesReceived;
    }

    public Integer getPackagesSent() {
        return packagesSent;
    }

    public void setPackagesSent(Integer packagesSent) {
        this.packagesSent = packagesSent;
    }
}
