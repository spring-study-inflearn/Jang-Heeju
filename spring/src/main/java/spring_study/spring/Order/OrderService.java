package spring_study.spring.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
