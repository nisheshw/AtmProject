/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.atmproject.dao.impl;

import com.lfa.atmproject.dao.VendorsDAO;
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
@Repository(value="vendorsDAO")
public class VendorsDAOImpl implements VendorsDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Vendors> getALL() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_vendors";
        return jdbcTemplate.query(sql, new VendorsMapper());
    }

    @Override
    public Vendors getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_vendors WHERE vendor_id=?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new VendorsMapper());
    }

    @Override
    public int insert(Vendors v) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_vendors(vendor_id, "
                + "vendor_name, contact_no) VALUES (?,?,?) ";
        return jdbcTemplate.update(sql, new Object[]{v.getId(), 
            v.getName(), v.getContactNo()
        });
    }

    @Override
    public int update(Vendors v) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_vendors vendor_name=?, "
                + "contact_no=? WHERE vendor_id=?";
        return jdbcTemplate.update(sql, new Object[]{v.getName(), 
            v.getContactNo()
        });
    }

    @Override
    public int delete(Vendors t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class VendorsMapper implements RowMapper<Vendors>{

        @Override
        public Vendors mapRow(ResultSet rs, int i) throws SQLException {
            Vendors vendors = new Vendors();
            vendors.setId(rs.getInt("vendor_id"));
            vendors.setName(rs.getString("vendor_name"));
            vendors.setName(rs.getString("contact_no"));
            return vendors;
        }
        
    }
    
}
