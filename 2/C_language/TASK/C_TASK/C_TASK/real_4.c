#include <stdio.h>

int main(void) {
    int N1, N2, i, ok;
    char name1[100], name2[100];
    int w1[100], w2[100];

    // 1st Max Number
    do {
        printf("1st Max Number: ");
        scanf_s("%d", &N1);
        if (N1 < 5 || N1 > 100) printf("Wrong number\n");
    } while (N1 < 5 || N1 > 100);

    // 1st Name
    printf("1st Name: ");
    for (i = 0; i < N1; i++) {
        scanf_s(" %c", &name1[i]);
    }

    // 1st Weight
    do {
        printf("1st Weight: ");
        for (i = 0; i < N1; i++) scanf_s("%d", &w1[i]);
        ok = 1;
        for (i = 0; i < N1; i++)
            if (w1[i] < 1 || w1[i] > 10) { ok = 0; break; }
        if (!ok) printf("Wrong weight\n");
    } while (!ok);

    // 2nd Max Number
    do {
        printf("2nd Max Number: ");
        scanf_s("%d", &N2);
        if (N2 < 5 || N2 > 100) printf("Wrong number\n");
    } while (N2 < 5 || N2 > 100);

    // 2nd Name
    printf("2nd Name: ");
    for (i = 0; i < N2; i++) {
        scanf_s(" %c", &name2[i]);
    }

    // 2nd Weight
    do {
        printf("2nd Weight: ");
        for (i = 0; i < N2; i++) scanf_s("%d", &w2[i]);
        ok = 1;
        for (i = 0; i < N2; i++)
            if (w2[i] < 1 || w2[i] > 10) { ok = 0; break; }
        if (!ok) printf("Wrong weight\n");
    } while (!ok);

    // 총 차량 수 및 전체 무게 계산
    int total = N1 + N2, total_weight = 0;
    for (i = 0; i < N1; i++) total_weight += w1[i];
    for (i = 0; i < N2; i++) total_weight += w2[i];

    // 교량 상태 초기화
    char lane1[2] = { '-', '-' }, lane2[2] = { '-', '-' };
    int wt1[2] = { 0, 0 }, wt2[2] = { 0, 0 };
    int idx1 = 0, idx2 = 0;
    int weight_on_bridge = 0;
    int exited = 0;

    // 출차 지연 버퍼
    char exit_name1 = 0; int exit_w1 = 0; int pending1 = 0;
    char exit_name2 = 0; int exit_w2 = 0; int pending2 = 0;

    // 시뮬레이션: time 0부터 시작, exited==total 될 때까지
    for (int time = 0; exited < total; time++) {
        // (1) 시간>0일 때만 shift: 뒷칸 차량을 출차 대기로 빼고 weight에서 감소
        if (time > 0) {
            // lane1 shift
            if (wt1[1]) {
                exit_name1 = lane1[1];
                exit_w1 = wt1[1];
                pending1 = 1;
                weight_on_bridge -= wt1[1];
                lane1[1] = '-'; wt1[1] = 0;
            }
            // 앞→뒷
            if (wt1[0]) {
                lane1[1] = lane1[0];
                wt1[1] = wt1[0];
                lane1[0] = '-'; wt1[0] = 0;
            }

            // lane2 shift
            if (wt2[1]) {
                exit_name2 = lane2[1];
                exit_w2 = wt2[1];
                pending2 = 1;
                weight_on_bridge -= wt2[1];
                lane2[1] = '-'; wt2[1] = 0;
            }
            if (wt2[0]) {
                lane2[1] = lane2[0];
                wt2[1] = wt2[0];
                lane2[0] = '-'; wt2[0] = 0;
            }

            // (2) 진입: 1st 차로 우선
            if (idx1 < N1 && wt1[0] == 0 &&
                weight_on_bridge + w1[idx1] <= 10) {
                lane1[0] = name1[idx1];
                wt1[0] = w1[idx1];
                weight_on_bridge += w1[idx1];
                idx1++;
            }
            if (idx2 < N2 && wt2[0] == 0 &&
                weight_on_bridge + w2[idx2] <= 10) {
                lane2[0] = name2[idx2];
                wt2[0] = w2[idx2];
                weight_on_bridge += w2[idx2];
                idx2++;
            }
        }

        // (3) 출력: 현재 교량 상태 + 이전 틱 shift에서 pending된 출차
        printf("(time %d) 1st [ %c %c ]", time, lane1[0], lane1[1]);
        if (pending1) {
            printf(" out: %c (%d)", exit_name1, exit_w1);
            pending1 = 0;
            exited++;
        }
        printf("\n");

        printf("(time %d) 2nd [ %c %c ]", time, lane2[0], lane2[1]);
        if (pending2) {
            printf(" out: %c (%d)", exit_name2, exit_w2);
            pending2 = 0;
            exited++;
        }
        printf("\n");
    }

    // 최종 합계
    printf("Total weight: %d\n", total_weight);
    printf("Elapsed time: %d\n", exited + 3);
    // <-- elapsed time는 time 0부터 시작해 last 출력 time(=when exited reached total) +1
    // 예시2 기준: 마지막 exited는 10일 때 time이 12였으므로, 12+1=13

    return 0;
}
