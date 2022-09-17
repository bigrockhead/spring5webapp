package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Address;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AddressRepository;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher oreilly = new Publisher("O'Reilly");
        Address oAdd = new Address("123 Main", "New York", "NY","09012");
        oreilly.setAddress(oAdd);
        addressRepository.save(oAdd);
        publisherRepository.save(oreilly);

        Author paul = new Author("Paul","Dorsey");
        Book ora = new Book("oracle forms","14231234");
        paul.getBooks().add(ora);
        ora.getAuthors().add(paul);
        ora.setPublisher(oreilly);
        oreilly.getBooks().add(ora);
        authorRepository.save(paul);
        bookRepository.save(ora);

        Author jay = new Author("Jay", "Pascal");
        Book nothing = new Book("I have written nothing","00000000");
        jay.getBooks().add(nothing);
        nothing.getAuthors().add(jay);
        nothing.setPublisher(oreilly);
        oreilly.getBooks().add(nothing);
        authorRepository.save(jay);
        bookRepository.save(nothing);

        Author martin = new Author("Martin", "Fowler");
        Book ood = new Book("Object Oriented Design","12343412");
        martin.getBooks().add(ood);
        ood.getAuthors().add(martin);
        ood.setPublisher(oreilly);
        oreilly.getBooks().add(ood);
        authorRepository.save(martin);
        bookRepository.save(ood);
        publisherRepository.save(oreilly);

        System.out.println("Initiated BootStrap");
        System.out.println("Number of Authors => "+ authorRepository.count());
        System.out.println("Number of Books => " + bookRepository.count());
        System.out.println("Number of Addresses => " + addressRepository.count());
        System.out.println ("Number of Publishers => " + publisherRepository.count());
        System.out.println("Number of books published => " + oreilly.getBooks().size());

    }
}
