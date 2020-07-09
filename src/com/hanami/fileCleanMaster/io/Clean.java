package com.hanami.fileCleanMaster.io;

import com.hanami.fileCleanMaster.gui.MyDialog;
import com.hanami.fileCleanMaster.gui.Refresh;
import com.hanami.fileCleanMaster.gui.CenterFrame;

import java.io.File;

public class Clean implements Runnable{

	File file;
	public int cleans = 0;
	
	public Clean(String path) {
		file = new File(path);
	}
	
	public boolean exist() {
		return file.exists();
	}
	
	public void run() {
		Refresh refresh = new Refresh(this);
		new Thread(refresh).start();
	    action();
		CenterFrame.ready = true;
		refresh.setControl(false);
		new MyDialog("Cleaned " + cleans + " Directory(s)");
	}
	
	public void action() {
		action(file);
	}
	
	public void action(File file) {
		File[] files = file.listFiles();
		if (files != null)
			for (File f : files)
				if (f.isDirectory())
					action(f);
		
		if (file.isDirectory() && file.delete())
			cleans++;
	}
}
