/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author PC
 */
public enum ProductOrderTableColumn {
    
    NAMEPRODUCT("Món"),
    AMOUNT("Số Lượng"),
    SUM("Thành tiền");
    
    private final String value;

    ProductOrderTableColumn(String value) {
        this.value = value;
    }
    
    public String getText(){
        return this.value;
    }
    
}
