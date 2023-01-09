package entity;

public class LigneCommande {
    int idCommande;
    String matriculProd;
    int quantiteProd;

    public LigneCommande(int idCommande, String matriculProd, int quantiteProd) {
        this.idCommande = idCommande;
        this.matriculProd = matriculProd;
        this.quantiteProd = quantiteProd;
    }

    public LigneCommande() {
    }

    @Override
    public String toString() {
        return "ligneComande{" +
                "idCommande=" + idCommande +
                ", matriculProd='" + matriculProd + '\'' +
                ", quantiteProd=" + quantiteProd +
                '}';
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getMatriculProd() {
        return matriculProd;
    }

    public void setMatriculProd(String matriculProd) {
        this.matriculProd = matriculProd;
    }

    public int getQuantiteProd() {
        return quantiteProd;
    }

    public void setQuantiteProd(int quantiteProd) {
        this.quantiteProd = quantiteProd;
    }
}
