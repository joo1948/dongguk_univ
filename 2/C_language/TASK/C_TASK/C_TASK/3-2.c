#include <stdio.h>
int main(void) {

	int year = 0;
	int result = 0;

	printf("연도를 입력하세요: ");
	scanf_s_s_s("%d", &year);

	if (year % 4 == 0 && year % 100 != 0) {
		result = 1;
	}
	else if (year % 400 == 0) {
		result = 1;
	}

	if (result) {
		printf("%d년은 윤년입니다.\n", year);
	}
	else {
		printf("%d년은 윤년이 아닙니다.\n", year);
	}


	return 0;

}