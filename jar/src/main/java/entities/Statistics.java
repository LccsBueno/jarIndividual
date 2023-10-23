package entities;

public class Statistics {

    private Computer computer;
    private Double temperature;
    private Double cpuUsage;
    private Double ramUsage;
    private Double ramAvailable;
    private Double ramTotal;
    private Double diskTotal;
    private Double diskUsage;

    public Statistics() {}

    public Statistics(Computer computer, Double temperature, Double cpuUsage, Double ramUsage, Double ramAvailable, Double ramTotal, Double diskTotal, Double diskUsage) {
        this.computer = computer;
        this.temperature = temperature;
        this.cpuUsage = cpuUsage;
        this.ramUsage = ramUsage;
        this.ramAvailable = ramAvailable;
        this.ramTotal = ramTotal;
        this.diskTotal = diskTotal;
        this.diskUsage = diskUsage;
    }


    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(Double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Double getRamUsage() {
        return ramUsage;
    }

    public void setRamUsage(Double ramUsage) {
        this.ramUsage = ramUsage;
    }

    public Double getRamAvailable() {
        return ramAvailable;
    }

    public void setRamAvailable(Double ramAvailable) {
        this.ramAvailable = ramAvailable;
    }

    public Double getRamTotal() {
        return ramTotal;
    }

    public void setRamTotal(Double ramTotal) {
        this.ramTotal = ramTotal;
    }

    public Double getDiskTotal() {
        return diskTotal;
    }

    public void setDiskTotal(Double diskTotal) {
        this.diskTotal = diskTotal;
    }

    public Double getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(Double diskUsage) {
        this.diskUsage = diskUsage;
    }
}
