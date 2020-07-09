package com.hanami.fileCleanMaster.gui;

import com.hanami.fileCleanMaster.io.Clean;

/**
 * @author Gargantua丶
 **/
public class Refresh implements Runnable{
    
    Bar bar = MainFrame.bar;
    Clean clean;
    boolean control = true;
    
    public Refresh(Clean clean) {
        this.clean = clean;
    }
    
    @Override
    public void run() {
        int times = 0, i = 0;
        while(control) {
            bar.refresh(true, clean.cleans, times);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(++i == 9) {
                times++;
                i = 0;
            }
        }
        bar.refresh(false, clean.cleans, times);
    }
    
    public void setControl(boolean control) {
        this.control = control;
    }
}
