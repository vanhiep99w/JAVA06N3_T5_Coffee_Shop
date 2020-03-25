/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub.order;

import entities.Table;
import entities.TableStatus;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class TableButton extends JButton {

    private final Table table;
    private final Font font = new Font("Tahoma", 1, 30);

    ;

    public TableButton() {
        table = new Table();
        setButton();

    }

    public TableButton(Table table) {
        this.table = table;
        setButton();
    }

    private void setButton() {
        this.setText(table.getName());
        this.setFont(font);
        this.setActionCommand("");
        this.setBorderPainted(false);
        
    }

    public void setColor() {
        if (table.getStatus().getId() == TableStatus.EMPTY) {//empty
            this.setBackground(Color.white);
            this.setContentAreaFilled(false);
            this.setOpaque(true);
        }
        if (table.getStatus().getId() == TableStatus.FULL) {//Full
            this.setBackground(Color.cyan);
            this.setContentAreaFilled(false);
            this.setOpaque(true);
        }
        if (table.getStatus().getId() == TableStatus.ORDERED) {//Ordered 
            this.setBackground(Color.pink);
            this.setContentAreaFilled(false);
            this.setOpaque(true);
        }
    }
    
    public void setColorEnter() {
        if (table.getStatus().getId() == TableStatus.EMPTY) {//empty
            this.setBackground(Color.LIGHT_GRAY);
            this.setContentAreaFilled(false);
            this.setOpaque(true);
        }
        if (table.getStatus().getId() == TableStatus.FULL) {//Full
            this.setBackground(Color.BLUE);
            this.setContentAreaFilled(false);
            this.setOpaque(true);
        }
        if (table.getStatus().getId() == TableStatus.ORDERED) {//Ordered 
            this.setBackground(Color.red);
            this.setContentAreaFilled(false);
            this.setOpaque(true);
        }
    }

    public Table getTable() {
        return this.table;
    }
}
