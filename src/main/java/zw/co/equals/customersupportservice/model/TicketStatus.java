package zw.co.equals.customersupportservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TicketStatus {
  OPEN("OPEN"),
  CLOSED("CLOSED");
  private final String status;
}
