package zw.co.equals.customersupportservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountResponse {
    private int status;
    private String accountNumber;
    private AccountType accountType;
}
