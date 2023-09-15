/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 18/05/2022
* Ultima alteracao.: 22/05/2022
* Nome.............: ProcessoCarroFishPurple
* Funcao...........: Controlar todo o funcionamento do carro do peixe roxo
*************************************************************** */
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class ProcessoCarroFishPurple extends Thread{
  private ImageView carro;
  ControleGeral cG;
  private int posicaoXo = 0;
  private int posicaoX = 0;
  private int posicaoYo = 0;
  private int posicaoY = 0;
  private int velocidade = 25;

  public ProcessoCarroFishPurple (ControleGeral cG, int id){
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
      Semaforos.purplefishCarBloqueiaRaceCar.acquire();
      Semaforos.purplefishCarBloqueiaPlanktonCar2.acquire();
      Semaforos.purplefishCarBloqueiaBobEsponjaCar4.acquire();
      Semaforos.taxiCarBloqueiaPurplefishCar1.acquire();
    } catch (InterruptedException i) {
      System.out.println(i.getMessage());
    }
    while (true){
      try {
        movimentacaoHorizontalIda(30);
        Semaforos.purplefishCarBloqueiaBobEsponjaCar4.release();
        Semaforos.purplefishCarBloqueiaPlanktonCar2.release();
        movimentacaoHorizontalIda(40);
        Semaforos.purplefishCarBloqueiaRedfishCar1.acquire();
        Semaforos.purplefishCarBloqueiaBobEsponjaCar1.acquire();
        movimentacaoHorizontalIda(115);
        Semaforos.purplefishCarBloqueiaRedfishCar1.release();
        movimentacaoHorizontalIda(195);
        Semaforos.purplefishCarBloqueiaBobEsponjaCar1.release();
        movimentacaoHorizontalIda(200);
        Semaforos.taxiCarBloqueiaPurplefishCar1.release();
        Semaforos.purplefishCarBloqueiaBobEsponjaCar2.acquire();
        Semaforos.purplefishCarBloqueiaRedfishCar2.acquire();
        Semaforos.purplefishCarBloqueiaPlanktonCar1.acquire();
        movimentacaoHorizontalIda(201);
        Semaforos.taxiCarBloqueiaPurplefishCar2.acquire();
        movimentacaoHorizontalIda(240);
        carro.setRotate(0);
        movimentacaoSubida(-35);
        Semaforos.taxiCarBloqueiaPurplefishCar2.release();
        Semaforos.purplefishCarBloqueiaRaceCar.release();
        movimentacaoSubida(-40);
        Semaforos.taxiCarBloqueiaPurplefishCar3.acquire();
        Semaforos.purplefishCarBloqueiaSharkCar1.acquire();
        movimentacaoSubida(-120);
        Semaforos.purplefishCarBloqueiaPlanktonCar1.release();
        Semaforos.purplefishCarBloqueiaSharkCar1.release();
        Semaforos.purplefishCarBloqueiaBobEsponjaCar2.release();
        movimentacaoSubida(-130);
        Semaforos.purplefishCarBloqueiaBobEsponjaCar3.acquire();
        movimentacaoSubida(-180);
        Semaforos.purplefishCarBloqueiaSharkCar2.acquire();
        Semaforos.purplefishCarBloqueiaPlanktonCar2.acquire();
        movimentacaoSubida(-225);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(210);
        Semaforos.purplefishCarBloqueiaBobEsponjaCar3.release();
        movimentacaoHorizontalVolta(205);
        Semaforos.purplefishCarBloqueiaBobEsponjaCar4.acquire();
        movimentacaoHorizontalVolta(130);
        Semaforos.taxiCarBloqueiaPurplefishCar3.release();
        movimentacaoHorizontalVolta(45);
        Semaforos.purplefishCarBloqueiaRedfishCar2.release();
        movimentacaoHorizontalVolta(0);
        carro.setRotate(180);
        movimentacaoDescida(-130);
        Semaforos.taxiCarBloqueiaPurplefishCar1.acquire();
        movimentacaoDescida(-40);
        Semaforos.purplefishCarBloqueiaSharkCar2.release();
        Semaforos.purplefishCarBloqueiaRaceCar.acquire();
        movimentacaoDescida(0);
        carro.setRotate(90);
      } catch (InterruptedException i) {
        i.getMessage();
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
  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
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

  
}
