package entity;

public class Stock {
    int idStock;
    String matricule;
    int quantiteProd;
    int seuilCritique;


    public Stock(int idStock, String matricule, int quantiteProd, int seuilCritique ) {
        this.idStock = idStock;
        this.matricule = matricule;
        this.quantiteProd = quantiteProd;
        this.seuilCritique = seuilCritique;
    }
    public Stock() {
    }




    public int getIdStock() {
        return idStock;
    }

    public int getSeuilCritique() {
        return seuilCritique;
    }

    public void setSeuilCritique(int seuilCritique) {
        this.seuilCritique = seuilCritique;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getQuantiteProd() {
        return quantiteProd;
    }

    public void setQuantiteProd(int quantiteProd) {
        this.quantiteProd = quantiteProd;
    }
}
