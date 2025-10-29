# 🎯 Proyecto de Matrices Dispersas en Java

> Proyecto académico para la materia **Algoritmos y Programación 3**  
> Implementación y manipulación de matrices dispersas usando 3 formas diferentes de representación en Java

---

## 💡 ¿Qué son las matrices dispersas?

Las **matrices dispersas** (sparse matrices) son matrices que contienen una gran cantidad de elementos con valor cero. En aplicaciones reales, estas matrices pueden ser extremadamente grandes, haciendo ineficiente el almacenamiento tradicional.

### Ventajas de usar representaciones especiales:
- 🚀 **Optimización de memoria**: Solo se almacenan los elementos no nulos
- ⚡ **Mayor eficiencia**: Las operaciones son más rápidas al ignorar ceros
- 📊 **Escalabilidad**: Permite trabajar con matrices de grandes dimensiones

### Ejemplo:
```
Matriz original (8x8):          Elementos no nulos: solo 6
[ 0  0  3  0  0  0  0  0 ]      Densidad: 9.4%
[ 0  0  0  0  5  0  0  0 ]      Ahorro de memoria: ~90%
[ 0  7  0  0  0  0  0  0 ]
[ 9  0  0  0  0  0  0  0 ]
[ 0  0  0  0  0  0  2  0 ]
[ 0  0  0  0  0  0  0  0 ]
[ 0  0  0  0  0  0  0  0 ]
[ 0  0  0  0  0  4  0  0 ]
```

---

## 📁 Estructura del proyecto

```
Proyecto-Matrices-Dispersas-main/
│
├── src/
│   └── matrices/
│       ├── Principal.java    → Controlador principal y menú de navegación
│       ├── Tripleta.java     → Implementación forma Tripleta
│       ├── Forma1.java       → Implementación forma 1 (vector de vectores)
│       ├── Forma2.java       → Implementación forma 2 (lista enlazada)
│       └── Nodo.java         → Clase auxiliar para estructuras enlazadas
│
├── nbproject/                → Configuración de NetBeans
├── build.xml                 → Script de construcción Ant
└── README.md                 → Este archivo
```

### Descripción de archivos clave:

| Archivo | Descripción |
|---------|-------------|
| **Principal.java** | Punto de entrada del programa. Genera matrices dispersas aleatorias (40% densidad) y gestiona el menú principal para seleccionar formas y operaciones |
| **Tripleta.java** | Implementa la representación en forma de tripleta donde cada elemento no nulo se guarda como `(fila, columna, valor)` |
| **Forma1.java** | Implementa la representación mediante lista enlazada con nodos cabecera y enlaces ortogonales (ligaFila y ligaColumna). Incluye operaciones completas |
| **Forma2.java** | Implementa la representación mediante lista enlazada ortogonal simplificada sin nodos cabecera múltiples. Estructura más eficiente en memoria |
| **Nodo.java** | Clase auxiliar que define la estructura de nodos para listas enlazadas |

<div align="center">

</div>
