package ua.luckydev.jpa.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "worker")
public class Worker {
	@Id
	private int id;

	private String fio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datebirth;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datehire;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public Date getDatebirth() {
		return datebirth;
	}

	public void setDatebirth(Date datebirth) {
		this.datebirth = datebirth;
	}

	public Date getDatehire() {
		return datehire;
	}

	public void setDatehire(Date datehire) {
		this.datehire = datehire;
	}
}
