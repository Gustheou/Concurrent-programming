/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 13/04/2022
* Ultima alteracao.: 24/04/2022
* Nome.............: ControleGeral
* Funcao...........: Controlar a thread, imagens, sliders...
*************************************************************** */
package Controller;
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
import Model.Filosofo;

public class ControleGeral implements Initializable{

  //Imagem complementar ao filosofo pensante
  @FXML
  private ImageView imagemBalaoPensante0;
  @FXML
  private ImageView imagemBalaoPensante1;
  @FXML
  private ImageView imagemBalaoPensante2;
  @FXML
  private ImageView imagemBalaoPensante3;
  @FXML
  private ImageView imagemBalaoPensante4;
  
  //Filosofo interessado
  @FXML
  private ImageView imagemComFome0;
  @FXML
  private ImageView imagemComFome1;
  @FXML
  private ImageView imagemComFome2;
  @FXML
  private ImageView imagemComFome3;
  @FXML
  private ImageView imagemComFome4;
  
  //Filosofo comendo
  @FXML
  private ImageView imagemComendo0;
  @FXML
  private ImageView imagemComendo1;
  @FXML
  private ImageView imagemComendo2;
  @FXML
  private ImageView imagemComendo3;
  @FXML
  private ImageView imagemComendo4;

  //Filosofo no estado pensando
  @FXML
  private ImageView imagemFilosofo0;
  @FXML
  private ImageView imagemFilosofo1;
  @FXML
  private ImageView imagemFilosofo2;
  @FXML
  private ImageView imagemFilosofo3;
  @FXML
  private ImageView imagemFilosofo4;

  //Imagens do hashi na mesa
  @FXML
  private ImageView imagemHashi0;
  @FXML
  private ImageView imagemHashi1;
  @FXML
  private ImageView imagemHashi2;
  @FXML
  private ImageView imagemHashi3;
  @FXML
  private ImageView imagemHashi4;
  
  //Imagens do pensamento do "filosofo"
  @FXML
  private ImageView imagemPensamentoPraia0;
  @FXML
  private ImageView imagemPensamentoPraia1;
  @FXML
  private ImageView imagemPensamentoPraia2;
  @FXML
  private ImageView imagemPensamentoPraia3;
  @FXML
  private ImageView imagemPensamentoPraia4;

  //label referente a cada filosofo pensante e no ato de comer que se relaciona com o slider
  @FXML
  private Label labelUmaruThinking0;
  @FXML
  private Label labelUmaruThinking1;
  @FXML
  private Label labelUmaruThinking2;
  @FXML
  private Label labelUmaruThinking3;
  @FXML
  private Label labelUmaruThinking4;
  @FXML
  private Label labelUmaruEating0;
  @FXML
  private Label labelUmaruEating1;
  @FXML
  private Label labelUmaruEating2;
  @FXML
  private Label labelUmaruEating3;
  @FXML
  private Label labelUmaruEating4;

  //Slider para alterar a velocidade de cada filosofos
  @FXML
  private Slider sliderUmaruThinking0;
  @FXML
  private Slider sliderUmaruThinking1;
  @FXML
  private Slider sliderUmaruThinking2;
  @FXML
  private Slider sliderUmaruThinking3;
  @FXML
  private Slider sliderUmaruThinking4;
  @FXML
  private Slider sliderUmaruEating0;
  @FXML
  private Slider sliderUmaruEating1;
  @FXML
  private Slider sliderUmaruEating2;
  @FXML
  private Slider sliderUmaruEating3;
  @FXML
  private Slider sliderUmaruEating4;

  //Imagens "decorativas"
  @FXML
  private ImageView imageUmaruPet;
  @FXML
  private ImageView imageUmaruPet1;

  //Botao iniciar
  @FXML
  private Button iniciarButton;

  //Velocidade referente ao slider de cada um
  private long velocidadeUmaruThinking0, velocidadeUmaruThinking1, velocidadeUmaruThinking2,
  velocidadeUmaruThinking3, velocidadeUmaruThinking4, velocidadeUmaruEating0, velocidadeUmaruEating1,
  velocidadeUmaruEating2, velocidadeUmaruEating3, velocidadeUmaruEating4;

