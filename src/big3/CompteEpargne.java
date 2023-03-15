package big3;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class CompteEpargne extends Compte {
    public CompteEpargne(double solde, String code) {
        super(solde, code);

    }
    public CompteEpargne()
    {
        super();
    }
    public String compteEpargne = "COMPTE EPARGNE";

    public String getCompteEpargne() {
        return compteEpargne;
    }

    protected void creerCompteEpargne() {
       CompteEpargne ce = new CompteEpargne(solde, code);

    }

    private float tauxInteret;
    public void setTauxInteret(float t)
    {
        this.tauxInteret = t;
    }

    public float getTauxInteret() {
        return tauxInteret;
    }
    public String toString()
    {
        return getCompteEpargne() +"\n  Solde: "+ getSolde() + "\n  Code: "+ getCode();
    }
    public float majSoldeCompte()
    {
        return 0;
    }


}
