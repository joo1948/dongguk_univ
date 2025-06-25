#include <stdio.h>

int main(void) {

	//줄 for {공백 + *  for{}}
	//공백 + * for :: 공백 + & 합친 값 : 입력 값 

	int number;

	printf("Enter a number: ");
	scanf_s_s_s("%d", &number);

	/*
	int star = 1;
	int blank = number - 1;

	for (int i = 1; i <= number; i++) {//줄
		for (int j = blank; j > 0; j--) {//공백 + *
			printf(" ");
		}
		blank--;

		for (int k = 1; k <= star; k++) {
			printf("*");
		}
		star += 2;
		printf("\n");
	}
	*/

	int star = 1;
	for (int i = 0; i < number; i++) {//줄
		for (int j = number - 1; j > i; j--) {//공백
			printf(" ");
		}

		for (int k = 0; k < star; k++) {//*
			printf("*");
		}
		star += 2;
		printf("\n");

	}




	return 0;
}