  public static Semaphore mutex = new Semaphore(1);
  public static Semaphore[] semaforos = new Semaphore[5];
  public static Filosofo[] filosofos = new Filosofo[5];
  public static int[] estado = new int [5];

/* ***************************************************************
* Metodo: inicializarButton
* Funcao: Quando acionado o botao, o programa inicia
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh o de apertar um botao
* Retorno: void
*************************************************************** */
  @FXML
  void iniciarButton(ActionEvent event) {
    iniciarButton.setVisible(false);
    //Labels e sliders referentes a velocidade do filosofo
    labelUmaruThinking0.setVisible(true);
    labelUmaruThinking1.setVisible(true);
    labelUmaruThinking2.setVisible(true);
    labelUmaruThinking3.setVisible(true);
    labelUmaruThinking4.setVisible(true);
    labelUmaruEating0.setVisible(true);
    labelUmaruEating1.setVisible(true);
    labelUmaruEating2.setVisible(true);
    labelUmaruEating3.setVisible(true);
    labelUmaruEating4.setVisible(true);
    sliderUmaruThinking0.setVisible(true);
    sliderUmaruThinking1.setVisible(true);
    sliderUmaruThinking2.setVisible(true);
    sliderUmaruThinking3.setVisible(true);
    sliderUmaruThinking4.setVisible(true);
    sliderUmaruEating0.setVisible(true);
    sliderUmaruEating1.setVisible(true);
    sliderUmaruEating2.setVisible(true);
    sliderUmaruEating3.setVisible(true);
    sliderUmaruEating4.setVisible(true);
    //Imagens decorativas que ficam no lugar do botão
    imageUmaruPet.setVisible(true);
    imageUmaruPet1.setVisible(true);

    //Fazer com que todos os filosofos fiquem pensando
    for (int i = 0; i < estado.length; i++){
      estado[i] = 0; // 0 == "Pensando"
    }//Fim do for

    //Instanciar os filosofos
    for (int i = 0; i < 5; i++){
      filosofos[i] = new Filosofo(this, i);
    }//Fim do for

    //Referir aos filosofos os hashi que possuem
    for(int i = 0; i < filosofos.length; i++){//Qual garfo pertence a quem
      System.out.println("O filosofo "+ i +" possui os seguintes hashis: "+"\nHashi: "+ i +"\nHashi: "+(i+1)%5);
    }//Fim do for

    //Inicializar os semaforos
    for (int i = 0; i < semaforos.length; i++){
      semaforos[i] = new Semaphore(0);
    }//Fim do for

    //Inicializar os filosofos
    for (int i = 0; i < filosofos.length;i++){
      filosofos[i].start();
    }//Fim do for

    //Inicializar suas velocidades
    for (int i = 0; i < 5; i++){
      setVelocidadePensar(1000, i);
      setVelocidadeComer(10000, i);
    }//Fim do for
  }//Fim do metodo iniciarButton

/* ***************************************************************
* Metodo: getImagemFilosofoEstadoPensando
* Funcao: retornar a imagem ao referente filosofo
* Parametros: int id = Identificacao do filosofo que recebera a imagem
* Retorno: ImageView
*************************************************************** */
  public ImageView getImagemFilosofoEstadoPensando(int id){
    switch (id){
      case 0: {
        return imagemFilosofo0;
      }
      case 1: {
        return imagemFilosofo1;
      }
      case 2: {
        return imagemFilosofo2;
      }
      case 3: {
        return imagemFilosofo3;
      }
      case 4: {
        return imagemFilosofo4;
      }
      default: {
        return null;
      }
    }//Fim do switch
  }//Fim do metodo getImagemFilosofoEstadoPensando

/* ***************************************************************
* Metodo: getImagemFilosofoEstadoComFome
* Funcao: retornar a imagem ao referente filosofo
* Parametros: int id = Identificacao do filosofo que recebera a imagem
* Retorno: ImageView
*************************************************************** */
  public ImageView getImagemFilosofoEstadoComFome(int id){
    switch (id){
      case 0: {
        return imagemComFome0;
      }
      case 1: {
        return imagemComFome1;
      }
      case 2: {
        return imagemComFome2;
      }
      case 3: {
        return imagemComFome3;
      }
      case 4: {
        return imagemComFome4;
      }
      default: {
        return null;
      }
    }//Fim do switch
  }//Fim do metodo getImagemFilosofoEstadoComFome

/* ***************************************************************
* Metodo: getImagemFilosofoEstadoComendo
* Funcao: retornar a imagem ao referente filosofo
* Parametros: int id = Identificacao do filosofo que recebera a imagem
* Retorno: ImageView
*************************************************************** */
  public ImageView getImagemFilosofoEstadoComendo(int id){
    switch (id){
      case 0: {
        return imagemComendo0;
      }
      case 1: {
        return imagemComendo1;
      }
      case 2: {
        return imagemComendo2;
      }
      case 3: {
        return imagemComendo3;
      }
      case 4: {
        return imagemComendo4;
      }
      default: {
        return null;
      }
    }//Fim do switch
  }//Fim do metodo getImagemFilosofoEstadoComendo

/* ***************************************************************
* Metodo: getImagemBalaoPensante
* Funcao: retornar a imagem ao referente filosofo
* Parametros: int id = Identificacao do filosofo que recebera a imagem
* Retorno: ImageView
*************************************************************** */
  public ImageView getImagemBalaoPensante(int id){
    switch (id){
      case 0: {
        return imagemBalaoPensante0;
      }
      case 1: {
        return imagemBalaoPensante1;
      }
      case 2: {
        return imagemBalaoPensante2;
      }
      case 3: {
        return imagemBalaoPensante3;
      }
      case 4: {
        return imagemBalaoPensante4;
      }
      default: {
        return null;
      }
    }//Fim do switch
  }//Fim do metodo getImagemBalaoPensante

/* ***************************************************************
* Metodo: getImagemPensamentoPraia
* Funcao: retornar a imagem ao referente filosofo
* Parametros: int id = Identificacao do filosofo que recebera a imagem
* Retorno: ImageView
*************************************************************** */
  public ImageView getImagemPensamentoPraia(int id){
    switch (id){
      case 0: {
        return imagemPensamentoPraia0;
      }
      case 1: {
        return imagemPensamentoPraia1;
      }
      case 2: {
        return imagemPensamentoPraia2;
      }
      case 3: {
        return imagemPensamentoPraia3;
      }
      case 4: {
        return imagemPensamentoPraia4;
      }
      default: {
        return null;
      }
    }//Fim do switch
  }//Fim do metodo getImagemPensamentoPraia

/* ***************************************************************
* Metodo: getImagemHashi
* Funcao: retornar a imagem ao referente filosofo
* Parametros: int id = Identificacao do filosofo que recebera a imagem
* Retorno: ImageView
*************************************************************** */
  public ImageView getImagemHashi(int id){
    switch (id){
      case 0: {
        return imagemHashi0;
      }
      case 1: {
        return imagemHashi1;
      }
      case 2: {
        return imagemHashi2;
      }
      case 3: {
        return imagemHashi3;
      }
      case 4: {
        return imagemHashi4;
      }
      default: {
        return null;
      }
    }//Fim do switch
  }//Fim do metodo getImagemHashi

/* ***************************************************************
* Metodo: initialize
* Funcao: iniciar os sliders
* Parametros: URL = localizacao dos sliders, ResourceBundle = recursos que podem ser facilmente modificados por serem emitidos pelos sliders
* Retorno: void
*************************************************************** */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //Manipulacao da velocidade de pensar
    sliderUmaruThinking0.valueProperty().addListener(//Velocidade de pensar do slider referente ao filosofo 0
      new ChangeListener<Number>() {
        @Override
        public void changed (ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo){
          velocidadeUmaruThinking0 = valorNovo.longValue()*1000;
          setVelocidadePensar(velocidadeUmaruThinking0, 0);
          System.out.println("Velocidade pensante 0 alterada para " + getVelocidadePensar(0) + "ms");
        }
      }
    );
    sliderUmaruThinking1.valueProperty().addListener(//Velocidade de pensar do slider referente ao filosofo 1
      new ChangeListener<Number>() {
        @Override
        public void changed (ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo){
          velocidadeUmaruThinking1 = valorNovo.longValue()*1000;
          setVelocidadePensar(velocidadeUmaruThinking1, 1);
          System.out.println("Velocidade pensante 1 alterada para " + getVelocidadePensar(1) + "ms");
        }
      }
    );
    sliderUmaruThinking2.valueProperty().addListener(//Velocidade de pensar do slider referente ao filosofo 2
      new ChangeListener<Number>() {
        @Override
        public void changed (ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo){
          velocidadeUmaruThinking2 = valorNovo.longValue()*1000;
          setVelocidadePensar(velocidadeUmaruThinking2, 2);
          System.out.println("Velocidade pensante 2 alterada para " + getVelocidadePensar(2) + "ms");
        }
      }
    );
    sliderUmaruThinking3.valueProperty().addListener(//Velocidade de pensar do slider referente ao filosofo 3
      new ChangeListener<Number>() {
        @Override
        public void changed (ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo){
          velocidadeUmaruThinking3 = valorNovo.longValue()*1000;
          setVelocidadePensar(velocidadeUmaruThinking3, 3);
          System.out.println("Velocidade pensante 3 alterada para " + getVelocidadePensar(3) + "ms");
        }
      }
    );
    sliderUmaruThinking4.valueProperty().addListener(//Velocidade de pensar do slider referente ao filosofo 4
      new ChangeListener<Number>() {
        @Override
        public void changed (ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo){
          velocidadeUmaruThinking4 = valorNovo.longValue()*1000;
          setVelocidadePensar(velocidadeUmaruThinking4, 4);
          System.out.println("Velocidade pensante 4 alterada para " + getVelocidadePensar(4) + "ms");
        }
      }
    );

