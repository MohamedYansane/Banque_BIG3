package big3;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
@SuppressWarnings("ALL")
public class BankApplication {

    public static  void main (String [] args)
    {
        String answer;
        int choix;
        List<Compte>comptes = new ArrayList<>();
        List<CompteEpargne> savingAccount = new ArrayList<CompteEpargne>();
        List<CompteCourant> currentAccount = new ArrayList<CompteCourant>();
        List<Retrait> withdraw = new ArrayList<Retrait>();
        Retrait retirer = new Retrait();
        Versement versement = new Versement();
        Operation operation = new Operation();
        int numbreRetrait;
        double  retraitAmount;

        String nom;
        String code;
        double solde;
        double montant;
        int id;
        double r;
        String resp;
        int response;
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        do
        {

            System.out.println();
            System.out.println("1) Creer un compte");
            System.out.println("2) Effectuer un versement");
            System.out.println("3) Effectuer un retrait");
            System.out.println("4) Effectuer un virement");
            System.out.println("5) Consulter le solde");
            System.out.println("6) Mettre à jour le solde du compte epargne");
            System.out.println("7) Consulter la liste des opérations");
            System.out.println("8) Calculer le total montant de des versements");
            System.out.println("9) Calculer le total montant de des retraits");
            System.out.println("10) Consulter Liste");
            System.out.print("Enter Your choice [1 - 9]: ");
            choix = sc.nextInt();
            System.out.println();

            switch (choix)
            {
                case 1:
                    System.out.println("1- Compte Epargne");
                    System.out.println("2- Compte Courant");
                    System.out.print("Enter your choice: ");
                    int rp = sc.nextInt();
                    switch (rp)
                    {
                        case 1:

                            do
                            {
                                CompteEpargne ce = new CompteEpargne();
                                System.out.print("Enter a code: ");
                                ce.setCode(sc.next());
                                System.out.print("Enter a solde: ");
                                ce.setSolde(sc.nextDouble());
                                //currentAccount.add(new CompteEpargne(solde, code, nom, id));
                                ce.creerCompteEpargne();
                                //savingAccount.add(ce);
                                savingAccount.add(ce);
                                System.out.print("Inserer d'autres utilisateurs [y/n]: ");
                                resp = sc.next();
                            }while (resp.toLowerCase().equals("y"));
                        break;
                        case 2:
                            do
                            {
                                CompteCourant cc = new CompteCourant();
                                System.out.print("Enter a code: ");
                                cc.setCode(sc.next());
                                System.out.print("Enter a solde: ");
                                cc.setSolde(sc.nextDouble());
                                cc.creerCompteCourant();
                                currentAccount.add(cc);
                                System.out.print("Inserer d'autres utilisateurs [y/n]: ");
                                resp = sc.next();
                            }while (resp.toLowerCase().equals("y"));
                    }

                    break;
                case 2:
                    System.out.println("1- Compte Epargne");
                    System.out.println("2- Compte Courant");
                    System.out.print("Enter your choice: ");
                    response = sc.nextInt();
                    switch (response)
                    {
                        case 1:

                            System.out.print("Entrez le code du compte: ");
                            code = sc.next();
                            System.out.print("Enter an amount: ");
                            retraitAmount =sc.nextDouble();
                            versement.effectuerVersementEpargne(savingAccount,retraitAmount,code);
                            break;
                        case 2:
                            System.out.print("Entrez le code du compte: ");
                            code = sc.next();
                            System.out.print("Enter an amount: ");
                            retraitAmount =sc.nextDouble();
                            versement.effectuerVersementCourant(currentAccount, retraitAmount, code);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1- Compte Epargne");
                    System.out.println("2- Compte Courant");
                    System.out.print("Enter your choice: ");
                    response = sc.nextInt();
                    switch (response)
                    {
                        case 1:

                            System.out.print("Entrez le code du compte: ");
                            code = sc.next();
                            System.out.print("Enter an amount: ");
                            retraitAmount =sc.nextDouble();
                            retirer.effectuerRetraitCompteEpargne(savingAccount,retraitAmount,code);
                            break;
                        case 2:
                            System.out.print("Entrez le code du compte: ");
                            code = sc.next();
                            System.out.print("Enter an amount: ");
                            retraitAmount =sc.nextDouble();
                            retirer.effectuerRetraitCompteCourant(currentAccount, code, retraitAmount);
                            break;
                    }
                    break;
                case 4:
                    operation.effectuerVersement(currentAccount, savingAccount);
                case 5:
                    System.out.println("1- Compte Epargne");
                    System.out.println("2- Compte Courant");
                    System.out.print("Enter your choice: ");
                    response = sc.nextInt();
                    switch (response)
                    {
                        case 1:
                            System.out.print("Entrez le code du compte: ");
                            sc.nextLine();
                            code = sc.next();
                            for(CompteEpargne e : savingAccount)
                                if(e.code.equals(code))
                                {
                                    System.out.print("Le solde du compte est: " + e.solde);
                                    break;
                                }
                                else
                                {
                                    System.out.print("Cet identifiant n'existe pas");
                                    break;
                                }

                            break;
                        case 2:
                            System.out.print("Entrez le code du compte: ");
                            code = sc.next();
                            for(CompteCourant c : currentAccount)
                                if(c.code.equals(code))
                                {
                                    System.out.print("Le solde du compte est: " + c.solde);
                                    break;
                                }
                                else
                                {
                                    System.out.print("Cet identifiant n'existe pas");
                                    break;
                                }

                            break;
                    }

                    break;
                case 6:
                    System.out.println("Vous aviez choisi l'option 6");

                    break;
                case 7:
                    System.out.println("Vous aviez choisi l'option 7");
                    break;
                case 8:
                    for(CompteEpargne Ce: savingAccount)
                        System.out.println(Ce);
                    break;
                case 9:

                case 10:
                    for(CompteEpargne saves: savingAccount)
                        System.out.println(saves);
                    for(CompteCourant compteEpargne: currentAccount)
                        System.out.println(compteEpargne);
                    break;
            }
            System.out.println();
            sc.nextLine();
            System.out.print("Vouliez vous continuez [y/n]: ");
            answer = sc.nextLine();
        }while(answer.toLowerCase().equals("y"));
        System.out.println();
        System.out.println("Merci d'avoir utilisé notre application 😊");
    }
}
