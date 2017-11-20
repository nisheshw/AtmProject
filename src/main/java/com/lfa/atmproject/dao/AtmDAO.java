/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.atmproject.dao;

import com.lfa.atmproject.entity.Atm;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Prachin
 */
public interface AtmDAO extends GenericDAO<Atm> {
    List<Atm> getAtmDetails() throws ClassNotFoundException, SQLException; 
}
