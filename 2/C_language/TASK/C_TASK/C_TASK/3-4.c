#include <stdio.h>
int main(void) {
	int n = 0;

	printf("0~100 사이의 점수를 입력하세요. : ");
	scanf_s_s_s("%d", &n);

	if (n >= 90 && n <= 100) printf("A\n");
	else if (n >= 80 && n<90) printf("B\n");
	else if (n >= 70 && n < 80) printf("C\n");
	else if (n >= 60 && n < 70) printf("D\n");
	else printf("F\n");

	return 0;

}