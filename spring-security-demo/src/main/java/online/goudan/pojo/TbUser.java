package online.goudan.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class TbUser implements UserDetails {
    private Long id;

    private String username;

    private String name;

    private String address;

    private String password;
    private List<TbRole> tbRoleList;

    public TbUser(Long id, String username, String name, String address, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.address = address;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        if (tbRoleList != null) {
            for (TbRole tbRole : tbRoleList) {
                list.add(new SimpleGrantedAuthority(tbRole.getName()));
            }
        }
        return list;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}