#include <stdio.h>
#include <stdlib.h>

#define N 100

//1. #define N 100, double p[N+1]은 무조건 넣어야하는건지 아니면 이런 식으로 표현할 수 있다는 것을 보여준 것인지
//2. 처음에 입력 받은 x 값으로 add()에도 제곱 시 사용해야하는 건지 써야하는 건지 의문이다.
double eval(double p[], double x, int n) {
	//n : 다항식의 p의 차수

	double result = 0.0;
	for (int i = 0; i < n+1; i++) {
		int temp = 1;
		if (i == 0) {
			result += p[i];
		}else{
			for (int j = 0; j < i; j++) {
				temp *= x;
			}
			result += (p[i] * temp);
		}
	}

	return result;
}

void print_func(char* name, double p[], int n) {
	printf("%s = ", name);
	for (int i = 0; i <= n; i++) {
		if (i > 0) {
			printf(" + ");
		}

		if (i == 0) {
			printf("%.2lf", p[i]);
		}
		else {
			printf("%.2lfx^%d", p[i], i);
		}
	}
	printf("\n");
}

void add(double f[], double g[], double h[], int n) {
	//n: f, g, h의 차수
	
	//f 생성
	for (int i = 0; i < n + 1; i++) {
		f[i] = g[i] + h[i];
	}

	print_func("g(x)", g, n);
	print_func("h(x)", h, n);
	print_func("f(x)", f, n);
}

int main() {
	
	int n = 0;
	double x = 0.0;

	printf("다항식의 차수 n: ");
	scanf_s("%d", &n);
	printf("x 값: ");
	scanf_s("%lf", &x);

	if (x > N) {
		//최대 100 제한
		return 0;
	}
	
	double* a = (double*)malloc(sizeof(double) * n);
	printf("a0~a%d 입력: ", n);
	for (int i = 0; i < n+1; i++) {
		scanf_s("%lf", &a[i]);
	}

	printf("p(%.2lf) = %.2lf\n",x, eval(a, x, n));
	printf("-----------------\n");

	
	printf("다항식의 차수 n: ");
	scanf_s("%d", &n);
	
	double* f = (double*)malloc(sizeof(double) * n);
	double* g = (double*)malloc(sizeof(double) * n);
	double* h = (double*)malloc(sizeof(double) * n);

	printf("g(x) a0~a%d 입력: ",n);
	for (int i = 0; i < n + 1; i++) {
		scanf_s("%lf", &g[i]);
	}
	printf("h(x) b0~b%d 입력: ", n);
	for (int i = 0; i < n + 1; i++) {
		scanf_s("%lf", &h[i]);
	}

	add(f, g, h, n);

	
	return 0;
}