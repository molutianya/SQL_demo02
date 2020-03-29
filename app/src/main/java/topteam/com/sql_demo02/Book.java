package topteam.com.sql_demo02;

import org.litepal.crud.DataSupport;
import org.litepal.exceptions.DataSupportException;

public class Book extends DataSupport{

    int id;
    String name;
    double price;
    int pag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }
}
