package project.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    CUSTOMER,
    SHOP_OWNER,
    COURIER;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
