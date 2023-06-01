package Model;

import enuns.RoleName;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class RoleModel {
    public boolean getId() {
        return false;
    }

    @Entity
    @Table(name="Role_model")
    public class rolemodel implements GrantedAuthority, Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long ROLEId;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false, unique = true)
        private RoleName roleName;

        @Override
        public String getAuthority() {
            return this.roleName.toString();
        }

        public Long getROLEId() {
            return ROLEId;
        }

        public void setROLEId(Long ROLEId) {
            this.ROLEId = ROLEId;
        }

        public <RoleName> RoleName getRoleName() {
            return (RoleName) roleName;
        }

        public <RoleName> void setRoleName(RoleName roleName) {
            this.roleName = (enuns.RoleName) roleName;
        }
    }
}
