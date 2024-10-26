//Descripción: Parcial de preguntas de Harry Potter.
//Autor: Enyelbert Anderson Panta Huaracha.
//Fecha creación: 17/10/2024
//Última modificación: 19/10/2024
package com.example.harry_potter

data class Preguntas(
    val pregunta: String,
    val opciones: List<String>,
    val respuestaCorrecta: Int
) {
    companion object {
        fun getPreguntas(): List<Preguntas> {
            return listOf(
                Preguntas(
                    "¿Cuál es el nombre del hechizo que Harry utiliza para conjurar un Patronus?",
                    listOf("Expelliarmus", "Expecto Patronum", "Lumos", "Stupefy"),
                    1
                ),
                Preguntas(
                    "¿Qué objeto mágico se utiliza para viajar en el tiempo en 'Harry Potter y el prisionero de Azkaban'?",
                    listOf("La capa de invisibilidad", "El giratiempo", "El espejo de Oesed", "El caldero de transformación"),
                    1
                ),
                Preguntas(
                    "¿Quién fue el primer profesor de Defensa Contra las Artes Oscuras de Harry en su primer año?",
                    listOf("Quirinus Quirrell", "Gilderoy Lockhart", "Remus Lupin", "Severus Snape"),
                    0
                ),
                Preguntas(
                    "¿Qué tipo de criatura es Dobby?",
                    listOf("Elfo doméstico", "Goblin", "Centauro", "Troll"),
                    0
                ),
                Preguntas(
                    "¿Cuál es el nombre de la varita que pertenece a Harry Potter?",
                    listOf("Varita de Saúco", "Varita de Olmo", "Varita de pino", "Varita de acebo"),
                    3
                ),
                Preguntas(
                    "¿Quién es el autor de 'Los cuentos de Beedle el Bardo'?",
                    listOf("Albus Dumbledore", "J.K. Rowling", "Gellert Grindelwald", "Salazar Slytherin"),
                    0
                ),
                Preguntas(
                    "¿Cuál es la relación entre Sirius Black y Harry Potter?",
                    listOf("Tío", "Padrino", "Hermano", "Primo"),
                    1
                ),
                Preguntas(
                    "¿Qué animal acompaña a Hermione Granger en sus aventuras?",
                    listOf("Un gato", "Una lechuza", "Un perro", "Un ratón"),
                    0
                ),
                Preguntas(
                    "¿Cuál es el nombre de la primera película de Harry Potter?",
                    listOf("Harry Potter y la cámara secreta", "Harry Potter y el prisionero de Azkaban", "Harry Potter y la piedra filosofal", "Harry Potter y las reliquias de la muerte"),
                    2
                ),
                Preguntas(
                    "¿Quién fue el verdadero fundador de la casa Slytherin?",
                    listOf("Godric Gryffindor", "Salazar Slytherin", "Helga Hufflepuff", "Rowena Ravenclaw"),
                    1
                )
            )
        }
    }
}
