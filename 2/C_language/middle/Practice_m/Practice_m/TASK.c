#include <stdio.h>

int totalCount = 0;

int fac(int n) {

   

}

int fivo(int n) {
  
}

long power(long base, int exp) {

    if (exp == 0) return 1;
    else if (exp == 1) return base;
    else {
        return base * power(base, exp - 1);
    }

}

int addNumbers(int x, int y) {
    totalCount++;
    
    return x + y;


}

int main(void) {
  
    int num1 = 10, num2 = 10;
    printf("%d\n", ++num1);//11
    printf("%d\n", num1); //11
    
    printf("%d\n", num2++);//10
    printf("%d\nn", num2); //11
       


    return 0;
}


