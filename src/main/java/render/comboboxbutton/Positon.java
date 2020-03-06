/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render.comboboxbutton;

import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public enum Positon {
    TATCA("Tất Cả"),LETAN("Lễ Tân"),ORDER("Order"),VESINH("Vệ Sinh"),BAOVE("Bảo Vệ"),PHACHE("Pha Chế");
    
    private final String sourcePath = new File("").getAbsolutePath()+"\\images";
    
    private ImageIcon icon;
    private String text;

    private Positon(String text) {
        this.text = text;
    }
    
    public ImageIcon getIcon(){
        return util.ImageUtils.loadImage(sourcePath+"\\"+this.toString()+".png");
    }
    public String getText(){
        return this.text;
    }
    
   
}
