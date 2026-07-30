public class FLOOD_FILL {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) {
            return image;
        }
        fill(image, sr, sc, originalColor, newColor);
        return image;
    }

    private void fill(int[][] image, int row, int col, int originalColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return;
        }
        if (image[row][col] != originalColor) {
            return;
        }

        image[row][col] = newColor;
        fill(image, row + 1, col, originalColor, newColor);
        fill(image, row - 1, col, originalColor, newColor);
        fill(image, row, col + 1, originalColor, newColor);
        fill(image, row, col - 1, originalColor, newColor);
    }

    public static void main(String[] args) {
        FLOOD_FILL solution = new FLOOD_FILL();
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] result = solution.floodFill(image, sr, sc, newColor);
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
