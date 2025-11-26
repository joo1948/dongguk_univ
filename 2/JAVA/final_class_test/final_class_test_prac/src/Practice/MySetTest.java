package week11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MySetTest {

    public static void main(String[] args) {
        Set<String> mySet = new MySetImpl<>();
        MySetTest test = new MySetTest(mySet);
        test.test();
    }

    private static final Random random = new Random();
    private final Set<String> set;

    public MySetTest(Set<String> set) {
        this.set = set;
    }

    public void test() {
        testAddAndNoDuplicate();
        testRemove();
        testContains();
        testAddAllAndSetProperties();
        testRemoveAllAndRetainAll();
    }

    private void testAddAndNoDuplicate() {
        set.clear();
        runTest("add(value) - 중복 불허 테스트", () -> {
            Set<String> expect = new HashSet<>();
            int SCALE = 5000;
            
            List<String> randomDataWithDuplicates = new ArrayList<>();
            for (int i = 0; i < SCALE; i++) {
                String value = String.valueOf(random.nextInt(1000));
                randomDataWithDuplicates.add(value);
            }
            
            int addSuccessCount = 0;
            for (String value : randomDataWithDuplicates) {
                expect.add(value); 
                
                if (set.add(value)) {
                    addSuccessCount++;
                }
            }

            if (set.size() != expect.size()) {
                throw new IllegalStateException("최종 크기 불일치. 예상 크기: " + expect.size() + ", 실제 크기: " + set.size());
            }
            
            if (addSuccessCount != expect.size()) {
                throw new IllegalStateException("add() 성공 횟수 불일치. 성공해야 할 횟수: " + expect.size() + ", 실제 성공 횟수: " + addSuccessCount);
            }

            if (!set.containsAll(expect)) {
                 throw new IllegalStateException("원소 포함 검증 실패. MySet에 있어야 할 원소가 누락됨.");
            }
        });
    }

    private void testRemove() {
        set.clear();
        Set<String> expect = new HashSet<>();
        int SCALE = 2000;
        
        runTest("remove(value) 및 크기 테스트", () -> {
            for(int i = 0; i<SCALE; i++) {
                String value = String.valueOf(i);
                expect.add(value);
                set.add(value);
            }

            int removeSuccessCount = 0;
            for(int i = 0; i < 1000; i++) {
                String targetValue = String.valueOf(random.nextInt(SCALE / 2)); 
                
                boolean expectRemoved = expect.remove(targetValue);
                boolean actualRemoved = set.remove(targetValue);
                
                if (expectRemoved != actualRemoved) {
                    throw new IllegalStateException("제거 결과 불일치. 값: " + targetValue);
                }
                if (actualRemoved) removeSuccessCount++;
            }
            
            if (set.size() != expect.size()) {
                 throw new IllegalStateException("제거 후 최종 크기 불일치. 예상 크기: " + expect.size() + ", 실제 크기: " + set.size());
            }

            if (set.remove("존재하지않는값")) {
                 throw new IllegalStateException("존재하지 않는 원소 제거 시 true 리턴 오류");
            }
        });
    }

    private void testContains() {
        set.clear();
        Set<String> expect = new HashSet<>();
        int SCALE = 2000;
        
        runTest("contains(value) 테스트", () -> {
            for(int i = 0; i<SCALE; i++) {
                expect.add(String.valueOf(i));
                set.add(String.valueOf(i));
            }

            for (int i = 0; i < 50; i++) {
                String existingValue = String.valueOf(random.nextInt(SCALE));
                if (!set.contains(existingValue)) {
                    throw new IllegalStateException("Contains 테스트 실패: 존재하는 값 (" + existingValue + ")을 찾지 못함");
                }
            }
            
            if (set.contains(String.valueOf(SCALE))) throw new IllegalStateException("Contains 테스트 실패: 존재하지 않는 값 (" + SCALE + ")을 찾음");
            if (set.contains("-1")) throw new IllegalStateException("Contains 테스트 실패: 존재하지 않는 값 (-1)을 찾음");
        });
    }
    
    private void testAddAllAndSetProperties() {
        set.clear();
        runTest("addAll(Collection) 및 containsAll(Collection) 테스트", () -> {
            Set<String> setA = new HashSet<>();
            Set<String> setB = new HashSet<>();
            Set<String> expectUnion = new HashSet<>();
            int SCALE = 1000;

            for (int i = 0; i < SCALE; i++) {
                String valA = "A" + random.nextInt(SCALE / 2);
                String valB = "B" + random.nextInt(SCALE);
                setA.add(valA);
                setB.add(valB);
                expectUnion.add(valA);
                expectUnion.add(valB);
            }

            set.addAll(setA);
            set.addAll(setB);

            if (set.size() != expectUnion.size()) {
                throw new IllegalStateException("addAll 후 크기 불일치. 예상 크기: " + expectUnion.size() + ", 실제 크기: " + set.size());
            }

            if (!set.containsAll(expectUnion)) {
                throw new IllegalStateException("containsAll 실패. 모든 원소를 포함해야 함.");
            }
            
            if (set.addAll(setA)) {
                 throw new IllegalStateException("중복 addAll 시 true 리턴 오류 (Set이 수정되지 않았어야 함).");
            }
        });
    }

    private void testRemoveAllAndRetainAll() {
        set.clear();
        runTest("removeAll(차집합) 및 retainAll(교집합) 테스트", () -> {
            Set<String> initialSet = new HashSet<>();
            Set<String> removeSet = new HashSet<>();
            Set<String> retainSet = new HashSet<>();
            int SCALE = 2000;

            for (int i = 0; i < SCALE; i++) {
                initialSet.add(String.valueOf(i));
                set.add(String.valueOf(i));
            }
            
            for (int i = 0; i < SCALE / 2; i++) {
                removeSet.add(String.valueOf(i));
            }
            
            for (int i = SCALE / 2; i < SCALE; i++) {
                retainSet.add(String.valueOf(i));
            }
            
            Set<String> expectDifference = new HashSet<>(initialSet);
            expectDifference.removeAll(removeSet);
            
            set.removeAll(removeSet); 

            if (set.size() != expectDifference.size() || !set.containsAll(expectDifference)) {
                throw new IllegalStateException("removeAll 실패. 예상 크기: " + expectDifference.size() + ", 실제 크기: " + set.size());
            }

            set.clear(); 
            set.addAll(initialSet);

            Set<String> expectIntersection = new HashSet<>(initialSet);
            expectIntersection.retainAll(retainSet);
            
            set.retainAll(retainSet); 
            
            if (set.size() != expectIntersection.size() || !set.containsAll(expectIntersection)) {
                throw new IllegalStateException("retainAll 실패. 예상 크기: " + expectIntersection.size() + ", 실제 크기: " + set.size());
            }
            
            if (!set.containsAll(retainSet)) {
                throw new IllegalStateException("retainAll 후 모든 원소가 포함되지 않음.");
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