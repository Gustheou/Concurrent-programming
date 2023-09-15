/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 18/05/2022
* Ultima alteracao.: 22/05/2022
* Nome.............: ProcessoCarroCorrida
* Funcao...........: Controlar todo o funcionamento do carro do patrick(corrida)
*************************************************************** */
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class ProcessoCarroCorrida extends Thread{
  private ImageView carro;
  ControleGeral cG;
  private int posicaoXo = 0;
  private int posicaoX = 0;
  private int posicaoYo = 0;
  private int posicaoY = 0;
  private int velocidade = 25;

  public ProcessoCarroCorrida (ControleGeral cG, int id){
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
      Semaforos.raceCarSpongebob.acquire();
      Semaforos.raceCarPlankton.acquire();
    } catch (InterruptedException i) {
      System.out.println(i.getMessage());
    }
    while (true){
      try {
        movimentacaoHorizontalVolta(-140);
        Semaforos.raceCarSpongebob.release();
        Semaforos.redfishCarBloqueiaRace2.acquire();
        Semaforos.taxiCarBloqueiaRaceCar1.acquire();
        movimentacaoHorizontalVolta(-215);
        Semaforos.raceCarPlankton.release();
        movimentacaoHorizontalVolta(-220);
        Semaforos.raceCarBloqueiaPlankton2.acquire();
        movimentacaoHorizontalVolta(-290);
        Semaforos.taxiCarBloqueiaRaceCar1.release();
        movimentacaoHorizontalVolta(-300);
        Semaforos.raceCarBloqueiaBobEsponja1.acquire();
        movimentacaoHorizontalVolta(-370);
        Semaforos.redfishCarBloqueiaRace2.release();
        movimentacaoHorizontalVolta(-420);
        carro.setRotate(0);
        movimentacaoSubida(-110);
        Semaforos.purplefishCarBloqueiaRaceCar.acquire();
        Semaforos.taxiCarBloqueiaRaceCar2.acquire();
        movimentacaoSubida(-145);
        carro.setRotate(90);
        movimentacaoHorizontalIda(-390);
        Semaforos.raceCarBloqueiaBobEsponja1.release();
        Semaforos.raceCarBloqueiaPlankton2.release();
        movimentacaoHorizontalIda(-380);
        Semaforos.raceCarBloqueiaBobEsponja2.acquire();
        Semaforos.redfishCarBloqueiaRace3.acquire();
        movimentacaoHorizontalIda(-300);
        Semaforos.redfishCarBloqueiaRace3.release();
        movimentacaoHorizontalIda(-220);
        Semaforos.raceCarBloqueiaBobEsponja2.release();
        Semaforos.taxiCarBloqueiaRaceCar2.release();
        movimentacaoHorizontalIda(-215);
        Semaforos.raceCarBloqueiaBobEsponja3.acquire();
        Semaforos.raceCarBloqueiaPlankton1.acquire();
        Semaforos.redfishCarBloqueiaRace1.acquire();
        Semaforos.taxiCarBloqueiaRaceCar3.acquire();
        movimentacaoHorizontalIda(-140);
        Semaforos.redfishCarBloqueiaRace1.release();
        Semaforos.purplefishCarBloqueiaRaceCar.release();
        movimentacaoHorizontalIda(-60);
        Semaforos.raceCarBloqueiaPlankton1.release();
        Semaforos.raceCarBloqueiaBobEsponja3.release();
        movimentacaoHorizontalIda(-40);
        Semaforos.raceCarSpongebob.acquire();
        Semaforos.raceCarPlankton.acquire();

        movimentacaoHorizontalIda(0);
        carro.setRotate(180);
        movimentacaoDescida(-110);
        Semaforos.taxiCarBloqueiaRaceCar3.release();
        movimentacaoDescida(0);
        carro.setRotate(270);
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
