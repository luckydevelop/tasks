package ua.luckydev.jpa.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "person")
public class Person
{
    @Id
    private int id;
    private String fio;

    @Temporal(TemporalType.DATE)
    private Date dateBirth;

    @Temporal(TemporalType.DATE)
    private Date dateHire;

    String position;
    String manager;
    String info;

    @Transient
    List<Person> listWorkers = new ArrayList<>();


    public String getManager()
    {
        return manager;
    }

    public void setManager(String manager)
    {
        this.manager = manager;
    }

    public List<Person> getListWorkers()
    {
        return listWorkers;
    }

    public void setListWorkers(List<Person> listWorkers)
    {
        this.listWorkers = listWorkers;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public int getId()
    {
        return id;
    }

    public Date getDateHire()
    {
        return dateHire;
    }

    public void setDateHire(Date dateHire)
    {
        this.dateHire = dateHire;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public Date getDateBirth()
    {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth)
    {
        this.dateBirth = dateBirth;
    }

    public String getFio()
    {
        return fio;
    }

    public void setFio(String fio)
    {
        this.fio = fio;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
