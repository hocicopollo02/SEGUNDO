#include<stdio.h>
#include<stdlib.h>

int main(int argc, char *argv[])
{
	int val_return = 0;
	
	for (int i = 0; i < 4; i++) 
	{
		val_return = fork();
		if (val_return == 0) 
		{
			printf("Hijo %ld creado en la iteración %d\n", (long) getpid(), i);
		}

		else
		{
			printf("Padre %ld creado en iteración = %d\n", (long) getpid(),i);
			printf("He creado un hijo %ld \n", (long) val_return);

			exit(i);
		} 

		
	}
	wait();

	sleep(10);
	exit(0);

}
