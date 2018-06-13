import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/13
 */
@FeignClient(value = "/")
public interface OrderClient {
    @RequestMapping(value = "/api/order",method = RequestMethod.GET)
    Object get();

}
