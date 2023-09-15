/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 20/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: Principal
* Funcao...........: O programa tem como funcionalidade a simulacao de trens em acao
*************************************************************** */
import java.io.IOException;

import Util.MudancaDeTela;
import javafx.application.Application;
import javafx.stage.Stage;


public class Principal extends Application{

/* ***************************************************************
* Metodo: main
* Funcao: lançar o programa
* Parametros: args=essencial para tornar o arquivo como principal
* Retorno: void
*************************************************************** */
  public static void main (String [] args) {
    launch (args);
  }//Fim do metodo main

/* ***************************************************************
* Metodo: start
* Funcao: Iniciar a exibição de telas
* Parametros: cenario=responsavel por permitir o uso de telas
* Retorno: void
*************************************************************** */
  @Override
  public void start(Stage cenario) throws IOException {
    MudancaDeTela.init(cenario);
  }//Fim do metodo start
}//Fim da classe Principal
