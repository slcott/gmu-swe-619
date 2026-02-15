package com.teamsp26_1;


public class Assignment2 {
    public static void main(String[] args) {
        System.out.println(
                findDup(
                        new int[]{7, 13, 5},
                        new int[]{5, 13, 5}
                ) == 1);

        System.out.println(
                findDupTransformed(
                        new int[]{7, 13, 5},
                        new int[]{5, 13, 5}
                ) == 1);
    }

    /**
     * Return the first index i at which <code>a[i] == b[i]</code>
     * There is some index i such that <code>a[i] == b[i]</code>
     *
     * <p>
     * Precondition: a input array not null and
     *               b input array not null.
     *               There is some index i such that <code>a[i] == b[i]</code>.
     *
     * <p>
     * Postcondition: return the first index i at which <code>a[i] == b[i]</code>
     *
     * <p>
     * E.g. <code>findDup (new int[]{7, 13, 5}, new int[]{5, 13, 5})</code> = 1
     *
     * @param a input array not null
     * @param b input array not null
     * @return first index i such that <code>a[i] == b[i]</code>
     */
    public static int findDup(int[] a, int[] b) {
        int i = 0;
        while (a[i] != b[i]) i++;
        return i;
    }

    /**
     * Return the first index i at which <code>a[i] == b[i]</code> if it exists
     *
     * <p>
     * Precondition: True
     *
     * <p>
     * Postcondition: return the first index i at which <code>a[i] == b[i]</code> or -1 if it does not exist
     *
     * <p>
     * E.g. <code>findDup (new int[]{7, 13, 5}, new int[]{5, 13, 5})</code> = 1
     * <p>
     * E.g. <code>findDup (new int[]{200}, new int[]{5, 13, 5})</code> = -1
     * <p>
     * E.g. <code>findDup (new int[]{7, 13, 5}, null)</code> = -1
     *
     * @param a input array, nullable
     * @param b input array, nullable
     * @return first index i such that <code>a[i] == b[i]</code> or -1 if it does not exist
     */
    public static int findDupTransformed(int[] a, int[] b) {
        if (a == null || b == null) return -1;
        int i = 0;
        while (i < Math.min(a.length, b.length)) {
            if (a[i] == b[i]) return i;
            i++;
        }
        return -1;
    }
}