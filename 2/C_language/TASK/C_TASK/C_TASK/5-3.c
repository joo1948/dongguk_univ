#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int myStrlen(char* s) {

	int len = 0;
	while (*(s + len) != '\0') {
		len++;
	}

	return len;
}

int palindrome_func(char* s) {
	//가장 처음과 끝을 비교해야함
	int result = 0;

	char* l = s;
	char* r = s + myStrlen(s) - 1;//끝자리 값 구하기

	
	while (l < r)//r>l 되는 순간 비교 끝난거임
	{
	
		//알파벳인지 확인 > 아니면 하나 증가
		while (l < r && !((*l >= 'a' && *l <= 'z')|| (*l >= 'A' && *l <= 'Z'))) {
			l++;
		}
		while (l < r && !((*r >= 'a' && *r <= 'z') || (*r >= 'A' && *r <= 'Z'))) {
			r--;
		}

		//대소문자 비교 X
		char l_alpha = *l;
		char r_alpha = *r;

		// 대문자를 소문자로 변환
		if (l_alpha >= 'A' && l_alpha <= 'Z') {
			l_alpha = l_alpha + ('a' - 'A');
		}
		if (r_alpha >= 'A' && r_alpha <= 'Z') {
			r_alpha = r_alpha + ('a' - 'A');
		}
		printf("l_alpha = %c r_alpha =%c \n", l_alpha, r_alpha);
		if (l_alpha != r_alpha) {
			result = 0;
			break;
		}
		else {
			l++;
			r--;
			result = 1;
		}
	}

	return result;
}


int main() {

	char s[MAX] = { '\0' };

	while (1) {
		printf("문자열 입력: ");

		//TODO 공백입력
		//scanf_s(" %[^\n]", s, MAX);  // 공백 포함 입력을 위해 " %[^\n]" 사용
		int i = 0;
		char c;
		while ((c = getchar()) != '\n' && i < MAX - 1) {
			s[i] = c;
			i++;
		}
		s[i] = '\0';  // 문자열 끝 표시

		if (myStrlen(s) == 0) {
			printf("\"\" is palindrome.\n");
			continue;
		}

		if (!palindrome_func(s)) {
			printf("\"%s\" is not palindrome.\n", s);
			
			break;
		}
		else {
			printf("\"%s\" is palindrome.\n", s);
		}
	}

	return 0;
}