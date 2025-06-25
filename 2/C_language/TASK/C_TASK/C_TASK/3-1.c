#include <stdio.h>

void get_median(int num1,int num2,int  num3) {

	int result = 0;

	if (num1 > num2) {
		if (num2 > num3) result = num2;
		else if (num1 > num3) result = num3;
		else result = num1;
	}
	else if (num1 > num3) result = num1;
	else if (num2 > num3) result = num3;
	else result = num2;

	printf("중앙값은 %d입니다.\n", result);
}

int main(void) {

	int num1 = 0;
	int num2 = 0;
	int num3 = 0;

	printf("세 개의 정수를 입력하세요: ");
	scanf_s_s_s("%d %d %d", &num1, &num2, &num3);

	get_median(num1, num2, num3);


	return 0;
}