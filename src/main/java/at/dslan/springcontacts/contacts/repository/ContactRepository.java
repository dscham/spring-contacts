package at.dslan.springcontacts.contacts.repository;

import at.dslan.springcontacts.contacts.object.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, String> {
    List<Contact> findAll();
}
