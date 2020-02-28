/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class ImageUtils {

    private ImageUtils() {}
    
    public static ImageIcon loadImage(String path){
        if(path == null ||  path.isEmpty()){
            return null;
        }
        ImageIcon imageIcone = new ImageIcon(path);
        return imageIcone;
    }
    public static Image loadImage(String path,int width,int height){
        if(path == null ||  path.isEmpty()){
            return null;
        }
        return loadImage(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    
}
