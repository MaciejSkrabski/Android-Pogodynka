

# Dokumentacja do Projektu 1
Mobilne Interfejsy Multimedialne (Informatyka st. I sem. VI)
## Szybkie dane
1. **Nazwa projektu:** Pogodynka
2. **Autor:** Maciej Skrabski
3. **Narzędzia, skrypty i źródła zewnętrzne, które były wykorzystane:**
    - **IDE**: Android Studio 3.6.1 z językiem Kotlin w wersji 1.3.61
    - **repozytoria:** google(), jcenter()
    - **biblioteki i narzędzia:**
        - gson (deserializacjia json -> kotlin)
        https://github.com/google/gson.git
        - androidx
        - Material Components for Android
        https://material.io/develop/android/docs/getting-started/
        - Picasso v2.71828 (obrazy wczytywane z sieci)
        https://square.github.io/picasso/ 
    - **API**: https://openweathermap.org/current
    - **ikony pogody:**
    https://openweathermap.org/weather-conditions
    - **inne źródła:**
        - codelabs z zakresu Material Components, 101, 102, 103, 104, 111.


## Opis
*Pogodynka* to aplikacja na smartfony z systemem Android. Wyświetla aktualne warunki pogodowe w wybranym mieście. Stworzona zgodnie z założeniami *Material Design*.

## Działanie
Po uruchomieniu

zawiera opis problemów, na jakie napotkał autor w trakcie realizacji projektów;
## Najważniejsza część projektu
Z racji samego charakteru przedmiotu, najważniejszy jest *Material Design*.

## Opinia własna autora nt. projektu
Zadanie przypomniało mi, że rzeczy które są proste wszędzie indziej, w androidzie takimi nie są. Zwykłe obsłużenie zapytania do API nie powinno przysparzać nikomu większych problemów. Jednak Android, przez wymuszanie wielowątkowości gdzie nie jest to potrzebne (bo aplikacja poza wyświetleniem danych z internetu nic nie robi - więc jeśli wątek odpowiadający za połączenie nie zakończy pomyślnie swojego działania, to aplikacja i tak nie ma nic do roboty) potrafi uprzykrzyć nawet to.
Z rzeczy możliwych do poprawy - oprócz wielu TextView mogłem napisać RecyclerView wczytujące karty z nagłówkiem i odpowiedzią API. Mniej formatowania xml.
