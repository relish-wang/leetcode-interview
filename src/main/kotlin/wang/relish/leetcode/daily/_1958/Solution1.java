package wang.relish.leetcode.daily._1958;

/**
 * 作者：灵茶山艾府
 * 链接：https://leetcode.cn/problems/check-if-move-is-legal/solutions/2833477/jian-ji-xie-fa-pythonjavaccgojsrust-by-e-tpln/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution1 {
    private static final int[][] DIRS = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int m = board.length;
        int n = board[0].length;
        for (int[] dir : DIRS) {
            int x = rMove + dir[0];
            int y = cMove + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != (color ^ 'B' ^ 'W')) {
                continue;
            }
            while (true) {
                x += dir[0];
                y += dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == '.') {
                    break;
                }
                if (board[x][y] == color) {
                    return true;
                }
            }
        }
        return false;
    }
}