package entity;

public class Laboratoire {
    int idLabo;
    String ville;
    int idStock;
    String numTelephone;
    String nom;
    String adresse;
    String email;

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Laboratoire(int idLabo, String ville, int idStock, String numTelephone, String nom, String adresse, String email) {
        this.idLabo = idLabo;
        this.ville = ville;
        this.idStock = idStock;
        this.numTelephone = numTelephone;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
    }



    public Laboratoire() {

    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getIdLabo() {
        return idLabo;
    }

    public void setIdLabo(int idLabo) {
        this.idLabo = idLabo;
    }


    @Override
    public String toString() {
        return "Laboratoire{" +
                "idLabo=" + idLabo +
                ", ville='" + ville + '\'' +
                ", idStock=" + idStock +
                ", numTelephone=" + numTelephone +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
