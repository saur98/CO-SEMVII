%{ 
#include<stdio.h> 
#include<string.h> 
%} 

%% 
([a|e|i|o|u|A|E|I|O|U]) {printf("VOWEL %s\n",yytext);}
([a-zA-z]) {printf("CONSONANT %s\n",yytext);}
. {}
%% 

int yywrap(void){} 

int main() 
{ 
	yylex(); 
	return 0; 
} 
