package Klasy;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Uzytkownicy")
public class Uzytkownik {

	@Id
	@GeneratedValue
	long id;
	@Column(name="login")
	String name;
	@Column(name="haslo")
	String haslo1;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHaslo1() {
		return haslo1;
	}
	public void setHaslo1(String haslo1) {
		this.haslo1 = haslo1;
	}

}
