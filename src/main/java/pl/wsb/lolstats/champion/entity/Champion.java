package pl.wsb.lolstats.champion.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/** Bohater League of Legends: jeden wiersz tabeli champion. */
@Entity
@Table(name = "champion")
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    protected Champion() {
    }

    public Champion(String name, String title, ChampionRole role, LocalDate releaseDate, BaseStats baseStats) {
        this.name = name;
        this.title = title;
        this.role = role;
        this.releaseDate = releaseDate;
        this.baseStats = baseStats;
    }

    public Long getId() {
        return id;
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
}
