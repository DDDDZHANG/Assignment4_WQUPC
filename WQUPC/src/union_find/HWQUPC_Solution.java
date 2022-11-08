package union_find;

import java.util.Random;

public class HWQUPC_Solution {
    public static void main(String[] args) {
        System.out.printf("%-15s %-20s %s\n", "n", "m(Average per run)", "0.37 * n * lg(n)");
        int[] sites = new int[]{1, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536};
        for (int n : sites) {
            System.out.printf("%-15s %-20s %s\n", n, getAverage(n, 1000), (int)(0.37 * n * (Math.log(n) / Math.log(2))));
        }
    }

    private static int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n, true);
        Random r = new Random();
        int connections = 0;
        while (uf.components() > 1) {
            int p = r.nextInt(n);
            int q = r.nextInt(n);
            uf.connect(p, q);
            connections++;
        }
        return connections;
    }

    private static int getAverage(int n, int runs) {
        int total = 0;
        for (int i = 0; i < runs; i++) {
            total += count(n);
        }
        return total / runs;
    }
}
