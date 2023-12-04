package model.dao;

import model.entity.Business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessDAO extends AbstractDAO<Business> {

    @Override
    public void create(Business entity) throws SQLException {
        String sql="INSERT INTO business(name,type,address,profit) VALUES(?,?,?,?)";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, entity.getName());
        pst.setString(2, entity.getType());
        pst.setString(3, entity.getAddress());
        pst.setFloat(4, entity.getProfit());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()){
            entity.setId(rs.getInt(1));
        }
        con.close();
    }

    @Override
    public Business read(int id) throws SQLException {
        String sql = "SELECT * FROM business WHERE id_business = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        Business b = null;
        if(rs.next()){
            b = new Business();
            b.setId(rs.getInt("id_business"));
            b.setName(rs.getString("name"));
            b.setType(rs.getString("type"));
            b.setAddress(rs.getString("address"));
            b.setProfit(rs.getFloat("profit"));
        }
        con.close();
        return b;
    }

    @Override
    public void update(Business entity) throws SQLException {
        String sql = "UPDATE * FROM business WHERE id_business = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,entity.getId());
        pst.setString(1, entity.getName());
        pst.setString(2, entity.getType());
        pst.setString(3, entity.getAddress());
        pst.setFloat(4, entity.getProfit());
        pst.executeUpdate();
        con.close();
    }

    @Override
    public void delete(Business entity) throws SQLException {
        String sql = "DELETE FROM business WHERE id_business = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, entity.getId() );
        pst.executeUpdate();
        con.close();
    }
}
