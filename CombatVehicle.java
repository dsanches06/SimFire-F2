import java.util.*;
/**
 * Escreva a descrição da classe CombatVehicle aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CombatVehicle {

    //capacidade maxima entre 1500 a 20000 litros de aguas em ]500[
    public static final int MIN_WATER_CAPACITY = 1500;
    public static final int MAX_WATER_CAPACITY = 20000;
    //lugar maximo de 8 bombeiros
    public static final int MAX_FIREMAN = 8;
    //lugar minimos para 3 bombeiros
    public static final int MIN_FIREMAN = 3;
    //para gerar novo id
    private static int nextNumber = 0;
    //id
    private int id;
    // capacidade atual de agua
    private int waterCapacity;
    //quartel
    private Quarter quarter;
    //localizaçao  
    private Location location;
    //incendio (tipo)
    private Fire fire;
    //lista de lugares para bombeiros
    private Map<Integer, Fireman> firemans;

    /* Construtor */
    public CombatVehicle(int waterCapacity) {
        //se a capacidade da agua estiver nos limites
        if (isWaterCapacityValid(waterCapacity) == true) {
            this.id = ++CombatVehicle.nextNumber;
            this.location = null;
            this.quarter = null;
            this.waterCapacity = waterCapacity;
            this.firemans = new HashMap<>();
            this.fire = null;
        }
    }

    //mostrar dados do veiculos
    public void showInf() {
        System.out.format(" VEICULO ID    : %02d\n", id);
        location.showInf();
        System.out.println(" Capacidade    : " + waterCapacity + "L");
        if (quarter != null) {
            System.out.println(" Quartel     : " + quarter.getName());
            quarter.getLocation().showInf();
        } else {
            System.out.println(" Quartel         : N/A");
        }
        System.out.println(" Lugares Ocupados   : " + firemans.size());
        System.out.println(" Lugares Disponiveis: " + getAvailablePlace());
        //mostrar apenas os dados do bombeiro condutor

        if (firemans.isEmpty() != true) {
            System.out.print(" -- DADOS DO CONDUTOR NO VEICULO --");
            for (Fireman fireman : firemans.values()) {
                if (fireman.isIsAbleToDrive() == true) {
                    fireman.showInf();
                }
            }
        } else {
            System.out.format(" Condutor do Veiculo %02d : N/A \n", id);
        }

        //mostrar os restantes bombeiro
        if (firemans.isEmpty() != true) {
            System.out.print("\n -- DADOS DOS BOMBEIROS NO VEICULO --");
            for (Fireman fireman : firemans.values()) {
                if (fireman.isIsAbleToDrive() != true) {
                    fireman.showInf();
                }
            }
        } else {
            System.out.format(" Bombeiros no Veiculo %02d: N/A", id);
        }
        
        if (fire != null) {
            fire.showInf();
        } else {
            System.out.println("\n Combate ao Fogo : N/A");
        }
        
    }

    /*
      Metodo para validar meios de alocaçao
      verificar se existe no min=3 e max=8 bombeiros no veiculo
      sendo 1 condutor + os restantes bombeiro ajudante
     */
    public boolean validMeansOfAllocationOfCombat() {
        //se tiver 3 ou mais bombeiros
        if ((firemans.size() >= CombatVehicle.MIN_FIREMAN)
                //e tiver no maximo 8 bombeiros
                && (firemans.size() <= CombatVehicle.MAX_FIREMAN)
                //e existir 1 condutor
                && (existFiremanAbleToDrive() == true)
                //e tiver agua suficiente
                && (isWaterCapacityValid(waterCapacity) == true)) {
            //retorna falso
            return true;
        }//se for o contrario, retorna falso
        return false;
    }


    /* Metódo para validar a capacidade da agua*/
    private boolean isWaterCapacityValid(int newWaterCapacity) {
        //se latitude estiver entre 1500
        if ((newWaterCapacity >= CombatVehicle.MIN_WATER_CAPACITY)
                // e 20000
                && (newWaterCapacity <= CombatVehicle.MAX_WATER_CAPACITY)) {
            //retorna verdadeira
            return true;
        }
        //se for o contrário, retorna falso
        return false;
    }

    //obter lugar disponivel
    private int getAvailablePlace() {
        int total = CombatVehicle.MAX_FIREMAN - firemans.size();
        return total;
    }

    //verificar se ja existe condutor no veiculo
    private boolean existFiremanAbleToDrive() {
        //faz o loop para obter o bombeiro
        for (Fireman fireman : firemans.values()) {
            //se tiver habilitaçao para conduzir
            if (fireman.isIsAbleToDrive() == true) {
                //retorna verdadeira
                return true;
            }
        }//retorna falso
        return false;
    }

  
    //adicionar bombeiro
    public boolean addFireman(Fireman fireman) {
        //se bombeiro existir
        if ((firemans.containsKey(fireman.getId()))
                && (firemans.containsValue(fireman))) {
            //retorna falso
            return false;
        } //ou se ja existe 1 condutor
        else if (existFiremanAbleToDrive() == fireman.isIsAbleToDrive()) {
            //retorna falso
            return false;
        }//se for igual 8 lugares ocupado
        else if (firemans.size() == CombatVehicle.MAX_FIREMAN) {
            //retorna falso
            return false;
        }
        //adicona o bombeiro no veiculo
        fireman.setVehicles(this);
        //adiciona ao array 
        firemans.put(fireman.getId(), fireman);
        //retorna verdadeira
        return true;
    }

    //adicionar bombeiro
    public Fireman removeFireman(int firemanID) {
        int idx;
        Fireman firemanRemove = null;
        //obter a posição do camião
        idx = indexOfFiremanByID(firemanID);
        //se for diferente de - 1
        if (idx != -1) {
            //cria uma cópia
            firemanRemove = firemans.remove(idx);
        }//retorna o bombeiro removido
        return firemanRemove;
    }

    /* Metódo para obter a posição do bombeiro no quartel */
    private int indexOfFiremanByID(int firemanID) {
        //faz o loop para obter a chave do bombeiro
        for (int pos : firemans.keySet()) {
            //e tiver o mesmo codigo
            if (firemans.get(pos).getId() == firemanID) {
                //retorna a chave do bombeiro na lista
                return pos;
            }
        }//se for o contrário, retorna -1
        return -1;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getWaterCapacity() {
        return waterCapacity;
    }
    
    public void setWaterCapacity(int waterCapacity) {
        this.waterCapacity = waterCapacity;
    }
    
    public Quarter getQuarter() {
        return quarter;
    }
    
    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        //se a localizaçao for valida
        if (location.isLocationValid(location)) {
            this.location = location;
        }
    }
    
    public Fire getFire() {
        return fire;
    }
    
    public void setFire(Fire fire) {
        this.fire = fire;
    }
    
    public Map<Integer, Fireman> getFiremans() {
        return firemans;
    }
    
    public void setFiremans(Map<Integer, Fireman> firemans) {
        this.firemans = firemans;
    }
    
}
