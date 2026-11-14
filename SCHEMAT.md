# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 7 (w tym tabele łączące @ManyToMany: champion_item) · kolumny: 43 · relacje: 3 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 1 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| ability | Ability | 6 | champion_id |
| champion | Champion | 10 | — |
| item | Item | 6 | — |
| match_participation | MatchParticipation | 8 | champion_id, summoner_id |
| summoner | Summoner | 8 | user_account_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    ability {
        Long id PK
        AbilityKey ability_key
        Long champion_id FK
        BigDecimal cooldown
        String description
        String name
    }
    champion {
        Long id PK
        BigDecimal armor
        BigDecimal attack_damage
        Integer health
        Integer mana
        String name
        LocalDate release_date
        String riot_key
        ChampionRole role
        String title
    }
    item {
        Long id PK
        String description
        Integer gold_cost
        String name
        Boolean purchasable
        Integer sell_value
    }
    match_participation {
        Long id PK
        Integer assists
        Long champion_id FK
        Integer deaths
        Integer kills
        LocalDateTime played_at
        Long summoner_id FK
        Boolean win
    }
    summoner {
        Long id PK
        String game_name
        LocalDateTime last_updated
        String puuid
        String server
        Integer summoner_level
        String tag_line
        Long user_account_id FK
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    champion ||--o{ ability : "champion_id"
    champion ||--o{ match_participation : "champion_id"
    champion }o--o{ item : "champion_item"
    summoner ||--o{ match_participation : "summoner_id"
    user_account |o--o| summoner : "user_account_id"
```
