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
        for (int i = k - 1; i >= 0; i--) {
            taskQueue.addLast(tasks[i]);
        }

        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - k; i < workers.length; i++) {
            workerMap.put(workers[i], workerMap.getOrDefault(workers[i], 0) + 1);
        }

        int pillsLeft = pills;

        while (!taskQueue.isEmpty()) {
            int task = taskQueue.pollFirst();

            // Try to assign without pill
            Integer normalWorker = workerMap.ceilingKey(task);
            if (normalWorker != null) {
                removeWorker(workerMap, normalWorker);
                continue;
            }

            // Try to assign with pill
            if (pillsLeft == 0) return false;
            Integer pillWorker = workerMap.ceilingKey(task - strength);
            if (pillWorker == null) return false;

            removeWorker(workerMap, pillWorker);
            pillsLeft--;
        }

        return true;
    }

    private void removeWorker(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
}
