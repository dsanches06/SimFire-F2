import java.util.*;
/**
 * Escreva a descrição da classe Quarter aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Quarter {

    //capacidade maxima de veiculos
    public static final int MAX_VEHICLES = 3;
    //capacidade maxima de bombeiros
    public static final int MAX_FIREMAN = 20;
    //nome
    private String name;
    //localizaçao
    private Location location;
    //lista de veiculos
    private Map<Integer, CombatVehicle> vehicles;
    //lista de bomeiros
    private List<Fireman> firemans;

    /* Construtor */
    public Quarter(String name, Location location) {
        //se nome for valido
        if ((isNameValid(name))
                //e localizaçao for valida
                && (location.isLocationValid(location))) {
            this.name = name;
            this.location = location;
            this.vehicles = new HashMap<>(Quarter.MAX_VEHICLES);
            this.firemans = new ArrayList<>(Quarter.MAX_FIREMAN);
        }
    }

    //validar meios de alocaçao ao combate, validar veiculos com bombeiros e quantidade de agua?
    public boolean isMeansOfAllocationToCombatIsvalid(CombatVehicle vehicle) {
        //se o veiculo nao existir no quartel
        if ((vehicles.containsKey(vehicle.getId()) != true)
                && (vehicles.containsValue(vehicle)) != true) {
            System.out.println("NAO VALIDO 1");
            //retorna falso
            return false;
        } //verifica ainda se nao contem condutor e bombeiro ajudante, min=3 e max=8         
        else if (vehicle.validMeansOfAllocationOfCombat() != true) {
            System.out.println("NAO VALIDO 2");
            return false;
        }
        //
        System.out.println("VALIDO");
        //retorna verdadeira;
        return true;
    }

    /*
     metodo para validar os meios de alocaçao e mover o 
      veiculo para a posiçao do fogo 
     */
    public CombatVehicle sendVehicleToCombatFire(CombatVehicle vehicle, Fire fire) {
        //se o veiculo a enviar
        CombatVehicle vehicleRemove = null;
        //se o veiculo existir no quartel
        if ((vehicles.containsKey(vehicle.getId()))
                && (vehicles.containsValue(vehicle))) {
            if (isMeansOfAllocationToCombatIsvalid(vehicle) == true) {
                //elimina o veiculo do quartel e cria uma copia
                vehicleRemove = removeCombatVehicle(vehicle.getId());
                //veiculo recebe os dados do fogo
                vehicleRemove.setFire(fire);
                //envia a posiçao do fogo, para o veiculo
                vehicleRemove.setLocation(fire.getLocation());
            }
        }//retorna o veiculo
        return vehicleRemove;
    }

    //mostrar informaçao do quartel
    public void showInf() {
        System.out.println("--- QUARTEL DE BOMBEIROS ---");
        System.out.println("Nome: " + name);
        location.showInf();
        //mostrar os restantes bombeiro
        System.out.print(" -- DADOS DOS BOMBEIROS --");
        
        if (firemans.isEmpty() != true) {
            for (Fireman fireman : firemans) {
                fireman.showInf();
                System.out.println(" ");
            }
        } else {
            System.out.println("\n Qt Bombeiro: " + firemans.size());
        }
        
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
    
    private boolean isNameValid(String nome) {
        return !(nome.isEmpty() || nome.length() == 0);
    }

    //adicionar bombeiro
    public boolean addFireman(Fireman fireman) {
        //se bombeiro existir
        if (firemans.contains(fireman)) {
            //retorna falso
            return false;
        }
        fireman.setQuarter(this);
        firemans.add(fireman);
        return true;
    }

    //adicionar bombeiro
    public Fireman removeFireman(int firemanID) {
        Fireman firemanRemove = null;
        //faz o loop
        for (Fireman fireman : firemans) {
            //se tiver mesmo id
            if (fireman.getId() == firemanID) {
                //obter o retorno do bombeiro removido
                firemanRemove = firemans.remove(fireman.getId());
                //retorna o bombeiro removido
                return firemanRemove;
            }
        }
        //retorna o bombeiro removido
        return firemanRemove;
    }

    //adicionar veiculo
    public boolean addCombatVehicle(CombatVehicle vehicle) {
        //se veiculo existir
        if ((vehicles.containsKey(vehicle.getId()))
                && (vehicles.containsValue(vehicle))) {
            //retorna falso
            return false;
        }
        vehicle.setQuarter(this);
        vehicle.setLocation(location);
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

    /* Metódo para obter a posição do bombeiro no quartel */
    private int indexOfVehicleByID(int vehiclesID) {
        //faz o loop para obter a chave do veiculo
        for (int pos : vehicles.keySet()) {
            //e tiver o mesmo codigo
            if (vehicles.get(pos).getId() == vehiclesID) {
                //retorna a chave do bombeiro na lista
                return pos;
            }
        }//se for o contrário, retorna -1
        return -1;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public Map<Integer, CombatVehicle> getVehicles() {
        return vehicles;
    }
    
    public void setVehicles(Map<Integer, CombatVehicle> vehicles) {
        this.vehicles = vehicles;
    }
    
    public List<Fireman> getFiremans() {
        return firemans;
    }
    
    public void setFiremans(List<Fireman> firemans) {
        this.firemans = firemans;
    }
    
}
