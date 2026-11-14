package pl.wsb.lolstats.champion.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

/** Umiejętność bohatera (pasywna, Q, W, E, R). */
@Entity
@Table(name = "ability")
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Wiele-do-jednego: wiele umiejętności należy do jednego bohatera. Kolumna champion_id. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "champion_id", nullable = false)
    private Champion champion;

    @Enumerated(EnumType.STRING)
    @Column(name = "ability_key", nullable = false, length = 10)
    private AbilityKey abilityKey;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "cooldown", precision = 6, scale = 2)
    private BigDecimal cooldown;                // w sekundach; null dla umiejętności pasywnej

    @Column(name = "description", length = 255)
    private String description;

    protected Ability() {
    }

    public Ability(Champion champion, AbilityKey abilityKey, String name, BigDecimal cooldown, String description) {
        this.champion = champion;
        this.abilityKey = abilityKey;
        this.name = name;
        this.cooldown = cooldown;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Champion getChampion() {
        return champion;
    }

    public AbilityKey getAbilityKey() {
        return abilityKey;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCooldown() {
        return cooldown;
    }

    public String getDescription() {
        return description;
    }
}
