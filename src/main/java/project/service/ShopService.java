package project.service;

import project.dto.shopDto.ShopDto;
import project.dto.shopDto.ShopInitDto;
import project.entity.Shop;
import java.util.List;

public interface ShopService {
    void create(ShopInitDto dto);

    ShopDto findById(Long id);

    Shop getById(Long id);

    void update(ShopInitDto dto);

    void delete(Long id);

    List<ShopDto> findAll();

    List<Shop> getAll();

}
