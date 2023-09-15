/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 25/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: ProcessoTremA
* Funcao...........: Controlar o trem vermelho
*************************************************************** */
package Model;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import Controller.ControleGeral;

public class ProcessoTremA extends Thread{
  private ControleGeral controle;
  private int velocidadeDoTrem = 25;
  private int posicaoX = -110;
  private int posicaoY;
  private ImageView tremVermelho;

  public ProcessoTremA (ControleGeral controle) {
    this.controle = controle;
    this.tremVermelho = controle.getTremVermelho();
    posicaoY = (int) tremVermelho.getY();
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
        movimentacaoDoEixoX(50);
        //"tunel1"
	      verificarPassagemSimplesEsquerda();
        mudarStatusDaPassagemSimplesEsquerda();
	      controle.setVisibleHomemAranhaSuperiorCentroEsquerdo(true);
      	movimentacaoDaPassagemSimples1();
	      mudarStatusDaPassagemSimplesEsquerda();
	      controle.setVisibleHomemAranhaSuperiorCentroEsquerdo(false);
        //"tunel2"
        movimentacaoDoEixoX(432);
        verificarPassagemSimplesDireita();
        mudarStatusDaPassagemSimplesDireita();
        controle.setVisibleHomemAranhaSuperiorDireito(true);
        movimentacaoDaPassagemSimples2();
        mudarStatusDaPassagemSimplesDireita();
        controle.setVisibleHomemAranhaSuperiorDireito(false);
        //loop do trem
        movimentacaoDoEixoX(760);
        posicaoX = -110;
        Platform.runLater( () -> tremVermelho.setX(-110));
        
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
      } catch (InterruptedException i) {}//Fim do try - catch
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
      } catch (InterruptedException i) {}//Fim do try-catch
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
    tremVermelho.setY(posicaoY + 19);
    movimentacaoDoEixoX(246);
    tremVermelho.setY(posicaoY);
  }//Fim do metodo movimentacaoDaPassagemSimples1

/* ***************************************************************
* Metodo: movimentacaoDaPassagemSimples2
* Funcao: mover o trem pela segunda passagem simples (da esquerda para direita)
* Parametros: void
* Retorno: void
*************************************************************** */
  public void movimentacaoDaPassagemSimples2() throws InterruptedException{
    tremVermelho.setY(posicaoY + 19);
    movimentacaoDoEixoX(675);
    tremVermelho.setY(posicaoY);
  }//Fim do metodo movimentacaoDaPassagemSimples2

/* ***************************************************************
* Metodo: movimentacaoDoEixoX
* Funcao: Fazer a animacao do trem se mover e mover o trem pelo eixo x
* Parametros: int stopPosition = valor que limitara o movimento do trem (o trem se movera ate atingir o valor do parametro)
* Retorno: void
*************************************************************** */
  public void movimentacaoDoEixoX(int stopPosition) throws InterruptedException{
    while(posicaoX != stopPosition){
      Thread.sleep(velocidadeDoTrem);
      final int posicaoConstante = posicaoX;
      Platform.runLater( () -> tremVermelho.setX(posicaoConstante));
      posicaoX++;
    }//Fim do while
  }//Fim do metodo movimentacaoDoEixoX
}//Fim da classe ProcessoTremA
