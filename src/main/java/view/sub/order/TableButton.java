/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub.order;

import entities.Table;
import entities.TableStatus;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import util.ImageUtils;
import util.URL_Factory;


/**
 *
 * @author Admin
 */
public class TableButton extends JButton {

    private final Table table;
    private final Font font = new Font("Tahoma", 1, 29);


    public TableButton() {
        table = new Table();
        setButton();

    }

    public TableButton(Table table) {
        this.table = table;
        setButton();
    }

    private void setButton() {
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setText(table.getName());
        this.setFocusPainted(false);
        this.setFont(font);
        this.setForeground(new Color(223, 240, 254));
        this.setActionCommand("");
        this.setPreferredSize(new Dimension(150, 150));
        this.setBorderPainted(false);
        
    }

    public void setColor() {

        this.setBackground(new Color(170, 207, 207));
        if (table.getStatus().getId() == TableStatus.EMPTY) {//empty 
            this.setForeground(new Color(223, 240, 254));
            this.setIcon(ImageUtils.loadImage(URL_Factory.IMAGE_FOLDER_URL + "\\empty.png"));

        }
        if (table.getStatus().getId() == TableStatus.FULL) {//Full
            this.setForeground(new Color(223, 240, 254));
            this.setIcon(ImageUtils.loadImage(URL_Factory.IMAGE_FOLDER_URL + "\\full.png"));

        }
        if (table.getStatus().getId() == TableStatus.ORDERED) {//Ordered '
            
            this.setForeground(new Color(74, 72, 231));
            this.setIcon(ImageUtils.loadImage(URL_Factory.IMAGE_FOLDER_URL + "\\ordered.png"));


        }
    }
    
    public void setColorEnter() {
        
        this.setBackground(new Color(103, 155, 155));

    }

    public Table getTable() {
        return this.table;
    }
}
