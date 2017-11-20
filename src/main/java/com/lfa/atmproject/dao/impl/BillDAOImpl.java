/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.atmproject.dao.impl;

import com.lfa.atmproject.dao.BillDAO;
import com.lfa.atmproject.entity.Bill;
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
@Repository(value = "billDAO")
public class BillDAOImpl implements BillDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Bill> getALL() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_bill";
        return jdbcTemplate.query(sql, new BillMapper());
    }

    @Override
    public Bill getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_bill WHERE bill_id=?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new BillMapper());
    }

    @Override
    public int insert(Bill b) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_bill(bill_id, bill_name)"
                + " VALUES (?,?) ";
        return jdbcTemplate.update(sql, new Object[]{b.getId(), b.getName()
        });
    }

    @Override
    public int update(Bill b) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_bill bill_name=? WHERE bill_id=?";
        return jdbcTemplate.update(sql, new Object[]{b.getName()
        });
    }

    @Override
    public int delete(Bill t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class BillMapper implements RowMapper<Bill> {

        @Override
        public Bill mapRow(ResultSet rs, int i) throws SQLException {
            Bill bill = new Bill();
            bill.setId(rs.getInt("bill_id"));
            bill.setName(rs.getInt("bill_name"));
            return bill;
        }

    }
}
