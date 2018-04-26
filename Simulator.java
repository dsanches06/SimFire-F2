
import java.util.*;

/**
 * Escreva a descrição da classe Simulator aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class Simulator {

    //Lista de incêndios.
    Fire fire1;
    Fire fire2;
    Fire fire3;
    //Condições climatéricas.
    Weather weather;
    //Lista de quarteis disponíveis.
    Quarter quarterBSL;
     //Lista de quarteis disponíveis.
    Quarter quarterBVB;
    //Lista de pontos de abastecimento disponíveis.
    SupplyStation supplyStation;

    //Construtor
    public Simulator() {
        init();
    }

    private void init() {

         //criar 1 condiçoes climatericas
        weather = new Weather(45, 100, 100);
        
        //criar 1 fogos 
        fire1 = new Fire(new Location(30, -30), 50, Time.getSistemTime());
        fire2 = new Fire(new Location(-10, -150), 100, Time.getSistemTime());
        fire3 = new Fire(new Location(90, -90), 150, Time.getSistemTime());
        //criar 1 quartel 
        quarterBSL = new Quarter("BSL", new Location(16, 30));

        //criar 3 veiculos 
        CombatVehicle vehicle1 = new CombatVehicle(2000);
        CombatVehicle vehicle2 = new CombatVehicle(2000);
        CombatVehicle vehicle3 = new CombatVehicle(2000);
        quarterBSL.addCombatVehicle(vehicle1);
        quarterBSL.addCombatVehicle(vehicle2);
        quarterBSL.addCombatVehicle(vehicle3);

        //criar 10 bombeiros 
        Fireman fireman1 = new Fireman(100, true);//condutor
        quarterBSL.addFireman(fireman1);
        Fireman fireman2 = new Fireman(100, true);//condutor
        quarterBSL.addFireman(fireman2);
        Fireman fireman3 = new Fireman(100, true);//condutor
        quarterBSL.addFireman(fireman3);
        Fireman fireman4 = new Fireman(100, false);//ajudante
        quarterBSL.addFireman(fireman4);
        Fireman fireman5 = new Fireman(100, false);//ajudante
        quarterBSL.addFireman(fireman5);
        Fireman fireman6 = new Fireman(100, false);//ajudante
        quarterBSL.addFireman(fireman6);
        Fireman fireman7 = new Fireman(100, false);//ajudante
        quarterBSL.addFireman(fireman7);
        Fireman fireman8 = new Fireman(100, false);//ajudante
        quarterBSL.addFireman(fireman8);
        Fireman fireman9 = new Fireman(100, false);//ajudante
        quarterBSL.addFireman(fireman9);
        Fireman fireman10 = new Fireman(100, false);//ajudante
        quarterBSL.addFireman(fireman10);
        
        quarterBVB = new Quarter("BVB", new Location(-26, 30));

        CombatVehicle vehicle4 = new CombatVehicle(2000);
        CombatVehicle vehicle5 = new CombatVehicle(2000);
        CombatVehicle vehicle6 = new CombatVehicle(2000);
        quarterBVB.addCombatVehicle(vehicle4);
        quarterBVB.addCombatVehicle(vehicle5);
        quarterBVB.addCombatVehicle(vehicle6);
        
        Fireman fireman11 = new Fireman(100, false);//ajudante
        quarterBVB.addFireman(fireman11);
        Fireman fireman12 = new Fireman(100, false);//ajudante
        quarterBVB.addFireman(fireman12);
        Fireman fireman13 = new Fireman(100, true);//ajudante
        quarterBVB.addFireman(fireman13);
        Fireman fireman14 = new Fireman(100, true);//condutor
        quarterBVB.addFireman(fireman14);
        Fireman fireman15 = new Fireman(100, false);//condutor
        quarterBVB.addFireman(fireman15);
        Fireman fireman16 = new Fireman(100, false);//ajudante
        quarterBVB.addFireman(fireman16);
        Fireman fireman17 = new Fireman(100, false);//condutor
        quarterBVB.addFireman(fireman15);
        Fireman fireman18 = new Fireman(100, false);//ajudante
        quarterBVB.addFireman(fireman16);
     
        //criar 1 posto de abastecimento 
        supplyStation = new SupplyStation("PS", new Location(-45,30), 1000000);
    }

    public void iniciarSimulacao() {
        //paa limpar tela de output
        limparTela();
        //mensagem de inicio da simulaçao
        System.out.print("\t--- INICIO DA SIMULAÇAO ---\n");
        //tempo
        weather.act();
        //fogo
        fire1.act();
        quarterBSL.act(fire1);
                
        fire2.act();
        quarterBVB.act(fire2);
               
        fire3.act();
        quarterBVB.act(fire3);
        quarterBSL.act(fire3);
        
        supplyStation.act();
    }
    
     private static void limparTela(){
      System.out.print('\u000C');
    }

}
