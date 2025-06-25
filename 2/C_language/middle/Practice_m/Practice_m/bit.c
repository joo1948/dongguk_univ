#include <stdio.h>

#define KEY 0x5A
int main(void) {
	int num1 = 20, num2 = 16;
	int result1;


	result1 = num1 ^ num2;

	printf("비트단위 ^ 연산의 결과 %d\n", result1);


	num1 = 20;
	result1 = 0;

	result1 = ~num1;
	printf("비트단위 ~ 연산의 결과 %d \n", result1);



	num1 = 10;
	result1 = 0;

	result1 = num1 << 2;
	printf("비트단위 << 연산의 결과 %d \n", result1);

	num1 = 10;
	num2 = -10;

	result1 = 0;
	int result2 = 0;

	result1 = num1 >> 1;
	result2 = num2 >> 1;

	printf("비트단위 >> 연산의 결과 %d \n", result1);
	printf("비트단위 >> 연산의 결과 %d \n", result2);


	printf("3개 논리 연산자 확장\n");


	/*
	int a, b, c;
	printf("정수 3개를 입력하세요 : ");
	scanf_s("%d %d %d", &a, &b, &c);

	int max = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
	//a가 b보다 크면 a>c 면 a, 아니면 c
	//a < b면 b>c 면 b,아니면 c

	printf("최댓값: %d\n", max);
	*/


	// 비트연산자 XOR 스왑
	int x = 5; //0 0 0 0 0 1 0 1 
	int y = 10;//0 0 0 0 1 0 1 0
	printf("초기값 : x = %d, y = %d\n", x, y);

	x = x ^ y; //0 0 0 0 1 1 1 1 
	printf("x : %d, y : %d\n", x,y);
	//x = 1 1 1 1
	//y=  1 0 1 0
	y = x ^ y; // 0 1 0 1
	printf("x : %d, y : %d\n", x, y);
	x = x ^ y; 
	//0 1 0 1
	//1 1 1 1
	//x = 1 0 1 0

	printf("x : %d, y : %d\n", x, y);

	unsigned int color = 0x123456;

	unsigned int red = (color >> 16) & 0xFF;
	unsigned int green = (color >> 8) & 0xFF;
	unsigned int blue = color & 0xFF;

	printf("원본 : color = 0x%x\n", color);
	printf("red = %u (0x%x)\n", red, red);
	printf("green = %u (0x%x)\n", green, green);
	printf("blue = %u (0x%x)\n", blue, blue);


	unsigned int original;
	printf("양의 정수를 입력 : ");
	scanf_s("%u", &original);

	unsigned int enc = original ^ KEY;
	unsigned int dec = enc ^ KEY;

	printf("원본 : %u, 암호화 : %u, 복호화 : %u \n", original, enc, dec);


	return 0;
}