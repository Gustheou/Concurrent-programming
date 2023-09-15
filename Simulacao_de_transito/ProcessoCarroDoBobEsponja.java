/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 17/05/2022
* Ultima alteracao.: 22/05/2022
* Nome.............: ProcessoCarroDoBobEsponja
* Funcao...........: Controlar todo o funcionamento do carro do bob esponja
*************************************************************** */
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class ProcessoCarroDoBobEsponja extends Thread {
  
  private ImageView carro;
  ControleGeral cG;
  private int posicaoXo = 0;
  private int posicaoX = 0;
  private int posicaoYo = 0;
  private int posicaoY = 0;
  private int velocidade = 25;

  public ProcessoCarroDoBobEsponja (ControleGeral cG, int id){
    this.cG = cG;
    carro = cG.getImageVeiculo(id);
  }
 
/* ***************************************************************
* Metodo: run
* Funcao: Inicializar a thread
* Parametros: void
* Retorno: void
*************************************************************** */
  @Override
  public void run () {
    carro.setX(posicaoXo);
    carro.setY(posicaoYo);
    try {
      Semaforos.spongebobPlankton1.acquire();
      Semaforos.raceCarBloqueiaBobEsponja1.acquire();
    } catch (Exception i) {
      System.out.println(i.getMessage());  
    }
    while (true){
      try {
        movimentacaoSubida(-100);
        Semaforos.purplefishCarBloqueiaBobEsponjaCar4.acquire();
        Semaforos.taxiCarBloqueiaBobEsponja2.acquire();
        movimentacaoSubida(-180);
        Semaforos.raceCarBloqueiaBobEsponja1.release();
        movimentacaoSubida(-190);
        Semaforos.sharkEntradaInicial.acquire();
        movimentacaoSubida(-250);
        Semaforos.taxiCarBloqueiaBobEsponja2.release();
        movimentacaoSubida(-360);
        carro.setRotate(90);
        movimentacaoHorizontalIda(50);
        Semaforos.redfishCarBloqueiaBobEsponja4.acquire();
        movimentacaoHorizontalIda(130);
        Semaforos.taxiCarBloqueiaBobEsponja4.acquire();
        movimentacaoHorizontalIda(170);
        carro.setRotate(180);
        movimentacaoDescida(-330);
        Semaforos.redfishCarBloqueiaBobEsponja4.release();
        Semaforos.sharkEntradaInicial.release();
        Semaforos.purplefishCarBloqueiaBobEsponjaCar4.release();
        Semaforos.spongebobPlankton1.release();
        movimentacaoDescida(-298);
        carro.setRotate(90);
        movimentacaoHorizontalIda(200);
        Semaforos.taxiCarBloqueiaBobEsponja4.release();
        movimentacaoHorizontalIda(210);
        Semaforos.spongebobPlankton2.acquire();
        Semaforos.sharkBloqueiaBobEsponja2.acquire();
        Semaforos.redfishCarBloqueiaBobEsponja1.acquire();
        Semaforos.purplefishCarBloqueiaBobEsponjaCar3.acquire();
        Semaforos.taxiCarBloqueiaBobEsponja5.acquire();
        movimentacaoHorizontalIda(248);
        carro.setRotate(0);
        movimentacaoSubida(-325);
        movimentacaoSubida(-360);
        carro.setRotate(90);
        movimentacaoHorizontalIda(280);
        Semaforos.taxiCarBloqueiaBobEsponja5.release();
        Semaforos.purplefishCarBloqueiaBobEsponjaCar3.release();
        Semaforos.redfishCarBloqueiaBobEsponja1.release();
        movimentacaoHorizontalIda(424);
        carro.setRotate(180);
        movimentacaoDescida(-260);
        Semaforos.taxiCarBloqueiaBobEsponja7.acquire();
        movimentacaoDescida(-200);
        Semaforos.spongebobPlankton2.release();
        Semaforos.sharkBloqueiaBobEsponja2.release();
        movimentacaoDescida(-180);
        Semaforos.raceCarSpongebob.acquire();
        movimentacaoDescida(-110);
        Semaforos.taxiCarBloqueiaBobEsponja7.release();
        movimentacaoDescida(-100);
        Semaforos.spongebobPlankton3.acquire();
        movimentacaoDescida(10);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(325);
        carro.setRotate(0);
        movimentacaoSubida(-15);
        Semaforos.spongebobPlankton3.release();
        Semaforos.raceCarSpongebob.release();
        movimentacaoSubida(-35);
        Semaforos.spongebobPlankton4.acquire();
        movimentacaoSubida(-110);
        Semaforos.raceCarBloqueiaBobEsponja3.acquire();
        Semaforos.taxiCarBloqueiaBobEsponja8.acquire();
        movimentacaoSubida(-139);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(280);
        Semaforos.redfishCarBloqueiaBobEsponja2.acquire();
        Semaforos.purplefishCarBloqueiaBobEsponjaCar2.acquire();
        movimentacaoHorizontalVolta(242);
        carro.setRotate(0);
        movimentacaoSubida(-180);
        Semaforos.taxiCarBloqueiaBobEsponja8.release();
        Semaforos.raceCarBloqueiaBobEsponja3.release();
        Semaforos.sharkBloqueiaBobEsponja1.acquire();
        movimentacaoSubida(-220);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(210);
        Semaforos.purplefishCarBloqueiaBobEsponjaCar2.release();
        Semaforos.redfishCarBloqueiaBobEsponja2.release();
        Semaforos.spongebobPlankton4.release();
        movimentacaoHorizontalVolta(165);
        carro.setRotate(180);
        movimentacaoDescida(-180);
        Semaforos.sharkBloqueiaBobEsponja1.release();
        Semaforos.raceCarBloqueiaBobEsponja2.acquire();
        Semaforos.purplefishCarBloqueiaBobEsponjaCar1.acquire();
        Semaforos.taxiCarBloqueiaBobEsponja1.acquire();
        movimentacaoDescida(-140);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(120);
        Semaforos.redfishCarBloqueiaBobEsponja3.acquire();
        movimentacaoHorizontalVolta(85);
        carro.setRotate(180);
        movimentacaoDescida(-105);
        Semaforos.taxiCarBloqueiaBobEsponja1.release();
        Semaforos.purplefishCarBloqueiaBobEsponjaCar1.release();
        Semaforos.raceCarBloqueiaBobEsponja2.release();
        movimentacaoDescida(-20);
        Semaforos.spongebobPlankton1.acquire();
        Semaforos.raceCarBloqueiaBobEsponja1.acquire();
        movimentacaoDescida(10);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(50);
        Semaforos.redfishCarBloqueiaBobEsponja3.release();
        movimentacaoHorizontalVolta(0);
        carro.setRotate(0);
      } catch (InterruptedException i) {
        i.getMessage();
      }//Fim do try-catch
    }//Fim do while
  }//Fim do metodo run
  
/* ***************************************************************
* Metodo: movimentacaoSubida
* Funcao: mover o carro de baixo para cima (vertical)
* Parametros: int posicaoDeParadaY = coordenada para que o carro pare no eixo Y
* Retorno: void
*************************************************************** */
  public void movimentacaoSubida (int posicaoDeParadaY){
    while(posicaoY != posicaoDeParadaY){
      try {
        Thread.sleep(velocidade);
      } catch (InterruptedException i) {
        i.getMessage();
      }//getVelocidade
      final int posicaoConstante = posicaoY;
      Platform.runLater( () -> carro.setY(posicaoConstante));
      posicaoY--;
    }//Fim do while
  }//Fim da movimentacaoSubida

/* ***************************************************************
* Metodo: movimentacaoDescida
* Funcao: mover o carro de cima para baixo (vertical)
* Parametros: int posicaoDeParadaY = coordenada para que o carro pare no eixo Y
* Retorno: void
*************************************************************** */
  public void movimentacaoDescida(int posicaoDeParadaY){
    while(posicaoY != posicaoDeParadaY){
      try {
        Thread.sleep(velocidade);
      } catch (InterruptedException i) {
        i.getMessage();
      }
      final int posicaoConstante = posicaoY;
      Platform.runLater( () -> carro.setY(posicaoConstante));
      posicaoY++;
    }//Fim do while
  }//Fim movimentacaoDescida

/* ***************************************************************
* Metodo: movimentacaoHorizontalIda
* Funcao: mover o carro da esquerda para direita (horizontal)
* Parametros: int posicaoDeParadaX = coordenada para que o carro pare no eixo X
* Retorno: void
*************************************************************** */
  public void movimentacaoHorizontalIda (int posicaoDeParadaX){
    while(posicaoX != posicaoDeParadaX){
      try {
        Thread.sleep(velocidade);
      } catch (InterruptedException i) {
        i.getMessage();
      }
      final int posicaoConstante = posicaoX;
      Platform.runLater( () -> carro.setX(posicaoConstante));
      posicaoX++;
    }
  }
  
/* ***************************************************************
* Metodo: movimentacaoHorizontalVolta
* Funcao: mover o carro da direita para esquerda (horizontal)
* Parametros: int posicaoDeParadaX = coordenada para que o carro pare no eixo X
* Retorno: void
*************************************************************** */
  public void movimentacaoHorizontalVolta (int posicaoDeParadaX){
    while(posicaoX != posicaoDeParadaX){
      try {
        Thread.sleep(velocidade);
      } catch (InterruptedException i) {
        i.getMessage();
      }
      final int posicaoConstante = posicaoX;
      Platform.runLater( () -> carro.setX(posicaoConstante));
      posicaoX--;
    }//Fim do while
  }//Fim do metodo movimentacaoHorizontalVolta

/* ***************************************************************
* Metodo: setVelocidade
* Funcao: guardar a velocidade do carro
* Parametros: int velocidade = valor para definir a velocidade do carro
* Retorno: void
*************************************************************** */
  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  }//Fim do metodo setVelocidade

/* ***************************************************************
* Metodo: getVelocidade
* Funcao: adquirir a velocidade do carro
* Parametros: void
* Retorno: int
*************************************************************** */
  public int getVelocidade() {
    return this.velocidade;
  }//Fim do metodo getVelocidade
}//Fim da classe ProcessoCarroDoBonEsponja
