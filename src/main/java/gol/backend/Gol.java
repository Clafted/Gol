package gol.backend;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

public class Gol implements Serializable {
	
	public static final long serialVersionUID = 203984;
	public static int nextID = 0;
	
	private String name;
	private int id;
	private float targetCount;
	private Date startDate;
	private Date endDate = null;
	private HashMap<Date, Float> logs = new HashMap<Date, Float>();
	private float counter = 0.0f;
	
	public Gol(String name, float targetCount) {
		id = Gol.nextID++;
		this.name = name;
		this.targetCount = targetCount;
		startDate = Date.from(Instant.now());
	}
	
	public Gol(String name, float targetCount, Date startDate) {
		id = Gol.nextID++;
		this.name = name;
		this.targetCount = targetCount;
		this.startDate = startDate;
	}
	
	public Gol(String name, float targetCount, Date startDate, Date endDate) {
		this(name, targetCount, startDate);
		this.endDate = endDate;
	}
	
	public String toString() {
		return "Name: " + name
				+ "\nStart Date: " + startDate
				+ "\nEnd Date: " + endDate
				+ "\n\nProgress " + counter + " of " + targetCount;
	}
	
	public HashMap<Date, Float> getLogs() {
		return logs;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return id;
	}
	
	public float getCount() {
		return counter;
	}
	
	public float getTargetCount() {
		return targetCount;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public void increment(Date date, float value) {
		counter += value;
		logs.put(date, value);
	}
	
	public void delete(Date date) {
		logs.remove(date);
	}
}
