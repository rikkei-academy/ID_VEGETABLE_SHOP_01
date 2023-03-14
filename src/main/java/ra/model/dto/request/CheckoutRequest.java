package ra.model.dto.request;

import lombok.Data;
import ra.model.entity.OrDerDetail;
import ra.model.entity.Users;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class CheckoutRequest {
    private int orDerId;
    private String firstName;
    private String  lastName;


    private String note;
    private String country;
    private String adress;
    private String city;
    private int postCode;

    private String phone;

}
