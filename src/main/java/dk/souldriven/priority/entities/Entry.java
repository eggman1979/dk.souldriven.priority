package dk.souldriven.priority.entities;

import java.util.ArrayList;
import java.util.List;

public class Entry {
	private String name;
	private String description;
	private int estimatedPriority;
	private int estimatedTime;
	private List<Entry> dependencies;
	private PriorityEnum priorityEnum;
	private boolean isClosed = false;
	private boolean isSubtask = false;
	
	public Entry(){			}
	
	public Entry(String name, String description, int estimatedTime, PriorityEnum priorityEnum){
		this.name = name;
		this.description = description;
		this.estimatedTime = estimatedTime;
		this.priorityEnum = priorityEnum;
		dependencies = new ArrayList<>();
		
		calculateEstimatedPriority();
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getEstimatedPriority() {
		return estimatedPriority;
	}
	
	public void setEstimatedPriority(int estimatedPriority) {
		this.estimatedPriority = estimatedPriority;
	}
	
	public int getEstimatedTime() {
		return estimatedTime;
	}
	
	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	
	public List<Entry> getDependencies() {
		return dependencies;
	}
	
	public void setDependencies(List<Entry> dependencies) {
		this.dependencies = dependencies;
	}
	
	public PriorityEnum getPriorityEnum() {
		return priorityEnum;
	}
	
	public void setPriorityEnum(PriorityEnum priorityEnum) {
		this.priorityEnum = priorityEnum;
	}
	
	private void calculateEstimatedPriority() {
	}
	
	public boolean getIsClosed() {
		return isClosed;
	}
	
	public void setIsClosed(boolean isDone){
		this.isClosed = isDone;
	}
	
	public void setIsSubtask(boolean isSubtask) {
		this.isSubtask = isSubtask;
	}
	
	public boolean isSubtask() {
		return isSubtask;
	}
}
