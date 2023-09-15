/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 17/05/2022
* Ultima alteracao.: 22/05/2022
* Nome.............: ControleGeral
* Funcao...........: Controlar todo o funcionamento do transito
*************************************************************** */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ControleGeral {

  @FXML
  private Button iniciarButton;
  
  @FXML
  private Label labelText;

  @FXML
  private ImageView carroBobEsponja; //P01
  @FXML
  private ImageView carroPlankton; //P03
  @FXML
  private ImageView carroShark; //P07
  @FXML
  private ImageView carroCorrida; //P10
  @FXML
  private ImageView carroFishRed; //P12
  @FXML
  private ImageView carroFishPurple; //P15
  @FXML
  private ImageView carroTaxi; //P19

  @FXML
  private ImageView semaforo;

/* ***************************************************************
* Metodo: getImagemVeiculo
* Funcao: retornar a imagem ao referente "carro"
* Parametros: int id = Identificacao do carro que recebera a imagem
* Retorno: ImageView
*************************************************************** */
  public ImageView getImageVeiculo(int id) {
    switch (id) {
      case 0: {// Carro do bob esponja
        return carroBobEsponja;
      }
      case 1: {// Carro do plankton
        return carroPlankton;
      }
      case 2: {// Carro do tubarao
        return carroShark;
      }
      case 3: {// Carro de corrida
        return carroCorrida;
      }
      case 4: {// Carro do peixe vermelho
        return carroFishRed;
      }
      case 5: {// Carro do peixe roxo
        return carroFishPurple;
      }
      case 6: {// Carro do taxista
        return carroTaxi;
      }
      default: {
        return null;
      }
    }
  }

  ProcessoCarroDoBobEsponja pCBE;
  ProcessoCarroPlankton pCP;
  ProcessoCarroShark pCS;
  ProcessoCarroCorrida pCC;
  ProcessoCarroFishRed pCFR;
  ProcessoCarroFishPurple pCFP;
  ProcessoCarroTaxi pCT;

/* ***************************************************************
* Metodo: inicializarButton
* Funcao: Quando acionado o botao, o programa inicia
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void iniciarButton(ActionEvent event) {
    iniciarButton.setVisible(false);
    labelText.setVisible(false);
    semaforo.setVisible(true);
    pCBE = new ProcessoCarroDoBobEsponja(this, 0);
    pCP = new ProcessoCarroPlankton(this, 1);
    pCS = new ProcessoCarroShark(this, 2);
    pCC = new ProcessoCarroCorrida(this, 3);
    pCFR = new ProcessoCarroFishRed(this, 4);
    pCFP = new ProcessoCarroFishPurple(this, 5);
    pCT = new ProcessoCarroTaxi(this, 6);
    pCBE.start();
    pCP.start();
    pCS.start();
    pCC.start();
    pCFR.start();
    pCFP.start();
    pCT.start();
  }
  
/* ***************************************************************
* Metodo: aumentarVelocidadeSpongebob
* Funcao: Quando acionado o botao, a velocidade do carro eh aumentada
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void aumentarVelocidadeSpongebob(ActionEvent event) {
    int velocidade = pCBE.getVelocidade();
    velocidade -= 5;
    if(velocidade >= 5){
      pCBE.setVelocidade(velocidade);
    }
  }

/* ***************************************************************
* Metodo: aumentarVelocidadePlankton
* Funcao: Quando acionado o botao, a velocidade do carro eh aumentada
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
    @FXML
  void aumentarVelocidadePlankton(ActionEvent event) {
    int velocidade = pCP.getVelocidade();
    velocidade -= 5;
    if(velocidade >= 5){
      pCP.setVelocidade(velocidade);
    }
  }
  
/* ***************************************************************
* Metodo: aumentarVelocidadeShark
* Funcao: Quando acionado o botao, a velocidade do carro eh aumentada
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void aumentarVelocidadeShark(ActionEvent event) {
    int velocidade = pCS.getVelocidade();
    velocidade -= 5;
    if(velocidade >= 5){
      pCS.setVelocidade(velocidade);
    }
  }
  
/* ***************************************************************
* Metodo: aumentarVelocidadeRaceCar
* Funcao: Quando acionado o botao, a velocidade do carro eh aumentada
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void aumentarVelocidadeRaceCar(ActionEvent event) {
    int velocidade = pCC.getVelocidade();
    velocidade -= 5;
    if(velocidade >= 5){
      pCC.setVelocidade(velocidade);
    }
  }

/* ***************************************************************
* Metodo: aumentarVelocidadeRedFish
* Funcao: Quando acionado o botao, a velocidade do carro eh aumentada
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void aumentarVelocidadeRedFish(ActionEvent event) {
    int velocidade = pCFR.getVelocidade();
    velocidade -= 5;
    if(velocidade >= 5){
      pCFR.setVelocidade(velocidade);
    }
  }

/* ***************************************************************
* Metodo: aumentarVelocidadePurpleFish
* Funcao: Quando acionado o botao, a velocidade do carro eh aumentada
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void aumentarVelocidadePurpleFish(ActionEvent event) {
    int velocidade = pCFP.getVelocidade();
    velocidade -= 5;
    if(velocidade >= 5){
      pCFP.setVelocidade(velocidade);
    }
  }

/* ***************************************************************
* Metodo: aumentarVelocidadeTaxi
* Funcao: Quando acionado o botao, a velocidade do carro eh aumentada
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void aumentarVelocidadeTaxi(ActionEvent event) {
    int velocidade = pCT.getVelocidade();
    velocidade -= 5;
    if(velocidade >= 5){
      pCT.setVelocidade(velocidade);
    }
  }

/* ***************************************************************
* Metodo: diminuirVelocidadeSpongebob
* Funcao: Quando acionado o botao, a velocidade do carro eh diminuida
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void diminuirVelocidadeSpongebob(ActionEvent event) {
    int velocidade = pCBE.getVelocidade();
    velocidade += 5;
    if(velocidade <= 25){
      pCBE.setVelocidade(velocidade);
    }
  }

/* ***************************************************************
* Metodo: diminuirVelocidadeSpongebob
* Funcao: Quando acionado o botao, a velocidade do carro eh diminuida
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void diminuirVelocidadePlankton(ActionEvent event) {
    int velocidade = pCP.getVelocidade();
    velocidade += 5;
    if(velocidade <= 25){
      pCP.setVelocidade(velocidade);
    }
  }

/* ***************************************************************
* Metodo: diminuirVelocidadeSpongebob
* Funcao: Quando acionado o botao, a velocidade do carro eh diminuida
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void diminuirVelocidadeShark(ActionEvent event) {
    int velocidade = pCS.getVelocidade();
    velocidade += 5;
    if(velocidade <= 25){
      pCS.setVelocidade(velocidade);
    }
  }

/* ***************************************************************
* Metodo: diminuirVelocidadeSpongebob
* Funcao: Quando acionado o botao, a velocidade do carro eh diminuida
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void diminuirVelocidadeRaceCar(ActionEvent event) {
    int velocidade = pCC.getVelocidade();
    velocidade += 5;
    if(velocidade <= 25){
      pCC.setVelocidade(velocidade);
    }
  }
  
  @FXML
  void diminuirVelocidadeRedFish(ActionEvent event) {
    int velocidade = pCFR.getVelocidade();
    velocidade += 5;
    if(velocidade <= 25){
      pCFR.setVelocidade(velocidade);
    }
  }

/* ***************************************************************
* Metodo: diminuirVelocidadeSpongebob
* Funcao: Quando acionado o botao, a velocidade do carro eh diminuida
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void diminuirVelocidadePurpleFish(ActionEvent event) {
    int velocidade = pCFP.getVelocidade();
    velocidade += 5;
    if(velocidade <= 25){
      pCFP.setVelocidade(velocidade);
    }
  }

/* ***************************************************************
* Metodo: diminuirVelocidadeSpongebob
* Funcao: Quando acionado o botao, a velocidade do carro eh diminuida
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void diminuirVelocidadeTaxi(ActionEvent event) {
    int velocidade = pCT.getVelocidade();
    velocidade += 5;
    if(velocidade <= 25){
      pCT.setVelocidade(velocidade);
    }//Fim do if
  }//Fim do metodo diminuirVelocidadeTaxi
}//Fim da classe ControleGeral
