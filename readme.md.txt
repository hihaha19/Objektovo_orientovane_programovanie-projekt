BALÍK ZÁKAZNÍK
Z abstraktnej triedy Zákazník dedí:
1. Živnostník
2. Sro, a z tejto Sro dedí Akciová spoločnosť, takže hierarchia vyzerá takto: Zákazník - Sro - Akciová spoločnosť

Abstraktná trieda Zákazník obsahuje aj abstraktnú metódu vypíš názov, ktorá sa použije vo všetkých triedach, ktoré
dedia zo Zákazníka. Pri s.r.o. bude vo formáte, že sa vypíše do konzoly:
Názov s.r.o. je ...... (nejaký názov).

V abstraktnej triede Zákazník sa nachádza agregácia. Táto trieda obsahuje triedu Adresa.

BALÍK ZAMESTNANEC
V balíku zamestnanec sa nachádza riaditeľ, ktorý je vytvorený návrhovým vzorom singleton.

Je tu nasledujúca hierarchia dedenia:
abstraktná trieda Zamestnanec - JuniorÚčtovník - Účtovník

Agregácia sa nachádza v triede Účtovník. Táto trieda obsahuje triedu Počítač.

Trieda Auto implementuje interface s názvom AutoInterface.

Abstraktná trieda Zamestnanec obsahuje abstraktnú metódu ZobrazUdaje, ktorá vypíše meno, priezvisko... o určitom zamestnancovi

Pridanie kompozície v novej triede Budova, ktorá obsahuje triedy Horná sála a Dolná sála