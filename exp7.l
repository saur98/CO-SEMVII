%{ 
#include<stdio.h> 
#include<string.h> 
int i = 0; 
%} 

%% 
([a|e|i|o|u|A|E|I|O|U][a-zA-Z]*) {i++;}
"\n" {printf("%d\n",i);i=0;}
([a-zA-Z]*) {}
. {}
%% 

int yywrap(void){} 

int main() 
{ 
	yylex(); 
	return 0; 
} 

