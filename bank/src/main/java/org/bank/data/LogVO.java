package org.bank.data;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogVO
{
	private BigDecimal logno,deposit,balance;
	private String userID,means,payment_number,mall_ID,mall_account_number,etc;
	private Timestamp transaction_date;
}
