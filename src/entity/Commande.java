package entity;

public class Commande {
    int idRecap;
    String dateCommande;
    String descriptionCommande;
    int idComande;
    int idLabo;



    public Commande(int idRecap, String DateCommande, String DescriptionCommande, int idComande,int idLabo) {
        this.idRecap = idRecap;
        this.dateCommande = DateCommande;
        this.descriptionCommande = DescriptionCommande;
        this.idComande = idComande;
        this.idLabo = idLabo;
    }

    public Commande() {

    }

    @Override
    public String toString() {
        return "Commande{" +
                "idRecap=" + idRecap +
                ", DateCommande='" + dateCommande + '\'' +
                ", DescriptionCommande='" + descriptionCommande + '\'' +
                ", idComande=" + idComande + '\''+
                ", idLabo=" + idLabo +
                '}';
    }

    public int getIdRecap() {
        return idRecap;
    }

    public void setIdRecap(int idRecap) {
        this.idRecap = idRecap;
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

    public int getIdComande() {
        return idComande;
    }

    public void setIdComande(int idComande) {
        this.idComande = idComande;
    }
    public int getIdLabo() { return idLabo; }

    public void setIdLabo(int idLabo) {this.idLabo = idLabo;}
}
