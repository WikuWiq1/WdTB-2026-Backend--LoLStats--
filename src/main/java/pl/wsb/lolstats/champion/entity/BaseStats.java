package pl.wsb.lolstats.champion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

/**
 * Bazowe statystyki bohatera na 1. poziomie. Klasa wbudowana: nie ma własnej tabeli,
 * jej kolumny trafiają do tabeli champion.
 */
@Embeddable
public class BaseStats {

    @Column(name = "health", nullable = false)
    private Integer health;

    @Column(name = "mana")
    private Integer mana;                       // null: bohater bez many (np. Garen)

    @Column(name = "attack_damage", nullable = false, precision = 6, scale = 2)
    private BigDecimal attackDamage;

    @Column(name = "armor", nullable = false, precision = 6, scale = 2)
    private BigDecimal armor;

    protected BaseStats() {
    }

    public BaseStats(Integer health, Integer mana, BigDecimal attackDamage, BigDecimal armor) {
        this.health = health;
        this.mana = mana;
        this.attackDamage = attackDamage;
        this.armor = armor;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getMana() {
        return mana;
    }

    public BigDecimal getAttackDamage() {
        return attackDamage;
    }

    public BigDecimal getArmor() {
        return armor;
    }
}
