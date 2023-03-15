package big3;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class CompteCourant extends Compte{
    public CompteCourant(double solde, String code) {
        super(solde, code);
    }
    public CompteCourant()
    {
        super();
    }

    double decouvert = 500000.00;
    private String compteCourant = "COMPTE COURANT";

    public String getCompteCourant() {
        return compteCourant;
    }

    public double getDecouvert() {
        return decouvert;
    }

    protected void creerCompteCourant() {
        CompteCourant cc = new CompteCourant(solde,code);
    }

    public String toString()
    {
        return getCompteCourant() +"\n  Solde: "+ getSolde() + "\n  Code: "+ getCode();
    }



}
