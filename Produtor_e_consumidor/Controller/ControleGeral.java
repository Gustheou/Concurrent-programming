/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 30/03/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: ControleGeral
* Funcao...........: Controlar as threads, imagens, etc
*************************************************************** */
package Controller;
import java.util.concurrent.Semaphore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import Model.*;
import Util.Buffer;

public class ControleGeral {

  @FXML
  private ImageView bombExplode;
  @FXML
  private ImageView bombaProduzida;
  @FXML
  private ImageView bombermanCarrying1;
  @FXML
  private ImageView bombermanCarrying2;
  @FXML
  private ImageView bombermanCarrying3;
  @FXML
  private ImageView bombermanRunning1;
  @FXML
  private ImageView bombermanRunning2;
  @FXML
  private ImageView bombermanRunning3;
  @FXML
  private ImageView bombermanThrowing1;
  @FXML
  private ImageView bombermanThrowing2;
  @FXML
  private ImageView bombermanThrowing3;

  @FXML
  private Button inicializarButton;
  @FXML
  private Button velocidadeDaBombaDownButton;
  @FXML
  private Button velocidadeDaBombaUpButton;
  @FXML
  private Button velocidadeDoBombermanDownButton;
  @FXML
  private Button velocidadeDoBombermanUpButton;

  @FXML
  private TextField velocidadeDaBombaTextField;
  @FXML
  private TextField VelocidadeDoBombermanTextField;

  private ProcessoProduzBomba processoProduzBomba;
  private ProcessoConsomeBomba processoConsomeBomba1;
  private ProcessoConsomeBomba processoConsomeBomba2;
  private ProcessoConsomeBomba processoConsomeBomba3;

