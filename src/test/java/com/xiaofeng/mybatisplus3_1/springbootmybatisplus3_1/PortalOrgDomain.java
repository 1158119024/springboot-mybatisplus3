package com.xiaofeng.mybatisplus3_1.springbootmybatisplus3_1;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@TableName("uf_spm_portal_org")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortalOrgDomain{
    /**
     * isOpen	是否启用
     * openTime	启用时间
     * orgCode	组织编码
     * orgFullName	组织全称
     * orgId	组织ID
     * orgName	组织名称
     * parentOrgId	父组织ID
     * recordAddTime	记录新增时间
     * recordUpdateTime	记录最后更新时间
     * sortSeq	排序序号
     * stopTime	停用时间
     * newOrgId	新组织ID
     * newParentOrgId	新父组织ID
     * managerId	组织主负责人
     * superVisor	上级主管
     * orgType	组织类型
     * viceManager	组织辅助负责人
     * smapViceManager	smap组织辅助负责人
     */

    @TableField(value = "is_open")
    private String isOpen;
    @TableField(value = "open_time")
    private String openTime;
    @TableField(value = "org_code")
    private String orgCode;
    @TableField(value = "org_full_name")
    private String orgFullName;
    @TableField(value = "org_id")
    private String orgId;
    @TableField(value = "org_name")
    private String orgName;
    @TableField(value = "parent_org_id")
    private String parentOrgId;
    @TableField(value = "record_add_time")
    private String recordAddTime;
    @TableField(value = "record_update_time")
    private String recordUpdateTime;
    @TableField(value = "sort_seq")
    private String sortSeq;
    @TableField(value = "stop_time")
    private String stopTime;
    @TableField(value = "new_org_id")
    private String newOrgId;
    @TableField(value = "new_parent_org_id")
    private String newParentOrgId;
    @TableField(value = "manager_id")
    private String managerId;
    @TableField(value = "super_visor")
    private String superVisor;
    @TableField(value = "org_type")
    private String orgType;
    @TableField(value = "vice_manager")
    private String viceManager;
    @TableField(value = "smap_vice_manager")
    private String smapViceManager;
}
