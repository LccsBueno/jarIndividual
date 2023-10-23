import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import entities.*;
import oshi.SystemInfo;
import repositories.*;
import utils.Util;

import java.util.concurrent.TimeUnit;

public class Application {

    private final static ComputerRepository COMPUTER_REPOSITORY = new ComputerRepository(new ConnectionMySql());
    private final static CpuRepository CPU_REPOSITORY = new CpuRepository(new ConnectionMySql());
    private final static DiskRepository DISK_REPOSITORY = new DiskRepository(new ConnectionMySql());
    private final static NetworkRepository NETWORK_REPOSITORY = new NetworkRepository(new ConnectionMySql());
    private final static StatisticsRepository STATISTICS_REPOSITORY = new StatisticsRepository();

    private static Computer computer = new Computer(1);

    public static void main(String[] args) {
        Looca looca = new Looca();
        if(args.length > 0){
            if(args.length > 2){
                String SETUP = args[0];
                if(SETUP.toUpperCase().equals("SETUP")){
                    System.out.println("Entrou no setup()");
                    setup();
                }
                String USER_DATABASE = args[1];
                String PASSWORD_DATABASE = args[2];
                STATISTICS_REPOSITORY.setConnectionMySql(new ConnectionMySql("admin", "admin"));
            } else {
                String USER_DATABASE = args[0];
                String PASSWORD_DATABASE = args[1];
                STATISTICS_REPOSITORY.setConnectionMySql(new ConnectionMySql("admin", "admin"));
            }
        }
        Statistics statistics = new Statistics();
        System.out.println("Entrei nas statistics");
        Util.setInterval(() -> {
            System.out.println(looca.getSistema());
            System.out.println(looca.getProcessador());
            //statistics.setComputer(computer);
            //statistics.setTemperature(looca.getTemperatura().getTemperatura());
            //statistics.setCpuUsage(looca.getProcessador().getUso());
            //statistics.setRamUsage(looca.getMemoria().getEmUso().doubleValue());
            //statistics.setRamAvailable(looca.getMemoria().getDisponivel().doubleValue());
            //statistics.setRamTotal(looca.getMemoria().getTotal().doubleValue());
            //statistics.setDiskTotal(looca.getGrupoDeDiscos().getTamanhoTotal().doubleValue());
            //statistics.setDiskUsage(looca.getGrupoDeDiscos().getTamanhoTotal().doubleValue());

            STATISTICS_REPOSITORY.save(statistics);
        }, 2, TimeUnit.SECONDS);
    }

    // ATENÇÃO: rode esse método apenas uma vez na main
    public static void setup(){
        System.out.println("Ta chegando no setup do looca");
        Looca looca = new Looca();
        Computer computer = new Computer();
        Cpu cpu = new Cpu(looca.getProcessador().getId(), (looca.getProcessador().getNome()));
        Disk disk = new Disk();
        for (Disco d : looca.getGrupoDeDiscos().getDiscos()){
            disk.setModel(d.getModelo());
            disk.setId(d.getSerial());
        }
        computer.setHostname(looca.getRede().getParametros().getHostName());
        computer.setSystemInfo(looca.getSistema().getSistemaOperacional());
        computer.setMaker(looca.getSistema().getFabricante());
        computer.setDisk(disk);
        computer.setCpu(cpu);

        DISK_REPOSITORY.save(disk);
        CPU_REPOSITORY.save(cpu);
        COMPUTER_REPOSITORY.save(computer);

        Application.computer = computer;
        Application.computer.setId(1);
        Network net = new Network(Application.computer, looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0));

        NETWORK_REPOSITORY.save(net);
    }
}
