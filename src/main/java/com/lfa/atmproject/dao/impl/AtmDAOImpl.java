/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.atmproject.dao.impl;

import com.lfa.atmproject.dao.AtmDAO;
import com.lfa.atmproject.entity.Atm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prachin
 */
@Repository(value = "atmDAO")
public class AtmDAOImpl implements AtmDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Atm> getALL() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_atm";
        return jdbcTemplate.query(sql, new AtmMapper());
    }

    @Override
    public Atm getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_atm WHERE atm_id=?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new AtmMapper());
    }

    @Override
    public int insert(Atm a) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_atm(atm_serial_no, "
                + "atm_location, atm_longitude, atm_latitude) "
                + "VALUES (?,?,?,?) ";
        return jdbcTemplate.update(sql, new Object[]{a.getSerialNo(),
            a.getLocation(), a.getLongitude(), a.getLatitude()
        });
    }

    @Override
    public int update(Atm a) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_atm atm_serial_no=?, "
                + "atm_location=?, atm_longitude=?, atm_latitude=? "
                + "WHERE atm_id=?";
        return jdbcTemplate.update(sql, new Object[]{a.getSerialNo(),
            a.getLocation(), a.getLongitude(), a.getLatitude()
        });
    }

    @Override
    public int delete(Atm t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atm> getAtmDetails() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class AtmMapper implements RowMapper<Atm> {

        @Override
        public Atm mapRow(ResultSet rs, int i) throws SQLException {
            Atm atm = new Atm();
            atm.setId(rs.getInt("atm_id"));
            atm.setSerialNo(rs.getString("atm_serial_no"));
            atm.setLocation(rs.getString("atm_location"));
            atm.setLongitude(rs.getString("atm_longitude"));
            atm.setLatitude(rs.getString("atm_latitude"));
            return atm;
        }
    }
}
