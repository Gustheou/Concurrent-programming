/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 05/05/2022
* Ultima alteracao.: 07/05/2022
* Nome.............: Leitor
* Funcao...........: O programa tem como funcao simular um "leitor"
*************************************************************** */
import java.util.concurrent.Semaphore;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Leitor extends Thread {
  
  private Button button;
  private ImageView imagemLendo, imagemLido;
  private int contador;
  private Semaphore mutex;
  ControlePrograma controle;

  public Leitor(ControlePrograma controle, Semaphore mutex){
    this.controle = controle;
    this.mutex = mutex;
    button = controle.getButtonIniciar();
  }
  
/* ***************************************************************
* Metodo: run
* Funcao: executar o processo
* Parametros: void
* Retorno: void
*************************************************************** */
  @Override
  public void run() {
    contador = 0;
    while (contador < 18) {
      try {
        mutex.acquire();
        //AnimacaoDeLeitura v
        imagemLendo = controle.getImageLendo(contador);
        controle.getImageEscrever(contador).setVisible(false);
        imagemLendo.setVisible(true);
        sleep(controle.getVelocidadeLeitor());//Velocidade de leitura, implementar o slider depois
        imagemLido = controle.getImageLeituraFinalizada(contador);
        contador++;
        if (contador > 18){
          contador = 0;
          mutex.release();
        }
        // AnimacaoDeLeitura ^
  
        //AnimacaoDeDeixarAzul = lido v
        imagemLendo.setVisible(false);
        imagemLido.setVisible(true);
        //AnimacaoDeDeixarAzul = lido ^

        mutex.release();
      } catch (InterruptedException e) {
        System.out.println("Erro no mutex: " + e.getMessage());
      }//Fim do try-catch
    }//Fim do while
    button.setVisible(true);
  }//Fim do metodo run
}//Fim da classe Leitor
