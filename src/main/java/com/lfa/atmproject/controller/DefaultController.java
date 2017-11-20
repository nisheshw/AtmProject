/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.atmproject.controller;

import com.lfa.atmproject.dao.AtmDAO;
import com.lfa.atmproject.dao.AtmLoadsDAO;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Prachin
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @Autowired
    AtmDAO atmDAO;
    
    @Autowired
    AtmLoadsDAO atmLoadsDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        try {
            model.addAttribute("atm", atmDAO.getALL());
            model.addAttribute("atmLoads", atmLoadsDAO.getALL());
        } catch (ClassNotFoundException | SQLException se) {
            System.out.println(se.getMessage());
        }
        return "index";
    }
}
