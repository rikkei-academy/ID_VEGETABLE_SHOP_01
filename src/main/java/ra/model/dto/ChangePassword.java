package ra.model.dto;

import lombok.Data;

@Data
public class ChangePassword {
    private String oldPassword;
    private String newPassword;
    private String comfimlNewPass;
}
