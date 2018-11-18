package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice7;

import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class TasksStorageImpl implements TasksStorage {

    Queue<Task> taskQueue = new LinkedBlockingDeque<>();

    @Override
    public void add(Task task) {
        if (task == null) {
            throw new NullPointerException();
        }
        taskQueue.add(task);
    }

    @Override
    public Task get() {
        return taskQueue.poll();
    }

    @Override
    public int count() {
        return taskQueue.size();
    }
}
