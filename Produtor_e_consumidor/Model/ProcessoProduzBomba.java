/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 02/03/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: ProcessoProduzBomba
* Funcao...........: O programa tem como funcao simular a producao de bombas para seus clientes
*************************************************************** */
package Model;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import Controller.ControleGeral;
import Util.Buffer;

public class ProcessoProduzBomba extends Thread{
  private ImageView bomb;
  private int posicaoX = -100; //-50 -- 160
  private int velocidadeDaBomba = 25;
  private int itemProduzido = 0;
  private Buffer buffer;

  public ProcessoProduzBomba(ControleGeral controle, Buffer buffer){
    this.bomb = controle.getBomb();
    this.buffer = buffer;
  }//Fim do construtor ProcessoProduzBomba
  
/* ***************************************************************
* Metodo: run
* Funcao: Inicializar a thread
* Parametros: void
* Retorno: void
*************************************************************** */
  @Override
  public void run(){
    bomb.setVisible(true);
    while (true){
      itemProduzido = (itemProduzido+1)%3;
      this.buffer.produzir(itemProduzido+1);
      bomb.setVisible(true);
      movimentacaoDoEixoX();
      posicaoX = -100;
      Platform.runLater(() -> bomb.setX(80));
    }//Fim do while 
  }//Fim do metodo run

/* ***************************************************************
* Metodo: movimentacaoDoEixoX
* Funcao: Fazer a animacao da bomba se mover e mover a bomba pelo eixo x
* Parametros: int = valor que limitara o movimento da bomba (o ponto final)
* Retorno: void
*************************************************************** */
  public void movimentacaoDoEixoX() {
    int posicaoDeParadaDaBomba = 80;
    while(posicaoX != posicaoDeParadaDaBomba){
      try {
        Thread.sleep(velocidadeDaBomba);
      } catch (InterruptedException i) {
        System.out.println("Erro na movimentacao do eixo x: "+ i.getMessage());
      }
      final int posicaoConstante = posicaoX;
      Platform.runLater( () -> bomb.setX(posicaoConstante));
      posicaoX++;
    }//Fim do while
  }//Fim do metodo movimentacaoDoEixoX

/* ***************************************************************
* Metodo: getVelocidadeDaBomba
* Funcao: adquirir a velocidade da bomba
* Parametros: void
* Retorno: int
*************************************************************** */
  public int getVelocidadeDaBomba() {
    return this.velocidadeDaBomba;
  }//Fim do metodo getVelocidade

/* ***************************************************************
* Metodo: setVelocidadeDaBomba
* Funcao: guardar a velocidade da bomba
* Parametros: int velocidadeDaBomba = valor para definir a velocidade atual da bomba
* Retorno: void
*************************************************************** */
  public void setVelocidadeDaBomba(int velocidadeDaBomba) {
    this.velocidadeDaBomba = velocidadeDaBomba;
  }//Fim do metodo setVelocidade
}//Fim da classe ProcessoProduzBomba
