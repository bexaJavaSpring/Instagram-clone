package com.example.instagramclone.entity;

import com.example.instagramclone.entity.enums.PermissionEnum;
import com.example.instagramclone.entity.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Role {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private RoleEnum roleName;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<PermissionEnum> permissionEnum;

    public Role(RoleEnum roleName, List<PermissionEnum> permissionEnum) {
        this.roleName = roleName;
        this.permissionEnum = permissionEnum;
    }
}
