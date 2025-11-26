public class P5_5 {

    static class InvalidIndexException extends Exception {
        public InvalidIndexException(String message) {
            super(message);
        }
    }

    static class ArraySearcher {
        private int[] numbers;

        public ArraySearcher(int[] numbers) {
            this.numbers = numbers;
        }

        public int getValue(int index) throws InvalidIndexException {
            if (index < 0 || index >= numbers.length) {
                throw new InvalidIndexException("잘못된 인덱스");
            }
            return numbers[index];
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        ArraySearcher searcher = new ArraySearcher(arr);

        int[] testIndexes = {0, 2, 5, -1};

        for (int idx : testIndexes) {
            System.out.println("조회 시도 인덱스: " + idx);
            try {
                int value = searcher.getValue(idx);
                System.out.println("값: " + value);
            } catch (InvalidIndexException e) {
                System.out.println("인덱스 범위 오류");
            }
            System.out.println();
        }
    }
}
