/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 25/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: ProcessoTremB
* Funcao...........: Controlar o trem azul
*************************************************************** */
package Model;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import Controller.ControleGeral;

public class ProcessoTremB extends Thread{
  private ControleGeral controle;
  private int velocidadeDoTrem = 25;
  private int posicaoX = 110;//775
  private int posicaoY;
  private ImageView tremAzul;

  public ProcessoTremB (ControleGeral controle) {
    this.controle = controle;
    this.tremAzul = controle.getTremAzul();
    posicaoY = (int) tremAzul.getY();
  }

/* ***************************************************************
* Metodo: run
* Funcao: iniciar o processo/thread
* Parametros: void
* Retorno: void
*************************************************************** */
  @Override
  public void run () {
    try{
      while (true) {
        movimentacaoDoEixoX(-72);
        //"tunel 1"
	      verificarPassagemSimplesDireita();
        mudarStatusDaPassagemSimplesDireita();
	      controle.setVisibleHomemAranhaSuperiorCentroDireito(true);
      	movimentacaoDaPassagemSimples1();
	      mudarStatusDaPassagemSimplesDireita();//CentroDireito
	      controle.setVisibleHomemAranhaSuperiorCentroDireito(false);
        //"tunel 2"
        movimentacaoDoEixoX(-432);
        verificarPassagemSimplesEsquerda();
        mudarStatusDaPassagemSimplesEsquerda();
        controle.setVisibleHomemAranhaSuperiorEsquerdo(true);
        movimentacaoDaPassagemSimples2();
        mudarStatusDaPassagemSimplesEsquerda();
        controle.setVisibleHomemAranhaSuperiorEsquerdo(false);
        //loop do trem
        movimentacaoDoEixoX(-760);
        posicaoX = 110;
        Platform.runLater(() -> tremAzul.setX(110));
      }//Fim do while
    } catch (InterruptedException i) {
        i.printStackTrace();
    }//Fim do try-catch
  }//Fim do metodo run

/* ***************************************************************
* Metodo: verificarPassagemSimplesEsquerda
* Funcao: verificar se a primeira passagem simples (da esquerda para direita) esta livre
* Parametros: void
* Retorno: void
*************************************************************** */
  public void verificarPassagemSimplesEsquerda() {
    while (controle.getViaSimplesEsquerdaLiberada() == false) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException i) {
        i.printStackTrace();
      }//Fim do try-catch
    }//Fim do while
  }//Fim do metodo verificarPassagemSimplesEsquerda

/* ***************************************************************
* Metodo: verificarPassagemSimplesDireita
* Funcao: verificar se a segunda passagem simples (da esquerda para direita) esta livre
* Parametros: void
* Retorno: void
*************************************************************** */
  public void verificarPassagemSimplesDireita() {
    while (controle.getViaSimplesDireitaLiberada() == false) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException i) {
        i.printStackTrace();
      }//Fim do try-catch
    }//Fim do while
  }//Fim do metodo verificarPassagemSimplesDireita

/* ***************************************************************
* Metodo: mudarStatusDaPassagemSimplesEsquerda
* Funcao: muda o estado de passagem livre para passagem ocupada (vice-versa), impedindo a colisao referente a primeira passagem simples (da direita para esquerda)
* Parametros: void
* Retorno: void
*************************************************************** */
  public void mudarStatusDaPassagemSimplesEsquerda() {
    if (controle.getViaSimplesEsquerdaLiberada()) {
      controle.setViaSimplesEsquerdaLiberada(false);
    }else {
      controle.setViaSimplesEsquerdaLiberada(true);
    }//Fim do if-else
  }//Fim do metodo mudarStatusDaPassagemSimplesEsquerda

/* ***************************************************************
* Metodo: mudarStatusDaPassagemSimplesDireita
* Funcao: muda o estado de passagem livre para passagem ocupada (vice-versa), impedindo a colisao referente a segunda passagem simples (da direita para esquerda)
* Parametros: void
* Retorno: void
*************************************************************** */
  public void mudarStatusDaPassagemSimplesDireita() {
    if (controle.getViaSimplesDireitaLiberada()) {
      controle.setViaSimplesDireitaLiberada(false);
    }else {
      controle.setViaSimplesDireitaLiberada(true);
    }//Fim do if-else
  }//Fim do metodo mudarStatusDaPassagemSimplesDireita

/* ***************************************************************
* Metodo: setVelocidade
* Funcao: definir/atualizar a velocidade do trem
* Parametros: int velocidadeDoTrem
* Retorno: void
*************************************************************** */
  public void setVelocidade(int velocidadeDoTrem){
    this.velocidadeDoTrem = velocidadeDoTrem;
  }//Fim do metodo setVelocidade
  
/* ***************************************************************
* Metodo: getVelocidade
* Funcao: recuperar a velocidade atual do trem
* Parametros: void
* Retorno: int
*************************************************************** */
  public int getVelocidade(){
    return this.velocidadeDoTrem;
  }//Fim do metodo getVelocidade

/* ***************************************************************
* Metodo: movimentacaoDaPassagemSimples1
* Funcao: mover o trem pela primeira passagem simples (da esquerda para direita)
* Parametros: void
* Retorno: void
*************************************************************** */
  public void movimentacaoDaPassagemSimples1() throws InterruptedException{
    tremAzul.setY(posicaoY - 19);
    movimentacaoDoEixoX(-246);//493
    tremAzul.setY(posicaoY);
  }//Fim do metodo movimentacaoDaPassagemSimples1

/* ***************************************************************
* Metodo: movimentacaoDaPassagemSimples2
* Funcao: mover o trem pela segunda passagem simples (da esquerda para direita)
* Parametros: void
* Retorno: void
*************************************************************** */
  public void movimentacaoDaPassagemSimples2() throws InterruptedException{
    tremAzul.setY(posicaoY - 19);
    movimentacaoDoEixoX(-675);//79
    tremAzul.setY(posicaoY);
  }//Fim do metodo movimentacaoDaPassagemSimples2

/* ***************************************************************
* Metodo: movimentacaoDoEixoX
* Funcao: Fazer a animacao do trem se mover e mover o trem pelo eixo x
* Parametros: int stopPosition = valor que limitara o movimento do trem (o trem se movera ate atingir o valor do parametro)
* Retorno: void
*************************************************************** */
  public void movimentacaoDoEixoX(int stop) throws InterruptedException{
    while(posicaoX != stop){
      Thread.sleep(velocidadeDoTrem);
      final int posicaoConstante = posicaoX;
      Platform.runLater( () -> tremAzul.setX(posicaoConstante));
      posicaoX--;
    }//Fim do while
  }//Fim do metodo movimentacaoDoEixoX
}//Fim da classe processoTremB
