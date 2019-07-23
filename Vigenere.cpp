#include<iostream>
using namespace std;

int main()
{
    string key="deceptive",nkey;
    string plaintext="wearediscoveredsaveyourself";
    string ciphertext,text;
    //cin>>key>>plaintext;
    int j=0;
    int lenkey=key.length();
    for(int i=0;plaintext[i]!='\0';i++)
    {
        nkey+=key[j++%lenkey];
        ciphertext+=(int(nkey[i])-97+int(plaintext[i])-97)%26+65;
    }
    cout<<ciphertext<<endl;
    for(int i=0;ciphertext[i]!='\0';i++)
    {
        text+=(((int(ciphertext[i])-65)-(int(nkey[i])-97))+26)%26+97;
        //cout<<(int(ciphertext[i])-65)<<(int(nkey[i])-97)<<" "<<ciphertext[i]<<endl;
    }
    cout<<text;
}
