public class Athlete{
    /*
    Дан файл в json формате, содержащий сведения о спринтерах (ФИО спортсмена, страна, длина дистанции в метрах, результат в часах, минутах и секундах).
     */
    private String FIO;
    private String Country;
    private String Distance;
    private String result;

    public Athlete(String FIO, String country, String distance, String result) {
        this.FIO = FIO;
        Country = country;
        Distance = distance;
        this.result = result;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
