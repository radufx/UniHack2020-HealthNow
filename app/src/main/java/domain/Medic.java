package domain;

import androidx.annotation.Nullable;

import java.util.Vector;

public class Medic extends Object {
    private String username, parola, adresa, telefon, email, cnp, nume;
    private Vector<String> username_pacienti = new Vector<String>();

    public Medic (){

    }

    public Medic(String username, String parola, String adresa, String telefon, String email, String cnp,
                 String Prenume, String Nume) {
        this.username = username;
        this.nume = Prenume + Nume;
        this.parola = parola;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String Nume, String Prenume) {
        this.nume = Prenume + Nume;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public void stergere_pacient (String username){
        for (int i=0; i<this.username_pacienti.size(); ++i)
            if (username == this.username_pacienti.get(i)) {
                this.username_pacienti.remove(i);
                return;
            }
    }

    public void adaugare_pacient (String username){
        this.username_pacienti.add(username);
    }

    public Vector<String> getUsername_pacienti() {
        return username_pacienti;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        Medic alt_medic = (Medic)obj;
        return this.username == alt_medic.username;
    }
}
