import java.util.*;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0, right = Math.min(tasks.length, workers.length), answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int k) {
        Deque<Integer> taskQueue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            taskQueue.addLast(tasks[i]);  // k easiest tasks
        }

        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - k; i < workers.length; i++) {
            workerMap.put(workers[i], workerMap.getOrDefault(workers[i], 0) + 1);
        }

        int remainingPills = pills;

        while (!taskQueue.isEmpty()) {
            int task = taskQueue.pollLast(); // hardest task left

            Integer directWorker = workerMap.ceilingKey(task);
            if (directWorker != null) {
                decrement(workerMap, directWorker);
                continue;
            }

            if (remainingPills == 0) return false;

            Integer pillWorker = workerMap.ceilingKey(task - strength);
            if (pillWorker == null) return false;

            decrement(workerMap, pillWorker);
            remainingPills--;
        }

        return true;
    }

    private void decrement(TreeMap<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }
}
