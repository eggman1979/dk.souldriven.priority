package dk.souldriven.priority.entities;

import dk.souldriven.priority.program.SavedEntriesLoader;

import java.util.ArrayList;
import java.util.List;

public class PriorityList {

    IEntryDAO entrySaver;
    final private List<Entry> todoList = new ArrayList<>();
    final private List<Entry> doneList = new ArrayList<>();

    public PriorityList(IEntryDAO entryDAO) {
        this.entrySaver = entryDAO;
        entrySaver.readFile(todoList, "todo");
        entrySaver.readFile(doneList, "done");
    }

    public List<Entry> getTodoList() {
        return todoList;
    }

    public List<Entry> getDoneList() {
        return doneList;
    }

    public List<Runnable> observers = new ArrayList<>();



    public Entry createTodo(String name, String description, int estimatedTime, PriorityEnum priority, Entry parent) {
        Entry todo = new Entry(name, description, estimatedTime, priority);
        todo.setParentTask(parent);
        addTodoList(todo);
        entrySaver.saveToFile(todoList,"todo");
        return todo;
    }

    public void moveTodoToDone(Entry todo) {
        System.out.println("Before move; \nTodoList has " + todoList.size() + " entries\nDoneList has " + doneList.size() + " entries");
        todoList.remove(todo);
        addToDoneList(todo);
        entrySaver.saveToFile(todoList,"todo");
        entrySaver.saveToFile(doneList,"done");
        System.out.println("Before move; \nTodoList has " + todoList.size() + " entries\nDoneList has " + doneList.size() + " entries");
    }

    private void addToDoneList(Entry todo) {
        doneList.add(todo);
        entrySaver.saveToFile(doneList,"done");
        updateSubscribers();
    }

    public void moveDoneTodo(Entry done) {
        System.out.println("Before move; \nTodoList has " + todoList.size() + " entries\nDoneList has " + doneList.size() + " entries");
        doneList.remove(done);
        addTodoList(done);
        entrySaver.saveToFile(todoList,"todo");
        entrySaver.saveToFile(doneList,"done");
        System.out.println("Before move; \nTodoList has " + todoList.size() + " entries\nDoneList has " + doneList.size() + " entries");
    }

    public boolean deleteTodo(Entry todo) {
        for (Entry e : todoList) {
            if (e.getDependencies().contains(todo))
                return false;
        }
        todoList.remove(todo);
        entrySaver.saveToFile(todoList,"todo");
        return true;
    }

    public Entry getTodo(String name) {
        for (Entry e : todoList) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }

    public void addTodoList(Entry entry) {
        todoList.add(entry);
        entrySaver.saveToFile(todoList,"todo");
        updateSubscribers();
    }

    public void subscribe(Runnable runnable) {
        observers.add(runnable);
    }

    public void updateSubscribers() {
        System.out.println(observers.size() + " observers");
        for (Runnable observer : observers) {
            observer.run();
        }
    }
}
