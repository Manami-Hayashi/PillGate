package be.kdg.programming3.presentation.controllers;

import be.kdg.programming3.domain.user.Customer;
import be.kdg.programming3.presentation.controllers.viewmodels.CustomerRegistrationDto;
import be.kdg.programming3.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping("/pillgate")
@Controller
public class RegistrationController {
    Logger logger = org.slf4j.LoggerFactory.getLogger(RegistrationController.class);

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showHomeView() {
        logger.info("Request for home view!");

        return "home";
    }

    @GetMapping("/registration")
    public String showRegistration(Model model) {
        logger.info("Showing registration form");
        model.addAttribute("customerDTO", new CustomerRegistrationDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerCustomer(@ModelAttribute CustomerRegistrationDto registrationDto) {
        logger.info("Registering customer: " + registrationDto.toString());
        userService.registerNewCustomer(registrationDto);

        return "redirect:/registration";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        logger.info("Showing login form");
        model.addAttribute("customerDTO", new CustomerRegistrationDto());
        return "login";
    }

//    @PostMapping("/login")
//    public String loginCustomer(@ModelAttribute CustomerRegistrationDto registrationDto) {
//        logger.info("Logging in customer: " + registrationDto.toString());
//        userService.loginCustomer(registrationDto);
//
//        return "redirect:/login";
//    }
}


//@RestController
//@RequestMapping("/api/customers")
//public class CustomerController {
//
//    @Autowired
//    private UserService customerService;
//
//    @PostMapping("/register")
//    public ResponseEntity<String> registerCustomer(@RequestBody CustomerRegistrationDto customerRegistrationDto) {
//        // Map properties from CustomerRegistrationDto to Customer
//        Customer customer = new Customer();
//        customer.setCustomer_name(customerRegistrationDto.getFirstName() + " " + customerRegistrationDto.getLastName());
//        customer.setBirthDate(customerRegistrationDto.getBirthDate());
//        customer.setEmail(customerRegistrationDto.getEmail());
//        customer.setHasCareGiver(false); // Set default value, adjust as needed
//        customer.setPassword(customerRegistrationDto.getPassword());
//
//        // Call service method to register the customer
//        customerService.registerNewCustomer(customer);
//
//        return new ResponseEntity<>("Customer registered successfully", HttpStatus.CREATED);
//    }
//}
