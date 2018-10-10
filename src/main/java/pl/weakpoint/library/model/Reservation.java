package pl.weakpoint.library.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
public class Reservation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ReservationSeq")
	private Long id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="id")
	private User owner;
	
	@ManyToMany
	@JoinTable(name = "Reservation_Book", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "isbn") })
    @NotNull
	private List<Book> books;
	
	@Version
    private long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	
}
