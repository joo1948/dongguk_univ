#include <stdio.h>

int main(void) {
	
	const int YEAR = 2025;
	const int MON = 3;
	const int DAY = 1;

	double cm, kg;
	int year, mon, day;

	int koreanAge, age;
	double BMI;

	// 기준 : 2025 / 3/ 1
	//한국식 나이 : 2025(year) - 입력받은 날짜 : +1 하여 출력
	//만 나이 : 2025(year) - 입력받은 날짜 출력
	//만약 2025 3 1 이후 고려 X

	//입력
	printf("Enter your birth year, month, and day: ");
	scanf_s_s_s("%d %d %d", &year, &mon, &day);

	printf("\nEnter your height in cm: ");
	scanf_s_s_s("%lf", &cm);

	printf("\nEnter your weight in kg: ");
	scanf_s_s_s("%lf", &kg);
	printf("\n");

	//계산
	//한국식 나이 : 2025 - year + 1
	koreanAge = YEAR - year + 1;
	//만나이 : 2025 - year , 생일 안지났으면 -1
	age = YEAR - year;
	if (MON < mon|| (MON == mon && DAY < day)) {
		age = age - 1;
	}

	
	//BMI = kg / (cm/100)^2 
	BMI = kg / ((cm / 100) * (cm / 100));


	//출력
	printf("Your Korean age is %d\n", koreanAge);
	printf("Your age is %d\n", age);
	printf("Your BMI is %.2lf\n", BMI);







	return 0;
}