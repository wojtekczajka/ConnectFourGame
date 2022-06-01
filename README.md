# ConnectFourGame

Connect Four Game to gra dla 2 graczy napisana w Javie.

## Technologies used

Projekt był napisany przy użyciu klasy Servlet.

Pozwala ona na wyświetlenie gry na stronie internetowej.


W celu testowania funkcji została użyta klasa JUnit.

## Zasady gry
Gra rozpoczyna się od pustej planszy, a gracze na zmianę umieszczają na niej kolorowe dyski. 

Podczas każdej tury gracz może dołożyć kolejny dysk z góry lub, jeśli ma jakiekolwiek dyski swojego koloru w dolnym rzędzie, 
usunąć (lub "wyskoczyć") dysk swojego koloru z dołu. Usunięcie dysku z dołu powoduje, 
że każdy znajdujący się nad nim dysk zostaje przesunięty o jedno miejsce w dół, 
co zmienia ich relacje z resztą planszy i zmienia możliwości połączenia. 

Pierwszy gracz, który połączy cztery swoje dyski poziomo, pionowo lub po przekątnej, wygrywa grę.


https://en.wikipedia.org/wiki/Connect_Four

## Backlog
Wymagania produktu:

Zapewnienie funkcjonalności:
  - Gra z CPU
  - Gra z innym graczem lokalnie
  - Gra z innym graczem zdalnie


Połączenie klient-serwer(http)

Prototyp planszy do gry i żetonów

Możliwość stawiania żetonów

Wykrycie przez grę wygranej użytkownika

Stworzenie finalnych modeli planszy i żetonów

## Diagram UML
![Diagram](https://user-images.githubusercontent.com/71210407/171406590-cbb3d5aa-a434-47bf-b40d-48dae31d3dc6.jpg)

## Gra

W grę można zagrać na stronie:
http://connect-four-gm.herokuapp.com/start

![The game board](https://user-images.githubusercontent.com/71210407/170267969-dfea623e-3586-4e40-8267-f9dcfa3d2280.PNG)


