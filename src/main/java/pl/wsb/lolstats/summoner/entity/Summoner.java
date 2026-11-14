package pl.wsb.lolstats.summoner.entity;

import jakarta.persistence.*;
import pl.wsb.lolstats.account.domain.UserAccount;

import java.time.LocalDateTime;

/** Konto gracza (przywoływacza) pobrane z Riot API. */
@Entity
@Table(name = "summoner")
public class Summoner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "puuid", unique = true, length = 78)
    private String puuid;                       // stały identyfikator gracza w Riot API; uzupełni się przy pobraniu z API

    @Column(name = "game_name", nullable = false, length = 40)
    private String gameName;                    // część Riot ID przed #

    @Column(name = "tag_line", nullable = false, length = 10)
    private String tagLine;                     // część Riot ID po #, np. EUNE

    @Column(name = "server", nullable = false, length = 10)
    private String server;                      // np. EUN1, EUW1

    @Column(name = "summoner_level", nullable = false)
    private Integer summonerLevel;

    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;          // kiedy ostatnio pobrano dane z Riot API

    /**
     * Jeden-do-jednego: konto w aplikacji, do którego użytkownik podpiął to konto LoL.
     * Opcjonalne: większość graczy w bazie nie ma konta w aplikacji.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id", unique = true)
    private UserAccount account;

    protected Summoner() {
    }

    public Summoner(String puuid, String gameName, String tagLine, String server, Integer summonerLevel,
                    LocalDateTime lastUpdated, UserAccount account) {
        this.puuid = puuid;
        this.gameName = gameName;
        this.tagLine = tagLine;
        this.server = server;
        this.summonerLevel = summonerLevel;
        this.lastUpdated = lastUpdated;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getPuuid() {
        return puuid;
    }

    public String getGameName() {
        return gameName;
    }

    public String getTagLine() {
        return tagLine;
    }

    public String getServer() {
        return server;
    }

    public Integer getSummonerLevel() {
        return summonerLevel;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public UserAccount getAccount() {
        return account;
    }
}
