package big3;

import java.util.*;

@SuppressWarnings("ALL")
public class Operation {
    protected int numeroOperation;
    protected Date dateOperation;
    protected double montantOperation;
    public Operation(int numeroOperation, Date dateOperation, double montantOperation)
    {
        setDateOperation(dateOperation);
        setNumeroOperation(numeroOperation);
        setMontantOperation(montantOperation);
    }
    public Operation()
    {

    }
    Compte c = new Compte();
    public int getNumeroOperation() {
        return numeroOperation;
    }

    public void setNumeroOperation(int numeroOperation) {
        this.numeroOperation = numeroOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontantOperation() {
        return montantOperation;
    }

    public void setMontantOperation(double montantOperation) {
        this.montantOperation = montantOperation;
    }
    public void effectuerVersement(List<CompteCourant>current, List<CompteEpargne>saving)
    {
        String ans;
        String rep;
        int response;
        CompteCourant currentAccount = new CompteCourant();
        CompteEpargne savingAccount = new CompteEpargne();
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        do {
            System.out.println("Choisir un compte pour soutirer un montant");
            System.out.println("1- Compte Epargne");
            System.out.println("2- Compte Courant");
            System.out.print("Enter your choice: ");
            response = sc.nextInt();
            switch (response)
            {
                case 1:

                       do
                       {
                           System.out.print("Entrez le code: ");
                           savingAccount.setCode(sc.next());
                           System.out.print("Entrez le montant a retirer : ");
                           savingAccount.setSolde(sc.nextDouble());
                           for(CompteEpargne ce : saving)
                           {
                               if(ce.code.equals(savingAccount.getCode()) && ce.solde > savingAccount.getSolde())
                               {
                                   double r;
                                   r = ce.solde - savingAccount.getSolde() ;
                                   saving.remove(0);
                                   saving.add(new CompteEpargne(r, ce.code));
                                   System.out.print("Entrer le code du compte courant: ");
                                   currentAccount.setCode(sc.next());
                                   for(CompteCourant c : current)
                                   {
                                       if(currentAccount.getCode().equals(c.code))
                                       {
                                           current.remove(0);
                                           montantOperation = savingAccount.getSolde()+ c.solde;
                                           current.add(new CompteCourant(montantOperation, c.code));
                                           System.out.println("Virement effectue avec success");
                                           System.out.println("Avec un montant total de l'operation: " +getMontantOperation());
                                           break;

                                       }
                                       else
                                       {
                                           System.out.println("ce compte est inexistant");
                                           break;
                                       }
                                   }
                                   break;
                               }
                               else
                               {
                                   System.out.println("We're sorry for you");
                                   break;
                               }
                           }
                           System.out.print("Effectuez un autre virement [y/n]: ");
                           rep = sc.next();
                       }while (rep.toLowerCase().equals("y"));
                    break;
                case 2:

                    System.out.print("Entrez le code: ");
                    currentAccount.setCode(sc.next());
                    System.out.print("Entrez le montant a retirer : ");
                    currentAccount.setSolde(sc.nextDouble());
                    for(CompteCourant c : current)
                    {
                        if(c.code.equals(currentAccount.getCode()) && c.solde > currentAccount.getSolde())
                        {
                            double r;
                            r = c.solde - currentAccount.getSolde() ;
                            current.remove(0);
                            current.add(new CompteCourant(r, c.code));
                            System.out.print("Entrer le code du compte epargne: ");
                            savingAccount.setCode(sc.next());
                            for(CompteEpargne ce : saving)
                            {
                                if(savingAccount.getCode().equals(ce.code))
                                {
                                    saving.remove(0);
                                    montantOperation = currentAccount.getSolde()+ c.solde;
                                    saving.add(new CompteEpargne(montantOperation, c.code));
                                    System.out.println("Virement effectue avec success");
                                    System.out.println("Avec un montant total de l'operation: " +getMontantOperation());
                                    break;

                                }
                                else
                                {
                                    System.out.println("ce compte est inexistant");
                                    break;
                                }
                            }
                            break;
                        }
                        else
                        {
                            System.out.println("We're sorry for you");
                            break;
                        }
                    }

                    break;
            }
            System.out.print("Effectuez un autre virement [y/n]: ");
            rep = sc.next();
        }while (rep.toLowerCase().equals("y"));


    }

}
