package com.hanami.fileCleanMaster.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyDialog extends JDialog implements ActionListener{

	JButton jButton;
	
	public MyDialog(String s) {
		
		JLabel jLabel = new JLabel(s, JLabel.CENTER);
		jLabel.setFont(new Font("serifa", Font.PLAIN, 16));
		
		jButton = new JButton("OK");
		jButton.setFont(new Font("serifa", Font.PLAIN, 16));
		jButton.addActionListener(this);
		jButton.setBackground(Color.WHITE);
		
		setTitle("NOTICE");
		setLayout(new BorderLayout());
		add(jLabel, BorderLayout.CENTER);
		add(jButton, BorderLayout.SOUTH);
		setModal(true);
		setResizable(false);
		setSize(400, 160);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jButton)
			this.dispose();
	}
}
