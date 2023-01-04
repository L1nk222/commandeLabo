package entity;

public class Produit {
    String matricule;
    String nom;
    String description;
    int poids;
    int idFournisseur;

    public Produit(String matricule, String nom, String description, int poids, int idFournisseur) {
        this.matricule = matricule;
        this.nom = nom;
        this.description = description;
        this.poids = poids;
        this.idFournisseur = idFournisseur;
    }

    public Produit() {
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", poids=" + poids +
                ", idFournisseur=" + idFournisseur +
                '}';
    }
}
