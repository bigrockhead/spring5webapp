package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
