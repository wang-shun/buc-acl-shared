/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.buc.acl.api.input.role;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.alibaba.buc.acl.api.annotation.AppKeyPrivilegeAnnotation;
import com.alibaba.buc.acl.api.annotation.sequence.Oper;
import com.alibaba.buc.acl.api.annotation.sequence.S1;
import com.alibaba.buc.acl.api.annotation.sequence.S2;
import com.alibaba.buc.acl.api.annotation.sequence.S3;
import com.alibaba.buc.acl.api.annotation.sequence.Sa1;
import com.alibaba.buc.acl.api.annotation.sequence.Sb1;
import com.alibaba.buc.acl.api.annotation.sequence.Sb3;
import com.alibaba.buc.acl.api.common.AclParam;


/**
 * 分页查询数据权限模型关联操作的入参
 * 类PageDataPermissionModelOperationParam.java的实现描述：TODO 类实现描述
 *
 * @author tongxu 2016年4月28日 下午4:07:20
 */

@GroupSequence(
        value = {
                Sb1.class,
                S1.class,
                Sa1.class,
                S2.class,
                Oper.class,
                PageDataPermissionModelOperationParam.class
        }
)

@AppKeyPrivilegeAnnotation(
        appKeyField = "accessKey",
        keyCenterAccessKeyField = "keyCenterAccessKey",
        interfaceNameField = "DataPermissionModelService.pageDataPermissionModelOperation",
        groups = {Sa1.class}
)

public class PageDataPermissionModelOperationParam extends AclParam {

    private static final long serialVersionUID = 8544782005254653337L;

    /**
     * 所属数据权限模型名
     */
    @NotNull(groups = {Sb3.class})
    @Size(min = 1, max = 200, groups = {S3.class})
    private String dataPermissionModelName;

    public String getDataPermissionModelName() {
        return dataPermissionModelName;
    }

    public void setDataPermissionModelName(String dataPermissionModelName) {
        this.dataPermissionModelName = dataPermissionModelName;
    }

}
