"# Cars" 

This project was developed as a training in OOP. 

--------------

For starting project is required:
- java-JDK
- java conf.


Úvod – motivácia
Téma môjho projektu bude naprogramovanie modelu autobazáru. V projekte budem uplatňovať princípy OOP.
Motivácia je aplikovať jednoduchý redakčný systém, na vybranú tému autobazáru. Dôvodom môjho výberu danej témy bola moja záľuba v autách/vozidlách a na druhej strane tiež veľa súvislosti a tiež závislosti ktoré sa vyskytujú v štruktúre autobazáru. Ako príklad môžem uviesť že každé vozidlo bude mať nejaké spoločné časti/vlastnosti – počet kolies, max. rýchlosť, výkon, majiteľ, počet najazdených kilometrov, rok výroby, cenu, značku...

Model (väzby)
Najabstraktnejšia časť programu bude vozidlo a autobazár ako taký. Pod vozidlom budú kategórie vozidiel, napríklad osobné autá, úžitkové autá, kamióny. Nasledovne vieme ísť ešte hlbšie a osobné autá rozdeliť na podkategórie, napríklad rodinné, SUV, hybridy, elektro autá...  Vlastnosti a funkcionalita bude kompozitovaná na základe priradenia ku rodičovskej kategórie. 
Príklad: Toyota Land cruiser –> SUV –> osobné auto –> vozidlo  

View
View programu bude jednoduché a reprezentované bude len jednoduchými výpismi v konzole programu. 

Kontrolér 
Kontrolér, ktorý bude pracovať s modelom bude pravdepodobne skonštruovaný zo vstupov konzoly programu. Nápad je, že užívateľ bude mať na výber n rôznych možností vstupov, v istej skrátene forme zápisu. Ako príklad možno uviesť číslice 0-n. Keď užívateľ zadá niektoré z daných čísel, spustí sa vopred definovaný proces inštrukcií/ postupov, priradený danému číslu príkazu. Tento proces môže byť x-krát iterovaný podľa vopred zadefinovanej logike príkazu.
Use case: Ak užívateľ zadá 1, čo modelovo predstavuje pridanie nového vozidla tak program začne viesť dialóg s užívateľom v podobe čítania vstupov od užívateľa až kým následne nevytvorí napríklad inzerát.  

Funkcionalita
Model autobazáru bude mať niekoľko funkcionalít – zoznam áut, filtrovanie, kúpa/ predaj/ mazanie vozidiel.. „Nice to have“ je mať prenájom vozidiel, bank account autobazáru, štatistické funkcionality. 
Využitie
Program môže byť využitý ako šablóna jednoduchého redakčného systému či už autobazáru ale aj inej organizačnej štruktúry.

Záver
Pri implementácií programu budem využívať viaceré techniky OOP. Kód sa budem snažiť robiť čo najviac generický a efektívny. Verím, že sa mi podarí urobiť vierohodnú kópiu jednoduchého systému autobazáru
