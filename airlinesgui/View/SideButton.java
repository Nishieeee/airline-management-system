package com.mycompany.airlinesgui.View;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SideButton extends JPanel {
    
    private boolean selected;
    private String text;

    
    public SideButton(String text, String pic) {
        super(new FlowLayout(FlowLayout.LEFT, 10, 10));
        this.text = text;
        setMaximumSize(new Dimension(182, 50));
        setBackground(null);
        if (selected) setBackground(Constants.blue_dark);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ImageIcon image = new ImageIcon("pics/"+pic+".png");
        // To scale image to size: 20x20
        // You can add icon in pics folder with any size and it will be scaled
        ImageIcon scaledImage = new ImageIcon(image.getImage()
                .getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        add(new JLabel(scaledImage));
        
        // Changed text color to white
        add(new com.mycompany.airlinesgui.View.JLabel(text, 17, Constants.white, 1));
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (!selected) setBackground(Constants.blue);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!selected) setBackground(Constants.blue_hover);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
        });
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            setBackground(Constants.blue_dark);
        } else {
            setBackground(Constants.blue);
        }
    }
    
    public boolean isSelected() {
        return selected;
    }
    
    public String getText() {
        return text;
    }
}
