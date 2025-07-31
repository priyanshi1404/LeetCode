class Solution {
    public int[] closestPrimes(int left, int right) {
        // Step 1: Sieve of Eratosthenes to precompute all primes up to right
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Collect primes in the range [left, right]
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) primes.add(i);
        }

        // Step 3: Find closest pair
        int minDiff = Integer.MAX_VALUE;
        int[] result = {-1, -1};

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
            }
        }

        return result;
    }
}
