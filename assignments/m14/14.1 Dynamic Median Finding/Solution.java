import java.util.Scanner;
/**DYNAMICMEDIANFIND.**/
final class Solution {
    /**
     * @brief [brief description]
     * @details [long description]
     */
    private Solution() { }
    /**
     * @param args value
     * Time complexity is O(N).
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Minpq<Float> min = new Minpq<Float>(n);
        Maxpq<Float> max = new Maxpq<Float>(n);
        float median = 0.0f;
        for (int i = 0; i < n; i++) {
            float f = Float.parseFloat(s.nextLine());
            if (f > median) {
                min.insert(f);
            } else {
                max.insert(f);
            }
            if (min.size() - max.size() > 1) {
                float f1 = min.delMin();
                max.insert(f1);
            }
            if (max.size() - min.size() > 1) {
                float f2 = max.delMax();
                min.insert(f2);
            }
            if (min.size() == max.size()) {
                median = (min.min() + max.max()) / 2;
                System.out.println(median);
            }
            if (min.size() > max.size()) {
                median = min.min();
                System.out.println(median);
            }
            if (max.size() > min.size()) {
                median = max.max();
                System.out.println(median);
            }
        }
    }
}
