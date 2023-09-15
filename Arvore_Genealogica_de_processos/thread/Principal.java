/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 07/03/2022
* Ultima alteracao.: 12/03/2022
* Nome.............: Arvore Genealogica
* Funcao...........: O programa basicamente funciona como uma arvore genealogica, exibindo desde o nascimento ate a morte do "pai"
*************************************************************** */
import java.io.IOException;

import Util.MudancaDeTela;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage cenario) throws IOException {
    MudancaDeTela.init(cenario);
  }
}