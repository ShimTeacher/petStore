package perstore.pet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import perstore.pet.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

//    public List<OrderGetResponse> getAllInventory() {
//        return OrderGetResponse;
//    }


//    public OrderGetResponse getOne(int id) {
//        Order order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException());
//        return OrderGetResponse.builder()
//
//    }


}
