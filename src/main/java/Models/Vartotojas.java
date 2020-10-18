package Models;

public class Vartotojas {
    String vardas;
    String pavarde;
    String telefonas;
    String pastas;

    public String getVardas() {
        return vardas;
    }

    public Vartotojas setVardas(String vardas) {
        this.vardas = vardas;
        return this;
    }

    public String getPavarde() {
        return pavarde;
    }

    public Vartotojas setPavarde(String pavarde) {
        this.pavarde = pavarde;
        return this;
    }

    public String getTelefonas() {
        return telefonas;
    }

    public Vartotojas setTelefonas(String telefonas) {
        this.telefonas = telefonas;
        return this;
    }

    public String getPastas() {
        return pastas;
    }

    public Vartotojas setPastas(String pastas) {
        this.pastas = pastas;
        return this;
    }

    public static Vartotojas Builder (){
        return new Vartotojas();
    }

    void funkcija() {
        Vartotojas vartotojas = Vartotojas.Builder()
                .setPastas("")
                .setPavarde("");

//        Vartotojas vartotojas1 = Vartotojas.bui

    }
}


