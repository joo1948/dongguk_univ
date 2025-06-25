#include <stdio.h>

int is_leap_year(int year) {
	int result = 0;

	if (year % 4 == 0 && year % 100 != 0) {
		result = 1;
	}
	else if (year % 400 == 0) {
		result = 1;
	}

	return result;

}

int is_valid_date(int year, int month, int day) {
	int result = 0;

	int leap_year_result = is_leap_year(year);
	
	switch (month) {
		case 2:
			if (leap_year_result) {
				if (day >= 1 && day <= 29) {
					result = 1;
				}
			}
			else {
				if (day >= 1 && day <= 28) {
					result = 1;
				}
				else {
					result = 0;
				}
			}
			break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			if (day >= 1 && day <= 31) {
				result = 1;
			}
			break;
		case 4:case 6: case 9:case 11:
			if (day >= 1 && day <= 30) {
				result = 1;
			}
			break;
	}

	return result;
}

int main(void) {

	int year = 0;
	int month = 0;
	int day = 0;
	int is_leap_year_check = 0;

	printf("연도를 입력하세요: ");
	scanf_s_s_s("%d", &year);
	printf("월을 입력하세요: ");
	scanf_s_s_s("%d", &month);
	printf("일을 입력하세요: ");
	scanf_s_s_s("%d", &day);
	
	int day_result = is_valid_date(year, month, day);
	if (day_result) {
		printf("유효한 날짜입니다.\n");
	}
	else {
		printf("유효하지 않은 날짜입니다.\n");
	}

	return 0;
}