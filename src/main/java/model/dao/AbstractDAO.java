package model.dao;
import model.entity.AbstractEntity;
import model.entity.Business;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO<E extends AbstractEntity> {
    protected String ConUrl = "jdbc:mysql://localhost";
    protected String Port = "3306";
    protected String Database = "test";
    protected String Username = "root";
    protected String Password = "isaacreborn1";

    public Connection getConnection() throws SQLException{
        String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                +"&password="+Password;
        Connection con = DriverManager.getConnection(url);
        return con;
    }

    public abstract void create(E entity) throws SQLException;

    public abstract void create(Business entity) throws SQLException;

    public abstract E read(int id) throws SQLException;
    public abstract void update(E entity) throws SQLException;

    public abstract void delete(E entity) throws SQLException;

}
