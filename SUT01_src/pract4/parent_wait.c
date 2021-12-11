#include<stdio.h>
#include<stdlib.h>

int main(int argc, char *argv[])
{
	int val_return = 0;
	
	for (int i = 0; i < 5; i++) 
	{
		val_return = fork();
		

		if (val_return == 0)
		{
			printf("Hijo creado en iteración = %d\n", i);

			exit(i);
		} 

		
		wait();
	}

	sleep(10);
	exit(0);

}
