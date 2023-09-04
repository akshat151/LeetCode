public class LastHopMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {29, 8, 37},
                {15, 41, 3},
                {1, 10, 14}
        };

        System.out.println(lastHop(matrix));  // Expected output: 41
    }

    public static int lastHop(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = cols, top = 0, bottom = rows;
        boolean skip = false;  // Start with hopping, not skipping
        int lastVisited = matrix[0][0];

        while (left < right && top < bottom) {

            // Move top to bottom on leftmost column
            for (int i = top; i < bottom; i++) {
                if (!skip) {
                    lastVisited = matrix[i][left];
                }
                skip = !skip;
            }

            left++;

            // Move left to right on bottommost row
            for (int i = left; i < right; i++) {
                if (!skip) {
                    lastVisited = matrix[bottom - 1][i];
                }
                skip = !skip;
            }

            bottom--;

            if (left < right && top < bottom) {  // Check if there are rows/columns left to process

                // Move bottom to top on rightmost column
                for (int i = bottom - 1; i > top - 1; i--) {
                    if (!skip) {
                        lastVisited = matrix[i][right - 1];
                    }
                    skip = !skip;
                }

                right--;

                // Move right to left on topmost row
                for (int i = right - 1; i > left - 1; i--) {
                    if (!skip) {
                        lastVisited = matrix[top][i];
                    }
                    skip = !skip;
                }

                top++;
            }
        }

        return lastVisited;
    }
}