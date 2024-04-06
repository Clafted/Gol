package gol.backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Handles reading and writing data to the user system. 
 * @author noahm
 *
 */
public class DataManager {
	
	File rootFolder;
	File dataFolder;
	File dataFile;
	
	FileOutputStream fOS;
	ObjectOutputStream oOS;

	FileInputStream fIS;
	ObjectInputStream oIS;
	
	ArrayList<Gol> data;
	
	public DataManager() {
		rootFolder = new File("gol");
		dataFolder = new File(rootFolder.getAbsolutePath() + "/data");
		data = new ArrayList<Gol>();
		initializeAppDirectory();
		loadFiles();
		loadData();
	}
	
	private void initializeAppDirectory() {
		if (rootFolder.mkdirs()) {
			dataFolder.mkdirs();
		}
	}
	
	private void loadFiles() {
		dataFile = new File(dataFolder.getAbsolutePath() + "/logs.txt");
	}
	
	@SuppressWarnings("unchecked")
	private void loadData() {
		if(!dataFile.exists()) return;
		try {
			fIS = new FileInputStream(dataFile);
			oIS = new ObjectInputStream(fIS);
			data = (ArrayList<Gol>) oIS.readObject();
			Gol.nextID = data.get(data.size()-1).getID() + 1;
			oIS.close();
			fIS.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void saveData() {
		try {
			fOS = new FileOutputStream(new File(dataFolder.getAbsolutePath() + "/logs.txt"));
			oOS = new ObjectOutputStream(fOS);
			oOS.writeObject(data);
			oOS.close();
			fOS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addGol(Gol gol) {
		data.add(gol);
	}
	
	public ArrayList<Gol> getData() {
		return data;
	}
}
