/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.atmproject.dao.impl;

import com.lfa.atmproject.dao.AtmLoadsDAO;
import com.lfa.atmproject.entity.Atm;
import com.lfa.atmproject.entity.AtmLoads;
import com.lfa.atmproject.entity.Vendors;
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
@Repository(value = "atmLoadsDAO")
public class AtmLoadsDAOImpl implements AtmLoadsDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<AtmLoads> getALL() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_atm_loads";
        return jdbcTemplate.query(sql, new AtmLoadsMapper());
    }

    @Override
    public AtmLoads getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_atm_loads WHERE load_id=?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new AtmLoadsMapper());
    }

    @Override
    public int insert(AtmLoads a) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_atm_loads(atm_id, vendor_id, "
                + "deposited_amount) VALUES (?,?,?) ";
        return jdbcTemplate.update(sql, new Object[]{a.getAtm().getId(),
            a.getVendor().getId(),a.getAmount()
        });
    }

    @Override
    public int update(AtmLoads a) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_atm_loads atm_id=?, vendor_id=?, "
                + "deposited_amount=? WHERE load_id=? ";
        return jdbcTemplate.update(sql, new Object[]{a.getAtm().getId(),
            a.getVendor().getId(),a.getAmount()
        });
    }

    @Override
    public int delete(AtmLoads t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class AtmLoadsMapper implements RowMapper<AtmLoads> {

        @Override
        public AtmLoads mapRow(ResultSet rs, int i) throws SQLException {
            AtmLoads atmLoads = new AtmLoads();
            atmLoads.setId(rs.getInt("load_id"));
            atmLoads.setAtm(new Atm(rs.getInt("atm_id")));
            atmLoads.setAddedDate(rs.getDate("added_date"));
            atmLoads.setVendor(new Vendors(rs.getInt("vendor_id")));
            atmLoads.setAmount(rs.getInt("deposited_amount"));
            return atmLoads;
        }
    }
}
