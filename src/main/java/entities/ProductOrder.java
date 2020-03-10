/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author PC
 */
public class ProductOrder {

    private String nameTable;
    private String nameProduct;
    private Integer amout;
    private Float sum;
    private Integer idOrder;

    public ProductOrder() {
    }

    public ProductOrder(String nameTable, String nameProduct, Integer amout, Float sum, Integer idOrder) {
        this.nameTable = nameTable;
        this.nameProduct = nameProduct;
        this.amout = amout;
        this.sum = sum;
        this.idOrder = idOrder;
    }

    public String getNameTable() {
        return nameTable;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Integer getAmout() {
        return amout;
    }

    public Float getSum() {
        return sum;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setAmout(Integer amout) {
        this.amout = amout;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public String toString() {
        return "ProductOrder{" + "nameTable=" + nameTable + ", nameProduct=" + nameProduct + ", amout=" + amout + ", sum=" + sum + ", idOrder=" + idOrder + '}';
    }

    
}
