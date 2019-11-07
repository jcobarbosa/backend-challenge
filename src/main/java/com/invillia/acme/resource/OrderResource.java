package com.invillia.acme.resource;

import com.invillia.acme.resource.dto.OrderDTO;
import com.invillia.acme.resource.dto.PaymentDTO;
import com.invillia.acme.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/order")
public class OrderResource {

    private OrderService orderService;

    OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value = "Criar pedido com itens", response = OrderDTO.class)
    @PostMapping
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {
        return this.orderService.create(orderDTO);
    }

    @ApiOperation(value = "Criar pagamento para um pedido", response = OrderDTO.class)
    @PostMapping(path = "/{id}/payment")
    public OrderDTO c(@PathVariable(name = "id") Long id, @RequestBody PaymentDTO paymentDTO) throws Exception {
        return this.orderService.receivePayment(id, paymentDTO);
    }

    @ApiOperation(value = "Estornar pgamento para um pedido", response = OrderDTO.class)
    @PostMapping(path = "/{id}/refund")
    public OrderDTO refundPayment(@PathVariable(name = "id") Long id) throws Exception {
        return this.orderService.refundOrder(id);
    }

    //refundOrderItemPayment - não específicado
}
