#include <stdio.h>
#include <errno.h>

#define EOTHER 131
#define DIGITS 10

//1. main은 그대로 쓰면 되는지 아니면 입력받도록 변경해야하는건지  >> 그대로 둔 상태로 실행결과 동일하면 된다.
int str2myInt(char* s, char myInt[], int n) {
	//string > array

	int len = 0;
	while (s[len] != '\0') {
		if (s[len] < '0' || s[len] > '9') return EOTHER;  
		len++;
	}

	//조건
	if (len > n) return ERANGE;

	for (int i = 0; i < n; i++) {
		if (len <= i) {
			myInt[i] = '0';
		}
		else {
			myInt[i] = s[len - 1 -i];
			//myInt[i] = s[len-i+1]; > 이건 왜 안되는거지?
		}
		
	}
	/*printf("myInt 값  :: ");
	for (int i = 0; i < n; i++) {
		printf("%c ", myInt[i]);
	}
	printf("\n");*/
	


	return 0;
}

int myInt2str(char myInt[], int n, char* s) {
	//ASCII 인거 조심하기
	
	for (int i = 0; i < n; i++) {
		if (myInt[i] < '0' || myInt[i] > '9') {
			return EOTHER;
		}
	}

	// 처음 시작은 0이면 X
	int start = n - 1;
	while (start > 0 && myInt[start] == '0') {
		start--;
	}

	// 문자열로 변환
	int idx = 0;
	for (int i = start; i >= 0; i--) {
		s[idx++] = myInt[i];
	}
	s[idx] = '\0';



	return 0;
}


int myIntAdd(char a[], char b[], char c[], int n) {
	//printf("myIntAdd\n");

	int al = 0;

	for (int i = 0; i < n; i++) { c[i] = 0; }//배열 초기화

	

	for (int i = 0; i < n; i++) {//따로따로 해줘야함
		if (a[i] < '0' || a[i] > '9' || b[i] < '0' || b[i] > '9') {
			//printf("myIntAdd :: a[i] = %d, b[i] = %d\n", a[i], b[i]);
			return EOTHER;
		}
	}

	for(int i=0;i<n;i++){
		int sum = a[i]-'0' + b[i]-'0';
		al = sum / 10;
		c[i] = (sum % 10) + '0';

		/*for (int i = 0; i < n; i++) {
			printf("%c ", c[i]);
		}
		printf("\n");
		printf("\n");*/


		if (i == 0 && al > 0) return EOVERFLOW;
	}

	return 0;
}
int main(int argc, char* args[]) {

	char a[DIGITS], b[DIGITS], c[DIGITS];
	char strA[DIGITS + 1], strB[DIGITS + 1], strC[DIGITS + 1];
	str2myInt("0000123456", a, DIGITS);
	str2myInt("123", b, DIGITS);
	myIntAdd(a, b, c, DIGITS);
	myInt2str(a, DIGITS, strA);
	myInt2str(b, DIGITS, strB);
	myInt2str(c, DIGITS, strC);
	printf("%s + %s = %s\n", strA, strB, strC);
	str2myInt("0", a, DIGITS);
	myInt2str(a, DIGITS, strA);
	printf("%s\n", strA);
	char str9[] = "9999999999";
	str2myInt(str9, a, DIGITS); // b is 123.
	if (myIntAdd(a, b, c, DIGITS) == EOVERFLOW)
		printf("Overflow: %s + %s\n", str9, strB);

	char strDot[] = "3.14";
	if (str2myInt(strDot, a, DIGITS) == EOTHER)
		printf("None digit: %s\n", strDot);
	char strLarge[] = "12345678901";
	if (str2myInt(strLarge, a, DIGITS) == ERANGE)
		printf("Out of range: %s\n", strLarge);
	if (myInt2str("123456", DIGITS, strA) == EOTHER)
		printf("Bad format\n");
	if (myIntAdd(a, "1234", c, DIGITS) == EOTHER)
		printf("Bad format\n");

}