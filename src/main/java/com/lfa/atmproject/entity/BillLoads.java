/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.atmproject.entity;

/**
 *
 * @author Prachin
 */
public class BillLoads {
    private int id, total;
    private AtmLoads atmLoads;
    private Bill bill;

    public BillLoads() {
    }

    public BillLoads(int id, int total, AtmLoads atmLoads, Bill bill) {
        this.id = id;
        this.total = total;
        this.atmLoads = atmLoads;
        this.bill = bill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public AtmLoads getAtmLoads() {
        return atmLoads;
    }

    public void setAtmLoads(AtmLoads atmLoads) {
        this.atmLoads = atmLoads;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    
}
