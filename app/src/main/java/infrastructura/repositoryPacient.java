package infrastructura;

import androidx.annotation.Nullable;

import java.util.Vector;

import domain.Pacient;

public class repositoryPacient {
    private Vector<Pacient> lista_pacienti = new Vector<Pacient>();

    public repositoryPacient(Vector<Pacient> lista_pacienti) {
        this.lista_pacienti = lista_pacienti;
    }

    public void adauga_pacient (Pacient pacient) throws Exception {
        if (this.lista_pacienti.contains(pacient)){
            throw new Exception("Pacient deja existent!");
        }
        this.lista_pacienti.add(pacient);
    }

    public int size (){
        return this.lista_pacienti.size();
    }

    public void sterge_pacient (Pacient pacient) throws Exception  {
        if (!this.lista_pacienti.contains(pacient)){
            throw new Exception("Pacient inexistent!");
        }
        this.lista_pacienti.remove(pacient);
    }

    public void modifica_pacient(Pacient pacient) throws Exception {
        if (!this.lista_pacienti.contains(pacient)){
            throw new Exception("Pacient inexistent!");
        }
        for (int i=0; i<this.lista_pacienti.size(); ++i){
            if (this.lista_pacienti.get(i).equals(pacient) ) this.lista_pacienti.set(i, pacient);
        }

    }

    public Pacient cauta_pacient (String username) throws Exception {

        for (int i=0; i<this.lista_pacienti.size(); ++i) {
            if (this.lista_pacienti.get(i).getUsername()== username) {
                return this.lista_pacienti.get(i);
            }
        }

        throw new Exception("Pacient inexistent!");
    }

    public Vector<Pacient> get_all (){
        return this.lista_pacienti;
    }

}
