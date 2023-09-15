/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 13/04/2022
* Ultima alteracao.: 24/04/2022
* Nome.............: Filosofo
* Funcao...........: Controlar os estados do filosofo, manipulado imagens e tudo mais.
*************************************************************** */
package Model;
import Controller.ControleGeral;
import javafx.scene.image.ImageView;

public class Filosofo extends Thread{
  int id, velocidade;
  //Inteiros constantes referentes aos estados
  final int pensando = 0;
  final int comFome = 1;
  final int comendo = 2;

  ControleGeral controle;
  //Imagens necessarias para o filosofo
  private ImageView imagemFilosofoEstadoPensando;
  private ImageView imagemFilosofoEstadoComFome;
  private ImageView imagemFilosofoEstadoComendo;
  private ImageView imagemBalaoPensante;
  private ImageView imagemPensamentoPraia;
  private ImageView imagemHashiEsquerdo;
  private ImageView imagemHashiDireito;

  public Filosofo (ControleGeral controle, int id) {
    this.id = id;
    this.controle = controle;
    imagemFilosofoEstadoPensando = controle.getImagemFilosofoEstadoPensando(id);
    imagemFilosofoEstadoComFome = controle.getImagemFilosofoEstadoComFome(id);
    imagemFilosofoEstadoComendo = controle.getImagemFilosofoEstadoComendo(id);
    imagemBalaoPensante = controle.getImagemBalaoPensante(id);
    imagemPensamentoPraia = controle.getImagemPensamentoPraia(id);
    imagemHashiEsquerdo = controle.getImagemHashi(id);
    imagemHashiDireito = controle.getImagemHashi((id+1)%5);
  }

/* ***************************************************************
* Metodo: estaComFome
* Funcao: colocar o estado do filosofo para com fome e mudar as respectivas imagens
* Parametros: void
* Retorno: void
*************************************************************** */
  public void estaComFome(){//Interesse
    ControleGeral.estado[this.id] = comFome;
    imagemPensamentoPraia.setVisible(false);
    imagemBalaoPensante.setVisible(false);
    imagemFilosofoEstadoPensando.setVisible(false);
    imagemFilosofoEstadoComFome.setVisible(true);
    System.out.println ("O filosofo "+this.id+ " esta com fome");
  }//Fim do metodo estaComFome

/* ***************************************************************
* Metodo: comendo
* Funcao: colocar o estado do filosofo para comendo e mudar as respectivas imagens
* Parametros: void
* Retorno: void
*************************************************************** */
  public void comendo(){
    ControleGeral.estado[this.id] = comendo;
    imagemFilosofoEstadoComFome.setVisible(false);
    imagemFilosofoEstadoComendo.setVisible(true);
    imagemHashiDireito.setVisible(false);
    imagemHashiEsquerdo.setVisible(false);
    System.out.println("O filosofo "+this.id + " esta comendo");
    try {
      Thread.sleep(controle.getVelocidadeComer(id));
    }catch (InterruptedException i){
      System.out.println("Erro no metodo comendo: "+ i.getMessage());
    }//Fim do try-catch
  }//Fim do metodo comendo

/* ***************************************************************
* Metodo: pensando
* Funcao: colocar o estado do filosofo para pensando e mudar as respectivas imagens
* Parametros: void
* Retorno: void
*************************************************************** */
  public void pensando(){
    ControleGeral.estado[this.id] = pensando;
    imagemFilosofoEstadoComendo.setVisible(false);
    imagemFilosofoEstadoPensando.setVisible(true);
    imagemBalaoPensante.setVisible(true);
    imagemPensamentoPraia.setVisible(true);
    System.out.println("O filosofo "+this.id + " está pensando");
    try {
      Thread.sleep(controle.getVelocidadePensar(id));
    } catch (InterruptedException i) {
      System.out.println("Erro no metodo pensando: "+ i.getMessage());
    }//Fim do try-catch
  }//Fim do metodo pensando

/* ***************************************************************
* Metodo: devolveHashi
* Funcao: incrementa o semaforo, liberando algum processo no estado de bloqueio e altera o status das imagens do hashi
* Parametros: void
* Retorno: void
*************************************************************** */
  public void devolveHashi(){
    try {
      ControleGeral.mutex.acquire();
      imagemHashiDireito.setVisible(true);
      imagemHashiEsquerdo.setVisible(true);
      pensando();//Quando o filosofo devolver os garfos, os filosofos vizinhos podem tentar pegar
      ControleGeral.filosofos[vizinhoEsquerda()].tentaPegarHashi();
      ControleGeral.filosofos[vizinhoDireita()].tentaPegarHashi();
      System.out.println("O filosofo "+this.id+ " devolveu os hashi's");
      ControleGeral.mutex.release();
    } catch (InterruptedException i) {
      System.out.println("Erro no metodo devolveHashi: "+ i.getMessage());
    }//Fim do try-catch
  }

/* ***************************************************************
* Metodo: pegaHashi
* Funcao: pega o hashi se as condicoes forem atendidas
* Parametros: void
* Retorno: void
*************************************************************** */
  public void pegaHashi(){
    try {
      ControleGeral.mutex.acquire();
      estaComFome();
      tentaPegarHashi();
      ControleGeral.mutex.release();
      ControleGeral.semaforos[this.id].acquire();
    } catch (InterruptedException i) {
      System.out.println("Erro no metodo pegaHashi: "+ i.getMessage());
    }//Fim do try-catch
  }//Fim do metodo pegaHashi

/* ***************************************************************
* Metodo: tentaPegaHashi
* Funcao: Muda o status para comendo se as condicoes forem atendidas
* Parametros: void
* Retorno: void
*************************************************************** */
  public void tentaPegarHashi(){
    if (ControleGeral.estado[this.id] == comFome && ControleGeral.estado[vizinhoEsquerda()] != comendo && ControleGeral.estado[vizinhoDireita()] != comendo){
      comendo();
      ControleGeral.semaforos[this.id].release();
    } else {
      System.out.println("O filosofo "+this.id+" nao conseguiu comer");
    }//Fim do if-else
  }//Fim do metodo tentaPegarHashi

/* ***************************************************************
* Metodo: run
* Funcao: executar o processo
* Parametros: void
* Retorno: void
*************************************************************** */
  @Override
  public void run(){
    try {
      while (true){
        pensando();
        System.out.println("");
        pegaHashi();
        Thread.sleep(10000);
        devolveHashi();
      }
    } catch (InterruptedException i) {
      System.out.println("Erro no metodo run: "+ i.getMessage());
    }//Fim do try-catch
  }//Fim do metodo run

/* ***************************************************************
* Metodo: vizinhoEsquerda
* Funcao: retornar o filosofo que se encontra a esquerda
* Parametros: void
* Retorno: int = o id do filosofo que se encontra a esquerda
*************************************************************** */
  public int vizinhoEsquerda(){
    if (this.id == 0){
      return 4;
    } else {
      return (this.id-1);
    }//Fim do if-else
  }//Fim do metodo vizinhoEsquerda
  
/* ***************************************************************
* Metodo: vizinhoDireita
* Funcao: retornar o filosofo que se encontra a direita
* Parametros: void
* Retorno: int = o id do filosofo que se encontra a direita
*************************************************************** */
  public int vizinhoDireita () {
    return (this.id+1) % 5;
  }//Fim do metodo vizinhoDireita
}//Fim da classe Filosofo
