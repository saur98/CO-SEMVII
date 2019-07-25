%{ 
#include<stdio.h> 
#include<string.h> 
int i = 0; 
%} 

%% 
([a-zA-Z]) {letters++;}
([ ]) {printf("%d\n",i);i=0;}
([a-zA-Z]*) {}
. {}
%% 

int yywrap(void){} 

int main() 
{ 
	yylex(); 
	return 0; 
} 

