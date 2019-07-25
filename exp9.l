%{ 
#include<stdio.h> 
#include<string.h> 
%} 

%% 
. {fprintf(yyout,"%s",yytext);}
%% 

int yywrap(void){} 

int main() 
{
	yyin=fopen("input.txt","r");
	yyout=fopen("output.txt","w");
	yylex(); 
	return 0; 
} 

