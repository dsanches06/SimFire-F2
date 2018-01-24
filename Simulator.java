import java.util.*;
/**
 * Escreva a descrição da classe Simulator aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Simulator
{
    //Lista de quarteis disponíveis.
    List<Quarter> quarters;
    //Lista de pontos de abastecimento disponíveis.
    List<SupplyStation> supplyStations;
    // Lista de veículos disponíveis.
    Map<Integer,CombatVehicle> vehicles;
    //Lista de bombeiros disponíveis.
    Map<Integer,Fireman> firemans;
    //Lista de incêndios.
    Set<Fire> fires;
    //Condições climatéricas.
    Set<Weather> weathers;

    //Construtor
    public Simulator() {
        this.quarters = new ArrayList<>();
        this.supplyStations = new ArrayList<>();
        this.vehicles = new HashMap<>();
        this.firemans = new HashMap<>();
        this.fires = new HashSet<>();
        this.weathers = new HashSet<>();
    }

    public void init() {
        //criar 5 condiçoes climatericas
        createWeathers();
        //criar 5 fogos 
        createFires();
        //criar 10 bombeiros
        createFiremans();
        //criar 5 veiculos 
        createVehicles();
        //criar 5 quartel
        createQuarters();
        //criar 5 posto de abastecimento 
        createSupplyStations();
    }

    private void createQuarters() {
        //criar 5 quartel 
        
       quarters.add(new Quarter("BSL", new Location(-26, 30)));
       quarters.add( new Quarter("BSS", new Location()));
       quarters.add( new Quarter("BRT", new Location()));
       quarters.add(new Quarter("BSP", new Location()));
       quarters.add( new Quarter("BVB", new Location()));
    }

    private void createVehicles() {
        //criar 5 veiculos 
       CombatVehicle vehicle1 = new CombatVehicle(2000);
       CombatVehicle vehicle2 = new CombatVehicle(2000);
       CombatVehicle vehicle3 = new CombatVehicle(2000);
       CombatVehicle vehicle4 = new CombatVehicle(2000);
       CombatVehicle vehicle5 = new CombatVehicle(2000);
       
       //adicionar na lista
       vehicles.put(vehicle1.getId(), vehicle1);
       vehicles.put(vehicle2.getId(), vehicle2);
       vehicles.put(vehicle3.getId(), vehicle3);
       vehicles.put(vehicle4.getId(), vehicle4);
       vehicles.put(vehicle5.getId(), vehicle5);

    }

    private void createFiremans() {
        //criar 10 bombeiros 
        Fireman fireman1 = new Fireman(100, true);//condutor
        Fireman fireman2 = new Fireman(100, true);//condutor
        Fireman fireman3 = new Fireman(100, true);//condutor
        Fireman fireman4 = new Fireman(100, false);//ajudante
        Fireman fireman5 = new Fireman(100, false);//ajudante
        Fireman fireman6 = new Fireman(100, false);//ajudante
        Fireman fireman7 = new Fireman(100, false);//ajudante
        Fireman fireman8 = new Fireman(100, false);//ajudante
        Fireman fireman9 = new Fireman(100, false);//ajudante
        Fireman fireman10 = new Fireman(100, false);//ajudante

        //adicionar na lista
        firemans.put(fireman1.getId(), fireman1);
        firemans.put(fireman2.getId(), fireman2);
        firemans.put(fireman3.getId(), fireman3);
        firemans.put(fireman4.getId(), fireman4);
        firemans.put(fireman5.getId(), fireman5);
        firemans.put(fireman6.getId(), fireman6);
        firemans.put(fireman7.getId(), fireman7);
        firemans.put(fireman8.getId(), fireman8);
        firemans.put(fireman9.getId(), fireman9);
        firemans.put(fireman10.getId(), fireman10);
    }

    private void createSupplyStations() {
        //criar 5 posto de abastecimento 
        supplyStations.add(new SupplyStation("PS", new Location(), 1000000));
        supplyStations.add(new SupplyStation("PL", new Location(), 1000000));
        supplyStations.add(new SupplyStation("PB", new Location(), 1000000));
        supplyStations.add(new SupplyStation("PA", new Location(), 1000000));
        supplyStations.add(new SupplyStation("PP", new Location(), 1000000));

    }

    private void createFires() {
        //criar 5 fogos 
        fires.add(new Fire(new Location(30, -30), Time.getSistemTime()));
        fires.add(new Fire(new Location(), Time.getSistemTime()));
        fires.add(new Fire(new Location(), Time.getSistemTime()));
        fires.add(new Fire(new Location(), Time.getSistemTime()));

    }

    private void createWeathers() {
        //criar 5 condiçoes climatericas
        weathers.add(new Weather(45, 100, 100));
        weathers.add( new Weather(45, 100, 100));
        weathers.add(new Weather(45, 100, 100));
        weathers.add(new Weather(45, 100, 100));
        weathers.add(new Weather(45, 100, 100));
    }

}
