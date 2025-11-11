#include <stdio.h>
#include <malloc.h>
#include <string.h>

int  main(void)
{
	struct test {
		int i;
		char str[20];
	};
	struct test *p;
	p=(struct test *)malloc(sizeof(struct test));
	if( p==NULL ) {
		printf("memory error");
		return 0;
	}
	p->i=100;
	strcpy(p->str,"just testing");
	free(p);
}
