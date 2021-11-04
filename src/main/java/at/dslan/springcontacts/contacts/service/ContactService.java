package at.dslan.springcontacts.contacts.service;

import at.dslan.springcontacts.contacts.object.Contact;
import at.dslan.springcontacts.contacts.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContactService {
    private final ContactRepository repository;

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public Optional<Contact> getContactById(String id) {
        return repository.findById(id);
    }

    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }

    public void deleteContact(Contact contact) {
        repository.delete(contact);
    }
}
