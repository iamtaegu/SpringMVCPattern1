package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;

//@Getter
@Data // Getter, Setter외 기능도 포함하기 때문에 사용 지양
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
