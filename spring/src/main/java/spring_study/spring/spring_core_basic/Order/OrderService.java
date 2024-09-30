package spring_study.spring.spring_core_basic.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
