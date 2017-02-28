package com.alibaba.buc.acl.api.input.grant;

import java.util.Date;
import java.util.List;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.alibaba.buc.acl.api.annotation.AclEnumAnnotation;
import com.alibaba.buc.acl.api.annotation.AppKeyPrivilegeAnnotation;
import com.alibaba.buc.acl.api.annotation.ArraySizeAnnotation;
import com.alibaba.buc.acl.api.annotation.MustExistInDbAnnotation;
import com.alibaba.buc.acl.api.annotation.grant.GrantExpireDateAnnotation;
import com.alibaba.buc.acl.api.annotation.grant.SameDomainAnnotation;
import com.alibaba.buc.acl.api.annotation.sequence.Oper;
import com.alibaba.buc.acl.api.annotation.sequence.S1;
import com.alibaba.buc.acl.api.annotation.sequence.S2;
import com.alibaba.buc.acl.api.annotation.sequence.S3;
import com.alibaba.buc.acl.api.annotation.sequence.S4;
import com.alibaba.buc.acl.api.annotation.sequence.S5;
import com.alibaba.buc.acl.api.annotation.sequence.S6;
import com.alibaba.buc.acl.api.annotation.sequence.Sa1;
import com.alibaba.buc.acl.api.annotation.sequence.Sa4;
import com.alibaba.buc.acl.api.annotation.sequence.Sa6;
import com.alibaba.buc.acl.api.annotation.sequence.Sb1;
import com.alibaba.buc.acl.api.annotation.sequence.Sb3;
import com.alibaba.buc.acl.api.annotation.sequence.Sb4;
import com.alibaba.buc.acl.api.common.AclParam;

/**
 * 授予/冻结/移除用户组权限入参
 * <p/>
 * {@link com.alibaba.buc.api.GrantService#grantPermissionsToUsergroup(GrantPermissionsToUsergroupParam)}
 *
 * @author yicheng.wp
 * @author taigao.wjj update on 2015/12/03
 */

@GroupSequence(
        value = {
                Sb1.class,
                S1.class,
                Sa1.class,
                S2.class,
                Oper.class,
                Sb3.class,
                S3.class,
                Sb4.class,
                S4.class,
                Sa4.class,
                S5.class,
                S6.class,
                Sa6.class,
                GrantPermissionsToUsergroupParam.class
        }
)

@AppKeyPrivilegeAnnotation(
        appKeyField = "accessKey",
        keyCenterAccessKeyField = "keyCenterAccessKey",
        interfaceNameField = "GrantService.grantPermissionsToUsergroup",
        groups = {Sa1.class}
)

@SameDomainAnnotation(
        appKeyField = "accessKey",
        namesField = "permissionNames",
        type = "permission",
        groups = {Sa4.class}
)

@GrantExpireDateAnnotation(
        appKeyField = "accessKey",
        permissionNamesField = "permissionNames",
        expireDateField = "expireDate",
        actionField = "action",
        type = "PERMISSION",
        groups = {S5.class}
)

public class GrantPermissionsToUsergroupParam extends AclParam {

    private static final long serialVersionUID = 7663211741564543912L;

    @NotEmpty(groups = {Sb3.class})
    @MustExistInDbAnnotation(type = "usergroup", groups = {S3.class})
    private String usergroupName; // 用户组名

    @NotEmpty(groups = {Sb4.class})
    @ArraySizeAnnotation(size = 100, groups = {S4.class})
    private List<String> permissionNames; // 权限名列表

    private Date expireDate; // 过期时间

    @NotNull(groups = {S6.class})
    @AclEnumAnnotation(scope = "Grant,Freeze,Revoke", groups = {Sa6.class})
    private String action; // 授予动作

    private String reason; // 理由

    public String getUsergroupName() {
        return usergroupName;
    }

    public void setUsergroupName(String usergroupName) {
        this.usergroupName = usergroupName;
    }

    public List<String> getPermissionNames() {
        return permissionNames;
    }

    public void setPermissionNames(List<String> permissionNames) {
        this.permissionNames = permissionNames;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
