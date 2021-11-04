package at.dslan.springcontacts.contacts.api;

import at.dslan.springcontacts.contacts.object.Contact;
import at.dslan.springcontacts.contacts.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContactController {

    private final ContactService service;

    @GetMapping("/api/contacts")
    public ResponseEntity<List<Contact>> getContacts(@RequestHeader HttpHeaders headers) {
        List<Contact> result = service.getAllContacts();

        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/api/contacts/{id}")
    public ResponseEntity<Contact> getContactById(@RequestHeader HttpHeaders headers, @PathVariable String id) {
        Optional<Contact> result = service.getContactById(id);

        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/contacts")
    public ResponseEntity<Contact> createContact(@RequestHeader HttpHeaders headers, @RequestBody Contact contact) {
        contact.setId(null);
        Contact result = service.saveContact(contact);

        return ResponseEntity.created(URI.create("/api/contacts/" + result.getId())).build();
    }

    @PutMapping("/api/contacts")
    public ResponseEntity<Contact> updateContact(@RequestHeader HttpHeaders headers, @RequestBody Contact contact) {
        Contact result = service.saveContact(contact);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/contacts")
    public ResponseEntity deleteContact(@RequestHeader HttpHeaders headers, @RequestBody Contact contact) {
        service.deleteContact(contact);

        return ResponseEntity.ok().build();
    }
}
