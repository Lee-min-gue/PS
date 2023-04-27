#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<stdlib.h>
#include <string.h>



int main(void)
{
	int num;
	int nanu=2;
	scanf("%d", &num);
	while (num != 1)
	{
		if (num % nanu == 0)
		{
			printf("%d\n", nanu);
			num /= nanu;
		}
		else
		{
			nanu++;
		}

	}

}