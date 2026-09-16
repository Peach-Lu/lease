package com.atguigu.lease.web.admin.controller.apartment;

import com.atguigu.lease.common.result.Result;
import com.atguigu.lease.model.entity.PaymentType;
import com.atguigu.lease.web.admin.service.PaymentTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前后端分离的项目
 * 后端 controller 就是接口 前端和后端controller 接口对接
 * 路径写错 会报404
 * 请求method 错误 报405
 * 权限不够 403
 * 参数错误 400
 * 服务器内部异常 500
 * 请求成功 200
 *
 * 接口主要功能
 * 接受请求 获取数据 (@RequstParam @PathVariable @RequestBody @RequestHeader @CookieValue HttpServletRequest)
 * 调用业务层 完成业务处理 数据处理
 * 返回结果给调用者客户端 移动 pc 第三方 iot物联网 统一结果封装result
 *
 * **/
@Tag(name = "支付方式管理")
@RestController
@RequestMapping("/admin/payment")
public class PaymentTypeController {
    @Autowired
    PaymentTypeService paymentTypeService;
    // 查询 所有支付方式
    @Operation(summary = "查询所有支付方式")
    @GetMapping("list")
    public Result<List<PaymentType>> listPaymentType(){
        List<PaymentType> list =  paymentTypeService.list();
        return Result.ok(list);
    }
    // 根据id删除支付
    @Operation(summary = "根据id删除支付方式")
    @DeleteMapping("deleteById")
    public Result deleteById(@RequestParam Long id){
        System.out.println("id = " + id);
        paymentTypeService.removeById(id);
        return Result.ok();
    }
    @Operation(summary = "保存或更新支付方式")
    @PostMapping("saveOrUpdate") // 数据存放在请求体 需要把请求题的JSON数据 转换为Bean 对象
    public Result saveOrUpdate(@RequestBody PaymentType paymentType){
        paymentTypeService.saveOrUpdate(paymentType);
        return Result.ok();
    }
    // 保存或更新支付方式
}
