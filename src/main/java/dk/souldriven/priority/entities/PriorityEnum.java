package dk.souldriven.priority.entities;

public enum PriorityEnum {
	CRITICAL("Critical", 100, 0),
	HIGH("High", 75, 1),
	NORMAL("Normal", 50, 2),
	LOW("Low", 25, 3);
	
	public int getIndex() {
		return index;
	}
	
	private final int index;
	
	PriorityEnum(String name, int ranking, int index) {
		this.name = name;
		this.ranking = ranking;
		this.index = index;
	}
	
	final private String name;
	final private int ranking;
	
	public String getName() {
		return name;
	}
	
	public int getRanking() {
		return ranking;
	}
}
