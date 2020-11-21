package infrastructura;

import java.util.Vector;

import domain.Medic;

public class repositoryMedic {
    private Vector<Medic> lista_medici = new Vector<Medic>();

    public repositoryMedic(Vector<Medic> lista_medici){
            this.lista_medici = lista_medici;
    }

    public void adauga_medic(Medic medic) throws Exception{
        if(this.lista_medici.contains(medic)){
            throw new Exception("Medic deja existent!");
        }
        this.lista_medici.add(medic);
    }

    public int size (){
        return this.lista_medici.size();
    }

    public void sterge_medic(Medic medic) throws Exception{
        if(!this.lista_medici.contains(medic)){
            throw new Exception("Medic inexistent!");
        }
        this.lista_medici.remove(medic);
    }
    public void modifica_medic(Medic medic) throws Exception{
        if(!this.lista_medici.contains(medic)){
            throw new Exception("Medic inexistent!");
        }
        for(int i=0; i<this.lista_medici.size();++i){
            if(this.lista_medici.get(i).equals(medic))
                this.lista_medici.set(i, medic);
        }
    }

    public Medic cauta_medic (String username) throws Exception{
        for(int i=0;i<this.lista_medici.size();++i)
            if(this.lista_medici.get(i).getUsername() == username)
                return this.lista_medici.get(i);

         throw new Exception("Medic inexistent!");
    }

    public Vector<Medic> get_all(){
        return this.lista_medici;
    }



}
