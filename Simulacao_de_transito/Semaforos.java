/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Inicio...........: 20/05/2022
* Ultima alteracao.: 22/05/2022
* Nome.............: Semaforos
* Funcao...........: "guardar" e instanciar os semaforos
*************************************************************** */
import java.util.concurrent.Semaphore;
public abstract class Semaforos {
  //Semaforos referente ao bob esponja e o plankton (carro 1 e 2)
  public static Semaphore spongebobPlankton1 = new Semaphore(1);//Inferior esquerdo até superior esquerdo
  public static Semaphore spongebobPlankton2 = new Semaphore(1);//Superior Centro até lateral cima direito
  public static Semaphore spongebobPlankton3 = new Semaphore(1);//Lateral baixo direito ate baixo direito
  public static Semaphore spongebobPlankton4 = new Semaphore(1);//Esquina dos 2 acima

  //Semaforos referentes ao bob esponja, plankton e o tubarão (carros 1, 2 e 3)
  public static Semaphore sharkEntradaInicial = new Semaphore(1);//Lateral esquerda
  public static Semaphore sharkBloqueiaBobEsponja1 = new Semaphore(1);//Centro (shark-bobesponja)
  public static Semaphore sharkBloqueiaBobEsponja2 = new Semaphore(1);
  public static Semaphore sharkBloqueiaPlankton1 = new Semaphore(1);

  //Semaforos referentes ao bob esponja, plankton, e o carro de corrida (carros 1, 2, 4). O carro 3 nao interfere no percursso
  public static Semaphore raceCarSpongebob = new Semaphore(1);
  public static Semaphore raceCarPlankton = new Semaphore(1);
  public static Semaphore raceCarBloqueiaPlankton1 = new Semaphore(1);
  public static Semaphore raceCarBloqueiaPlankton2 = new Semaphore(1);
  public static Semaphore raceCarBloqueiaBobEsponja1 = new Semaphore(1);
  public static Semaphore raceCarBloqueiaBobEsponja2 = new Semaphore(1);
  public static Semaphore raceCarBloqueiaBobEsponja3 = new Semaphore(1);

  //Semaforos referentes ao bob esponja, plankton, o carro de corrida e o peixe vermelho (carros 1, 2, 4, 5). O carro 3 nao interfere no percursso
  public static Semaphore redfishCarBloqueiaShark1 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaShark2 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaShark3 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaRace1 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaRace2 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaRace3 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaBobEsponja1 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaBobEsponja2 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaBobEsponja3 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaBobEsponja4 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaPlankton1 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaPlankton2 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaPlankton3 = new Semaphore(1);
  public static Semaphore redfishCarBloqueiaPlankton4 = new Semaphore(1);

  //Semaforos referentes ao peixe roxo, bob esponja, plankton, tubarao, carro de corrida e o peixe vermelho (carros 1, 2, 3, 4, 5, 6).
  public static Semaphore purplefishCarBloqueiaRedfishCar1 = new Semaphore(1);
  public static Semaphore purplefishCarBloqueiaRedfishCar2 = new Semaphore(1);
  public static Semaphore purplefishCarBloqueiaRaceCar = new Semaphore(1);
  public static Semaphore purplefishCarBloqueiaSharkCar1 = new Semaphore(1);
  public static Semaphore purplefishCarBloqueiaSharkCar2 = new Semaphore(1);
  public static Semaphore purplefishCarBloqueiaPlanktonCar1 = new Semaphore(1);
  public static Semaphore purplefishCarBloqueiaPlanktonCar2 = new Semaphore(1);
  public static Semaphore purplefishCarBloqueiaBobEsponjaCar1 = new Semaphore(1);
  public static Semaphore purplefishCarBloqueiaBobEsponjaCar2 = new Semaphore(1);
  public static Semaphore purplefishCarBloqueiaBobEsponjaCar3 = new Semaphore(1);
  public static Semaphore purplefishCarBloqueiaBobEsponjaCar4 = new Semaphore(1);

  //Semaforos referente ao taxi que afeta todos os outros carros
  public static Semaphore taxiCarBloqueiaPurplefishCar1 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaPurplefishCar2 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaPurplefishCar3 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaRedfishcar1 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaRedfishcar2 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaRedfishcar3 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaRedfishcar4 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaRaceCar1 = new Semaphore(1);
  public static Semaphore taxiCarBloqueiaRaceCar2 = new Semaphore(1);
  public static Semaphore taxiCarBloqueiaRaceCar3 = new Semaphore(1);
  public static Semaphore taxiCarBloqueiaSharkCar1 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaSharkCar2 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaSharkCar3 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaPlankton1 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaPlankton2 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaPlankton3 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaPlankton4 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaPlankton5 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaPlankton6 = new Semaphore (1);
  public static Semaphore taxiCarBloqueiaBobEsponja1 = new Semaphore(1);
  public static Semaphore taxiCarBloqueiaBobEsponja2 = new Semaphore(1);
  public static Semaphore taxiCarBloqueiaBobEsponja3 = new Semaphore(1);
  public static Semaphore taxiCarBloqueiaBobEsponja4 = new Semaphore(1);
  public static Semaphore taxiCarBloqueiaBobEsponja5 = new Semaphore(1);
  public static Semaphore taxiCarBloqueiaBobEsponja6 = new Semaphore(1);
  public static Semaphore taxiCarBloqueiaBobEsponja7 = new Semaphore(1);
  public static Semaphore taxiCarBloqueiaBobEsponja8 = new Semaphore(1);
}
