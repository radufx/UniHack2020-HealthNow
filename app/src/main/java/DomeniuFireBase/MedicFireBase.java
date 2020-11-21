package DomeniuFireBase;

import java.util.Vector;

public class MedicFireBase extends Object{
    private String nume, prenume, cnp, telefon;
    private Vector<String> id_pacienti = new Vector<String>();

    public MedicFireBase (){

    }

    public MedicFireBase (String nume, String prenume, String cnp, String telefon){
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.telefon = telefon;
    }

    public void adaugare_id_pacient (String id_pacient){
        this.id_pacienti.add(id_pacient);
    }

}
