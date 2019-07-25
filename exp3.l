%{ 
#include<stdio.h> 
#include<string.h> 
 
%} 

%% 
([0-9]) {printf("Number %s\n",yytext);}
([a-zA-z]) {printf("Character %s\n",yytext);}
. {}
%% 

int yywrap(void){} 

int main() 
{ 
	yylex(); 

	return 0; 
} 
