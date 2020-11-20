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
            throw new Exception("Element deja existent");
        }
    }

    public int size (){
        return 0;
    }

    public void sterge_pacient(){

    }

    public void modifica_pacient(){

    }

    public Pacient cauta_pacient (){
        return null;
    }

    public Vector<Pacient> get_all (){
        return null;
    }

}
