package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice7;

import interfaces.task7.executor.Executor;
import interfaces.task7.executor.Task;
import interfaces.task7.executor.TasksStorage;

public class ExecutorImpl implements Executor {

    private static final int MAX = 5;
    private static final int TIME = 100;
    private TasksStorage tasksStorage;

    private boolean startFlag = false;
    private boolean stopFlag = false;

    @Override
    public void setStorage(TasksStorage tasksStorage) {
        if (tasksStorage == null) {
            throw new NullPointerException();
        }
        this.tasksStorage = tasksStorage;
    }

    @Override
    public TasksStorage getStorage() {
        return tasksStorage;
    }

    @Override
    public void start() {
        if (getStorage() == null) {
            throw new NullPointerException();
        }
        if (startFlag) {
            throw new IllegalStateException();
        }
        startFlag = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stopFlag) {
                    Task task = tasksStorage.get();
                    if (task != null) {
                        task.incTryCount();
                        try {
                            if (!task.execute()) {
                                rollback(task);
                            }
                            System.out.println("executor " + Thread
                                    .currentThread().getName());
                        } catch (Exception e) {
                            rollback(task);
                        }
                    }
                    try {
                        System.out.println("sleep..." + Thread
                                .currentThread().getName());
                        Thread.sleep(TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void rollback(Task task) {
        if (task.getTryCount() <= MAX) {
            tasksStorage.add(task);
            System.out.println("rollBack " + Thread.currentThread().getName());
        }
    }

    @Override
    public void stop() {
        if (!startFlag) {
            throw new IllegalStateException();
        }
        stopFlag = true;
        startFlag = false;
    }
}
