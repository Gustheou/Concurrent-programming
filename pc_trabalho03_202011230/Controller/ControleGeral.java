/* ***************************************************************
* Autor............: Gustavo  Pereira Nunes
* Inicio...........: 25/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: ControleGeral
* Funcao...........: Controlar todo o mecanismo do programa, referente as "bandeiras", velocidades, etc.
*************************************************************** */
package Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import Model.*;

public class ControleGeral {

  @FXML
  public ImageView homemAranhaSuperiorCentroDireito;
  @FXML
  public ImageView homemAranhaSuperiorCentroEsquerdo;
  @FXML
  public ImageView homemAranhaSuperiorDireito;
  @FXML
  public ImageView homemAranhaSuperiorEsquerdo;

  @FXML
  public ImageView tremVermelho;
  @FXML
  public ImageView tremAzul;

  @FXML
  private Button aumentarVelocidadeDoTremAzulButton;
  @FXML
  private Button aumentarVelocidadeDoTremVermelhoButton;
  @FXML
  private Button diminuirVelocidadeDoTremAzulButton;
  @FXML
  private Button diminuirVelocidadeDoTremVermelhoButton;
  @FXML
  private Button iniciarButton;

  @FXML
  private TextField velocidadeTremAzul;
  @FXML
  private TextField velocidadeTremVermelho;

