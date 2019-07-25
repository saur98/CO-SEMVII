%{ 
#include<stdio.h> 
#include<string.h> 
int i = 0; 
%} 

%% 
([a|e|i|o|u|A|E|I|O|U]) {i++;}
"\n" {printf("%d\n",i);i=0;}
. {}
%% 

int yywrap(void){} 

int main() 
{ 
	yylex(); 
	return 0; 
} 

