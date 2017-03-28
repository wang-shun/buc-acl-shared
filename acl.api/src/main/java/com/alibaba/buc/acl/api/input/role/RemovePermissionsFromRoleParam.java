package com.alibaba.buc.acl.api.input.role;

import java.util.List;

import com.alibaba.buc.acl.api.common.AclParam;

/**
 * 从角色中移除权限入参
 *
 * @author yicheng.wp
 */

public class RemovePermissionsFromRoleParam extends AclParam {

    private static final long serialVersionUID = -4670211202150323840L;

    private String roleName; // 角色名

    private List<String> permissionNames; // 权限名列表

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<String> getPermissionNames() {
        return permissionNames;
    }

    public void setPermissionNames(List<String> permissionNames) {
        this.permissionNames = permissionNames;
    }

}