  private ProcessoTremA processoTremVermelho;
  private ProcessoTremB processoTremAzul;
  private boolean viaSimplesEsquerdaLiberada = true;
  private boolean viaSimplesDireitaLiberada = true;

/* ***************************************************************
* Metodo: getTremVermelho
* Funcao: chamar a imagem do trem
* Parametros: void
* Retorno: ImageView
*************************************************************** */
  public ImageView getTremVermelho(){
    return this.tremVermelho;
  }// Fim do metodo getTremVermelho

/* ***************************************************************
* Metodo: getTremAzul
* Funcao: chamar a imagem do trem
* Parametros: void
* Retorno: ImageView
*************************************************************** */
  public ImageView getTremAzul(){
    return this.tremAzul;
  }//Fim do metodo getTreamAzul

/* ***************************************************************
* Metodo: getViaSimplesEsquerdaLiberada
* Funcao: checar se a via foi ou nao liberada
* Parametros: void
* Retorno: boolean = true or false
*************************************************************** */
  public boolean getViaSimplesEsquerdaLiberada() {
    return this.viaSimplesEsquerdaLiberada;
  }//Fim do metodo getViaSimplesEsquerdaLiberada

/* ***************************************************************
* Metodo: getViaSimplesDireitaLiberada
* Funcao: checar se a via foi ou nao liberada
* Parametros: void
* Retorno: boolean = true or false
*************************************************************** */
  public boolean getViaSimplesDireitaLiberada(){
    return this.viaSimplesDireitaLiberada;
  }//Fim do metodo getViaSimplesDireitaLiberada

/* ***************************************************************
* Metodo: setViaSimplesEsquerdaLiberada
* Funcao: defini se a via esta liberada
* Parametros: boolean status = se tiver liberada, retorna true
* Retorno: void
*************************************************************** */
  public void setViaSimplesEsquerdaLiberada(boolean status) {
    this.viaSimplesEsquerdaLiberada = status;
  }//Fim do metodo setViaSimplesEsquerdaLiberada

/* ***************************************************************
* Metodo: setViaSimplesDireitaLiberada
* Funcao: defini se a via esta liberada
* Parametros: boolean status = se tiver liberada, retorna true
* Retorno: void
*************************************************************** */
  public void setViaSimplesDireitaLiberada(boolean status) {
    this.viaSimplesDireitaLiberada = status;
  }//Fim do metodo setViaSimplesDireitaLiberada

/* ***************************************************************
* Metodo: setVisibleHomemAranhaSuperiorEsquerdo
* Funcao: homem aranha salva o dia, impedindo a passagem do trem quando acionado, inibindo uma colisao
* Parametros: boolean status = se sera acionado ou nao
* Retorno: void
*************************************************************** */
  public void setVisibleHomemAranhaSuperiorEsquerdo (boolean status) {
    homemAranhaSuperiorEsquerdo.setVisible(status);
  }//Fim do metodo setVisibleHomemAranhaSuperiorEsquerdo

/* ***************************************************************
* Metodo: setVisibleHomemAranhaSuperiorCentroEsquerdo
* Funcao: homem aranha salva o dia, impedindo a passagem do trem quando acionado, inibindo uma colisao
* Parametros: boolean status = se sera acionado ou nao
* Retorno: void
*************************************************************** */
  public void setVisibleHomemAranhaSuperiorCentroEsquerdo(boolean status) {
    homemAranhaSuperiorCentroEsquerdo.setVisible(status);
  }//Fim do metodo setVisibleHomemAranhaSuperiorCentroEsquerdo

/* ***************************************************************
* Metodo: setVisibleHomemAranhaSuperiorCentroDireito
* Funcao: homem aranha salva o dia, impedindo a passagem do trem quando acionado, inibindo uma colisao
* Parametros: boolean status = se sera acionado ou nao
* Retorno: void
*************************************************************** */
  public void setVisibleHomemAranhaSuperiorCentroDireito(boolean status) {
    homemAranhaSuperiorCentroDireito.setVisible(status);
  }//Fim do metodo setVisibleHomemAranhaSuperiorCentroDireito

/* ***************************************************************
* Metodo: setVisibleHomemAranhaSuperiorDireito
* Funcao: homem aranha salva o dia, impedindo a passagem do trem quando acionado, inibindo uma colisao
* Parametros: boolean status = se sera acionado ou nao
* Retorno: void
*************************************************************** */
  public void setVisibleHomemAranhaSuperiorDireito(boolean status) {
    homemAranhaSuperiorDireito.setVisible(status);
  }//Fim do metodo setVisibleHomemAranhaSuperiorDireito

/* ***************************************************************
* Metodo: inicializarButton
* Funcao: Quando acionado o botao, o programa inicia
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  public void inicializarButton(ActionEvent event) {
    iniciarButton.setVisible(false);
    homemAranhaSuperiorCentroDireito.setVisible(false);
    homemAranhaSuperiorCentroEsquerdo.setVisible(false);
    homemAranhaSuperiorDireito.setVisible(false);
    homemAranhaSuperiorEsquerdo.setVisible(false);
    velocidadeTremAzul.setVisible(true);
    velocidadeTremVermelho.setVisible(true);
    aumentarVelocidadeDoTremAzulButton.setVisible(true);
    aumentarVelocidadeDoTremVermelhoButton.setVisible(true);
    diminuirVelocidadeDoTremAzulButton.setVisible(true);
    diminuirVelocidadeDoTremVermelhoButton.setVisible(true);
    
    tremVermelho.setX(-10);
    tremAzul.setX(708);
    
    processoTremVermelho = new ProcessoTremA(this);
    processoTremAzul = new ProcessoTremB(this);

    velocidadeTremAzul.setText("Azul: 20km/h");
    velocidadeTremVermelho.setText("Vermelho: 20km/h");

    processoTremVermelho.start();
    processoTremAzul.start();
  }//Fim do metodo inicializarButton

/* ***************************************************************
* Metodo: aumentarVelocidadeDoTremAzul
* Funcao: Quando acionado o botao, a velocidade do trem eh aumentada
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  public void aumentarVelocidadeDoTremAzul(ActionEvent evento){
    int velocidade = processoTremAzul.getVelocidade();
    velocidade -= 5;
    if(velocidade >= 5){
      processoTremAzul.setVelocidade(velocidade);
      velocidadeTremAzul.setText("Azul: "+Integer.toString(1000/velocidade) + "km/h");
    }//Fim do if
  }//fim metodo aumentarVelocidadeDoTremAzul
  
/* ***************************************************************
* Metodo: diminuirVelocidadeDoTremAzul
* Funcao: Quando acionado o botao, a velocidade do trem eh diminuida
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  public void diminuirVelocidadeDoTremAzul(ActionEvent evento){
    int velocidade = processoTremAzul.getVelocidade();
    velocidade += 5;
    if(velocidade <= 25){
      processoTremAzul.setVelocidade(velocidade);
      velocidadeTremAzul.setText("Azul: "+Integer.toString(1000/velocidade) + "km/h");
    }//Fim do if
  }//fim metodo diminuirVelocidadeDoTremAzul

/* ***************************************************************
* Metodo: aumentarVelocidadeDoTremVermelho
* Funcao: Quando acionado o botao, a velocidade do trem eh aumentada
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  public void aumentarVelocidadeDoTremVermelho(ActionEvent evento){
    int velocidade = processoTremVermelho.getVelocidade();
    velocidade -= 5;
    if(velocidade >= 5){
      processoTremVermelho.setVelocidade(velocidade);
      velocidadeTremVermelho.setText("Vermelho: "+Integer.toString(1000/velocidade) + "km/h");
    }//Fim do if
  }//fim metodo aumentarVelocidadeDoTremVermelho

/* ***************************************************************
* Metodo: diminuirVelocidadeDoTremVermelho
* Funcao: Quando acionado o botao, a velocidade do trem eh diminuida
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  public void diminuirVelocidadeDoTremVermelho(ActionEvent evento){
    int velocidade = processoTremVermelho.getVelocidade();
    velocidade += 5;

    if(velocidade <= 25){
      processoTremVermelho.setVelocidade(velocidade);
      velocidadeTremVermelho.setText("Vermelho: "+Integer.toString(1000/velocidade) + "km/h");
    }//Fim do if
  }//Fim do metodo diminuirVelocidadeDoTremVermelho
}//Fim da classe ControleGeral
