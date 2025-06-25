#include <stdio.h>

int abs_compare(int a, int b) {

	int r_a = a;
	int r_b = b;
	int result = 0;

	//일단 절대값을 없애야함
	//a<0 = a= a*(-1), b<0 = b=b*(-1)
	//a , b 비교 하여 큰 수 result에 넣기

	if (r_a < 0) r_a = r_a * (-1);
	if (r_b < 0)  r_b = r_b * (-1);

	if (r_a < r_b) {
		result = b;
	}
	else {
		result = a;
	}

	return result;
}

int main(void) {

	int n1 = 0;
	int n2 = 0;

	printf("두 정수를 입력하세요: ");
	scanf_s_s_s("%d %d", &n1, &n2);

	printf("절댓값이 더 큰 수는 %d입니다.\n", abs_compare(n1, n2));

	return 0;
}