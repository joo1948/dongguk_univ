#include <stdio.h>
#include <stdlib.h>
void reculsive(int n)
{
	if(n == 0)
		return;
	
	printf("%d",n);
	reculsive(n-1);
	
 } 
 
 int main()
 {
 	reculsive(3);
	 return 0;
 }
 
