package DomeniuFireBase;


import java.util.Date;
import java.util.Vector;

public class PacientFireBase {
    private String nume, prenume, adresa, cnp;
    private Date data_nasterii;

    private Vector<ConditieFireBase> conditii = new Vector<ConditieFireBase>();

    public PacientFireBase(){

    }

    public PacientFireBase(String nume, String prenume, String adresa, Date data_nasterii, String cnp){
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.data_nasterii = data_nasterii;
        this.cnp = cnp;
    }

    public void adaugare_conditie (){

    }

}
