public class Product {
    private int id;
    private String nazwa;
    private int ilosc;
    private double cena;

    Product(int id, String nazwa, int ilosc, double cena) {
        this.id = id;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.cena = cena;
    }

    public int getId() {
        return this.id;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public int getIlosc() {
        return this.ilosc;
    }

    public double getCena() {
        return this.cena;
    }


}
