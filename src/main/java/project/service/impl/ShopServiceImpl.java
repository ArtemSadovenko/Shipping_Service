package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project.dto.shopDto.ShopDto;
import project.dto.shopDto.ShopInitDto;
import project.entity.Shop;
import project.entity.User;
import project.enums.UserRole;
import project.exeption.IrregularData;
import project.mapper.ShopMapper;
import project.repository.ShopRepository;
import project.repository.UserRepository;
import project.service.ShopService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public void create(ShopInitDto dto) {
        User admin = userRepository.findById(dto.getAdminId())
                .orElseThrow(()-> new IrregularData("No Such User", HttpStatus.BAD_REQUEST));
        if(!admin.getUserRole().equals(UserRole.SHOP_OWNER)){
            throw new IrregularData("This user can`t be assigned as shop owner", HttpStatus.BAD_REQUEST);
        }
        Shop shop = ShopMapper.DtoToEntity(dto);
        shop.setUser(admin);
        shopRepository.save(shop);
    }

    @Override
    public ShopDto findById(Long id) {
        return ShopMapper.EntToShopDto(getById(id));
    }

    @Override
    public Shop getById(Long id) {
        return shopRepository.findById(id)
                .orElseThrow(() -> new IrregularData("No such shop", HttpStatus.BAD_REQUEST));
    }

    @Override
    public void update(ShopInitDto dto) {
        User admin = userRepository.findById(dto.getAdminId())
                .orElseThrow(()-> new IrregularData("No Such User", HttpStatus.BAD_REQUEST));
        Shop shop = ShopMapper.DtoToEntity(dto);
        shop.setUser(admin);
        shopRepository.save(shop);
    }

    @Override
    public void delete(Long id) {
        shopRepository.deleteById(id);
    }

    @Override
    public List<ShopDto> findAll() {
        return shopRepository.findAll().stream()
                .map(ShopMapper::EntToShopDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }
}
