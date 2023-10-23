package repositories;

import entities.Disk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DiskRepository {

    private ConnectionMySql connectionMySql;

    public DiskRepository(ConnectionMySql connectionMySql){
        this.connectionMySql = connectionMySql;
    }

    public void save(Disk disk) {
        String command = """
            INSERT INTO tb_disk (id, model) VALUES (?, ?);
        """;

        Connection conn = connectionMySql.open();
        try (PreparedStatement st = conn.prepareStatement(command)) {
            st.setString(1, disk.getId());
            st.setString(2, disk.getModel());
            st.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionMySql.close(conn);
        }
    }
}
