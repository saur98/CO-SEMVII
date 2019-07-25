%{ 
#include<stdio.h> 
#include<string.h> 
%} 

%% 
([0-9][0-9]+) {printf("Number %s\n",yytext);}
([a-zA-z][a-zA-z]+) {printf("String %s\n",yytext);}
. {}
%% 

int yywrap(void){} 

int main() 
{ 
	yylex(); 
	return 0; 
} 
