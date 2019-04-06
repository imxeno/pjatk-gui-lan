package pl.edu.pja.gui.lan.zadanie10;

public class StringTask {
    private final String txt;
    private String result = "";
    private final int count;
    private TaskState state;
    private Thread t;

    public StringTask(String txt, int count) {
        state = TaskState.CREATED;
        this.txt = txt;
        this.count = count;
    }

    public TaskState getState() {
        return state;
    }

    public boolean isDone() {
        return state == TaskState.READY || state == TaskState.ABORTED;
    }

    public String getResult() {
        return result;
    }

    public String getTxt() {
        return txt;
    }

    public void start() {
        state = TaskState.RUNNING;
        t = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                if (state == TaskState.ABORTED) return;
                for (int j = txt.length() - 1; j >= 0; j--) {
                    result = result + txt.charAt(j);
                }
            }
            state = TaskState.READY;
        });
        t.start();
    }

    public void abort() {
        state = TaskState.ABORTED;
    }
}
