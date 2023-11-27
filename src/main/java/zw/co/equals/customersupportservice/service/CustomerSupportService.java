package zw.co.equals.customersupportservice.service;

import zw.co.equals.customersupportservice.dto.UpdateAccountRequest;
import zw.co.equals.customersupportservice.dto.UpdateAccountResponse;

public interface CustomerSupportService {
    UpdateAccountResponse updateAccountType(UpdateAccountRequest updateAccountRequest);
}
