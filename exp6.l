%{ 
#include<stdio.h> 
#include<string.h> 
%} 

%% 
([a|e|i|o|u|A|E|I|O|U][a-zA-Z]*) {printf("Starts with Vowel %s\n",yytext);}
([a-zA-z]*) {printf("Starts with Consonant %s\n",yytext);}
. {}
%% 

int yywrap(void){} 

int main() 
{ 
	yylex(); 
	return 0; 
} 
