package business;

import java.util.Date;

import domain.ConditieMedicala;
import domain.Medic;
import infrastructura.repositoryMedic;
import validatori.validatorMedic;

public class serviceMedic {
    private repositoryMedic repo_medici;
    private validatorMedic validator_medici;

    public serviceMedic(repositoryMedic repo_medici, validatorMedic validator_medici) {
        this.repo_medici = repo_medici;
        this.validator_medici = validator_medici;
    }

    public void adaugare_medic (String username, String parola, String email,
                                  String telefon, String adresa, String cnp, Date data_nasterii) throws Exception {
        this.validator_medici.validate(username,parola, email, adresa,
                    telefon, cnp);
        Medic medic = new Medic(username,parola, email, adresa,
                    telefon, cnp);
        this.repo_medici.adauga_medic(medic);
    }

    public void stergere_medic (String username) throws Exception {
        Medic medic = this.repo_medici.cauta_medic(username);
        this.repo_medici.sterge_medic(medic);
    }

    public void modifica_medic (String username, String parola, String email,
                                  String telefon, String adresa, String cnp, Date data_nasterii) throws Exception {
        this.validator_medici.validate(username,parola, email, adresa,
                telefon, cnp);
        Medic medic = new Medic(username,parola, email, adresa,
                telefon, cnp);
        this.repo_medici.modifica_medic(medic);
    }

    public Medic cauta_medic (String username) throws Exception {
        Medic medic = this.repo_medici.cauta_medic(username);
        return medic;
    }

    public void modifica_conditie_medicala (int indice, String username, String tratament) throws Exception {
        Medic medic = this.cauta_medic(username);
        medic.get_conditie_medicala(indice).setTratament(tratament);
    }

    public int get_size (){
        return this.repo_medici.size();
    }

}
