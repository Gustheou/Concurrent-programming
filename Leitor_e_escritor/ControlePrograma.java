/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 03/05/2022
* Ultima alteracao.: 07/05/2022
* Nome.............: ControlePrograma
* Funcao...........: Funcionamento do programa
*************************************************************** */
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class ControlePrograma implements Initializable{

  @FXML
  private Button buttonIniciar;

  @FXML
  private ImageView imageAmarelo00;
  @FXML
  private ImageView imageAmarelo01;
  @FXML
  private ImageView imageAmarelo02;
  @FXML
  private ImageView imageAmarelo10;
  @FXML
  private ImageView imageAmarelo11;
  @FXML
  private ImageView imageAmarelo12;
  @FXML
  private ImageView imageAmarelo20;
  @FXML
  private ImageView imageAmarelo21;
  @FXML
  private ImageView imageAmarelo22;
  @FXML
  private ImageView imageAmarelo30;
  @FXML
  private ImageView imageAmarelo31;
  @FXML
  private ImageView imageAmarelo32;
  @FXML
  private ImageView imageAmarelo40;
  @FXML
  private ImageView imageAmarelo41;
  @FXML
  private ImageView imageAmarelo42;
  @FXML
  private ImageView imageAmarelo50;
  @FXML
  private ImageView imageAmarelo51;
  @FXML
  private ImageView imageAmarelo52;

  @FXML
  private ImageView imageAzul00;
  @FXML
  private ImageView imageAzul01;
  @FXML
  private ImageView imageAzul02;
  @FXML
  private ImageView imageAzul10;
  @FXML
  private ImageView imageAzul11;
  @FXML
  private ImageView imageAzul12;
  @FXML
  private ImageView imageAzul20;
  @FXML
  private ImageView imageAzul21;
  @FXML
  private ImageView imageAzul22;
  @FXML
  private ImageView imageAzul30;
  @FXML
  private ImageView imageAzul31;
  @FXML
  private ImageView imageAzul32;
  @FXML
  private ImageView imageAzul40;
  @FXML
  private ImageView imageAzul41;
  @FXML
  private ImageView imageAzul42;
  @FXML
  private ImageView imageAzul50;
  @FXML
  private ImageView imageAzul51;
  @FXML
  private ImageView imageAzul52;

  @FXML
  private ImageView imageVermelho00;
  @FXML
  private ImageView imageVermelho01;
  @FXML
  private ImageView imageVermelho02;
  @FXML
  private ImageView imageVermelho10;
  @FXML
  private ImageView imageVermelho11;
  @FXML
  private ImageView imageVermelho12;
  @FXML
  private ImageView imageVermelho20;
  @FXML
  private ImageView imageVermelho21;
  @FXML
  private ImageView imageVermelho22;
  @FXML
  private ImageView imageVermelho30;
  @FXML
  private ImageView imageVermelho31;
  @FXML
  private ImageView imageVermelho32;
  @FXML
  private ImageView imageVermelho40;
  @FXML
  private ImageView imageVermelho41;
  @FXML
  private ImageView imageVermelho42;
  @FXML
  private ImageView imageVermelho50;
  @FXML
  private ImageView imageVermelho51;
  @FXML
  private ImageView imageVermelho52;

  @FXML
  private Label labelEscritor;
  @FXML
  private Label labelLeitor;
  @FXML
  private Label labelVelocidade;

  @FXML
  private Slider sliderVelocidadeEscritor;
  @FXML
  private Slider sliderVelocidadeLeitor;

  // public Semaphore escritor = new Semaphore(1);
  public Semaphore mutex = new Semaphore(2);
  private Leitor processoLeitor;
  private Escritor processEscritor;
  private long velocidadeEscritor = 3000;
  private long velocidadeLeitor = 3000;
  private static int loop = 0;

/* ***************************************************************
* Metodo: buttonIniciar
* Funcao: Quando acionado o botao, o programa inicia
* Parametros: ActionEvent event = evento que requer uma acao para ser
* executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void buttonIniciar(ActionEvent event) {
    buttonIniciar.setVisible(false);
    labelVelocidade.setVisible(true);
    labelEscritor.setVisible(true);
    labelLeitor.setVisible(true);
    sliderVelocidadeEscritor.setVisible(true);
    sliderVelocidadeLeitor.setVisible(true);
    if (loop == 0){
      imageVermelho00.setVisible(false);
      imageAmarelo01.setVisible(false);
      imageVermelho02.setVisible(false);
      imageAmarelo10.setVisible(false);
      imageVermelho11.setVisible(false);
      imageAzul12.setVisible(false);
      imageVermelho20.setVisible(false);
      imageAzul21.setVisible(false);
      imageVermelho22.setVisible(false);
      imageAzul30.setVisible(false);
      imageVermelho31.setVisible(false);
      imageAmarelo32.setVisible(false);
      imageAmarelo40.setVisible(false);
      imageVermelho41.setVisible(false);
      imageAzul42.setVisible(false);
      imageVermelho50.setVisible(false);
      imageAzul51.setVisible(false);
      imageVermelho52.setVisible(false);
    } else {
      imageVermelho00.setVisible(false);
      imageVermelho02.setVisible(false);
      imageVermelho11.setVisible(false);
      imageVermelho20.setVisible(false);
      imageVermelho22.setVisible(false);
      imageVermelho31.setVisible(false);
      imageVermelho41.setVisible(false);
      imageVermelho50.setVisible(false);
      imageVermelho52.setVisible(false);
    }
    loop = 1;
    processoLeitor = new Leitor(this, mutex);
    processEscritor = new Escritor(this, mutex);
    processEscritor.start();
    processoLeitor.start();
  }// Fim do metodo buttonIniciar

/* ***************************************************************
* Metodo: getImageEscrever
* Funcao: retornar a imagem vermelha que representa a escrita
* Parametros: int contador = a coordenada que sera inserida a imagem
* Retorno: ImageView
*************************************************************** */
  public ImageView getImageEscrever(int contador) {
    switch (contador) {// Ler na horizontal, coluna por coluna
      case 0: {
        return imageVermelho00;
      }
      case 1: {
        return imageVermelho10;
      }
      case 2: {
        return imageVermelho20;
      }
      case 3: {
        return imageVermelho30;
      }
      case 4: {
        return imageVermelho40;
      }
      case 5: {
        return imageVermelho50;
      }
      case 6: {
        return imageVermelho01;
      }
      case 7: {
        return imageVermelho11;
      }
      case 8: {
        return imageVermelho21;
      }
      case 9: {
        return imageVermelho31;
      }
      case 10: {
        return imageVermelho41;
      }
      case 11: {
        return imageVermelho51;
      }
      case 12: {
        return imageVermelho02;
      }
      case 13: {
        return imageVermelho12;
      }
      case 14: {
        return imageVermelho22;
      }
      case 15: {
        return imageVermelho32;
      }
      case 16: {
        return imageVermelho42;
      }
      case 17: {
        return imageVermelho52;
      }
      default: {
        return null;
      }
    }// Fim do switch case
  }// Fim do metodo getImageEscrever

/* ***************************************************************
* Metodo: getImageLendo
* Funcao: retornar a imagem amarela que representa a leitura
* Parametros: int contador = a coordenada que sera inserida a imagem
* Retorno: ImageView
*************************************************************** */
  public ImageView getImageLendo(int contador) {
    switch (contador) {// Ler na horizontal, coluna por coluna
      case 0: {
        return imageAmarelo00;
      }
      case 1: {
        return imageAmarelo10;
      }
      case 2: {
        return imageAmarelo20;
      }
      case 3: {
        return imageAmarelo30;
      }
      case 4: {
        return imageAmarelo40;
      }
      case 5: {
        return imageAmarelo50;
      }
      case 6: {
        return imageAmarelo01;
      }
      case 7: {
        return imageAmarelo11;
      }
      case 8: {
        return imageAmarelo21;
      }
      case 9: {
        return imageAmarelo31;
      }
      case 10: {
        return imageAmarelo41;
      }
      case 11: {
        return imageAmarelo51;
      }
      case 12: {
        return imageAmarelo02;
      }
      case 13: {
        return imageAmarelo12;
      }
      case 14: {
        return imageAmarelo22;
      }
      case 15: {
        return imageAmarelo32;
      }
      case 16: {
        return imageAmarelo42;
      }
      case 17: {
        return imageAmarelo52;
      }
      default: {
        return null;
      }
    }// Fim do switch case
  }// Fim do metodo getImageLendo

/* ***************************************************************
* Metodo: getImageLeituraFinalizada
* Funcao: retornar a imagem azul que representa a leitura ja finalizada
* Parametros: int contador = a coordenada que sera inserida a imagem
* Retorno: ImageView
*************************************************************** */
  public ImageView getImageLeituraFinalizada(int contador) {
    switch (contador) {// Ler na horizontal, coluna por coluna
      case 0: {
        return imageAzul00;
      }
      case 1: {
        return imageAzul10;
      }
      case 2: {
        return imageAzul20;
      }
      case 3: {
        return imageAzul30;
      }
      case 4: {
        return imageAzul40;
      }
      case 5: {
        return imageAzul50;
      }
      case 6: {
        return imageAzul01;
      }
      case 7: {
        return imageAzul11;
      }
      case 8: {
        return imageAzul21;
      }
      case 9: {
        return imageAzul31;
      }
      case 10: {
        return imageAzul41;
      }
      case 11: {
        return imageAzul51;
      }
      case 12: {
        return imageAzul02;
      }
      case 13: {
        return imageAzul12;
      }
      case 14: {
        return imageAzul22;
      }
      case 15: {
        return imageAzul32;
      }
      case 16: {
        return imageAzul42;
      }
      case 17: {
        return imageAzul52;
      }
      default: {
        return null;
      }
    }// Fim do switch case
  }// Fim do metodo getImageLeituraFinalizada

/* ***************************************************************
* Metodo: initialize
* Funcao: iniciar os sliders
* Parametros: URL = localizacao dos sliders, ResourceBundle = recursos que podem ser facilmente modificados por serem emitidos pelos sliders
* Retorno: void
*************************************************************** */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // Manipulacao da velocidade de pensar
    sliderVelocidadeLeitor.valueProperty().addListener(// Velocidade de pensar do slider referente ao filosofo 0
      new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo) {
          velocidadeLeitor = valorNovo.longValue();
          setVelocidadeLeitor(velocidadeLeitor);
          System.out.println("Velocidade de leitura alterada para " + getVelocidadeLeitor() + "ms");
        }
      }
    );
    sliderVelocidadeEscritor.valueProperty().addListener(// Velocidade de pensar do slider referente ao filosofo 1
      new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo) {
          velocidadeEscritor = valorNovo.longValue();
          setVelocidadeEscritor(velocidadeEscritor);
          System.out.println("Velocidade de escrita alterada para " + getVelocidadeEscritor() + "ms");
        }
      }
    );
  }//Fim do metodo initialize

