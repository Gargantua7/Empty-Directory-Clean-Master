package com.hanami.fileCleanMaster.gui;

import javax.swing.JLabel;

import java.awt.Font;
import java.io.File;

import javax.swing.JFileChooser;

@SuppressWarnings("serial")
public class fileChoose extends JFileChooser{

	private final File file;
	
	public fileChoose() {
		
		setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		showDialog(new JLabel(), "choose");
		setFont(new Font("serifa", Font.PLAIN, 16));
		file = getSelectedFile();
		
	}
	
	public File getFile() {
		return file;
	}
}
