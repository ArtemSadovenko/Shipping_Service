package project.dto.shopDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopInitDto {
    private Long id;
    private String name;
    private String address;
    private Long adminId;
}
