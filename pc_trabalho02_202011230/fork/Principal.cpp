/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 11/03/2022
* Ultima alteracao.: 12/03/2022
* Nome.............: Arvore Genealogica
* Funcao...........: O programa basicamente funciona como uma arvore genealogica, exibindo desde o nascimento ate a morte do "pai"
*************************************************************** */
#include <unistd.h>
#include <iostream>
#include <time.h>
using namespace std;

/* ***************************************************************
* Metodo: main
* Funcao: Realizar a execucao do programa
* Parametros: void
* Retorno: int
*************************************************************** */
int main(){
  pid_t idProcesso;//Identificando o processo
  cout << "Nasce o pai" << endl;
  sleep(22); //O pai envelhece 22 anos  
  idProcesso = fork();//Criando o processo do nascimento do primeiro filho
  
  if(idProcesso == -1){//Verificar se o id eh do pai ou do filho
    exit(1);
  }//Fim do if  
  if(idProcesso){
    cout << "O pai tem o primeiro filho aos 22 anos de idade" << endl;
    sleep(3);//Mais 3 anos se passam, logo o pai tem 25 anos
    idProcesso = fork(); //O pai tem o primeiro filho
    if(idProcesso == -1){//Erro
      exit(1);
    }//Fim do if
    if(idProcesso){
        cout << "O pai tem o segundo filho aos 25 anos de idade" << endl;
        sleep(7);//O pai envelhece 7 anos, tendo agora 32 anos   
        idProcesso = fork(); //O pai tem o terceiro filho
        if(idProcesso == -1){//Erro
          exit(1);
        }//Fim do if        
        if(idProcesso){
          cout << "O pai tem o terceiro filho aos 32 anos de idade" << endl;
          sleep(58);//Depois de muitos anos, o pai passa a ter 58 anos
          cout << "O pai morre aos 90 anos\n";
          _Exit(0);//Encerrar o processo
        }else{
          sleep(55);//filho envelhece 55 anos
          std::cout << "O terceiro filho morre aos 55 anos de idade" << endl;
          _Exit(0);//Encerrar o processo
        }//Fim do else
    }else{
      sleep(20); //O segundo filho envelhece 20 anos  
      idProcesso = fork(); //O pai se torna avo (segundo filho)
      if(idProcesso == -1){//Erro
        exit(1);
      }//Fim do if
      if(idProcesso){
        cout << "O pai eh avo (segundo filho) aos 45 anos de idade" << endl;
        sleep(35);//O segundo filho passa a ter 55 anos
        cout << "Morre o segundo filho aos 55 anos de idade" << endl;
        _Exit(0);
      }else{
        sleep(33);//O segundo neto envelhece 33 anos
        cout << "O segundo neto morre aos 33 anos de idade" << endl;
        _Exit(0);
      }//Fim do else      
    }//Fim do else  
  }else{
    sleep(16);//O primeiro filho envelhece 16 anos
    idProcesso = fork();//O pai se torna avo (primeiro filho)
    if(idProcesso == -1){//Erro
      exit(1);
    }//Fim do if        
    if(idProcesso){
      cout << "O pai eh avo (primeiro filho) aos 38 anos de idade" << endl;
      sleep(45);//O primeiro filho envelhece 45 anos
      cout << "primeiro filho morre aos 61 anos de idade" << endl;
      _Exit(0);    
    }else{        
      sleep(30);//O neto 1 envelhece 30 anos 
      idProcesso = fork();//O pai se torna bisavo (primeiro filho)
      if(idProcesso == -1){//Erro
        exit(1);
      }//Fim do if    
      if(idProcesso){
        cout << "O pai eh bisavo (primeiro filho) aos 68 anos de idade" << endl;
        sleep(5);
        cout << "O primeiro neto morre aos 35 anos de idade" << endl;
        _Exit(0);    
      }else{
        sleep(12);//O bisneto envelhece 12 anos
        cout << "O bisneto morre aos 12 anos de idade" << endl;
        _Exit(0);     
      }//Fim do else    
    }//Fim do else
  }//Fim do else      
  return 0;
}//Fim do metodo main
