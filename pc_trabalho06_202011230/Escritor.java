/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 05/05/2022
* Ultima alteracao.: 07/05/2022
* Nome.............: Escritor
* Funcao...........: O programa tem como funcao simular um "escritor"
*************************************************************** */
import java.util.concurrent.Semaphore;

import javafx.scene.image.ImageView;
public class Escritor extends Thread {
  
  ControlePrograma controle;
  private ImageView imageEscrever;
  private int contador;
  private Semaphore mutex;

  public Escritor (ControlePrograma controle, Semaphore mutex) {
    this.controle = controle;
    this.mutex = mutex;
  }

/* ***************************************************************
* Metodo: run
* Funcao: executar o processo
* Parametros: void
* Retorno: void
*************************************************************** */
  @Override
  public void run () {
    contador = 0;
    while (contador < 18){
      try {
        mutex.acquire(2);
        //Inserir novo "fragmento" v {
        imageEscrever = controle.getImageEscrever(contador);
        controle.getImageLeituraFinalizada(contador).setVisible(false);
        imageEscrever.setVisible(true);
        contador++;
        sleep(controle.getVelocidadeEscritor());
        //Inserir novo "fragmento" ^ }
        mutex.release(2);
      } catch (InterruptedException e) {
        System.out.println("Semaphore error: " + e.getMessage());
      }//Fim do try-catch
    }//Fim do while
  }//Fim do metodo run
}//Fim da classe Escritor
