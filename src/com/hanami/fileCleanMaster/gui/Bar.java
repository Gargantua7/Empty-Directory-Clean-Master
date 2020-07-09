package com.hanami.fileCleanMaster.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Gargantua丶
 **/
public class Bar extends JPanel {
    
    JLabel cleans, times, sta;
    
    public Bar() {
        cleans = new myLabel();
        times = new myLabel();
        sta = new myLabel();
        
        setLayout(new GridLayout(1, 3));
        add(sta);
        add(cleans);
        add(times);
        
        setBackground(Color.WHITE);
        
        refresh(false, 0, 0);
    }
    
    public void refresh(boolean stat, int clean, int time) {
        refreshS(stat);
        refreshC(clean);
        refreshT(time);
    }
    
    public void refreshS(boolean stat) {
        if (stat) sta.setText("Cleaning");
        else sta.setText("Ready!");
    }
    
    public void refreshC(int clean) {
        cleans.setText("cleaned: " + clean);
    }
    
    public void refreshT(int time) {
        times.setText("times: " + time);
    }
    
    
    
}

class myLabel extends JLabel {
    public myLabel() {
        setFont(new Font("serifa", Font.PLAIN, 16));
    }
}
