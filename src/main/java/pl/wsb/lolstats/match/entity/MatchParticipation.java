package pl.wsb.lolstats.match.entity;

import jakarta.persistence.*;
import pl.wsb.lolstats.champion.entity.Champion;
import pl.wsb.lolstats.summoner.entity.Summoner;

import java.time.LocalDateTime;

/**
 * Udział gracza w jednym meczu: kto, jakim bohaterem i z jakim wynikiem.
 * Łączy summoner i champion (wiele-do-wielu przez encję łączącą z własnymi danymi).
 */
@Entity
@Table(name = "match_participation")
public class MatchParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)   // który gracz grał
    @JoinColumn(name = "summoner_id", nullable = false)
    private Summoner summoner;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)   // jakim bohaterem
    @JoinColumn(name = "champion_id", nullable = false)
    private Champion champion;

    @Column(name = "kills", nullable = false)
    private Integer kills;

    @Column(name = "deaths", nullable = false)
    private Integer deaths;

    @Column(name = "assists", nullable = false)
    private Integer assists;

    @Column(name = "win", nullable = false)
    private Boolean win;

    @Column(name = "played_at", nullable = false)
    private LocalDateTime playedAt;

    protected MatchParticipation() {
    }

    public MatchParticipation(Summoner summoner, Champion champion, Integer kills, Integer deaths, Integer assists,
                              Boolean win, LocalDateTime playedAt) {
        this.summoner = summoner;
        this.champion = champion;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.win = win;
        this.playedAt = playedAt;
    }

    public Long getId() {
        return id;
    }

    public Summoner getSummoner() {
        return summoner;
    }

    public Champion getChampion() {
        return champion;
    }

    public Integer getKills() {
        return kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public Integer getAssists() {
        return assists;
    }

    public Boolean getWin() {
        return win;
    }

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }
}
