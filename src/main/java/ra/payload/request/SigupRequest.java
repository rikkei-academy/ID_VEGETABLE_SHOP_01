package ra.payload.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;
@Data
@Setter
@Getter
public class SigupRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String adress;
    private String password;
    private String email;
    private String phone;
    private Date created;
    private boolean userStatus;
    private Set<String> listRoles;


}
