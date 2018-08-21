package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller    // This means that this class is a Controller
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<bank> Bank = userRepository.findAll();
        model.put("Bank",Bank);
        return "main";
    }

    @PostMapping
    public String  filter(@RequestParam String filter1, @RequestParam Long balance, @RequestParam String filter2, Map<String, Object> model) {
        bank Bank1 = userRepository.findBySchet(filter1);
        bank Bank2 = userRepository.findBySchet(filter2);
        String name;
        if (Bank1 == null || Bank2 == null || balance <= 0) {
            name = "Проверьте введенные данные";
            model.put("name", name);
        } else {
            long n = Bank1.getBalance();
            if (balance > n) {
                name = "НЕДОСТАТОЧНО СРЕДСТВ";
                model.put("name", name);
            } else {
                n = n - balance;
                long m = Bank2.getBalance() + balance;
                Bank2.setBalance(m);
                Bank1.setBalance(n);
                userRepository.save(Bank1);
                userRepository.save(Bank2);
                name = "ПЕРЕВОД СОВЕРШЕН";
                model.put("name", name);
            }
        }
        return "main";
    }

}

