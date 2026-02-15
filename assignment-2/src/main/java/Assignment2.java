package swe619;

public class Assignment2 {

    /**
     * Precondition: a not null;
     *               b not null;
     *               There _is_ some index i such that a[i] == b[i] (guarantees i exists!)
     *
     * Postcondition: return the first index i at which a[i] == b[i]
     */
    public static int findDup(int[] a, int[] b) {
        int i = 0;
        while (a[i] != b[i]) {
            // since an index i is guaranteed to exist,
            // no need to check for bounds
            i++;
        }
        return i;
    }

    /**
     * Transform the preconditions into postconditions
     *
     * Precondition: true
     *
     * Postcondition: return the first index i at which a[i] == b[i].
     * Else, if (a is null) OR (b is null)
     *                      OR no index i exists such that a[i] == b[i]
     *       return -1
     */
    public static int findDup2(int[] a, int[] b) {
        if (a == null || b == null) {
            return -1;
        }
        int minLength = Math.min(a.length, b.length);
        for (int i = 0; i < minLength; i++) {
            if (a[i] == b[i]) {
                return i;
            }
        }
        return -1;
    }
}
