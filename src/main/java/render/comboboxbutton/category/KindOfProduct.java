/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render.comboboxbutton.category;

import javax.swing.ImageIcon;
import util.URL_Factory;

/**
 *
 * @author Admin
 */
public enum KindOfProduct {
    TATCA("Tất Cả"),DOUONG("Đồ Uống"),TRASUA("Trà Sữa"),BANHNGOT("Bánh Ngọt"),NUOCEP("Nước Ép"),SINHTO("Sinh Tố"),CAFFEE("CAFFEE");
    
    private final String sourcePath = URL_Factory.IMAGE_FOLDER_URL;
    
    private ImageIcon icon;
    private String text;

    private KindOfProduct(String text) {
        this.text = text;
    }
    
    public ImageIcon getIcon(){
        return util.ImageUtils.loadImage(sourcePath+"\\"+this.toString()+".png");
    }
    public String getText(){
        return this.text;
    }
}
