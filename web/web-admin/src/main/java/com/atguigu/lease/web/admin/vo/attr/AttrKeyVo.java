package com.atguigu.lease.web.admin.vo.attr;

import com.atguigu.lease.model.entity.AttrKey;
import com.atguigu.lease.model.entity.AttrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Data
public class AttrKeyVo extends AttrKey {

    //一对多关联属性
    @Schema(description = "属性value列表")
    private List<AttrValue> attrValueList;
}
