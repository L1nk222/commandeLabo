package entity;

public class Fournisseur {
    int idFournisseur;
    String nom;
    String email;
    String adresse;

    public Fournisseur(int idFournisseur, String nom, String email, String adresse) {
        this.idFournisseur = idFournisseur;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
    }

    public Fournisseur(){

    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "idFournisseur=" + idFournisseur +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
