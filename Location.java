
/**
 * Escreva a descrição da classe Location aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Location
{
    //latitude no intervalo de [-90.0, 90.0] graus (>0 é norte, <0 é sul)
    private static final float MAX_LATITUDE = 90.0f;
    private static final float MIN_LATUTIDE = -90.0f;
    //longitude de [-180.0, 180.0] graus (>0 é este, <0 é oeste)
    private static final float MAX_LONGITUDE = 180.0f;
    private static final float MIN_LONGITUDE = -180.0f;
    //latitude
    private int latitude;
    //longitude
    private int longitude;

    /* Construtor por defualt*/
    public Location() {
        this(0, 0);
    }

    /* Construtor */
    public Location(int latitude, int longitude) {
        //se a latitude e longitude for válida
        if (isLocationValid(latitude, longitude) == true) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }

    // mostrar localizaçao
    public void showInf() {
        if (latitude > 0) {
            System.out.println("   Latitude    : " + latitude + "º Norte");
        } else {
            System.out.println("   Latitude    : " + latitude + "º Sul");
        }
        if (longitude > 0) {
            System.out.println("   Longitude   : " + longitude + "º Este");
        } else {
            System.out.println("   Longitude   : " + longitude + "º Oeste");
        }
    }

    public boolean isLocationValid(Location location) {
        //se latitude e longitude for válida 
        if (isLocationValid(location.latitude, location.longitude) == true) {
            //retorna verdadeira
            return true;
        }
        //se for o contrário, retorna falso
        return false;
    }

    /* Metódo para validar a latitude e longitude */
    private boolean isLocationValid(int newLatitude, int newLongitude) {
        //se latitude for válida 
        if ((isLatitudeValid(newLatitude) == true)
                //se longitude for válida 
                && (isLongitudeValid(newLongitude) == true)) {
            //retorna verdadeira
            return true;
        }
        //se for o contrário, retorna falso
        return false;
    }

    /* Metódo para validar latitude */
    private boolean isLatitudeValid(int newLatitude) {
        //se latitude estiver entre -90º
        if ((newLatitude < Location.MIN_LATUTIDE)
                // e 90º
                || (newLatitude > Location.MAX_LATITUDE)) {
            //retorna falso
            return false;
        }
        //se for o contrário, retorna verdadeiro
        return true;
    }

    /* Metódo para validar longitude */
    private boolean isLongitudeValid(int newLongitude) {
        //se longitude estiver entre -180º
        if ((newLongitude < Location.MIN_LONGITUDE)
                // e 180º
                || (newLongitude > Location.MAX_LONGITUDE)) {
            //retorna falso
            return false;
        }
        //se for o contrário, retorna verdadeiro
        return true;
    }

    /* Metódo que calcula a distancia entre dois posição através da distância euclidiana */
    public double getDistance(Location other) {
        //distância euclidiana
        double distance;
        //d = raiz ( (Xa-Xb)² + (Ya-Yb)² ).
        distance = Math.sqrt(Math.pow((latitude - other.latitude), 2) + Math.pow((longitude - other.longitude), 2));
        //retorna a distância
        return distance;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
