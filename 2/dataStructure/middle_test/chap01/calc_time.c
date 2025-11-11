#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(void)
{
	clock_t start, stop;
	double duration;
	start = clock();	// 痢≪젙 �떆�옉
	int i=0;
	for (i = 0; i < 100000000; i++)	// �쓽誘� �뾾�뒗 諛섎났 猷⑦봽
		;
	stop = clock();	// 痢≪젙 醫낅즺
	duration = (double)(stop - start) / CLOCKS_PER_SEC;
	
	printf("�닔�뻾�떆媛꾩�� %f珥덉엯�땲�떎.\n", duration);
	return 0;
}

