/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;

/**
 *
 * @author Admin
 */
public class URL_Factory {
    
    
    public static final String CURRENT_PROJECT_URL = new File("").getAbsolutePath();
    
    public static final String CONFIG_FILE_URL = URL_Factory.CURRENT_PROJECT_URL + "\\other_file\\config.properties";
    
    public static final String IMAGE_FOLDER_URL = URL_Factory.CURRENT_PROJECT_URL + "\\images";
}
