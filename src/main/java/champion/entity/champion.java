package champion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Champion")
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "<kolumna>", nullable = false, length = 60)
    private String name;

    private Integer health;

    private Double attackDamage;

    private Integer mana;

    protected <NazwaKlasy>() {
    }
}