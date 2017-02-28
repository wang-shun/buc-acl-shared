package com.alibaba.buc.acl.api.input.datapermission;

import javax.validation.GroupSequence;

import com.alibaba.buc.acl.api.annotation.AppKeyPrivilegeAnnotation;
import com.alibaba.buc.acl.api.annotation.sequence.Oper;
import com.alibaba.buc.acl.api.annotation.sequence.S1;
import com.alibaba.buc.acl.api.annotation.sequence.S2;
import com.alibaba.buc.acl.api.annotation.sequence.Sa1;
import com.alibaba.buc.acl.api.annotation.sequence.Sb1;
import com.alibaba.buc.acl.api.common.AclParam;

/**
 * @author baidian.zc
 */
@GroupSequence(
               value = {
                       Sb1.class,
                       S1.class,
                       Sa1.class,
                       S2.class,
                       Oper.class,
                       DeleteDataPermissionModelParam.class
               }
       )

@AppKeyPrivilegeAnnotation(
        appKeyField = "accessKey",
        keyCenterAccessKeyField = "keyCenterAccessKey",
        interfaceNameField = "DataPermissionModelService.deleteDataPermissionModel",
        groups = {Sa1.class}
)

/**
 * 封装数据权限模型删除相关信息
 * 类DeleteDataPermissionModelParam.java的实现描述：TODO 类实现描述 
 * @author tongxu 2016年9月1日 下午2:13:32
 */
public class DeleteDataPermissionModelParam extends AclParam {

	private static final long serialVersionUID = 4135372589910768550L;
    
    // 要删除的数据权限模型name
    private String            name;
    
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
  
	
}
