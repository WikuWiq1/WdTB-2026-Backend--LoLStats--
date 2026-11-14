package pl.wsb.lolstats.champion.entity;

import jakarta.persistence.*;
import pl.wsb.lolstats.item.entity.Item;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Bohater League of Legends: jeden wiersz tabeli champion. */
@Entity
@Table(name = "champion")
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "riot_key", nullable = false, unique = true, length = 40)
    private String riotKey;                     // identyfikator w Data Dragon, np. "LeeSin"

    @Column(name = "name", nullable = false, unique = true, length = 60)
    private String name;

    @Column(name = "title", nullable = false, length = 80)
    private String title;                       // np. "the Nine-Tailed Fox"

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private ChampionRole role;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Embedded
    private BaseStats baseStats;

    /** Jeden-do-wielu: drugi koniec relacji Ability.champion. Nie tworzy kolumny. */
    @OneToMany(mappedBy = "champion")
    private List<Ability> abilities = new ArrayList<>();

    /** Wiele-do-wielu: polecane przedmioty. Hibernate tworzy tabelę łączącą champion_item. */
    @ManyToMany
    @JoinTable(name = "champion_item",
            joinColumns = @JoinColumn(name = "champion_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> recommendedItems = new HashSet<>();

    protected Champion() {
    }

    public Champion(String riotKey, String name, String title, ChampionRole role, LocalDate releaseDate, BaseStats baseStats) {
        this.riotKey = riotKey;
        this.name = name;
        this.title = title;
        this.role = role;
        this.releaseDate = releaseDate;
        this.baseStats = baseStats;
    }

    public Long getId() {
        return id;
    }

    public String getRiotKey() {
        return riotKey;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public ChampionRole getRole() {
        return role;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public BaseStats getBaseStats() {
        return baseStats;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public Set<Item> getRecommendedItems() {
        return recommendedItems;
    }
}
