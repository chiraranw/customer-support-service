package zw.co.equals.customersupportservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.equals.customersupportservice.dto.UpdateAccountRequest;
import zw.co.equals.customersupportservice.dto.UpdateAccountResponse;
import zw.co.equals.customersupportservice.service.CustomerSupportService;

@RestController
@RequestMapping("/api/v1.0/support")
public class CustomerSupportController {

    private final CustomerSupportService customerSupportService;

    public CustomerSupportController(CustomerSupportService customerSupportService) {
        this.customerSupportService = customerSupportService;
    }

    @PostMapping("update-account-type")
    public ResponseEntity<UpdateAccountResponse> updateAccountType(@RequestBody UpdateAccountRequest updateAccountRequest){
        return new ResponseEntity<>(customerSupportService.updateAccountType(updateAccountRequest), HttpStatus.CREATED);
    }
}
