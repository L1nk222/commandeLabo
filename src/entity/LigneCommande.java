package entity;

public class LigneCommande {
    int idCommande;
    String matriculProd;
    String NomProd;
    int quantiteProd;



    public LigneCommande(int idCommande, String matriculProd, String nomProd, int quantiteProd) {
        this.idCommande = idCommande;
        this.matriculProd = matriculProd;
        this.NomProd = nomProd;
        this.quantiteProd = quantiteProd;
    }




    public LigneCommande(int idCommande, String matriculProd, int quantiteProd) {
        this.idCommande = idCommande;
        this.matriculProd = matriculProd;
        this.quantiteProd = quantiteProd;
    }

    public LigneCommande() {
    }

    @Override
    public String toString() {
        return "LigneCommande{" +
                "idCommande=" + idCommande +
                ", matriculProd='" + matriculProd + '\'' +
                ", NomProd='" + NomProd + '\'' +
                ", quantiteProd=" + quantiteProd +
                '}';
    }

    public String getNomProd() {
        return NomProd;
    }

    public void setNomProd(String nomProd) {
        NomProd = nomProd;
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
