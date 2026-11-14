package pl.wsb.lolstats.item.entity;

import jakarta.persistence.*;

/** Przedmiot ze sklepu w grze. */
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 60)
    private String name;

    @Column(name = "gold_cost", nullable = false)
    private Integer goldCost;

    @Column(name = "sell_value", nullable = false)
    private Integer sellValue;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "purchasable", nullable = false)
    private Boolean purchasable;                // czy da się go kupić w sklepie

    protected Item() {
    }

    public Item(String name, Integer goldCost, Integer sellValue, String description, Boolean purchasable) {
        this.name = name;
        this.goldCost = goldCost;
        this.sellValue = sellValue;
        this.description = description;
        this.purchasable = purchasable;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getGoldCost() {
        return goldCost;
    }

    public Integer getSellValue() {
        return sellValue;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getPurchasable() {
        return purchasable;
    }
}
