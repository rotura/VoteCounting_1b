#language: es
Característica: Página de aterrizaje 
  Escenario: Ir a la página de aterrizaje
    Cuando el cliente accede a /
    Entonces el cliente recibe el código 200
    Y el resultado contiene la cadena "Voting"