    //Manipulacao da velocidade de comer
    sliderUmaruEating0.valueProperty().addListener(//Velocidade de comer do slider referente ao filosofo 0
      new ChangeListener<Number>() {
        @Override
        public void changed (ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo){
          velocidadeUmaruEating0= valorNovo.longValue()*1000;
          setVelocidadeComer(velocidadeUmaruEating0, 0);
          System.out.println("Velocidade de comer 0 alterada para " + getVelocidadeComer(0) + "ms");
        }
      }
    );
    sliderUmaruEating1.valueProperty().addListener(//Velocidade de comer do slider referente ao filosofo 1
      new ChangeListener<Number>() {
        @Override
        public void changed (ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo){
          velocidadeUmaruEating1 = valorNovo.longValue()*1000;
          setVelocidadeComer(velocidadeUmaruEating1, 1);
          System.out.println("Velocidade de comer 1 alterada para " + getVelocidadeComer(1) + "ms");
        }
      }
    );
    sliderUmaruEating2.valueProperty().addListener(//Velocidade de comer do slider referente ao filosofo 2
      new ChangeListener<Number>() {
        @Override
        public void changed (ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo){
          velocidadeUmaruEating2 = valorNovo.longValue()*1000;
          setVelocidadeComer(velocidadeUmaruEating2, 2);
          System.out.println("Velocidade de comer 2 alterada para " + getVelocidadeComer(2) + "ms");
        }
      }
    );
    sliderUmaruEating3.valueProperty().addListener(//Velocidade de comer do slider referente ao filosofo 3
      new ChangeListener<Number>() {
        @Override
        public void changed (ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo){
          velocidadeUmaruEating3 = valorNovo.longValue()*1000;
          setVelocidadeComer(velocidadeUmaruEating3, 3);
          System.out.println("Velocidade de comer 3 alterada para " + getVelocidadeComer(3) + "ms");
        }
      }
    );
    sliderUmaruEating4.valueProperty().addListener(//Velocidade de comer do slider referente ao filosofo 4
      new ChangeListener<Number>() {
        @Override
        public void changed (ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo){
          velocidadeUmaruEating4 = valorNovo.longValue()*1000;
          setVelocidadeComer(velocidadeUmaruEating4, 4);
          System.out.println("Velocidade de comer 4 alterada para " + getVelocidadeComer(4) + "ms");
        }
      }
    );
  }//Fim do metodo initialize

