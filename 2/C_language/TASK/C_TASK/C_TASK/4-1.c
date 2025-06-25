#include <stdio.h>

int main(void) {
    int N1, N2;
    char name1[100], name2[100];
    int w1[100], w2[100];
    int i;

    // 1st Max Number 입력
    do {
        printf("1st Max Number: ");
        scanf_s("%d", &N1);
        if (N1 < 5 || N1 > 100) {
            printf("Wrong number\n");
        }
    } while (N1 < 5 || N1 > 100);

    // 1st Name 입력
    printf("1st Name: ");
    for (i = 0; i < N1; i++) {
        scanf_s(" %c", &name1[i]);
    }

    // 1st Weight 입력
    int ok;
    do {
        printf("1st Weight: ");
        for (i = 0; i < N1; i++) {
            scanf_s("%d", &w1[i]);
        }
        ok = 1;
        for (i = 0; i < N1; i++) {
            if (w1[i] < 1 || w1[i] > 10) {
                ok = 0;
                break;
            }
        }
        if (!ok) {
            printf("Wrong weight\n");
        }
    } while (!ok);

    // 2nd Max Number 입력
    do {
        printf("2nd Max Number: ");
        scanf_s("%d", &N2);
        if (N2 < 5 || N2 > 100) {
            printf("Wrong number\n");
        }
    } while (N2 < 5 || N2 > 100);

    // 2nd Name 입력
    printf("2nd Name: ");
    for (i = 0; i < N2; i++) {
        scanf_s(" %c", &name2[i]);
    }

    // 2nd Weight 입력
    do {
        printf("2nd Weight: ");
        for (i = 0; i < N2; i++) {
            scanf_s("%d", &w2[i]);
        }
        ok = 1;
        for (i = 0; i < N2; i++) {
            if (w2[i] < 1 || w2[i] > 10) {
                ok = 0;
                break;
            }
        }
        if (!ok) {
            printf("Wrong weight\n");
        }
    } while (!ok);

    // 총 차량 수와 총 무게 계산
    int total_vehicles = N1 + N2;
    int total_weight = 0;
    for (i = 0; i < N1; i++) total_weight += w1[i];
    for (i = 0; i < N2; i++) total_weight += w2[i];

    // 교량 시뮬레이션 준비
    char lane1_name[2] = { '-', '-' };
    char lane2_name[2] = { '-', '-' };
    int lane1_w[2] = { 0, 0 };
    int lane2_w[2] = { 0, 0 };
    int idx1 = 0, idx2 = 0;           // 다음 진입할 차량 인덱스
    int exited = 0;                  // 출차된 차량 수
    int weight_on_bridge = 0;        // 교량 위 현재 무게 합
    int time = 0;

    while (exited < total_vehicles) {
        // 1) 이동 및 출차 처리 (Lane 1)
        int exit_wt; char exit_nm;
        if (lane1_w[1] != 0) {
            exit_nm = lane1_name[1];
            exit_wt = lane1_w[1];
            printf("(time %d) 1st [ %c %c ] out: %c (%d)\n",
                time, lane1_name[0], lane1_name[1],
                exit_nm, exit_wt);
            weight_on_bridge -= exit_wt;
            lane1_name[1] = '-'; lane1_w[1] = 0;
            exited++;
        }
        else {
            printf("(time %d) 1st [ %c %c ]\n",
                time, lane1_name[0], lane1_name[1]);
        }
        // shift
        if (lane1_w[0] != 0) {
            lane1_name[1] = lane1_name[0];
            lane1_w[1] = lane1_w[0];
            lane1_name[0] = '-';
            lane1_w[0] = 0;
        }

        // 2) 이동 및 출차 처리 (Lane 2)
        if (lane2_w[1] != 0) {
            exit_nm = lane2_name[1];
            exit_wt = lane2_w[1];
            printf("(time %d) 2nd [ %c %c ] out: %c (%d)\n",
                time, lane2_name[0], lane2_name[1],
                exit_nm, exit_wt);
            weight_on_bridge -= exit_wt;
            lane2_name[1] = '-'; lane2_w[1] = 0;
            exited++;
        }
        else {
            printf("(time %d) 2nd [ %c %c ]\n",
                time, lane2_name[0], lane2_name[1]);
        }
        if (lane2_w[0] != 0) {
            lane2_name[1] = lane2_name[0];
            lane2_w[1] = lane2_w[0];
            lane2_name[0] = '-';
            lane2_w[0] = 0;
        }

        // 3) 진입 처리: Lane 1 → Lane 2 순서
        if (idx1 < N1 && lane1_w[0] == 0 &&
            weight_on_bridge + w1[idx1] <= 10) {
            lane1_name[0] = name1[idx1];
            lane1_w[0] = w1[idx1];
            weight_on_bridge += w1[idx1];
            idx1++;
        }
        if (idx2 < N2 && lane2_w[0] == 0 &&
            weight_on_bridge + w2[idx2] <= 10) {
            lane2_name[0] = name2[idx2];
            lane2_w[0] = w2[idx2];
            weight_on_bridge += w2[idx2];
            idx2++;
        }

        time++;
    }

    // 최종 결과 출력
    printf("Total weight: %d\n", total_weight);
    printf("Elapsed time: %d\n", time);

    return 0;
}
