class Array {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};

        int[] columnSum = new int[3];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                columnSum[j] += arr[i][j];
            }
        }

        System.out.println("Sum of columns:");
        for (int j = 0; j < columnSum.length; j++) {
            System.out.println("Column " + (j + 1) + ": " + columnSum[j]);
        }
    }
}