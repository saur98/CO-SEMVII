%{ 
#include<stdio.h> 
#include<string.h> 
int i = 0; 
%} 

%% 
([a|e|i|o|u|A|E|I|O|U][a-zA-Z]*) {fprintf(yyout,"%s ",yytext);}
([a-zA-Z]*) {}
. {}
%% 

int yywrap(void){} 

int main() 
{ 
	yyin=fopen("input.txt","r");
	yyout=fopen("output.txt","w");
	yylex(); 
	return 0; 
} 


