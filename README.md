# BURGUER DRINK MACHINE

## Objetivo:
Programa funcional para servir bebidas.

---

### Caracteristicas:
Poder añadir mas tipos de bebidas sin necesidad de tocar el codigo.
Al pulsar sobre una bebida (Un Buffered reader con un system.in).

---

Maquina de bebidas frias y bebidas calientes usando reflexion (se 
podrian añadir nuevas maquinas creando simplemente una clase).
Añadir maquina de hielo para comprobar que todo funciona correctamente.

Cada maquina lee su propio fichero, que es de donde saca las bebidas 
a servir.

---
Cada fichero lleva la siguiente estructura:

name;price;desc <br>
name;price;desc <br>
name;price;desc
---
Menú que liste las máquinas. Poder elegir la maquina y mas tarde la 
bebida, las cuales serán listadas al elegir la maquina (a excepcion de
las maquinas que solo tengan una única opcion, que te pedirá que elijas
si continuar o cancelar)

---


Se me irán ocurriendo mas cosas, pero eso es lo basico.

---


## ESTRUCTURA
- .app
  - .model
    - .interfaces
      - Iface.java
      - Iface.java
    - .machines
      - Machine.java
      - Machine.java
    - .drinks
      - Drink.java
  - .view
  - .controller
- Main.java

---

### INTERFACES

#### IMachine
void pay(int amount)
Drink chooseDrink(int drinkId)
Drink prepare(Drink drink)

---

### IDrink
String prepare()


## HITOS
Ya se nos irán ocurriendo...
<!--✅-->
- ☑ 
