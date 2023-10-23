package repositories;

import entities.Statistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatisticsRepository {


    private ConnectionMySql connectionMySql;

    public StatisticsRepository(){
        connectionMySql = new ConnectionMySql();
    }

    public StatisticsRepository(ConnectionMySql connectionMySql){
        this.connectionMySql = connectionMySql;
    }

    public void save(Statistics statistics) {
        String command = """
            INSERT INTO tb_statistics (id_computer, temperature, cpu_usage, ram_usage, ram_available, ram_total, disk_total, disk_usage)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?);
        """;

        Connection conn = connectionMySql.open();
        try (PreparedStatement st = conn.prepareStatement(command)) {
            st.setInt(1, statistics.getComputer().getId());
            st.setDouble(2, statistics.getTemperature());
            st.setDouble(3, statistics.getCpuUsage());
            st.setDouble(4, statistics.getRamUsage());
            st.setDouble(5, statistics.getRamAvailable());
            st.setDouble(6, statistics.getRamTotal());
            st.setDouble(7, statistics.getDiskTotal());
            st.setDouble(8, statistics.getDiskUsage());
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionMySql.close(conn);
        }
    }

    public void setConnectionMySql(ConnectionMySql connectionMySql){
        this.connectionMySql = connectionMySql;
    }
}
