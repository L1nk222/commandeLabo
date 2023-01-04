package entity;

public class Laboratoire {
    int idLabo;
    String Ville;
    int idStock;

    public Laboratoire(int idLabo, String Ville,int idStock){

        this.idLabo= idLabo;
        this.Ville= Ville;
        this.idStock = idStock;
    }

    public Laboratoire() {

    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
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
                ", Ville='" + Ville + '\'' +
                ", idStock=" + idStock +
                '}';
    }
}
