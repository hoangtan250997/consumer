package com.example.comsumer;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class FoodOrderDto {
String item;
Double amount;
}
