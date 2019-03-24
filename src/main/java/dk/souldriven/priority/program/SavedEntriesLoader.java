package dk.souldriven.priority.program;

import dk.souldriven.priority.entities.Entry;
import dk.souldriven.priority.entities.IEntryDAO;
import dk.souldriven.priority.entities.PriorityEnum;
import dk.souldriven.priority.entities.PriorityList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SavedEntriesLoader implements IEntryDAO {
	

	List<String> entryStorage = new ArrayList<>();
	

	
	public void readFile(List<Entry> list, String listName) {
		String workingList = null;
		String file = null;
		if (listName.equals("todo")) {
			file = this.getClass().getResource("/data/saved_entries_todo").getFile();
		} else if (listName.equals("done")) {
			file = this.getClass().getResource("/data/saved_entries_done").getFile();
		}
		try {
			
			FileInputStream fileReader = new FileInputStream(new File(file));
			BufferedReader br = new BufferedReader(new InputStreamReader(fileReader));
			String line;
			
			while ((line = br.readLine()) != null ) {
				if (!line.startsWith("#")) {
					entryStorage.add(line);
					String[] entryString = line.split(",");
					Entry entry = new Entry(entryString[1], entryString[2], Integer.parseInt(entryString[3].trim()), PriorityEnum.valueOf(entryString[5].toUpperCase().trim()));
					entry.setEstimatedPriority(Integer.parseInt(entryString[3].trim()));
					String parentString = entryString[6];
					if (!parentString.equalsIgnoreCase("NULL")) {
						for (Entry possibleParent : list) {
							if (possibleParent.getName().equals(parentString)) {
								entry.setParentTask(possibleParent);
								possibleParent.getDependencies().add(entry);
								break;
							}
						}
					}
					entry.setIsClosed(listName != "todo");
					entry.setId(Integer.parseInt(entryString[0]));
					list.add(entry);
				}
			}
		} catch (IOException e) {
			System.out.println("Error loading file");
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("a line was not loaded");
		}
	}


	public void saveToFile(List<Entry> entries, String listName) {
		StringBuilder sb = new StringBuilder();

		String file = "";
		if (listName.equals("todo")) {
			file = this.getClass().getResource("/data/saved_entries_todo").getFile();
		} else if (listName.equals("done")) {
			file = this.getClass().getResource("/data/saved_entries_done").getFile();
		}
		else{
			return;
		}
		for (Entry entry : entries) {
			sb.append(entry.toString()+"\r\n");
		}
		
		FileOutputStream fileOut = null;
		try {

			fileOut = new FileOutputStream(file);
			fileOut.write(String.valueOf(sb).getBytes());
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
