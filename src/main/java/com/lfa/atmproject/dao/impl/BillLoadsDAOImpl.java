/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.atmproject.dao.impl;

import com.lfa.atmproject.dao.BillLoadsDAO;
import com.lfa.atmproject.entity.AtmLoads;
import com.lfa.atmproject.entity.Bill;
import com.lfa.atmproject.entity.BillLoads;
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
@Repository(value = "billLoadsDAO")
public class BillLoadsDAOImpl implements BillLoadsDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<BillLoads> getALL() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_bill_loads";
        return jdbcTemplate.query(sql, new BillLoadsMapper());
    }

    @Override
    public BillLoads getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_bill_loads WHERE loadbill_id=?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new BillLoadsMapper());
    }

    @Override
    public int insert(BillLoads c) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_bill_loads(loadbill_id, "
                + "load_id, bill_id, bill_total) VALUES (?,?,?,?) ";
        return jdbcTemplate.update(sql, new Object[]{c.getId(), 
            c.getAtmLoads().getId(), c.getBill().getId(), c.getTotal()
        });
    }

    @Override
    public int update(BillLoads c) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_bill_loads(loadbill_id=?, load_id=?, "
                + "bill_id=?, bill_total=? WHERE loadbill_id=? ";
        return jdbcTemplate.update(sql, new Object[]{c.getId(), 
            c.getAtmLoads().getId(), c.getBill().getId(), c.getTotal()
        });
    }

    @Override
    public int delete(BillLoads t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class BillLoadsMapper implements RowMapper<BillLoads> {

        @Override
        public BillLoads mapRow(ResultSet rs, int i) throws SQLException {
            BillLoads billLoads = new BillLoads();
            billLoads.setId(rs.getInt("loadbill_id"));
            billLoads.setAtmLoads(new AtmLoads(rs.getInt("load_id")));
            billLoads.setBill(new Bill(rs.getInt("bill_id")));
            billLoads.setTotal(rs.getInt("bill_total"));
            return billLoads;
        }

    }

}
