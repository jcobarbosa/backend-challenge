package com.invillia.acme.service;

import com.invillia.acme.entity.Order;
import com.invillia.acme.entity.Payment;
import com.invillia.acme.entity.domain.OrderStatus;
import com.invillia.acme.entity.domain.PaymentStatus;
import com.invillia.acme.repository.OrderRepository;
import com.invillia.acme.resource.dto.OrderDTO;
import com.invillia.acme.resource.dto.PaymentDTO;
import com.invillia.acme.util.ObjectMapperUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDTO create(OrderDTO orderDTO) {
        Order order = ObjectMapperUtil.convert(orderDTO, Order.class);
        return saveOrUpdate(order);
    }

    public OrderDTO receivePayment(Long orderId, PaymentDTO paymentDTO) throws Exception {
        Order orderToPay = retrieveOrderOrFail(orderId);
        Payment payment = ObjectMapperUtil.convert(paymentDTO, Payment.class);
        orderToPay.setPayment(payment);
        return saveOrUpdate(orderToPay);
    }

    public OrderDTO refundOrder(Long orderId) throws Exception {
        Order orderToRefund = retrieveOrderOrFail(orderId);

        validIfOrderIsAvailableForRefund(orderToRefund);

        orderToRefund.setStatus(OrderStatus.REFUND);
        orderToRefund.getPayment().setStatus(PaymentStatus.REFUND);
        return saveOrUpdate(orderToRefund);
    }

    private void validIfOrderIsAvailableForRefund(Order orderToRefund) throws Exception {
        if (Objects.isNull(orderToRefund.getPayment())) {
            throw new Exception(("Não é possivel reembolsar um pedido que não foi pago."));
        }

        if (orderToRefund.getPayment().getPaymentDate().until(LocalDateTime.now(), ChronoUnit.DAYS) > 10) {
            throw new Exception("Não é possível reembolsar um pedido realiado a mais de 10 dias.");
        }
    }

    //refundOrderItemPayment - não especificado

    private Order retrieveOrderOrFail(Long id) throws Exception {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return order.get();
        } else {
            throw new Exception("Pedido não encontrado!");
        }
    }

    private OrderDTO saveOrUpdate(Order orderToPersist) {
        return ObjectMapperUtil.convert(orderRepository.save(orderToPersist), OrderDTO.class);
    }

}
