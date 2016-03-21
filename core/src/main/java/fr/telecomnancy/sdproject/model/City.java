package fr.telecomnancy.sdproject.model;

/**
 * @author Zakaria BENJEBARA.
 */
public class City {

    private String name;
    private String pays;

    public City() {
    }

    public City(String name, String pays) {
        this.name = name;
        this.pays = pays;
    }

    public String getName() {
        return name;
    }

    public String getPays() {
        return pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (pays != null ? !pays.equals(city.pays) : city.pays != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pays != null ? pays.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("name='").append(name).append('\'');
        sb.append(", pays='").append(pays).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
