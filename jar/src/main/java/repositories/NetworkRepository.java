package repositories;

import entities.Network;
import entities.Statistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NetworkRepository {


    private ConnectionMySql connectionMySql;

    public NetworkRepository(){
        connectionMySql = new ConnectionMySql();
    }

    public NetworkRepository(ConnectionMySql connectionMySql){
        this.connectionMySql = connectionMySql;
    }

    public void save(Network network) {
        String command = """
            INSERT INTO tb_network (id_computer, name, mac_address, packages_received, packages_sent)
            VALUES (?, ?, ?, ?, ?);
        """;

        Connection conn = connectionMySql.open();
        try (PreparedStatement st = conn.prepareStatement(command)) {
            st.setInt(1, network.getComputer().getId());
            st.setString(2, network.getName());
            st.setString(3, network.getMacAddress());
            st.setInt(4, network.getPackagesReceived());
            st.setDouble(5, network.getPackagesSent());
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
