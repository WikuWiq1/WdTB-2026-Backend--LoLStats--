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
insert into champion (name, title, role, release_date, health, mana, attack_damage, armor) values
    ('Ahri',    'the Nine-Tailed Fox',  'MID',     '2011-12-14', 590, 418,  53.00, 21.00),
    ('Garen',   'The Might of Demacia', 'TOP',     '2010-04-27', 690, null, 69.00, 38.00),
    ('Jinx',    'the Loose Cannon',     'ADC',     '2013-10-10', 630, 260,  59.00, 26.00),
    ('Thresh',  'the Chain Warden',     'SUPPORT', '2013-01-23', 620, 274,  56.00, 28.00),
    ('Lee Sin', 'the Blind Monk',       'JUNGLE',  '2011-04-01', 645, null, 69.00, 36.00);

-- ===== LAB 02 · item =====
insert into item (name, gold_cost, sell_value, description, purchasable) values
    ('Doran''s Blade',      450,  180,  'Przedmiot startowy: obrażenia i zdrowie.', true),
    ('Infinity Edge',       3400, 2380, 'Zwiększa obrażenia trafień krytycznych.',  true),
    ('Rabadon''s Deathcap', 3600, 2520, 'Duży bonus do mocy umiejętności.',         true),
    ('Health Potion',       50,   20,   'Odnawia zdrowie przez 15 sekund.',         true);

-- ===== LAB 02 · summoner =====
insert into summoner (game_name, tag_line, server, summoner_level, last_updated) values
    ('Faker',      'KR1',  'KR',   812, '2026-11-10 20:15:00'),
    ('Caps',       'EUW',  'EUW1', 654, '2026-11-12 18:40:00'),
    ('WroclawMid', 'EUNE', 'EUN1', 143, '2026-11-14 09:05:00');
