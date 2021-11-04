package at.dslan.springcontacts.contacts.object;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.Map;

@Data
public class Contact {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String title;
    private String email;
    private String company;
    private Instant birthday;
    private Map<String, Object> customProperties;
}
