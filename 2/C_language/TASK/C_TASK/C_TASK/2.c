#include <stdio.h>
int main(void) {

	int km, km_h;
	double time;

	int hour, min, sec;
	int timeSec;

	//입력
	printf("Enter the distance (km): ");
	scanf_s_s_s("%d", &km);

	printf("\nEnter the speed (km/h): ");
	scanf_s_s_s("%d", &km_h);

	//식 계산	
	time = (double)km / km_h;
	timeSec = (int)(time * 3600);//초로 변환

	hour = timeSec / 3600;
	min = (timeSec % 3600) / 60;//시간을 뺀 시간에서 분으로 변경
	sec = timeSec % 60;//

	printf("\n");
	printf("Estimated time: %d hour %d min %d sec.", hour, min, sec);

	

	return 0;

}