import java.util.*;
import java.text.DecimalFormat;
/**
 * Escreva a descrição da classe SupplyStation aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class SupplyStation
{
    
     //capacidade maxima de veiculos
    public static final int MAX_VEHICLES = 3;
    // capacidade atual de agua
    private int waterCapacity;
    //nome
    private String name;
    //localizaçao
    private Location location;
    //lista de veiculos
    private Map<Integer, CombatVehicle> vehicles;
    //tempo da entrada de veiculos
    private Time time;

    /* Construtor */
    public SupplyStation(String name, Location location, int waterCapacity) {
        //se nome for valido
        if ((isNameValid(name))
                //e localizaçao for valida
                && (location.isLocationValid(location))) {
            this.name = name;
            this.location = location;
            this.waterCapacity = waterCapacity;
            this.vehicles = new HashMap<>(SupplyStation.MAX_VEHICLES);
            this.time = null;
        }
    }

    //mostrar informaçao do quartel
    public void showInf() {
        System.out.println("\n --- POSTO DE ABASTECIMENTO ---");
        System.out.println("Nome: " + this.name);
        this.location.showInf();
        System.out.println("Capacidade Agua   : " + this.waterCapacity + "L");
        System.out.println("-- DADOS DOS VEICULOS --");
        if (vehicles.isEmpty() != true) {
            for (CombatVehicle vehicle : vehicles.values()) {
                vehicle.showInf();
                System.out.println("--");
            }
        } else {
            System.out.println(" Qt Veiculo: " + vehicles.size());
        }

    }
    
    public void act() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.format("\nPosto Abastecimento %s na posicao [%s,%s] com capacidade de %02dL de agua.\n",
                name, df.format(location.getLatitude()), 
                df.format(location.getLongitude()),
                waterCapacity);
    }
    
    private boolean isNameValid(String nome) {
        return !(nome.isEmpty() || nome.length() == 0);
    }

    //metodo para reabastecer o veiculo
    public boolean vehicleFuel() {
        //verifica se o veiculo esta na mesma posicao

        return true;
    }

    //adicionar veiculo
    public boolean addCombatVehicle(CombatVehicle vehicle) {
        //se veiculo existir
        if ((vehicles.containsKey(vehicle.getId()))
                && (vehicles.containsValue(vehicle))) {
            //retorna falso
            return false;
        }
        //altera a localizaçao do veiculo para mesma do posto de abastecimento
        vehicle.setLocation(this.location);
        vehicles.put(vehicle.getId(), vehicle);
        return true;
    }

    //adicionar bombeiro
    public CombatVehicle removeCombatVehicle(int vehiclesID) {
        int idx;
        CombatVehicle vehicleRemove = null;
        //obter a posição do camião
        idx = indexOfVehicleByID(vehiclesID);
        //se for diferente de - 1
        if (idx != -1) {
            //cria uma cópia
            vehicleRemove = vehicles.remove(idx);
        }//retorna o bombeiro removido
        return vehicleRemove;
    }

    /* Metódo para obter a posição do veiculo no quartel */
    private int indexOfVehicleByID(int vehicleID) {
        //faz o loop para obter a chave do veiculo na lista
        for (int pos : vehicles.keySet()) {
            //e tiver o mesmo codigo
            if (vehicles.get(pos).getId() == vehicleID) {
                return pos;
            }
        }//se for o contrário, retorna -1
        return -1;
    }
}
