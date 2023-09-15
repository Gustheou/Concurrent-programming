/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 08/03/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: Buffer
* Funcao...........: O buffer tem como funcao guardar e remover os valores "produzidos", alem de impedir uma producao e um consumo alem do limite
*************************************************************** */
package Util;
import java.util.concurrent.Semaphore;

public class Buffer { 
  private int item;
  private Semaphore semaforoFull, semaforoEmpty;

  public Buffer (){
    this.semaforoFull = new Semaphore(0);
    this.semaforoEmpty = new Semaphore(1);
  }//Fim do construtor do buffer

/* ***************************************************************
* Metodo: consumir
* Funcao: retirar um item do buffer
* Parametros: void
* Retorno: void
*************************************************************** */
  public void consumir (){
    try {
      semaforoFull.acquire();//Tenta acessar pelo semaforo de posicao cheia
      System.out.println ("Consumido: "+ this.item);
      System.out.println("");
      semaforoEmpty.release();
    } catch (InterruptedException i) {
      System.out.println("Erro ao retirar" + i.getMessage());
    }//Fim do try-catch
  }//Fim do metodo consumir

/* ***************************************************************
* Metodo: produzir
* Funcao: inserir um item no buffer
* Parametros: int novo item -> item que sera inserido no buffer
* Retorno: void
*************************************************************** */
  public void produzir (int novoItem) {
    try {
      semaforoEmpty.acquire();//Tento acessar o semaforo das posicoes vazias
      this.item = novoItem;//Regiao critica
      System.out.println("Item inserido/produzido: "+ this.item);
      semaforoFull.release();
    } catch (InterruptedException i) {
      System.out.println("Erro ao inserir" + i.getMessage());
    }//Fim do try-catch
  }//Fim do metodo produzir
}//Fim da classe Buffer
