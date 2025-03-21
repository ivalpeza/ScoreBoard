# Live Football World Cup Scoreboard
Ova Java biblioteka omogućava praćenje nogometnih utakmica u stvarnom vremenu, uključujući pokretanje utakmica, ažuriranje rezultata, završavanje utakmica i dobivanje sažetka utakmica u tijeku.

Funkcionalnosti:
1. Pokretanje nove utakmice 
   Omogućava započinjanje nove utakmice između domaćeg i gostujućeg tima s početnim rezultatom 0 – 0.
2. Ažuriranje rezultata utakmice 
   Omogućava ažuriranje rezultata za domaći i gostujući tim.
3. Završavanje utakmice   
   Omogućava završavanje utakmice, čime se uklanja iz popisa utakmica u tijeku.
4. Dohvaćanje sortiranog sažetka utakmice   
   Omogućava dohvaćanje svih utakmica koje su u tijeku, sortirane prema ukupnom broju golova. Ako su ukupni golovi isti, utakmice će biti sortirane prema vremenu početka (novije utakmice dolaze prve).
## Strukturiranje projekta

- Match.java: Predstavlja jednu utakmicu.
- Scoreboard.java: Glavna logika za upravljanje utakmicama.
- ScoreboardTest.java: Testovi koji provjeravaju funkcionalnost.
- Main.java: Glavna klasa koja prikazuje osnovnu upotrebu.
