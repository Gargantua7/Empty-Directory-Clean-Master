package com.hanami.fileCleanMaster.gui;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import com.hanami.fileCleanMaster.io.Clean;
import javafx.beans.property.adapter.JavaBeanLongProperty;
import javafx.scene.layout.BackgroundRepeat;

@SuppressWarnings("serial")
public class CenterFrame extends JPanel implements ActionListener{

	JTextField fileUrl;
	JButton choose, action;
	public static boolean ready = true;
	
	public CenterFrame() {
		
		fileUrl = new JTextField("Entry a Folder Path");
		fileUrl.setFont(new Font("serifa", Font.PLAIN, 16));
		
		choose = buttonInit("Choose a Folder Path");
		action = buttonInit("Start Clean !");
		
		setLayout(new GridLayout(3, 1));
		
		add(fileUrl);
		add(choose);
		add(action);
	}
	
	public JButton buttonInit(String s){
		
		JButton obj = new JButton(s);
		obj.setFont(new Font("serifa", Font.PLAIN, 16));
		obj.setBackground(Color.WHITE);
		obj.addActionListener(this);
		return obj;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == choose) {
			if(!fileUrl.getText().equals("")) {
				File file = new fileChoose().getFile();
				if(file != null)
					fileUrl.setText(file.toString());
			}
		}
		if(e.getSource() == action) {
			if(ready) {
				Clean clean = new Clean(fileUrl.getText());
				if (clean.exist()) {
					ready = false;
					new Thread(clean).start();
				} else {
					new MyDialog("Error : Directory Path Not Found");
				}
			}
			else {
				new MyDialog("Error : Cleaner not ready");
			}
		}
	}
}
