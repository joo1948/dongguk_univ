#include <stdio.h>

#define MAX 100
#define BRIDGE 10


int main() {

	//입력
	int first_number, second_number;
	char first_name[MAX], second_name[MAX];
	int first_weight[MAX], second_weight[MAX];
	int validation = 0;

    // --- 1 MAX 입력 ---
    while (1) {
        printf("1st Max Number: ");
        scanf_s_s_s("%d", &first_number);
        if (first_number >= 5 && first_number <= 100) break;
        printf("Wrong number\n");
    }

    // --- 1 이름 입력 ---
    printf("1st Name: ");
    for (int i = 0; i < first_number; i++) {
        scanf_s_s_s(" %c", &first_name[i]);
    }

    // --- 1 무게 입력 ---
    int valid = 0;
    while (!valid) {
        valid = 1;
        printf("1st Weight: ");
        for (int i = 0; i < first_number; i++) {
            scanf_s_s_s("%d", &first_weight[i]);
            if (first_weight[i] < 1 || first_weight[i] > 10) valid = 0;
        }
        if (!valid) printf("Wrong weight\n");
    }

    // --- 2 MAX 입력 ---
    while (1) {
        printf("2nd Max Number: ");
        scanf_s_s_s("%d", &second_number);
        if (second_number >= 5 && second_number <= 100) break;
        printf("Wrong number\n");
    }

    // --- 2 이름 입력 ---
    printf("2nd Name: ");
    for (int i = 0; i < second_number; i++) {
        scanf_s_s_s(" %c", &second_name[i]);
    }

    // --- 2 무게 입력 ---
    valid = 0;
    while (!valid) {
        valid = 1;
        printf("2nd Weight: ");
        for (int i = 0; i < second_number; i++) {
            scanf_s_s_s("%d", &second_weight[i]);
            if (second_weight[i] < 1 || second_weight[i] > 10) valid = 0;
        }
        if (!valid) printf("Wrong weight\n");
    }

	
    //--구현--
    int idx1 = 0, idx2 = 0;
    char bridge_name[2] = { '-', '-' };
    int bridge_weight[2] = { 0, 0 };
    int bridge_time[2] = { 0, 0 };

    int time = 0;
    int total_weight = 0;

    while (
        idx1 < first_number || idx2 < second_number ||
        bridge_weight[0] > 0 || bridge_weight[1] > 0
        ) {
        // 상태 출력
        printf("(time %d) 1st [ ", time);
        for (int i = 0; i < 2; i++) {
            if (bridge_name[i] != '-')
                printf("%c ", bridge_name[i]);
            else
                printf("- ");
        }
        printf("]\n");

        printf("(time %d) 2nd [ ");
        for (int i = 0; i < 2; i++) {
            if (bridge_name[i] != '-')
                printf("%c ", bridge_name[i]);
            else
                printf("- ");
        }
        printf("]\n");

        // 퇴장
        for (int i = 0; i < 2; i++) {
            if (bridge_weight[i] > 0) {
                bridge_time[i]++;
                if (bridge_time[i] >= 2) {
                    printf("out: %c (%d)\n", bridge_name[i], bridge_weight[i]);
                    total_weight += bridge_weight[i];
                    bridge_name[i] = '-';
                    bridge_weight[i] = 0;
                    bridge_time[i] = 0;
                }
            }
        }

        // 현재 차량 수 및 무게
        int count = 0, sum_weight = 0;
        for (int i = 0; i < 2; i++) {
            if (bridge_weight[i] > 0) {
                count++;
                sum_weight += bridge_weight[i];
            }
        }

        // 진입 시도: 1st 우선
        if (count < 2 && idx1 < first_number && sum_weight + first_weight[idx1] <= BRIDGE) {
            for (int i = 0; i < 2; i++) {
                if (bridge_weight[i] == 0) {
                    bridge_name[i] = first_name[idx1];
                    bridge_weight[i] = first_weight[idx1];
                    bridge_time[i] = 0;
                    idx1++;
                    break;
                }
            }
        }
        else if (count < 2 && idx2 < second_number && sum_weight + second_weight[idx2] <= BRIDGE) {
            for (int i = 0; i < 2; i++) {
                if (bridge_weight[i] == 0) {
                    bridge_name[i] = second_name[idx2];
                    bridge_weight[i] = second_weight[idx2];
                    bridge_time[i] = 0;
                    idx2++;
                    break;
                }
            }
        }

        time++;
    }

    printf("Total weight: %d\n", total_weight);
    printf("Elapsed time: %d\n", time);
    return 0;
}
