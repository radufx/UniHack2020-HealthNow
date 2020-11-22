package DomeniuFireBase;

public class ConditieFireBase extends Object{
    private String conditie, raspuns;

    public ConditieFireBase() {

    }

    public ConditieFireBase(String conditie, String raspuns) {
        this.conditie = conditie;
        this.raspuns = raspuns;
    }

    public String getConditie() {
        return conditie;
    }

    public String getRaspuns() {
        return raspuns;
    }

    public void setConditie(String conditie) {
        this.conditie = conditie;
    }

    public void setRaspuns(String raspuns) {
        this.raspuns = raspuns;
    }
}
