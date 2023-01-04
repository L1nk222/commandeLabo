package entity;

public class Stock {
    int idStock;
    String matricule;
    int quantiteProd;

    public Stock() {
    }

    public Stock(int idStock, String matricule, int quantiteProd) {
        this.idStock = idStock;
        this.matricule = matricule;
        this.quantiteProd = quantiteProd;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "idStock=" + idStock +
                ", matricule='" + matricule + '\'' +
                ", quantiteProd=" + quantiteProd +
                '}';
    }

    public int getIdStock() {
        return idStock;
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
