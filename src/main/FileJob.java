package main;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;

import javax.swing.JFileChooser;

public class FileJob {

	public File Open() {
		JFileChooser fileopen = new JFileChooser();
		fileopen.setCurrentDirectory(new File("."));
		int ret = fileopen.showDialog(null, "Open File");
		if (ret == JFileChooser.APPROVE_OPTION) {
			return fileopen.getSelectedFile();
		}
		return null;
	}

	public File Save() {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("."));
		if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		}
		return null;
	}

	public void applyFileAction(RegularAction regularAction) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(Open()));
			FileWriter fw = new FileWriter(Save(), true);
			String str = null;
			while ((str = br.readLine()) != null) {
				fw.write(regularAction.getResult(str) + "\r\n");
			}
			fw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
