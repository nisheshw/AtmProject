/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.atmproject.entity;

import java.util.Date;

/**
 *
 * @author Prachin
 */
public class AtmLoads {

    private int id, amount;
    private Date addedDate;
    private Atm atm;
    private Vendors vendor;

    public AtmLoads() {
    }

    public AtmLoads(int id) {
        this.id=id;
    }

    public AtmLoads(int id, int amount, Atm atm, Vendors vendor) {
        this.id = id;
        this.amount = amount;
        this.atm = atm;
        this.vendor = vendor;
    }

    public int getId() {
        return id;
    }

    public void setVendor(Vendors vendor) {
        this.vendor = vendor;
    }

    public void setAtm(Atm atm) {
        this.atm = atm;
    }

    public Vendors getVendor() {
        return vendor;
    }

    public Atm getAtm() {
        return atm;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

}
