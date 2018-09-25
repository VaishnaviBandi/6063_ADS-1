
/**.
 * Class for percolate.
 */
class Percolate {
    /**.
     * { var_description }
     */
    private boolean[][] grid;
    /**.
     * { var_description }
     */
    private WeightedQuickUnionUF obj;
    /**.
     * { var_description }
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      size  The size
     */
    Percolate(final int s) {
        this.size = s;
        grid = new boolean[s][s];
        obj = new WeightedQuickUnionUF(s * s + 2);
    }
    /**.
     * { function_description }
     *
     * @param      row     The row
     * @param      column  The column
     */
    public void open(final int row, final int column) {
        if (grid[row][column]) {
            return;
        }
        grid[row][column] = true;
if (row == 0) {
obj.union(convert(row, column), size * size);
        }
    if (row == size - 1) {
obj.union(convert(row, column), size * size + 1);
        }
if (row < size - 1 && grid[row + 1][column]) { //bottom element
obj.union(convert(row, column), convert(row + 1, column));
        }
if (row > 0 && grid[row - 1][column]) { //top element
obj.union(convert(row, column), convert(row - 1, column));
        }
if (column > 0 && grid[row][column - 1]) { //left element
obj.union(convert(row, column), convert(row, column - 1));
        }
if (column < size - 1 && grid[row][column + 1]) { //right element
obj.union(convert(row, column), convert(row, column + 1));
        }
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean ispercolate() {
        return obj.connected(size * size, size * size + 1);
    }
    /**.
     * { function_description }
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int convert(final int i, final int j) {
        return i * size + j;
    }
}
