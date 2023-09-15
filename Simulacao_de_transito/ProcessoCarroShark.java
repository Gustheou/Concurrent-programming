/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 18/05/2022
* Ultima alteracao.: 22/05/2022
* Nome.............: ProcessoCarroShark
* Funcao...........: Controlar todo o funcionamento do carro do tubarão
*************************************************************** */
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class ProcessoCarroShark extends Thread{
  private ImageView carro;
  ControleGeral cG;
  private int posicaoXo = 0;
  private int posicaoX = 0;
  private int posicaoYo = 0;
  private int posicaoY = 0;
  private int velocidade = 25;

  public ProcessoCarroShark (ControleGeral cG, int id){
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
      Semaforos.sharkEntradaInicial.acquire();
      Semaforos.purplefishCarBloqueiaSharkCar2.acquire();
      Semaforos.sharkBloqueiaPlankton1.acquire();
    } catch (InterruptedException i) {
      System.out.println(i.getMessage());
    }
    while (true){
      try {
        movimentacaoDescida(100);
        Semaforos.taxiCarBloqueiaSharkCar1.acquire();
        movimentacaoDescida(140);
        carro.setRotate(90);
        movimentacaoHorizontalIda(30);
        Semaforos.purplefishCarBloqueiaSharkCar2.release();
        Semaforos.sharkEntradaInicial.release();
        Semaforos.sharkBloqueiaPlankton1.release();
        movimentacaoHorizontalIda(45);
        Semaforos.redfishCarBloqueiaShark3.acquire();
        movimentacaoHorizontalIda(120);
        Semaforos.redfishCarBloqueiaShark3.release();
        movimentacaoHorizontalIda(130);
        Semaforos.sharkBloqueiaPlankton1.acquire();
        Semaforos.sharkBloqueiaBobEsponja1.acquire();
        movimentacaoHorizontalIda(195);
        Semaforos.taxiCarBloqueiaSharkCar1.release();
        movimentacaoHorizontalIda(200);
        Semaforos.redfishCarBloqueiaShark2.acquire();
        Semaforos.purplefishCarBloqueiaSharkCar1.acquire();
        Semaforos.taxiCarBloqueiaSharkCar3.acquire();
        movimentacaoHorizontalIda(280);
        Semaforos.purplefishCarBloqueiaSharkCar1.release();
        Semaforos.redfishCarBloqueiaShark2.release();
        movimentacaoHorizontalIda(285);
        Semaforos.sharkBloqueiaBobEsponja1.release();
        movimentacaoHorizontalIda(380);
        Semaforos.sharkBloqueiaBobEsponja2.acquire();
        movimentacaoHorizontalIda(418);
        carro.setRotate(0);
        movimentacaoSubida(105);
        Semaforos.taxiCarBloqueiaSharkCar3.release();
        movimentacaoSubida(0);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(290);
        Semaforos.purplefishCarBloqueiaSharkCar2.acquire();
        Semaforos.redfishCarBloqueiaShark1.acquire();
        Semaforos.taxiCarBloqueiaSharkCar2.acquire();
        movimentacaoHorizontalVolta(210);
        Semaforos.sharkBloqueiaBobEsponja2.release();
        Semaforos.sharkEntradaInicial.acquire();
        movimentacaoHorizontalVolta(130);
        Semaforos.taxiCarBloqueiaSharkCar2.release();
        movimentacaoHorizontalVolta(45);
        Semaforos.redfishCarBloqueiaShark1.release();
        movimentacaoHorizontalVolta(0);
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
* Metodo: setVelocidade
* Funcao: guardar a velocidade do carro
* Parametros: int velocidade = valor para definir a velocidade do carro
* Retorno: void
*************************************************************** */
  public void setVelocidade (int velocidade){
    this.velocidade = velocidade;
  }

/* ***************************************************************
* Metodo: getVelocidade
* Funcao: adquirir a velocidade do carro
* Parametros: void
* Retorno: int
*************************************************************** */
  public int getVelocidade () {
    return velocidade;
  }
}
