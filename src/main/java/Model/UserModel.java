package Model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserModel {
    public Arrays getRoles() {
        return null;
    }

    public Object getUserName() {
        return null;
    }

    public void setPassword(String encode) {
    }

    public CharSequence getPassword() {
        return null;
    }

    public CharSequence getAuthorities() {
        return null;
    }

    public String getUsername() {
        return null;
    }

    @Entity
    @Table(name="user_model")
    public class userModel implements UserDetails, Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long userId;

        @Column(nullable = false, unique = true)
        private String userName;

        @Column(nullable = false)
        private String password;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name="role_id"))
        private List<RoleModel> roles;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return (Collection<? extends GrantedAuthority>) this.roles;
        }

        public List<RoleModel> getRoles() {
            return roles;
        }

        public void setRoles(List<RoleModel> roles) {
            this.roles = roles;
        }

        @Override
        public String getPassword() {
            return this.password;
        }

        @Override
        public String getUsername() {
            return this.userName;
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

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
