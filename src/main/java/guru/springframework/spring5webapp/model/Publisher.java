package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

@Entity
public class Publisher {

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }
    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    private String name;
    @OneToOne
    private Address address;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pubId;

    @OneToMany
    @JoinColumn(name="publisher_id")
    private Set<Book> books = new HashSet<Book>();

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", pubId=" + pubId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(pubId, publisher.pubId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pubId);
    }
}
