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
public class BillToPrint {

    private String nameProduct;
    private Integer amountProduct;
    private Float sum;

    public BillToPrint() {
    }

    public BillToPrint(String nameProduct, Integer amountProduct, Float sum) {
        this.nameProduct = nameProduct;
        this.amountProduct = amountProduct;
        this.sum = sum;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Integer getAmountProduct() {
        return amountProduct;
    }

    public Float getSum() {
        return sum;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setAmountProduct(Integer amountProduct) {
        this.amountProduct = amountProduct;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "BillToPrint{" + "nameProduct=" + nameProduct + ", amountProduct=" + amountProduct + ", sum=" + sum + '}';
    }
    
    

}
