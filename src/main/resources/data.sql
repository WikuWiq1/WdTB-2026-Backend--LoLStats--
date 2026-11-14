-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: konta zespołu
insert into user_account (email, display_name, role, created_at) values
    ('wrx82059@student.wroclaw.merito.pl', 'Wiktor', 'USER', current_timestamp),
    ('s356629@student.wroclaw.merito.pl',  'Szymon', 'USER', current_timestamp),
    ('wrx82057@student.wroclaw.merito.pl', 'Jakub',  'USER', current_timestamp);

-- ===== LAB 02 · champion =====
insert into champion (riot_key, name, title, role, release_date, health, mana, attack_damage, armor) values
    ('Ahri',   'Ahri',    'the Nine-Tailed Fox',  'MID',     '2011-12-14', 590, 418,  53.00, 21.00),
    ('Garen',  'Garen',   'The Might of Demacia', 'TOP',     '2010-04-27', 690, null, 69.00, 38.00),
    ('Jinx',   'Jinx',    'the Loose Cannon',     'ADC',     '2013-10-10', 630, 260,  59.00, 26.00),
    ('Thresh', 'Thresh',  'the Chain Warden',     'SUPPORT', '2013-01-23', 620, 274,  56.00, 28.00),
    ('LeeSin', 'Lee Sin', 'the Blind Monk',       'JUNGLE',  '2011-04-01', 645, null, 69.00, 36.00);

-- ===== LAB 02 · item =====
insert into item (name, gold_cost, sell_value, description, purchasable) values
    ('Doran''s Blade',      450,  180,  'Przedmiot startowy: obrażenia i zdrowie.', true),
    ('Infinity Edge',       3400, 2380, 'Zwiększa obrażenia trafień krytycznych.',  true),
    ('Rabadon''s Deathcap', 3600, 2520, 'Duży bonus do mocy umiejętności.',         true),
    ('Health Potion',       50,   20,   'Odnawia zdrowie przez 15 sekund.',         true);

-- ===== LAB 02 · summoner =====          (user_account_id: 7 = Jakub; pozostali gracze nie mają konta w aplikacji)
insert into summoner (game_name, tag_line, server, summoner_level, last_updated, user_account_id) values
    ('Faker',      'KR1',  'KR',   812, '2026-11-10 20:15:00', null),
    ('Caps',       'EUW',  'EUW1', 654, '2026-11-12 18:40:00', null),
    ('WroclawMid', 'EUNE', 'EUN1', 143, '2026-11-14 09:05:00', 7);

-- ===== LAB 03 · ability =====            (champion_id: 1 Ahri, 2 Garen, 3 Jinx, 4 Thresh, 5 Lee Sin)
insert into ability (champion_id, ability_key, name, cooldown, description) values
    (1, 'Q',       'Orb of Deception',            7.00,   'Kula leci i wraca, zadając obrażenia magiczne.'),
    (1, 'R',       'Spirit Rush',                 130.00, 'Trzy szybkie doskoki z pociskami.'),
    (2, 'Q',       'Decisive Strike',             8.00,   'Przyspieszenie i cios uciszający przeciwnika.'),
    (2, 'R',       'Demacian Justice',            120.00, 'Egzekucja: więcej obrażeń przy niskim zdrowiu celu.'),
    (3, 'Q',       'Switcheroo!',                 0.90,   'Zmiana broni: minigun albo wyrzutnia rakiet.'),
    (3, 'R',       'Super Mega Death Rocket!',    85.00,  'Rakieta przez całą mapę.'),
    (4, 'PASSIVE', 'Damnation',                   null,   'Zbiera dusze, które zwiększają pancerz i moc.'),
    (4, 'Q',       'Death Sentence',              19.00,  'Rzut sierpem, który przyciąga trafionego wroga.'),
    (5, 'Q',       'Sonic Wave / Resonating Strike', 10.00, 'Fala dźwiękowa, potem doskok do trafionego celu.'),
    (5, 'R',       'Dragon''s Rage',               110.00, 'Kopnięcie odrzucające wroga.');

-- ===== LAB 03 · match_participation =====  (summoner_id: 1 Faker, 2 Caps, 3 WroclawMid)
insert into match_participation (summoner_id, champion_id, kills, deaths, assists, win, played_at) values
    (1, 1, 12, 2, 8,  true,  '2026-11-09 21:00:00'),
    (1, 5, 7,  3, 15, true,  '2026-11-10 19:30:00'),
    (2, 1, 9,  4, 6,  false, '2026-11-11 20:10:00'),
    (2, 3, 14, 6, 9,  true,  '2026-11-12 18:00:00'),
    (3, 1, 5,  7, 10, false, '2026-11-13 22:15:00'),
    (3, 2, 8,  5, 3,  true,  '2026-11-14 08:20:00');

-- ===== LAB 03 · champion_item =====      (polecane przedmioty; item_id: 1 Doran's Blade, 2 Infinity Edge, 3 Rabadon's, 4 Health Potion)
insert into champion_item (champion_id, item_id) values
    (1, 3),
    (2, 1),
    (3, 1),
    (3, 2),
    (4, 4),
    (5, 4);
