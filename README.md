# Vorwort

Wer träumt nicht davon ein Programm zu haben mit dem man in Echtzeit alle Headlines von orf.at abrufen kann ohne die Seite selbst zu besuchen?
Das träumen hat ein Ende!


The Mighty Ducks präsentieren stolz den Mighty ORF Crawler!

# Funktionalitäten:

Über eine grafische Oberfläche kannst du auswählen was du ausgegeben haben willst:

- Abfrage ob du eh auf orf.at bist
- Main Headlines
- Main Headlines wie in der Mobile App
- Headlines der Spezialkategorien (COV, Inland, Ausland, Panorama, etc...)
- Ausgabe aller Links zu den Headlines
- Headlines rückwärts
- Mixed Up (Empfehlung des Hauses)



# Wie starte ich das Programm?

Da wir JavaFX verwendet haben, muss das Programm über View - Tool Windows - Gradle - Run ausgeführt werden.


# Aufbau des Programms

Webcrawler:
Mainmethode, hier wird der gesamte HTML Code von ORF.at abgerufen sowie die grafische Oberfläche initialisiert.

Headlines:
Verarbeitung des HTML Codes damit nur mehr die Headlines in Strings gespeichert werden.

WhatHappens:
Link ausgabe und Websiten Name ausgabe

ShitnGiggles:
Headlines werden von der Headlines übergeben und verunstaltet :)


Oberfläche:
Config File für die Buttons und der grafischen Oberfläche



# Schlusswort:
Wir wünschen dir mindestens genauso viel Spaß mit dem Crawler wie wir ihn hatten ihn zu programmieren :)
