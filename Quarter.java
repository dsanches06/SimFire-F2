import java.util.*;
import java.text.DecimalFormat;
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
    private List<CombatVehicle> vehicles;
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
            this.vehicles = new ArrayList<>(Quarter.MAX_VEHICLES);
            this.firemans = new ArrayList<>(Quarter.MAX_FIREMAN);
        }
    }

    //validar meios de alocaçao ao combate, validar veiculos com bombeiros e quantidade de agua?
    public boolean isMeansOfAllocationToCombatIsvalid(CombatVehicle vehicle) {
        //se o veiculo nao existir no quartel
        if (vehicles.contains(vehicle) != true) {
            //retorna falso
            return false;
        } //verifica ainda se nao contem condutor e bombeiro ajudante, min=3 e max=8         
        else if (vehicle.validMeansOfAllocationOfCombat() != true) {
            return false;
        }
        //retorna verdadeira;
        return true;
    }

    /*
     metodo para validar os meios de alocaçao e mover o 
      veiculo para a posiçao do fogo 
     */
    public CombatVehicle sendVehicleToCombatFire(CombatVehicle vehicle, Fire fire) {
        //se o veiculo existir no quartel
        if (vehicles.contains(vehicle)) {
            if (isMeansOfAllocationToCombatIsvalid(vehicle) == true) {
                //veiculo recebe os dados do fogo
                vehicle.setFire(fire);
                //envia a posiçao do fogo, para o veiculo
                vehicle.setLocation(fire.getLocation());
            }
        }//retorna o veiculo
        return vehicle;
    }

   public void act(Fire fire) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.format("\nQuartel %s na posicao [%s,%s] recebeu informaçao do fogo na posicao [%s,%s].\n",
                name, df.format(location.getLatitude()), df.format(location.getLongitude()),
                df.format(fire.getLocation().getLatitude()),
                df.format(fire.getLocation().getLongitude()));

        System.out.format("\nE vai enviar as viaturas para combater o fogo na posicao [%s,%s].\n",
                df.format(fire.getLocation().getLatitude()),
                df.format(fire.getLocation().getLongitude()));

        for (CombatVehicle vehicle : vehicles) {
            if (vehicle != null) {
                Iterator<Fireman> it2 = firemans.iterator();
                while (it2.hasNext()) {
                    Fireman fireman = it2.next();
                    if (fireman != null) {

                        if (vehicle.getFiremans().size() == CombatVehicle.MAX_FIREMAN) {
                            break;
                        } else {
                            vehicle.addFireman(fireman);
                            it2.remove();
                        }

                    }
                }
                System.out.format("\nViatura %02d na posiçao[,%s,%s] tem %02d lugar ocupado por bombeiros.\n",
                        vehicle.getId(), df.format(location.getLatitude()),
                        df.format(location.getLongitude()), vehicle.getFiremans().size());
            }
        }

        Iterator<CombatVehicle> it3 = vehicles.iterator();

        while (it3.hasNext()) {
            CombatVehicle vehicle = it3.next();
            if (vehicle != null) {
                System.out.format("\nQuartel %s na posicao [%s,%s] ja esta a validar os meios de alocaçao da viatura %02d.\n",
                        name, df.format(location.getLatitude()), df.format(location.getLongitude()), vehicle.getId());
                if (isMeansOfAllocationToCombatIsvalid(vehicle) == true) {
                    CombatVehicle vehicleAux = sendVehicleToCombatFire(vehicle, fire);
                    if (vehicleAux != null) {
                        System.out.format("\nA viatura %02d foi validada e foi enviada da posicao [%s,%s] para combater o "
                                + "fogo na posicao[%s,%s].\n", vehicleAux.getId(), df.format(location.getLatitude()),
                                df.format(location.getLongitude()), df.format(fire.getLocation().getLatitude()),
                                df.format(fire.getLocation().getLongitude()));
                        it3.remove();
                    }
                } else {
                    System.out.format("\nA viatura %02d nao esta valido e vai aguardar.\n", vehicle.getId());
                }
            }
        }
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
            for (CombatVehicle vehicle : vehicles) {
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
        Iterator<Fireman> it = firemans.iterator();        
        while(it.hasNext()){
          Fireman firemanRemove = it.next();
              if (firemanRemove.getId() == firemanID) {
                  it.remove();
                  return firemanRemove;
                }
                     
        }
      return null;
    }

    //adicionar veiculo
    public boolean addCombatVehicle(CombatVehicle vehicle) {
        //se veiculo existir
        if (vehicles.contains(vehicle)) {
            //retorna falso
            return false;
        }
        vehicle.setQuarter(this);
        vehicle.setLocation(location);
        vehicles.add(vehicle);
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
        for (int i = 0; i < vehicles.size(); i++) {
            //e tiver o mesmo codigo
            if (vehicles.get(i).getId() == vehiclesID) {
                //retorna a chave do bombeiro na lista
                return i;
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

    public List<CombatVehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<CombatVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    
    public List<Fireman> getFiremans() {
        return firemans;
    }

    public void setFiremans(List<Fireman> firemans) {
        this.firemans = firemans;
    }
}
