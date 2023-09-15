package Controller;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class ControleArvoreGenealogica {
  
  @FXML
  public ImageView imagemFilho3Mirin;

  @FXML
  public ImageView imagemNeto2Morre;

  @FXML
  public ImageView imagemFilho3Adulto;

  @FXML
  public ImageView imagemPaiIdoso;

  @FXML
  public ImageView imagemBisneto1Jovem;

  @FXML
  public ImageView imagemFilho1Adulto;

  @FXML
  public ImageView imagemPaiAdulto;

  @FXML
  public TextField textFieldFilho3;

  @FXML
  public ImageView imagemPaiIdosoMorre;

  @FXML
  public ImageView imageArvore;

  @FXML
  public ImageView imagemFilho2Jovem;

  @FXML
  public ImageView imagemFilho2Idoso;

  @FXML
  public ImageView imagemFilho3Idoso;

  @FXML
  public ImageView imagemPaiJovem;

  @FXML
  public ImageView imagemFilho1Mirin;

  @FXML
  public ImageView imagemNeto1Jovem;

  @FXML
  public ImageView imagemNeto1Morre;

  @FXML
  public TextField textFieldFilho1;

  @FXML
  public TextField textFieldFilho2;

  @FXML
  public ImageView imagemFilho2IdosoMorre;

  @FXML
  public TextField textFieldBisneto1;

  @FXML
  public ImageView imagemBisneto1Morre;

  @FXML
  public ImageView imagemNeto2Mirin;

  @FXML
  public ImageView imagemFilho3Jovem;

  @FXML
  public ImageView ImageBisneto1Mirin;

  @FXML
  public ImageView imagemNeto2Adulto;

  @FXML
  public ImageView imagemNeto2Jovem;

  @FXML
  public TextField textFieldNeto2;

  @FXML
  public TextField textFieldNeto1;

  @FXML
  public TextField textFieldPai;

  @FXML
  public Button buttonIniciar;

  @FXML
  public ImageView imagemFilho1IdosoMorre;

  @FXML
  public ImageView imagemFilho2Adulto;

  @FXML
  public ImageView imagemNeto1Mirin;

  @FXML
  public ImageView imagemPaiMirin;

  @FXML
  public ImageView imagemFilho1Jovem;

  @FXML
  public ImageView imagemFundo2;

  @FXML
  public ImageView imagemFilho2Mirin;

  @FXML
  public ImageView imagemFundo1;

  @FXML
  public ImageView imagemFilho3IdosoMorre;

  @FXML
  public ImageView imagemNeto1Adulto;

  @FXML
  public ImageView imagemFilho1Idoso;

/* ***************************************************************
* Metodo: buttonIniciar
* Funcao: Faz com que a arvore genealogica entre em acao, ou seja, faz o funcionamento do programa
* Parametros: ActionEvent event = evento que requer uma acao para ser executado, que no caso eh um botao
* Retorno: void
*************************************************************** */
  @FXML
  void buttonIniciar(ActionEvent event) throws InterruptedException {//InterruptedException funciona quando a thread eh interrompida, fazendo com que a thread entre no estado de terminado/finalizado.
    buttonIniciar.setVisible(false);
   
    ProcessoNasceOPai pNP = new ProcessoNasceOPai();
    ProcessoNasceOPrimeiroFilho pNPF = new ProcessoNasceOPrimeiroFilho();
    ProcessoNasceOSegundoFilho pNSF = new ProcessoNasceOSegundoFilho();
    ProcessoNasceOTerceiroFilho pNTF = new ProcessoNasceOTerceiroFilho();
    ProcessoPaiEhAvoDoPrimeiroFilho pPAPF = new ProcessoPaiEhAvoDoPrimeiroFilho();
    ProcessoPaiEhAvoDoSegundoFilho pPASF = new ProcessoPaiEhAvoDoSegundoFilho();
    ProcessoPaiEhBisavoDoPrimeiroFilho pPBPF = new ProcessoPaiEhBisavoDoPrimeiroFilho();
    ProcessoPrimeiroFilhoMorre pPFM = new ProcessoPrimeiroFilhoMorre();
    ProcessoSegundoFilhoMorre pSFM = new ProcessoSegundoFilhoMorre();
    ProcessoTerceiroFilhoMorre pTFM = new ProcessoTerceiroFilhoMorre();
    ProcessoPrimeiroNetoMorre pPNM = new ProcessoPrimeiroNetoMorre();
    ProcessoSegundoNetoMorre pSNF = new ProcessoSegundoNetoMorre();
    ProcessoBisnetoMorre pBNF = new ProcessoBisnetoMorre();
    ProcessoPaiMorre pPM = new ProcessoPaiMorre();
    
    
    FadeTransition ft = new FadeTransition(Duration.millis(800), imageArvore);//A classe FadeTransition serve para realizar uma transicao basicamente atraves da mudanca de opacidade de um valor para tal, nessa transicao foi aplicado de 0 (sem opacidade) para 1 (100% de opacidade), ela pega um intervalo de tempo que voce define em milisegundos para aplicar isso e uma imagem/objeto que almeja aplicar a transicao. 
    imageArvore.setVisible(true);
    ft.setFromValue(0.0);
    ft.setToValue(1.0);
    ft.play();

    pNP.start();//Comeco do processo de nascer o pai
    pNPF.start();//Comeco do processo de nascer o primeiro filho
    pNSF.start();//Comeco do processo de nascer o segundo filho
    pPAPF.start();//Comeco do processo de nascer o filho do primeiro filho
    pPASF.start();//Comeco do processo de nascer o filho do segundo filho
    pNTF.start();//Comeco do processo de nascer o terceiro filho
    pPBPF.start();//Comeco do processo de nascer o primeiro filho do primeiro filho do primeiro filho
    pPFM.start();//Comeco do processo de morte do primeiro filho
    pSFM.start();//Comeco do processo de morte do segundo filho
    pTFM.start();//Comeco do processo de morte do terceiro filho
    pPNM.start();//Comeco do processo de morte do primeiro filho do primeiro filho (ja falecido)
    pSNF.start();//Comeco do processo de morte do primeiro filho do segundo filho (ja falecido)
    pBNF.start();//Comeco do processo de morte do primeiro filho do primeiro filho (ja falecido) do primeiro filho (ja falecido)
    pPM.start();//Comeco do processo de morte do pai
  }//Fim do metodo buttonIniciar

  public class ProcessoNasceOPai extends Thread {
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 0;
      temporizador.schedule(nasceOPai, tempo);
    }//Fim do metodo run
    TimerTask nasceOPai = new TimerTask() {
      @Override
      public void run () {
        FadeTransition ft = new FadeTransition(Duration.millis(600), imagemPaiMirin);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        textFieldPai.setVisible(true);
        imagemPaiMirin.setVisible(true);
        textFieldPai.setText("Nasce o pai");

        System.out.println("O pai nasce");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoNasceOPai

  public class ProcessoNasceOPrimeiroFilho extends Thread{
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 22*1000;
      temporizador.schedule(nasceOPrimeiroFilho,tempo);
    }//Fim do metodo run
    TimerTask nasceOPrimeiroFilho = new TimerTask(){
      @Override
      public void run () {
      imagemPaiAdulto.setVisible(true);
      FadeTransition ft = new FadeTransition(Duration.millis(600), imagemPaiAdulto);
      ft.setFromValue(0.0);
      ft.setToValue(1.0);
      ft.play();
      imagemPaiMirin.setVisible(false);
      textFieldPai.setVisible(false);
      textFieldPai.setText("");

      textFieldFilho1.setVisible(true);
      textFieldFilho1.setText("Filho 1 nasce");
      imagemFilho1Mirin.setVisible(true);

      System.out.println("O pai tem o primeiro filho aos 22 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoNasceOPrimeiroFilho

  public class ProcessoNasceOSegundoFilho extends Thread {
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 25*1000;
      temporizador.schedule(nasceOSegundoFilho,tempo);
    }//Fim do metodo run
    TimerTask nasceOSegundoFilho = new TimerTask(){
      @Override
      public void run () {
        textFieldFilho2.setVisible(true);
        textFieldFilho2.setText("Filho 2 nasce");
        imagemFilho2Mirin.setVisible(true);

        System.out.println("O pai tem o segundo filho aos 25 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoNasceOSegundoFilho

  public class ProcessoNasceOTerceiroFilho extends Thread {
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 32*1000;
      temporizador.schedule(nasceOTerceiroFilho,tempo);
    }//Fim do metodo run
    TimerTask nasceOTerceiroFilho = new TimerTask(){
      @Override
      public void run () {
        textFieldFilho1.setVisible(false);
        textFieldFilho1.setText("");

        textFieldFilho2.setVisible(false);
        textFieldFilho2.setText("");

        textFieldFilho3.setVisible(true);
        textFieldFilho3.setText("Filho 3 nasce");
        imagemFilho3Mirin.setVisible(true);

        System.out.println("O pai tem o terceiro filho aos 32 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoNasceOTerceiroFilho

  public class ProcessoPaiEhAvoDoPrimeiroFilho extends Thread {
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 38*1000;
      temporizador.schedule(paiEhAvoDoPrimeiroFilho, tempo);
    }//Fim do metodo run
    TimerTask paiEhAvoDoPrimeiroFilho = new TimerTask() {
      @Override
      public void run () {
        textFieldFilho3.setVisible(false);
        textFieldFilho3.setText("");

        imagemFilho1Mirin.setVisible(false);
        imagemFilho1Jovem.setVisible(true);

        imagemFilho2Mirin.setVisible(false);
        imagemFilho2Jovem.setVisible(true);

        textFieldNeto1.setVisible(true);
        textFieldNeto1.setText("Neto 1 nasce");
        imagemNeto1Mirin.setVisible(true);

        System.out.println("O pai eh avo (primeiro filho) aos 38 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoPaiEhAvoDoPrimeiroFilho

  public class ProcessoPaiEhAvoDoSegundoFilho extends Thread {
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 45*1000;
      temporizador.schedule(paiEhAvoDoSegundoFilho, tempo);
    }//Fim do metodo run
    TimerTask paiEhAvoDoSegundoFilho = new TimerTask() {
      @Override
      public void run () {
        textFieldNeto1.setVisible(false);
        textFieldNeto1.setText("");

        imagemFilho3Mirin.setVisible(false);
        imagemFilho3Jovem.setVisible(true);

        textFieldNeto2.setVisible(true);
        textFieldNeto2.setText("Neto 2 nasce");
        imagemNeto2Mirin.setVisible(true);

        System.out.println("O pai eh avo (segundo filho) aos 45 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoPaiEhAvoDoSegundoFilho

  public class ProcessoPaiEhBisavoDoPrimeiroFilho extends Thread{
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 68*1000;
      temporizador.schedule(paiEhBisavoDoPrimeiroFilho,tempo);
    }//Fim do metodo run
    TimerTask paiEhBisavoDoPrimeiroFilho = new TimerTask() {
      @Override
      public void run () {
        imagemPaiAdulto.setVisible(false);
        imagemPaiIdoso.setVisible(true);

        imagemFilho1Jovem.setVisible(false);
        imagemFilho1Adulto.setVisible(true);

        imagemFilho2Jovem.setVisible(false);
        imagemFilho2Adulto.setVisible(true);

        imagemNeto2Mirin.setVisible(false);
        imagemNeto2Jovem.setVisible(true);
        textFieldNeto2.setVisible(false);
        textFieldNeto2.setText("");

        imagemNeto1Mirin.setVisible(false);
        imagemNeto1Jovem.setVisible(false);
        imagemNeto1Adulto.setVisible(true);

        textFieldBisneto1.setVisible(true);
        ImageBisneto1Mirin.setVisible(true);
        textFieldBisneto1.setText("Bisneto 1 nasce");

        System.out.println("O pai eh bisavo (primeiro filho) aos 68 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe PaiEhBisavoDoPrimeiroFilho

  public class ProcessoPrimeiroFilhoMorre extends Thread {
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 83*1000;
      temporizador.schedule(primeiroFilhoMorre, tempo);
    }//Fim do metodo run
    TimerTask primeiroFilhoMorre = new TimerTask() {
      @Override
      public void run () {
        imagemFilho1Idoso.setVisible(false);
        imagemFilho1IdosoMorre.setVisible(true);
        textFieldFilho1.setText("Filho 1 morre");
        textFieldFilho1.setVisible(true);

        System.out.println("O primeiro filho morre aos 61 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoPrimeiroFilhoMorre

  public class ProcessoSegundoFilhoMorre extends Thread {
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 80*1000;
      temporizador.schedule(segundoFilhoMorre, tempo);
    }//Fim do metodo run
    TimerTask segundoFilhoMorre = new TimerTask() {
      @Override
      public void run () {
        imagemFilho2Idoso.setVisible(false);
        imagemFilho2IdosoMorre.setVisible(true);
        textFieldFilho2.setText("Filho 2 morre");
        textFieldFilho2.setVisible(true);

        System.out.println("O segundo filho morre aos 55 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoSegundoFilhoMorre

  public class ProcessoTerceiroFilhoMorre extends Thread {
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 87*1000;
      temporizador.schedule(terceiroFilhoMorre, tempo);
    }//Fim do metodo run
    TimerTask terceiroFilhoMorre = new TimerTask() {
      @Override
      public void run () {
        textFieldFilho1.setVisible(false);
        textFieldFilho1.setText("");

        textFieldFilho2.setVisible(false);
        textFieldFilho2.setText("");

        textFieldBisneto1.setVisible(false);
        textFieldBisneto1.setText("");

        imagemFilho3Adulto.setVisible(false);
        imagemFilho3IdosoMorre.setVisible(true);
        textFieldFilho3.setText("Filho 3 morre");
        textFieldFilho3.setVisible(true);

        System.out.println("O terceiro filho morre aos 55 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoTerceiroFilhoMorre

  public class ProcessoPrimeiroNetoMorre extends Thread {
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 73*1000;
      temporizador.schedule(primeiroNetoMorre, tempo);
    }//Fim do metodo run
    TimerTask primeiroNetoMorre = new TimerTask() {
      @Override
      public void run () {
        imagemFilho1Adulto.setVisible(false);
        imagemFilho1Idoso.setVisible(true);

        imagemFilho2Adulto.setVisible(false);
        imagemFilho2Idoso.setVisible(true);

        imagemFilho3Jovem.setVisible(false);
        imagemFilho3Adulto.setVisible(true);

        textFieldBisneto1.setVisible(false);
        textFieldBisneto1.setText("");

        imagemNeto1Adulto.setVisible(false);
        imagemNeto1Morre.setVisible(true);
        textFieldNeto1.setVisible(true);
        textFieldNeto1.setText("Neto 1 morre");

        FadeTransition ft2 = new FadeTransition(Duration.millis(600), imagemFundo1);
        imagemFundo2.setVisible(true);
        ft2.setFromValue(1.0);
        ft2.setToValue(0.0);
        ft2.play();

        FadeTransition ft = new FadeTransition(Duration.millis(800), imagemFundo2);
        imagemFundo2.setVisible(true);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();

        System.out.println("O primeiro neto morre aos 35 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoPrimeiroNetoMorre

  public class ProcessoSegundoNetoMorre extends Thread {
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 78*1000;
      temporizador.schedule(segundoNetoMorre, tempo);
    }//Fim do metodo run
    TimerTask segundoNetoMorre = new TimerTask (){
      @Override
      public void run () {
        textFieldNeto1.setVisible(false);
        textFieldNeto1.setText("");

        imagemNeto2Jovem.setVisible(false);
        imagemNeto2Morre.setVisible(true);
        textFieldNeto2.setText("Neto 2 morre");
        textFieldNeto2.setVisible(true);

        System.out.println("O segundo neto morre aos 33 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoSegundoNetoMorre

  public class ProcessoBisnetoMorre extends Thread {
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 80*1000;
      temporizador.schedule(bisnetoMorre, tempo);
    }//Fim do metodo run
    TimerTask bisnetoMorre = new TimerTask() {
      @Override
      public void run () {
        textFieldNeto2.setVisible(false);
        textFieldNeto2.setText("");

        ImageBisneto1Mirin.setVisible(false);
        imagemBisneto1Jovem.setVisible(false);
        imagemBisneto1Morre.setVisible(true);
        textFieldBisneto1.setText("Bisneto 1 morre");
        textFieldBisneto1.setVisible(true);
        
        System.out.println("Bisneto morre aos 12 anos de idade");
      }//Fim do metodo run
    };//Fim do TimerTask 
  }//Fim da classe ProcessoBisnetoMorre

  public class ProcessoPaiMorre extends Thread {
    @Override
    public void run () {
      Timer temporizador = new Timer();
      long tempo = 90*1000;
      temporizador.schedule(paiMorre, tempo);
    }//Fim do metodo run
    TimerTask paiMorre = new TimerTask() {
      @Override
      public void run () {
        imagemPaiIdoso.setVisible(false);
        imagemPaiIdosoMorre.setVisible(true);
        textFieldPai.setText("Pai morre");
        textFieldPai.setVisible(true);

        System.out.println("Pai morre aos 90 anos de idade");
        System.out.println("\nFim\n");
      }//Fim do metodo run
    };//Fim do TimerTask
  }//Fim da classe ProcessoPaiMorre
}//Fim da classe ControleArvoreGenealogica
