package entity;

public class Commande {
    int idCommande;
    String dateCommande;
    String descriptionCommande;
    String etatCommande;
    int idLabo;


    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", dateCommande='" + dateCommande + '\'' +
                ", descriptionCommande='" + descriptionCommande + '\'' +
                ", etatCommande='" + etatCommande + '\'' +
                ", idLabo=" + idLabo +
                '}';
    }

    public String getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(String etatCommande) {
        this.etatCommande = etatCommande;
    }

    public Commande(int idCommande, String dateCommande, String descriptionCommande, String etatCommande, int idLabo) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.descriptionCommande = descriptionCommande;
        this.etatCommande = etatCommande;
        this.idLabo = idLabo;
    }

    public Commande(int idCommande, String DateCommande, String DescriptionCommande, int idLabo) {
        this.idCommande = idCommande;
        this.dateCommande = DateCommande;
        this.descriptionCommande = DescriptionCommande;

        this.idLabo = idLabo;
    }

    public Commande() {

    }



    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getDescriptionCommande() {
        return descriptionCommande;
    }

    public void setDescriptionCommande(String descriptionCommande) {
        this.descriptionCommande = descriptionCommande;
    }


    public int getIdLabo() { return idLabo; }

    public void setIdLabo(int idLabo) {this.idLabo = idLabo;}
}
