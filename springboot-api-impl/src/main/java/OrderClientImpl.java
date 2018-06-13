import com.sym.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/13
 */
@RequestMapping("api")
public class OrderClientImpl implements OrderClient {
    @Autowired
    private OrderService orderService;
    @Override
    @GetMapping("order")
    public Object get() {
        return orderService.get();
    }
}
