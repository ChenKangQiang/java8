package lambdasinaction.chap5.example;

import lambdasinaction.chap5.example.Trader;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 交易类
 */

@Data
@AllArgsConstructor
public class Transaction{

	private Trader trader;
	private int year;
	private int value;

}