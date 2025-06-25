#include <stdio.h>

void reverse_number(int original_number) {//486
	//숫자를 거꾸로 뒤집기
	int original = original_number;
	int reverse = 0;

	int re_one = 0;//4
	int re_two = 0;//8
	int re_three = 0;//6

	re_three = original / 100;
	original %= 100;
	re_two = original / 10;
	re_one = original % 10;

	reverse = (re_one * 100) + (re_two * 10) + (re_three);
	printf("뒤집은 수는 %d입니다.\n", reverse);

	is_palindrome(original_number, reverse);

}
int is_palindrome(int original, int reverse) {
	
	if (original == reverse) {
		printf("회문입니다.\n");
	}
	else {
		printf("회문이 아닙니다.\n");
	}
	return 0;
}


int main(void) {
	
	int num = 0;

	printf("세 자리 정수를 입력하세요: ");
	scanf_s_s_s("%d", &num);


	//세 자리수 확인 
	//입력받은 값 / 100 > 한자리 수 
	if (num/100 == 0 || num/100 >9) {
		printf("세 자리 정수가 아닙니다.");
	}
	else {
		reverse_number(num);
	}

	
	return 0;
}