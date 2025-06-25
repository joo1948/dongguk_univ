
#include <stdio.h>
int main(void) {

        //0 ~ 255 까지의 양의 정수를 16진수로 입력 받기
        int num;
        int Q, R, mulFour;


        printf("Enter a positive integer (in hexadecimal): ");
        scanf_s_s_s("%x", &num);

        printf("After divided by 8, the quotient is: %d\n", num >> 3);//2의 3승으>로 나눈 몫
        printf("and the remainder: %d\n", num & 3);//2의 3승으로 나눈 나머지
        printf("After multiplied by 4 (in octal): %o\n", num << 2);// 2의 2승으로 >곱한 값



        return 0;

}
