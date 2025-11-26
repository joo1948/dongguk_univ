package week11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyArrayListTest2 {

    public static void main(String[] args) {
        List<String> myList = new MyArrayList<>();
        MyArrayListTest2 test = new MyArrayListTest2(myList);
        test.test();
    }

    private static final Random random = new Random();
    private final List<String> list;

    public MyArrayListTest2(List<String> list) {
        this.list = list;
    }

    public void test() {
        testAdd();
        testRemove();
        testContains();
        testIndexOf();
        testSort();
    }

    private void testAdd() {
        runTest("add(value)", () -> {
            List<String> expect = new ArrayList<>();
            for (int i = 0; i < 50000; i++) expect.add(String.valueOf(random.nextDouble()));
            expect.forEach(list::add);
            for (int i = 0; i < expect.size(); i++) {
                boolean isMatch = expect.get(i).equals(list.get(i));
                if (!isMatch) throw new IllegalStateException("expect: " + expect.get(i) + ", actual: " + list.get(i));
            }
        });
        list.clear();
        runTest("add(index, value)", () -> {
            List<String> expect = new ArrayList<>();
            for (int i = 0; i < 50000; i++) {
                int targetIndex = (int) ((expect.size() + 1) * random.nextDouble());
                String value = String.valueOf(random.nextDouble());
                expect.add(targetIndex, value);
                list.add(targetIndex, value);
            }
            for (int i = 0; i < expect.size(); i++) {
                boolean isMatch = expect.get(i).equals(list.get(i));
                if (!isMatch) throw new IllegalStateException("expect: " + expect.get(i) + ", actual: " + list.get(i));
            }
        });
    }

    private void testRemove() {
        list.clear();
        List<String> expect = new ArrayList<>();
        runTest("remove(index)", ()->{
            for(int i = 0; i<1000; i++) {
                String value = String.valueOf(random.nextDouble());
                expect.add(value);
                list.add(value);
            }
            Object expectElement;
            int repeat = expect.size() / 2;
            for(int i = 0; i < repeat; i++) {
                int targetIndex = (int) (random.nextDouble() * list.size());
                expectElement = expect.remove(targetIndex);
                String actual = list.remove(targetIndex);
                if(!expectElement.equals(actual)) throw new IllegalStateException("원소 제거 테스트 실패");
            }

            // 첫 번째 원소 제거
            expectElement = expect.remove(0);
            if(!expectElement.equals(list.remove(0))) throw new IllegalStateException("첫 원소 제거 실패");

            // 마지막 원소 제거
            expectElement = expect.remove(expect.size()-1);
            if(!expectElement.equals(list.remove(list.size() - 1))) throw new IllegalStateException("마지막 원소 제거 실패");
        });
    }

    private void testContains() {
        list.clear();
        List<String> expect = new ArrayList<>();
        runTest("contains(Object o)", () -> {
            for (int i = 0; i < 2000; i++) {
                String value = String.valueOf(random.nextInt(500));
                expect.add(value);
                list.add(value);
            }

            for (int i = 0; i < 50; i++) {
                String existingValue = expect.get(random.nextInt(expect.size()));
                if (!list.contains(existingValue)) {
                    throw new IllegalStateException("Contains 테스트 실패: 존재하는 값 (" + existingValue + ")을 찾지 못함");
                }
            }

            if (list.contains("-1")) throw new IllegalStateException("Contains 테스트 실패: 존재하지 않는 값 (-1)을 찾음");
            if (list.contains("501")) throw new IllegalStateException("Contains 테스트 실패: 존재하지 않는 값 (501)을 찾음");

            String valueToRemove = expect.get(0);
            list.remove(0);
            expect.remove(0);

            if (!expect.contains(valueToRemove) && list.contains(valueToRemove)) {
                throw new IllegalStateException("Contains 테스트 실패: 제거 후에도 남아있다고 보고됨");
            }
        });
    }

    private void testIndexOf() {
        list.clear();
        List<String> expect = new ArrayList<>();
        final int SCALE = 2000;

        runTest("indexOf(Object o)", () -> {
            for (int i = 0; i < SCALE; i++) {
                String value = String.valueOf(random.nextInt(100));
                expect.add(value);
                list.add(value);
            }
            expect.add(null);
            list.add(null);

            for (int i = 0; i < 50; i++) {
                String targetValue = expect.get(random.nextInt(SCALE));
                int expectIndex = expect.indexOf(targetValue);
                int actualIndex = list.indexOf(targetValue);

                if (expectIndex != actualIndex) {
                    throw new IllegalStateException("indexOf 테스트 실패: 값 " + targetValue +
                            "의 예상 인덱스 " + expectIndex + ", 실제 인덱스 " + actualIndex);
                }
            }

            if (list.indexOf(null) != expect.indexOf(null)) {
                throw new IllegalStateException("indexOf 테스트 실패: null 인덱스 불일치");
            }

            if (list.indexOf("-1") != -1) {
                throw new IllegalStateException("indexOf 테스트 실패: 존재하지 않는 값의 인덱스가 -1이 아님");
            }
        });
    }

    private void testSort() {
        list.clear();
        List<String> expect = new ArrayList<>();
        runTest("sort(Comparator c)", () -> {
            for (int i = 0; i < 2000; i++) {
                String value = String.valueOf(random.nextInt(10000));
                expect.add(value);
                list.add(value);
            }

            expect.sort(String::compareTo);
            list.sort(String::compareTo);

            for (int i = 0; i < expect.size(); i++) {
                if (!expect.get(i).equals(list.get(i))) {
                    throw new IllegalStateException("오름차순 정렬 실패: 예상값 " + expect.get(i) + ", 실제값 " + list.get(i) + " (인덱스: " + i + ")");
                }
            }

            expect.sort((a, b) -> b.compareTo(a));
            list.sort((a, b) -> b.compareTo(a));

            for (int i = 0; i < expect.size(); i++) {
                if (!expect.get(i).equals(list.get(i))) {
                    throw new IllegalStateException("내림차순 정렬 실패: 예상값 " + expect.get(i) + ", 실제값 " + list.get(i) + " (인덱스: " + i + ")");
                }
            }
        });
    }

    private boolean runTest(String testName, Runnable action) {
        System.out.println("=".repeat(80));
        System.out.println(testName + " 테스트 시작");
        try {
            action.run();
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println(testName + " 테스트 실패: " + t.getMessage());
            return false;
        }
        System.out.println(testName + " 테스트 성공!");
        return true;
    }


}
