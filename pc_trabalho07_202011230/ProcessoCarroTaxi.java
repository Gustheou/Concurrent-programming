/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 18/05/2022
* Ultima alteracao.: 22/05/2022
* Nome.............: ProcessoCarroTaxi
* Funcao...........: Controlar todo o funcionamento do carro taxi
*************************************************************** */
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class ProcessoCarroTaxi extends Thread{
  private ImageView carro;
  ControleGeral cG;
  private int posicaoXo = 0;
  private int posicaoX = 0;
  private int posicaoYo = 0;
  private int posicaoY = 0;
  private int velocidade = 25;

  public ProcessoCarroTaxi (ControleGeral cG, int id){
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
      Semaforos.taxiCarBloqueiaPlankton1.acquire();
      Semaforos.taxiCarBloqueiaRedfishcar4.acquire();
      Semaforos.taxiCarBloqueiaRaceCar1.acquire();
    } catch (InterruptedException e) {
      System.out.println(e.getMessage()); 
    }
    while (true){
      try {
        movimentacaoSubida(-25);
        Semaforos.taxiCarBloqueiaRaceCar1.release();
        Semaforos.taxiCarBloqueiaRedfishcar4.release();
        movimentacaoSubida(-95);
        Semaforos.taxiCarBloqueiaPlankton1.release();
        Semaforos.taxiCarBloqueiaBobEsponja1.acquire();
        Semaforos.taxiCarBloqueiaPurplefishCar1.acquire();
        Semaforos.taxiCarBloqueiaRaceCar2.acquire();
        movimentacaoSubida(-135);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(-40);
        Semaforos.taxiCarBloqueiaRedfishcar1.acquire();
        movimentacaoHorizontalVolta(-125);
        Semaforos.taxiCarBloqueiaRedfishcar1.release();
        Semaforos.taxiCarBloqueiaBobEsponja1.release();
        Semaforos.taxiCarBloqueiaPlankton2.acquire();
        Semaforos.taxiCarBloqueiaBobEsponja2.acquire();
        movimentacaoHorizontalVolta(-165);
        carro.setRotate(0);
        movimentacaoSubida(-170);
        Semaforos.taxiCarBloqueiaRaceCar2.release();
        Semaforos.taxiCarBloqueiaSharkCar1.acquire();
        movimentacaoSubida(-215);
        carro.setRotate(90);
        movimentacaoHorizontalIda(-125);
        Semaforos.taxiCarBloqueiaBobEsponja2.release();
        Semaforos.taxiCarBloqueiaPlankton2.release();
        Semaforos.taxiCarBloqueiaPurplefishCar1.release();
        movimentacaoHorizontalIda(-120);
        Semaforos.taxiCarBloqueiaRedfishcar2.acquire();
        movimentacaoHorizontalIda(-40);
        Semaforos.taxiCarBloqueiaRedfishcar2.release();
        Semaforos.taxiCarBloqueiaBobEsponja3.acquire();
        movimentacaoHorizontalIda(0);
        carro.setRotate(0);
        movimentacaoSubida(-250);
        Semaforos.taxiCarBloqueiaBobEsponja3.release();
        Semaforos.taxiCarBloqueiaSharkCar1.release();
        movimentacaoSubida(-255);
        Semaforos.taxiCarBloqueiaPurplefishCar3.acquire();
        Semaforos.taxiCarBloqueiaRedfishcar3.acquire();
        Semaforos.taxiCarBloqueiaSharkCar2.acquire();
        Semaforos.taxiCarBloqueiaPlankton3.acquire();
        Semaforos.taxiCarBloqueiaBobEsponja4.acquire();
        movimentacaoSubida(-357);
        carro.setRotate(90);
        movimentacaoHorizontalIda(39);
        Semaforos.taxiCarBloqueiaBobEsponja4.release();
        movimentacaoHorizontalIda(40);
        Semaforos.taxiCarBloqueiaBobEsponja5.acquire();
        movimentacaoHorizontalIda(80);
        carro.setRotate(180);
        movimentacaoDescida(-315);
        Semaforos.taxiCarBloqueiaPlankton3.release();
        Semaforos.taxiCarBloqueiaSharkCar2.release();
        movimentacaoDescida(-255);
        Semaforos.taxiCarBloqueiaBobEsponja5.release();
        Semaforos.taxiCarBloqueiaSharkCar3.acquire();
        Semaforos.taxiCarBloqueiaPlankton4.acquire();
        movimentacaoDescida(-250);
        Semaforos.taxiCarBloqueiaBobEsponja6.acquire();
        movimentacaoDescida(-215);
        carro.setRotate(90);
        movimentacaoHorizontalIda(120);
        Semaforos.taxiCarBloqueiaBobEsponja6.release();
        Semaforos.taxiCarBloqueiaRedfishcar3.release();
        Semaforos.taxiCarBloqueiaPurplefishCar3.release();
        movimentacaoHorizontalIda(215);
        Semaforos.taxiCarBloqueiaBobEsponja7.acquire();
        movimentacaoHorizontalIda(260);
        carro.setRotate(180);
        movimentacaoDescida(-180);
        Semaforos.taxiCarBloqueiaPlankton4.release();
        Semaforos.taxiCarBloqueiaSharkCar3.release();
        Semaforos.taxiCarBloqueiaRaceCar3.acquire();
        movimentacaoDescida(-135);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(215);
        Semaforos.taxiCarBloqueiaBobEsponja7.release();
        movimentacaoHorizontalVolta(205);
        Semaforos.taxiCarBloqueiaPlankton5.acquire();
        Semaforos.taxiCarBloqueiaBobEsponja8.acquire();
        movimentacaoHorizontalVolta(120);
        Semaforos.taxiCarBloqueiaRedfishcar4.acquire();
        Semaforos.taxiCarBloqueiaPurplefishCar2.acquire();
        movimentacaoHorizontalVolta(80);
        carro.setRotate(180);
        movimentacaoDescida(-100);
        Semaforos.taxiCarBloqueiaPurplefishCar2.release();
        Semaforos.taxiCarBloqueiaBobEsponja8.release();
        Semaforos.taxiCarBloqueiaPlankton5.release();
        Semaforos.taxiCarBloqueiaRaceCar3.release();
        movimentacaoDescida(-95);
        Semaforos.taxiCarBloqueiaPlankton6.acquire();
        movimentacaoDescida(-20);
        Semaforos.taxiCarBloqueiaRaceCar1.acquire();
        movimentacaoDescida(13);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(45);
        Semaforos.taxiCarBloqueiaPlankton6.release();
        movimentacaoHorizontalVolta(40);
        Semaforos.taxiCarBloqueiaPlankton1.acquire();
        movimentacaoHorizontalVolta(0);
        carro.setRotate(0);
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
