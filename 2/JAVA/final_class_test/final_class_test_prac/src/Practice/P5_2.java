package Practice;

class P5_2{

    interface Transformer<T, R> {
        R apply(T input);
    }

    static class Pipeline<A, B> {
        private Transformer<A, B> transform;

        public Pipeline(Transformer<A, B> transform) {
            this.transform = transform;
        }

        public B execute(A value) {
            return transform.apply(value);
        }
    }

    public static void main(String[] args) {
        Pipeline<String, Integer> stringToLength =
                new Pipeline<>(s -> s.length());

        Pipeline<Integer, Double> lengthToSquare =
                new Pipeline<>(n -> (double)(n * n));

        String[] testInputs = {"robot", "lambda", "generic"};

        for (String s : testInputs) {
            int length = stringToLength.execute(s);
            double square = lengthToSquare.execute(length);
            System.out.println("입력: " + s + " -> 길이: " + length + " -> 제곱: " + square);
        }
    }
}
