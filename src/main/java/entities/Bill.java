/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public class Bill {

    private String idBill;
    private LocalDateTime billTime;
    private float vat;
    private float sum;
    private Integer idOrder;

    public Bill() {
    }

    public Bill(String idBill, LocalDateTime billTime, float vat, float sum, Integer idOrder) {
        this.idBill = idBill;
        this.billTime = billTime;
        this.vat = vat;
        this.sum = sum;
        this.idOrder = idOrder;
    }
    
    public Bill( LocalDateTime billTime, float vat, float sum, Integer idOrder) {
        this.billTime = billTime;
        this.vat = vat;
        this.sum = sum;
        this.idOrder = idOrder;
    }

    public String getIdBill() {
        return idBill;
    }

    public LocalDateTime getBillTime() {
        return billTime;
    }

    public float getVat() {
        return vat;
    }

    public float getSum() {
        return sum;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public void setBillTime(LocalDateTime billTime) {
        this.billTime = billTime;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

}
