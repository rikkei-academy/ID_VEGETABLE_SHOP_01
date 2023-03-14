package ra.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderUpdateRequest {
    private int orDerId;
    private int status;
}