/* ***************************************************************
  * Metodo: setVelocidadeLeitor
  * Funcao: referir a velocidade do slider para a thread do leitor
  * Parametros: long velocidade = a velocidade a ser enviada
  * Retorno: void
*************************************************************** */
  public void setVelocidadeLeitor(long velocidadeLeitor) {
    this.velocidadeLeitor = velocidadeLeitor*1000;
  }//Fim do metodo setVelocidadeLeitor

/* ***************************************************************
* Metodo: getVelocidadeLeitor
* Funcao: passar a velocidade do slider para a thread referente ao leitor
* Parametros: void
* Retorno: long
*************************************************************** */
  public long getVelocidadeLeitor() {
    return velocidadeLeitor;
  }//Fim do metodo getVelocidadeLeitor

/* ***************************************************************
  * Metodo: setVelocidadeEscritor
  * Funcao: referir a velocidade do slider para a thread do escritor
  * Parametros: long velocidade = a velocidade a ser enviada; 
  * Retorno: void
*************************************************************** */
  public void setVelocidadeEscritor(long velocidadeEscritor) {
    this.velocidadeEscritor = velocidadeEscritor*1000;
  }//Fim do metodo setVelocidadeEscritor

/* ***************************************************************
* Metodo: getVelocidadeEscritor
* Funcao: passar a velocidade do slider para a thread referente ao escritor
* Parametros: void
* Retorno: long
*************************************************************** */
  public long getVelocidadeEscritor() {
    return velocidadeEscritor;
  }//Fim do metodo getVelocidadeEscritor

/* ***************************************************************
* Metodo: getButtonIniciar
* Funcao: retornar o botao de iniciar
* Parametros: void
* Retorno: Button
*************************************************************** */
  public Button getButtonIniciar() {
    return buttonIniciar;
  }//FIm da classe getButtoniniciar
}// Fim da classe ControlePrograma
