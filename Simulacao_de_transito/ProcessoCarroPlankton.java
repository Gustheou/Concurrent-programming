/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 18/05/2022
* Ultima alteracao.: 22/05/2022
* Nome.............: ProcessoCarroPlankton
* Funcao...........: Controlar todo o funcionamento do carro do plankton
*************************************************************** */
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class ProcessoCarroPlankton extends Thread{
  private ImageView carro;
  ControleGeral cG;
  private int posicaoXo = 0;
  private int posicaoX = 0;
  private int posicaoYo = 0;
  private int posicaoY = 0;
  private int velocidade = 25;

  public ProcessoCarroPlankton (ControleGeral cG, int id){
    this.cG = new ControleGeral();
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
      Semaforos.sharkBloqueiaPlankton1.acquire();
      Semaforos.spongebobPlankton2.acquire();
    } catch (InterruptedException i) {
      System.out.println(i.getMessage());  
    }
    while (true){
      try {
        movimentacaoDescida(90);
        Semaforos.taxiCarBloqueiaPlankton4.acquire();
        movimentacaoDescida(135);
        carro.setRotate(270);
        Semaforos.spongebobPlankton2.release();
        movimentacaoHorizontalVolta(-140);
        Semaforos.spongebobPlankton4.acquire();
        Semaforos.redfishCarBloqueiaPlankton2.acquire();
        Semaforos.purplefishCarBloqueiaPlanktonCar1.acquire();
        movimentacaoHorizontalVolta(-180);
        carro.setRotate(180);
        movimentacaoDescida(175);
        Semaforos.taxiCarBloqueiaPlankton4.release();
        Semaforos.sharkBloqueiaPlankton1.release();
        Semaforos.raceCarBloqueiaPlankton1.acquire();
        movimentacaoDescida(180);
        Semaforos.taxiCarBloqueiaPlankton5.acquire();
        movimentacaoDescida(215);
        carro.setRotate(90);
        movimentacaoHorizontalIda(-140);
        Semaforos.purplefishCarBloqueiaPlanktonCar1.release();
        Semaforos.redfishCarBloqueiaPlankton2.release();
        movimentacaoHorizontalIda(-98);
        carro.setRotate(180);
        movimentacaoDescida(250);
        Semaforos.taxiCarBloqueiaPlankton5.release();
        Semaforos.raceCarBloqueiaPlankton1.release();
        movimentacaoDescida(290);
        carro.setRotate(90);
        movimentacaoHorizontalIda(-65);
        Semaforos.spongebobPlankton4.release();
        movimentacaoHorizontalIda(-40);
        Semaforos.raceCarPlankton.acquire();
        Semaforos.spongebobPlankton3.acquire();
        movimentacaoHorizontalIda(0);
        carro.setRotate(180);
        movimentacaoDescida(360);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(-70);
        Semaforos.spongebobPlankton3.release();
        movimentacaoHorizontalVolta(-140);
        Semaforos.taxiCarBloqueiaPlankton6.acquire();
        Semaforos.redfishCarBloqueiaPlankton3.acquire();
        movimentacaoHorizontalVolta(-182);
        carro.setRotate(0);
        movimentacaoSubida(325);
        Semaforos.raceCarPlankton.release();
        movimentacaoSubida(295);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(-215);
        Semaforos.redfishCarBloqueiaPlankton3.release();
        Semaforos.taxiCarBloqueiaPlankton6.release();
        movimentacaoHorizontalVolta(-220);
        Semaforos.taxiCarBloqueiaPlankton1.acquire();
        movimentacaoHorizontalVolta(-255);
        carro.setRotate(180);
        movimentacaoDescida(325);
        Semaforos.raceCarBloqueiaPlankton2.acquire();
        Semaforos.redfishCarBloqueiaPlankton4.acquire();
        movimentacaoDescida(360);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(-300);
        Semaforos.taxiCarBloqueiaPlankton1.release();
        Semaforos.spongebobPlankton1.acquire();
        movimentacaoHorizontalVolta(-375);
        Semaforos.redfishCarBloqueiaPlankton4.release();
        movimentacaoHorizontalVolta(-425);
        carro.setRotate(0);
        movimentacaoSubida(255);
        Semaforos.taxiCarBloqueiaPlankton2.acquire();
        Semaforos.purplefishCarBloqueiaPlanktonCar2.acquire();
        movimentacaoSubida(175);
        Semaforos.raceCarBloqueiaPlankton2.release();
        Semaforos.sharkBloqueiaPlankton1.acquire();
        movimentacaoSubida(100);
        Semaforos.taxiCarBloqueiaPlankton2.release();
        movimentacaoSubida(-6);
        carro.setRotate(90);
        movimentacaoHorizontalIda(-375);
        Semaforos.redfishCarBloqueiaPlankton1.acquire();
        movimentacaoHorizontalIda(-290);
        Semaforos.spongebobPlankton1.release();
        Semaforos.taxiCarBloqueiaPlankton3.acquire();
        movimentacaoHorizontalIda(-215);
        Semaforos.spongebobPlankton2.acquire();
        movimentacaoHorizontalIda(-135);
        Semaforos.taxiCarBloqueiaPlankton3.release();
        Semaforos.redfishCarBloqueiaPlankton1.release();
        Semaforos.purplefishCarBloqueiaPlanktonCar2.release();
        movimentacaoHorizontalIda(0);
        carro.setRotate(180);
      } catch (InterruptedException i) {
        System.out.println(i.getMessage());
      }
    }
  }

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
      }
      final int posicaoConstante = posicaoY;
      Platform.runLater( () -> carro.setY(posicaoConstante));
      posicaoY--;
    }
  }

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
    }
  }

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
    }
  }

/* ***************************************************************
* Metodo: getVelocidade
* Funcao: adquirir a velocidade do carro
* Parametros: void
* Retorno: int
*************************************************************** */
  public int getVelocidade() {
    return velocidade;
  }

/* ***************************************************************
* Metodo: setVelocidade
* Funcao: guardar a velocidade do carro
* Parametros: int velocidade = valor para definir a velocidade do carro
* Retorno: void
*************************************************************** */
  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  }
}
