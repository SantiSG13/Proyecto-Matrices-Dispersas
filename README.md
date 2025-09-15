# Proyecto de Matrices Dispersas en Java

Este es mi proyecto para la materia algoritmos y programación 3 donde el objetivo principal es trabajar con matrices dispersas usando 3 formas diferentes de representarlas en Java.

## 📌 ¿Qué son las matrices dispersas?

Las matrices dispersas son matrices que contienen una gran cantidad de elementos con valor cero. En lugar de almacenar todos los elementos (incluyendo los ceros), usamos representaciones especiales que solo guardan los elementos no nulos, optimizando así el uso de memoria y las operaciones.

## 📌 Estructura del proyecto

* **Principal.java** → Controla el menú principal, genera la matriz dispersa original aleatoriamente (40% de datos no nulos) y maneja la selección de formas de representación.
* **Tripleta.java** → Implementa la representación en forma de tripleta, donde cada elemento no nulo se almacena como (fila, columna, valor).
* **Forma1.java** → *[Pendiente de implementar]* - Otra forma de representación de matrices dispersas.
* **Forma3.java** → *[Pendiente de implementar]* - Tercera forma de representación de matrices dispersas.

## 🔹 Flujo general

1. El usuario ingresa las dimensiones de la matriz (filas y columnas).
2. El programa genera automáticamente una matriz dispersa donde el 40% de las posiciones contienen valores aleatorios entre -20 y 20 (excluyendo el 0).
3. El usuario puede seleccionar entre las diferentes formas de representación disponibles.
4. Según la elección, la matriz original se convierte a la forma seleccionada para realizar las operaciones correspondientes.

## 🔹 Formas de representación

### ✅ Tripleta (Implementada)
La forma tripleta almacena la información en una matriz de la siguiente manera:
- **Fila 0**: `[número_filas_original, número_columnas_original, cantidad_datos_no_nulos]`
- **Filas 1 en adelante**: `[fila, columna, valor]` para cada elemento no nulo

### 🚧 Forma 1 (En desarrollo)
*Descripción pendiente de implementación*

### 🚧 Forma 3 (En desarrollo)
*Descripción pendiente de implementación*

## 🔹 Operaciones implementadas

### Para Tripleta:
- ✅ **Mostrar forma**: Visualiza la representación interna de la tripleta
- ✅ **Sumar filas**: Calcula la suma de elementos por cada fila de la matriz original
- ✅ **Sumar columnas**: Calcula la suma de elementos por cada columna de la matriz original
- 🚧 **Insertar un dato**: *Pendiente de implementar*
- 🚧 **Eliminar un dato**: *Pendiente de implementar*
- 🚧 **Eliminar una posición**: *Pendiente de implementar*
- 🚧 **Sumar dos matrices**: *Pendiente de implementar*
- 🚧 **Multiplicar dos matrices**: *Pendiente de implementar*

### Para Forma 1 y Forma 3:
*Operaciones pendientes de definir según la implementación*

## 🔹 Características técnicas

- **Generación automática**: Las matrices se generan aleatoriamente con 40% de densidad (elementos no nulos)
- **Interfaz gráfica**: Utiliza `JOptionPane` para la interacción con el usuario
- **Visualización**: Tanto en consola como en ventanas emergentes
- **Validación**: Control de menús y opciones inválidas

## 🔹 Cómo usar el programa

1. Ejecutar `Principal.java`
2. Ingresar el número de filas y columnas deseadas
3. El programa mostrará la matriz dispersa generada
4. Seleccionar la forma de representación (actualmente solo Tripleta disponible)
5. Elegir la operación a realizar desde el submenú

## 🚧 Estado del desarrollo

- [x] Estructura base del proyecto
- [x] Generación de matrices dispersas aleatorias
- [x] Implementación completa de la forma Tripleta
- [x] Operaciones básicas de suma por filas y columnas
- [ ] Implementación de Forma 1
- [ ] Implementación de Forma 3
- [ ] Operaciones avanzadas (insertar, eliminar, operaciones entre matrices)
- [ ] Operaciones combinadas entre diferentes formas

## 🔹 Próximas funcionalidades

- Completar las operaciones faltantes para Tripleta
- Implementar Forma 1 y Forma 3 con sus respectivas operaciones
- Añadir operaciones para combinar diferentes formas de representación
- Mejorar la interfaz de usuario
- Añadir validaciones adicionales