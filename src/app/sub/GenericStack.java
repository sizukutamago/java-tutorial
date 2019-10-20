package app.sub;

import java.util.ArrayList;
import java.util.List;

public class GenericStack<T> {
    private List<T> taskList;

    public GenericStack() {
        taskList = new ArrayList<>();
    }

    public boolean push(T task) {
        return taskList.add(task);
    }

    public T pop() {
        if (taskList.isEmpty()) {
            return null;
        }

        return taskList.remove(taskList.size() - 1);
    }
}
