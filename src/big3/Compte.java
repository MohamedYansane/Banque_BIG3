package big3;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Compte {
    protected double solde;
    protected String code;
    public Compte(double solde, String code)
    {
        setCode(code);
        setSolde(solde);
    }
    public Compte()
    {

    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode()
    {
        return code;
    }

    public String consulterSolde(){
        return "Le Solde du Compte est: "+ solde;
    }
    public void creerCompte(){
        Compte c = new Compte(solde,code);
    }


}
