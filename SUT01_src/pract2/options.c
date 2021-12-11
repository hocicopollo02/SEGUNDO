#include<stdio.h>

main(int argc, char *argv[]) 
{
	int numArg = argc;

	for(int i = 0; i < numArg; i++)
	{
		if (strcmp(argv[i], "-c") == 0) 
		{
			printf("Argumento %d es Compilar\n", i);
		}
		else if (strcmp(argv[i], "-E") == 0) 
		{
			printf("Argumento %d es Preprocesar\n", i);
		}
		else if (strncmp(argv[i], "-i", 2) == 0) 
		{
			printf("Argumento %d es Incluir %s\n", i, &argv[i][2]);
		}
	}
}
