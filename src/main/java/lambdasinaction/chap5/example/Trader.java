package lambdasinaction.chap5.example;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 交易员类
 */

@Data
@AllArgsConstructor
public  class Trader{
	private String name;
	private String city;
}