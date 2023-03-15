package big3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
public class Retrait extends Operation {

    public Retrait(int numeroOperation, Date dateOperation, double montantOperation)
    {
        super(numeroOperation,dateOperation,montantOperation);
    }

    public Retrait()
    {
        super();
    }
    Compte c = new Compte();
    public void effectuerRetraitCompteEpargne(List<CompteEpargne>savings,double montant,String code)
    {

        for (CompteEpargne ce : savings)
        {
            if(montant > ce.solde)
            {
                System.out.println("Le retrait ne peut etre effectue car le solde de votre ");
                System.out.println("compte est insuffisant " +ce.solde);
                break;
            }
            if(ce.code.equals(code))
            {
                savings.remove(0);
                savings.add(new CompteEpargne(ce.solde - montant, ce.code ));
                System.out.println("Retrait effectué");
                break;
            }

            else{
                System.out.println("we're sorry");
                break;
            }
        }


    }
    public void effectuerRetraitCompteCourant(List<CompteCourant>current, String code, double montant)
    {

        for(CompteCourant cc : current)
        {
            double soldefinal = cc.solde + cc.getDecouvert();
            if(montant > soldefinal )
            {
                System.out.println("Le retrait ne peut etre effectue car le solde de votre ");
                System.out.println("compte est insuffisant " +soldefinal);
                break;
            }
            else if(cc.code.equals(code))
            {
                double r = soldefinal-montant;
                current.remove(0);
                current.add(new CompteCourant(r, cc.code));
                System.out.println("Retrait effectué");
                break;
            }
            else
            {
                System.out.println("We're sorry");
                break;
            }
        }
    }
    public void consulterRetrait()
    {

    }

}
