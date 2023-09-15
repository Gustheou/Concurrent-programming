/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 29/03/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: ProcessoConsomeBomba
* Funcao...........: O programa tem como funcao simular o "consumo" de bombas
*************************************************************** */
package Model;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import Controller.ControleGeral;
import Util.Buffer;

public class ProcessoConsomeBomba extends Thread{
  private int velocidadeDoBomberman = 25;
  private ImageView bombermanRunning;
  private ImageView bombermanCarrying;
  private ImageView bombermanThrowing;
  private ImageView bomb;
  private ImageView bombGif;

  private int posicaoXRunning = 130; //Posicao chegada = 136, carrying Inicial = 181 - 402, jogar a bomba = 402
  private int posicaoXCarrying = -150;
  private int id;
  
  private Buffer bufferCompartilhado = new Buffer();
  
  public ProcessoConsomeBomba(ControleGeral controle, int id, Buffer bufferCompartilhado){
  //id = 1, bomberman1, id = 2, bomberman2, id = 3, bomberman3
    setIdentificador(id);
    this.bombermanRunning = controle.getBombermanRunning(id);
    this.bombermanCarrying = controle.getBombermanCarrying(id);
    this.bombermanThrowing = controle.getBombThrowing(id);
    this.bomb = controle.getBomb();
    this.bombGif = controle.getBombGif();
    this.bufferCompartilhado = bufferCompartilhado;
  }

/* ***************************************************************
* Metodo: setIdentificador
* Funcao: guardar o valor do identificador
* Parametros: int id = valor que serve para identificar o consumidor
* Retorno: void
*************************************************************** */
  public void setIdentificador(int id) {
    this.id = id;
  }//Fim do metodo setIdentificador

/* ***************************************************************
* Metodo: getIdentificador
* Funcao: adquirir o identificador referente ao consumidor
* Parametros: void
* Retorno: int
*************************************************************** */
  public int getIdentificador(){
    return this.id;
  }//Fim do metodo getIdentificador
  
/* ***************************************************************
* Metodo: run
* Funcao: Inicializar a thread
* Parametros: void
* Retorno: void
*************************************************************** */
  @Override
  public void run(){
    try{
      while (true){
        //Verificar qual consumidor foi escolhido
        if (getIdentificador() == 1){
          bombermanRunning.setVisible(true);
        }else if (getIdentificador() == 2){
          Thread.sleep(9000);
          bombermanRunning.setVisible(true);
        }else if (getIdentificador() == 3){
          Thread.sleep(18000);
          bombermanRunning.setVisible(true);
        }
        movimentacaoDoEixoXPegarBomba();
        this.bufferCompartilhado.consumir();
        movimentacaoDoEixoXLevarBomba();
        posicaoXRunning = 130;
        posicaoXCarrying = -150;
        Platform.runLater(() -> bombermanRunning.setX(130));
      }        
    }catch(InterruptedException i){
      i.getMessage();
    }//Fim do try-catch
  }//Fim do metodo run

/* ***************************************************************
* Metodo: movimentacaoDoEixoXPegarBomba
* Funcao: Fazer a animacao do bomberman ir pegar a bomba
* Parametros: void
* Retorno: void
*************************************************************** */
  public void movimentacaoDoEixoXPegarBomba() throws InterruptedException{
    int posicaoDeParadaDoBomberman = -50;
    while(posicaoXRunning != posicaoDeParadaDoBomberman){
      Thread.sleep(getVelocidadeDoBomberman());
      final int posicaoConstante = posicaoXRunning;
      Platform.runLater( () -> bombermanRunning.setX(posicaoConstante));
      posicaoXRunning--;
    }//Fim do while
    bombermanRunning.setVisible(false);
    bomb.setVisible(false);
    bombermanCarrying.setVisible(true);
  }//Fim do metodo movimentacaoDoEixoXPegarBomba

/* ***************************************************************
* Metodo: movimentacaoDoEixoXLevarBomba
* Funcao: Fazer a animacao do bomberman levar a bomba
* Parametros: void
* Retorno: void
*************************************************************** */
  public void movimentacaoDoEixoXLevarBomba() throws InterruptedException{
    int posicaoDeParadaDoBomberman = 100;
    while(posicaoXCarrying != posicaoDeParadaDoBomberman){
      Thread.sleep(getVelocidadeDoBomberman());
      final int posicaoConstante = posicaoXCarrying;
      Platform.runLater( () -> bombermanCarrying.setX(posicaoConstante));
      posicaoXCarrying++;
    }//Fim do while
    bombermanCarrying.setVisible(false);
    bombermanThrowing.setVisible(true);
    Thread.sleep(800);
    bombermanThrowing.setVisible(false);
    bombGif.setVisible(true);
    Thread.sleep(1800);
    bombGif.setVisible(false);
  }//Fim do metodo movimentacaoDoEixoXLevarBomba

/* ***************************************************************
* Metodo: getVelocidadeDoBomberman
* Funcao: adquirir a velocidade do bomberman
* Parametros: void
* Retorno: void
*************************************************************** */
  public int getVelocidadeDoBomberman() {
    return velocidadeDoBomberman;
  }//Fim do metodo getVelocidadeDoBomberman

/* ***************************************************************
* Metodo: setVelocidadeDoBomberman
* Funcao: guardar a velocidade do bomberman
* Parametros: int velocidadeDoBomberman = valor para definir a velocidade atual do bomberman
* Retorno: void
*************************************************************** */
  public void setVelocidadeDoBomberman(int velocidadeDoBomberman) {
    this.velocidadeDoBomberman = velocidadeDoBomberman;
  }//Fim do metodo setVelocidadeDoBomberman
}//Fim da classe ProcessoConsomeBomba
