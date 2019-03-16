package dk.souldriven.priority.entities;

import java.util.List;

public interface IEntryDAO {
	void readFile(List<Entry> list, String listName);
	void saveToFile(List<Entry> entries, String listName);
}
