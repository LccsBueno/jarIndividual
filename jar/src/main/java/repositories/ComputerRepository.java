package repositories;

import entities.Computer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComputerRepository {

    private ConnectionMySql connectionMySql;

    public ComputerRepository(ConnectionMySql connectionMySql){
        this.connectionMySql = connectionMySql;
    }

    public void save(Computer computer) {
        String command = """
            INSERT INTO tb_computers (hostname, maker, system_info, id_cpu, id_disk) VALUES (?, ?, ?, ?, ?);
        """;

        Connection conn = connectionMySql.open();
        try (PreparedStatement st = conn.prepareStatement(command)) {
            st.setString(1, computer.getHostname());
            st.setString(2, computer.getMaker());
            st.setString(3, computer.getSystemInfo());
            st.setString(4, computer.getCpu().getId());
            st.setString(5, computer.getDisk().getId());
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionMySql.close(conn);
        }
    }
}
