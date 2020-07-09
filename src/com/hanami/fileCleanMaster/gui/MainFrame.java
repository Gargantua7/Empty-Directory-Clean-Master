package com.hanami.fileCleanMaster.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Gargantua丶
 **/
public class MainFrame extends JFrame{
    
    public static Bar bar = new Bar();
    
    public MainFrame() {
        setLayout(new BorderLayout());
        
        add(new CenterFrame(), BorderLayout.CENTER);
        add(bar, BorderLayout.SOUTH);
        
        setTitle("Empty File Clean Master / Power by HANAMI");
        setSize(450, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
