import java.util.*;
/**
 * Escreva a descrição da classe Estatistica aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Estatistica
{
    // Número total de focos de incêndio
    private List<Fire> fires;
    // Número total de veículos envolvidos
    private Set<CombatVehicle> vehicles;
    // Número total de bombeiros que participaram no fogo
    private Map<Integer, Fireman> firemans;
    // Área ardida (ha)
    private float areaArdida;
    // Tempo médio de combate dos fogos (dias/horas)
    private float tempoMedioCombateFogo;
    // Número médio de operacionais por foco de incêndio
    private float numeroMedioDeOperacoesNoIncendio;
    // Total de água gasta na simulação
    private int totalAguaGasta;
    // Média de água gasta por incêndio
    private int mediaAguaGastaPorIncendio;
    // Número de quilómetros percorridos em média pelos veículos
    private float qtKM;
    // Número médio de fogos em que cada bombeiro participou
    private float numeroMedioFogoPorCadaBombeiro;

    public Estatistica() {
        this.fires = new ArrayList<>();
        this.vehicles = new HashSet<>();
        this.firemans = new HashMap<>();
        this.areaArdida = 0.0f;
        this.tempoMedioCombateFogo = 0.0f;
        this.numeroMedioDeOperacoesNoIncendio = 0.0f;
        this.totalAguaGasta = 0;
        this.mediaAguaGastaPorIncendio = 0;
        this.qtKM = 0.0f;
        this.numeroMedioFogoPorCadaBombeiro = 0.0f;
    }

    public void showInf() {
         System.out.println("\n--- ESTATISTICA ---");
        System.out.println("Número total de focos de incêndio: " + fires.size());
        System.out.println("Número total de veículos envolvidos: " + vehicles.size());
        System.out.println("Número total de bombeiros que participaram no fogo: " + firemans.size());
        System.out.println("Área ardida (ha): " + areaArdida);
        System.out.println("Tempo médio de combate dos fogos (dias/horas): " + tempoMedioCombateFogo);
        System.out.println("Número médio de operacionais por foco de incêndio: " + numeroMedioDeOperacoesNoIncendio);
        System.out.println("Total de água gasta na simulação: " + totalAguaGasta);
        System.out.println("Média de água gasta por incêndio: " + mediaAguaGastaPorIncendio);
        System.out.println("Número de quilómetros percorridos em média pelos veículos: " + qtKM);
        System.out.println("Número médio de fogos em que cada bombeiro participou: " + numeroMedioFogoPorCadaBombeiro);

    }

    public List<Fire> getFires() {
        return fires;
    }

    public void setFires(List<Fire> fires) {
        this.fires = fires;
    }

    public Set<CombatVehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<CombatVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Map<Integer, Fireman> getFiremans() {
        return firemans;
    }

    public void setFiremans(Map<Integer, Fireman> firemans) {
        this.firemans = firemans;
    }

    public float getAreaArdida() {
        return areaArdida;
    }

    public void setAreaArdida(float areaArdida) {
        this.areaArdida = areaArdida;
    }

    public float getTempoMedioCombateFogo() {
        return tempoMedioCombateFogo;
    }

    public void setTempoMedioCombateFogo(float tempoMedioCombateFogo) {
        this.tempoMedioCombateFogo = tempoMedioCombateFogo;
    }

    public float getNumeroMedioDeOperacoesNoIncendio() {
        return numeroMedioDeOperacoesNoIncendio;
    }

    public void setNumeroMedioDeOperacoesNoIncendio(float numeroMedioDeOperacoesNoIncendio) {
        this.numeroMedioDeOperacoesNoIncendio = numeroMedioDeOperacoesNoIncendio;
    }

    public int getTotalAguaGasta() {
        return totalAguaGasta;
    }

    public void setTotalAguaGasta(int totalAguaGasta) {
        this.totalAguaGasta = totalAguaGasta;
    }

    public int getMediaAguaGastaPorIncendio() {
        return mediaAguaGastaPorIncendio;
    }

    public void setMediaAguaGastaPorIncendio(int mediaAguaGastaPorIncendio) {
        this.mediaAguaGastaPorIncendio = mediaAguaGastaPorIncendio;
    }

    public float getQtKM() {
        return qtKM;
    }

    public void setQtKM(float qtKM) {
        this.qtKM = qtKM;
    }

    public float getNumeroMedioFogoPorCadaBombeiro() {
        return numeroMedioFogoPorCadaBombeiro;
    }

    public void setNumeroMedioFogoPorCadaBombeiro(float numeroMedioFogoPorCadaBombeiro) {
        this.numeroMedioFogoPorCadaBombeiro = numeroMedioFogoPorCadaBombeiro;
    }

}