/* ***************************************************************
* Metodo: setVelocidadePensar
* Funcao: referir a velocidade do slider para a thread referente a cada filosofo
* Parametros: long velocidade = a velocidade a ser enviada; int id = filosofo selecionado para ter sua velocidade alterada
* Retorno: void
*************************************************************** */
  public void setVelocidadePensar (long velocidade, int id){
    switch (id){
      case 0: {
        this.velocidadeUmaruThinking0 = velocidade;
        break;
      }
      case 1: {
        this.velocidadeUmaruThinking1 = velocidade;
        break;
      }
      case 2: {
        this.velocidadeUmaruThinking2 = velocidade;
        break;
      }
      case 3: {
        this.velocidadeUmaruThinking3 = velocidade;
        break;
      }
      case 4: {
        this.velocidadeUmaruThinking4 = velocidade;
        break;
      }
      default: {
        System.out.println("Erro no switch da velocidade do pensar");
        break;
      }
    }//Fim do switch
  }//Fim do metodo setVelocidadePensar

/* ***************************************************************
* Metodo: getVelocidadePensar
* Funcao: passar a velocidade do slider para a thread referente a cada filosofo
* Parametros: int id = filosofo selecionado para ter sua velocidade alterada
* Retorno: long
*************************************************************** */
  public long getVelocidadePensar (int id){
    switch (id){
      case 0: {
        return this.velocidadeUmaruThinking0;
      }
      case 1: {
        return this.velocidadeUmaruThinking1;
      }
      case 2: {
        return this.velocidadeUmaruThinking2;
      }
      case 3: {
        return this.velocidadeUmaruThinking3;
      }
      case 4: {
        return this.velocidadeUmaruThinking4;
      }
      default: {
        return 0;
      }
    }//Fim do switch
  }//Fim do metodo getVelocidadePensar

