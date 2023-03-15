package big3;

import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
public class Versement extends Operation {
    public Versement(int numeroOperation, Date dateOperation, double montantOperation)
    {
       super(numeroOperation,dateOperation,montantOperation);
    }
    public Versement()
    {
    super();
    }
    public void effectuerVersementEpargne(List<CompteEpargne>ce ,double montant, String code)
    {
        for(CompteEpargne current : ce)
        {
            if(current.code.equals(code))
            {
                double solde = current.solde + montant;
                ce.remove(0);
                ce.add(new CompteEpargne(solde, current.code));
                System.out.println("Versement effectue avec success");
            }
            else
            {
                System.out.println("We're sorry");
            }
        }


    }
    public void effectuerVersementCourant(List<CompteCourant>current, double montant, String code)
    {
        for(CompteCourant c : current)
        {
            if(c.code.equals(code))
            {
                double solde = c.solde + montant;
                current.remove(0);
                current.add(new CompteCourant(solde, c.code));
                System.out.println("Versement effectue avec success");
            }
            else
            {
                System.out.println("We're sorry for you");
            }
        }
    }

}