  int numeroDePermissoes = 1;
  Semaphore vazio = new Semaphore(0);
  Semaphore mutex = new Semaphore(numeroDePermissoes);
  Semaphore cheio = new Semaphore (1);
  Buffer bufferCompartilhado = new Buffer();

/* ***************************************************************
* Metodo: getBomb
* Funcao: guardar a imagem da bomba que serao utilizadas nas threads
* Parametros: void
* Retorno: ImageView
*************************************************************** */
  public ImageView getBomb(){
    return this.bombaProduzida;
  }// Fim do metodo getBomb

/* ***************************************************************
* Metodo: getBombGif
* Funcao: guardar a imagem da bomba que explode (gif)
* Parametros: void
* Retorno: ImageView
*************************************************************** */
  public ImageView getBombGif(){
    return this.bombExplode;
  }//Fim do metodo getGif

/* ***************************************************************
* Metodo: getBombermanRunning
* Funcao: Definir qual consumidor recebera a imagem guardada para ir em direcao do produto
* Parametros: int id = identificador para o consumidor da thread
* Retorno: ImageView
*************************************************************** */
  public ImageView getBombermanRunning(int id){
    switch (id) {
      case 1: {
        return this.bombermanRunning1;
      }
      case 2: {
        return this.bombermanRunning2;
      }
      case 3: {
        return this.bombermanRunning3;
      }
      default: {
        return null;
      }
    }
  }//Fim do metodo getBombermanRunning

/* ***************************************************************
* Metodo: getBombermanCarrying
* Funcao: Definir qual consumidor recebera a imagem guardada para carregar o produto
* Parametros: int id = identificador para o consumidor da thread
* Retorno: ImageView
*************************************************************** */
  public ImageView getBombermanCarrying(int id){
    switch (id) {
      case 1: {
        return bombermanCarrying1;
      }
      case 2: {
        return bombermanCarrying2;
      }
      case 3: {
        return bombermanCarrying3;
      }
      default: {
        return null;
      }
    }
  }// Fim do metodo getBombermanCarrying

/* ***************************************************************
* Metodo: getBombThrowing
* Funcao: Definir qual consumidor recebera a imagem guardada para jogar o produto
* Parametros: int id = identificador para o consumidor da thread
* Retorno: ImageView
*************************************************************** */
  public ImageView getBombThrowing(int id){
    switch (id) {
      case 1: {
        return bombermanThrowing1;
      }
      case 2: {
        return bombermanThrowing2;
      }
      case 3: {
        return bombermanThrowing3;
      }
      default: {
        return null;
      }
    }
  }// Fim do metodo getBombThrowing

/* ***************************************************************
* Metodo: inicializarButton
* Funcao: Quando acionado o botao, o programa inicia
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  public void inicializarButton(ActionEvent event) {
    mostrarBotoesEOcultarCena();
    bombaProduzida.setX(-100);
    bombermanRunning1.setX(553);
    bombermanRunning2.setX(553);
    bombermanRunning3.setX(553);
    
    processoConsomeBomba1 = new ProcessoConsomeBomba(this, 1, bufferCompartilhado);
    processoConsomeBomba2 = new ProcessoConsomeBomba(this, 2, bufferCompartilhado);
    processoConsomeBomba3 = new ProcessoConsomeBomba(this, 3, bufferCompartilhado);
    processoProduzBomba = new ProcessoProduzBomba(this, bufferCompartilhado);

    processoProduzBomba.start();
    processoConsomeBomba1.start();
    processoConsomeBomba2.start();
    processoConsomeBomba3.start();
  }//Fim do metodo inicializarButton

/* ***************************************************************
* Metodo: velocidadeDaBombaDownButton
* Funcao: diminuir a velocidade da bomba
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  public void velocidadeDaBombaDownButton(ActionEvent event) {
    int velocidade = processoProduzBomba.getVelocidadeDaBomba();
    velocidade += 5;
    if(velocidade <= 25){
      processoProduzBomba.setVelocidadeDaBomba(velocidade);
    }//Fim do if
  }//Fim do metodo velocidadeDaBombaDownButton

/* ***************************************************************
* Metodo: velocidadeDaBombaUpButton
* Funcao: aumentar a velocidade da bomba
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  public void velocidadeDaBombaUpButton(ActionEvent event) {
    int velocidade = processoProduzBomba.getVelocidadeDaBomba();
    velocidade -= 5;
    if(velocidade >= 5){
      processoProduzBomba.setVelocidadeDaBomba(velocidade);
    }//Fim do if
  }//Fim do metodo velocidadeDaBombaUpButton

/* ***************************************************************
* Metodo: velocidadeDoBombermanDownButton
* Funcao: diminuir a velocidade do bomberman
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  public void velocidadeDoBombermanDownButton(ActionEvent event) {
    int velocidade = processoConsomeBomba1.getVelocidadeDoBomberman();
    velocidade += 5;
    if(velocidade <= 25){
      processoConsomeBomba1.setVelocidadeDoBomberman(velocidade);
      processoConsomeBomba2.setVelocidadeDoBomberman(velocidade);
      processoConsomeBomba3.setVelocidadeDoBomberman(velocidade);
    }//Fim do if
  }//Fim do metodo velocidadeDoBombermanDownButton

/* ***************************************************************
* Metodo: velocidadeDoBombermanUpButton
* Funcao: aumentar a velocidade da bomba
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  public void velocidadeDoBombermanUpButton(ActionEvent event) {
    int velocidade = processoConsomeBomba1.getVelocidadeDoBomberman();
    velocidade -= 5;
    if(velocidade >= 5){
      processoConsomeBomba1.setVelocidadeDoBomberman(velocidade);
      processoConsomeBomba2.setVelocidadeDoBomberman(velocidade);
      processoConsomeBomba3.setVelocidadeDoBomberman(velocidade);
    }//Fim do if
  }//Fim do metodo velocidadeDoBombermanUpButton

  public void mostrarBotoesEOcultarCena(){
    inicializarButton.setVisible(false);
    velocidadeDaBombaTextField.setVisible(true);
    VelocidadeDoBombermanTextField.setVisible(true);
    velocidadeDaBombaDownButton.setVisible(true);
    velocidadeDaBombaUpButton.setVisible(true);
    velocidadeDoBombermanUpButton.setVisible(true);
    velocidadeDoBombermanDownButton.setVisible(true);
    bombExplode.setVisible(false);
    bombermanCarrying1.setVisible(false);
    bombermanRunning1.setVisible(false);
    bombermanThrowing1.setVisible(false);
  }
}//Fim da classe ControleGeral
