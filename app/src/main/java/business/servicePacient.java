package business;

import java.util.Date;

import domain.ConditieMedicala;
import domain.Medic;
import domain.Pacient;
import infrastructura.repositoryPacient;
import validatori.validatorPacient;

public class servicePacient {
    private repositoryPacient repo_pacienti;
    private validatorPacient validator_pacienti;

    public servicePacient (repositoryPacient repo_pacienti, validatorPacient validator_pacienti){
        this.repo_pacienti = repo_pacienti;
        this.validator_pacienti = validator_pacienti;
    }

    public void adaugare_pacient (String username, String parola, String email,
                                  String telefon, String adresa, String cnp, Date data_nasterii) throws Exception {
        this.validator_pacienti.validate(username,parola, email, telefon,
                    adresa, cnp, data_nasterii);
        Pacient pacient = new Pacient(username,parola, email, telefon,
                    adresa, cnp, data_nasterii);
        this.repo_pacienti.adauga_pacient(pacient);

    }

    public void stergere_pacient (String username) throws Exception {
        Pacient pacient = this.repo_pacienti.cauta_pacient(username);
        this.repo_pacienti.sterge_pacient(pacient);
    }

    public void modifica_pacient (String username, String parola, String email,
                                  String telefon, String adresa, String cnp, Date data_nasterii) throws Exception {
        this.validator_pacienti.validate(username, parola, email, telefon,
                adresa, cnp, data_nasterii);
        Pacient pacient = new Pacient(username, parola, email, telefon,
                adresa, cnp, data_nasterii);
        this.repo_pacienti.modifica_pacient(pacient);
    }

    public Pacient cauta_pacient (String username) throws Exception {
        Pacient pacient = this.repo_pacienti.cauta_pacient(username);
        return pacient;
    }

    public void seteaza_medic (String username, String username_medic, serviceMedic srv_medici) throws Exception {
        Pacient pacient = this.cauta_pacient(username);
        Medic medic = srv_medici.cauta_medic(username_medic);
        pacient.setUsername_medic(username_medic);
    }

    public void adaugare_conditie_medicala(String username, String descriere, serviceMedic srv_medici) throws Exception {
        Pacient pacient = this.cauta_pacient(username);
        if (pacient.getUsername_medic() == ""){
            throw new Exception("Nu exista medic adaugat!");
        }
        ConditieMedicala conditie_medicala = new ConditieMedicala(username, pacient.getUsername_medic(), descriere, "");
        pacient.add_conditie_medicala(conditie_medicala);
        Medic medic = srv_medici.cauta_medic(pacient.getUsername_medic());
        medic.add_conditie_medicala(conditie_medicala);
    }

    public int get_size (){
        return this.repo_pacienti.size();
    }
}
