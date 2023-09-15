/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 18/05/2022
* Ultima alteracao.: 22/05/2022
* Nome.............: ProcessoCarroFishRed
* Funcao...........: Controlar todo o funcionamento do carro do peixe vermelho
*************************************************************** */
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class ProcessoCarroFishRed extends Thread{
  private ImageView carro;
  ControleGeral cG;
  private int posicaoXo = 0;
  private int posicaoX = 0;
  private int posicaoYo = 0;
  private int posicaoY = 0;
  private int velocidade = 25;

  public ProcessoCarroFishRed (ControleGeral cG, int id){
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
      Semaforos.purplefishCarBloqueiaRedfishCar2.acquire();
      Semaforos.redfishCarBloqueiaShark1.acquire();
      Semaforos.redfishCarBloqueiaBobEsponja1.acquire();
      Semaforos.redfishCarBloqueiaPlankton1.acquire();
      Semaforos.taxiCarBloqueiaRedfishcar3.acquire();
    } catch (InterruptedException i) {
      System.out.println(i.getMessage());
    }
    while (true){
      try {
        movimentacaoDescida(35);
        Semaforos.redfishCarBloqueiaPlankton1.release();
        Semaforos.redfishCarBloqueiaShark1.release();
        movimentacaoDescida(100);
        Semaforos.redfishCarBloqueiaBobEsponja1.release();
        Semaforos.redfishCarBloqueiaBobEsponja2.acquire();
        Semaforos.redfishCarBloqueiaPlankton2.acquire();
        Semaforos.redfishCarBloqueiaShark2.acquire();
        movimentacaoDescida(180);
        Semaforos.redfishCarBloqueiaShark2.release();
        Semaforos.taxiCarBloqueiaRedfishcar3.release();
        movimentacaoDescida(185);
        Semaforos.taxiCarBloqueiaRedfishcar4.acquire();
        Semaforos.redfishCarBloqueiaRace1.acquire();
        movimentacaoDescida(255);
        Semaforos.redfishCarBloqueiaRace1.release();
        Semaforos.redfishCarBloqueiaPlankton2.release();
        Semaforos.redfishCarBloqueiaBobEsponja2.release();
        Semaforos.purplefishCarBloqueiaRedfishCar2.release();
        movimentacaoDescida(265);
        Semaforos.redfishCarBloqueiaPlankton3.acquire();
        movimentacaoDescida(330);
        Semaforos.redfishCarBloqueiaRace2.acquire();
        movimentacaoDescida(370);
        carro.setRotate(270);
        movimentacaoHorizontalVolta(-40);
        Semaforos.redfishCarBloqueiaPlankton3.release();
        movimentacaoHorizontalVolta(-45);
        Semaforos.redfishCarBloqueiaPlankton4.acquire();
        movimentacaoHorizontalVolta(-115);
        Semaforos.taxiCarBloqueiaRedfishcar4.release();
        movimentacaoHorizontalVolta(-120);
        Semaforos.redfishCarBloqueiaBobEsponja3.acquire();
        movimentacaoHorizontalVolta(-160);
        carro.setRotate(0);
        movimentacaoSubida(330);
        Semaforos.redfishCarBloqueiaPlankton4.release();
        Semaforos.redfishCarBloqueiaRace2.release();
        movimentacaoSubida(260);
        Semaforos.redfishCarBloqueiaRace3.acquire();
        Semaforos.taxiCarBloqueiaRedfishcar1.acquire();
        movimentacaoSubida(255);
        Semaforos.purplefishCarBloqueiaRedfishCar1.acquire();
        movimentacaoSubida(185);
        Semaforos.taxiCarBloqueiaRedfishcar1.release();
        Semaforos.redfishCarBloqueiaRace3.release();
        Semaforos.purplefishCarBloqueiaRedfishCar1.release();
        movimentacaoSubida(180);
        Semaforos.taxiCarBloqueiaRedfishcar2.acquire();
        Semaforos.redfishCarBloqueiaBobEsponja3.release();
        Semaforos.redfishCarBloqueiaShark3.acquire();
        movimentacaoSubida(105);
        Semaforos.redfishCarBloqueiaShark3.release();
        Semaforos.taxiCarBloqueiaRedfishcar2.release();
        movimentacaoSubida(40);
        Semaforos.redfishCarBloqueiaPlankton1.acquire();
        Semaforos.redfishCarBloqueiaShark1.acquire();
        Semaforos.redfishCarBloqueiaBobEsponja4.acquire();
        Semaforos.purplefishCarBloqueiaRedfishCar2.acquire();
        Semaforos.taxiCarBloqueiaRedfishcar3.acquire();
        movimentacaoSubida(0);
        carro.setRotate(90);
        movimentacaoHorizontalIda(-40);
        Semaforos.redfishCarBloqueiaBobEsponja4.release();
        Semaforos.redfishCarBloqueiaBobEsponja1.acquire();
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
      }//getVelocidade
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
      }//getVelocidade
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
      }//getVelocidade
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
      }//getVelocidade
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
