package ua.luckydev.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "worker")
public class Worker
{
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    private String fio;

    @Column(name = "datebirth")
    Date dateBirth;

    @Column(name = "datehire")
    Date dateHire;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Date getDateHire() {
        return dateHire;
    }

    public void setDateHire(Date dateHire) {
        this.dateHire = dateHire;
    }
}
