package repositories;

import entities.Cpu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CpuRepository {

    private ConnectionMySql connectionMySql;

    public CpuRepository(ConnectionMySql connectionMySql){
        this.connectionMySql = connectionMySql;
    }

    public void save(Cpu cpu) {
        String command = """
            INSERT INTO tb_cpu (id, name) VALUES (?, ?);
        """;

        Connection conn = connectionMySql.open();
        try (PreparedStatement st = conn.prepareStatement(command)) {
            st.setString(1, cpu.getId());
            st.setString(2, cpu.getName());
            st.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionMySql.close(conn);
        }
    }
}