/* ***************************************************************
* Metodo: setVelocidadeComer
* Funcao: referir a velocidade do slider para a thread referente a cada filosofo
* Parametros: long velocidade = a velocidade a ser enviada; int id = filosofo selecionado para ter sua velocidade alterada
* Retorno: void
*************************************************************** */
  public void setVelocidadeComer (long velocidade, int id){
    switch (id){
      case 0: {
        this.velocidadeUmaruEating0 = velocidade;
        break;
      }
      case 1: {
        this.velocidadeUmaruEating1 = velocidade;
        break;
      }
      case 2: {
        this.velocidadeUmaruEating2 = velocidade;
        break;
      }
      case 3: {
        this.velocidadeUmaruEating3 = velocidade;
        break;
      }
      case 4: {
        this.velocidadeUmaruEating4 = velocidade;
        break;
      }
      default: {
        System.out.println("Erro no switch da velocidade do comer");
        break;
      }
    }//Fim do switch
  }//Fim do metodo setVelocidadeComer

/* ***************************************************************
* Metodo: getVelocidadeComer
* Funcao: passar a velocidade do slider para a thread referente a cada filosofo
* Parametros: int id = filosofo selecionado para ter sua velocidade alterada
* Retorno: long
*************************************************************** */
  public long getVelocidadeComer (int id){
    switch (id){
      case 0: {
        return this.velocidadeUmaruEating0;
      }
      case 1: {
        return this.velocidadeUmaruEating1;
      }
      case 2: {
        return this.velocidadeUmaruEating2;
      }
      case 3: {
        return this.velocidadeUmaruEating3;
      }
      case 4: {
        return this.velocidadeUmaruEating4;
      }
      default: {
        return 0;
      }
    }//Fim do switch
  }//Fim do metodo getVelocidadeComer
}//Fim da classe ControleGeral
