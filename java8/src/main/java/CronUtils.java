import java.util.*;

/**
 * @author haoxing_h
 */
public class CronUtils {
    public static final int LENGTH = 3600;
    private static int current = 0;
    private static List<Set<Task>> tasks = new ArrayList<>(LENGTH);
    static {
        for(int i=0;i<LENGTH;i++){
            tasks.add(Collections.synchronizedSet(new HashSet<>()));
        }
        run();
    }
    private static void currentMove() {
        if (++current == LENGTH) {
            current = 0;
        }
    }
    public static void addTask(Runnable function, int time) {
        int total = time + current;
        int cycleNum = total / LENGTH;
        int index = total % LENGTH;
        Task task = new Task(cycleNum, function);
        Set<Task> set = CronUtils.tasks.get(index);
        set.add(task);
    }

    private static void runTask() {
        Set<Task> set = tasks.get(current);
        Iterator<Task> iterator = set.iterator();
        while (iterator.hasNext()){
            Task task = iterator.next();
            if(task.cycleNum == 0){
                new Thread(task.getFunction()::run).start();
                iterator.remove();
            }else {
                task.setCycleNum(task.cycleNum-1);
            }
        }
    }


    private static void run() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runTask();
                currentMove();
            }
        }, 0, 1000);
    }


    private static class Task {
        private int cycleNum;
        private Runnable function;
        public Task(int cycleNum, Runnable function) {
            this.cycleNum = cycleNum;
            this.function = function;
        }

        public Runnable getFunction() {
            return function;
        }

        public void setFunction(Runnable function) {
            this.function = function;
        }

        public int getCycleNum() {
            return cycleNum;
        }

        public void setCycleNum(int cycleNum) {
            this.cycleNum = cycleNum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Task task = (Task) o;

            if (cycleNum != task.cycleNum) return false;
            return function != null ? function.equals(task.function) : task.function == null;
        }

        @Override
        public int hashCode() {
            int result = cycleNum;
            result = 31 * result + (function != null ? function.hashCode() : 0);
            return result;
        }
    }
}
