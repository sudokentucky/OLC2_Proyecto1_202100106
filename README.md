# OLC2_Proyecto1_202100106

## Proyecto: Intérprete de Lenguaje GoLight

Este proyecto consiste en la implementación de un intérprete funcional para el lenguaje de programación **GoLight**, desarrollado con **C#** y **ANTLR**, e integrado con una interfaz web construida en **React + TypeScript**. El lenguaje GoLight se inspira en la sintaxis de Go, con un diseño más reducido y orientado al aprendizaje de principios fundamentales de compiladores.

El sistema permite al usuario crear, editar y ejecutar archivos `.glt` desde un entorno visual amigable, generando reportes como la **tabla de símbolos**, **AST** y **errores léxicos, sintácticos y semánticos**, y desplegando los resultados directamente en la consola del sistema.

## Tabla de Contenido

- [OLC2\_Proyecto1\_202100106](#olc2_proyecto1_202100106)
  - [Proyecto: Intérprete de Lenguaje GoLight](#proyecto-intérprete-de-lenguaje-golight)
  - [Tabla de Contenido](#tabla-de-contenido)
  - [Competencias](#competencias)
    - [Competencia General](#competencia-general)
    - [Competencias Específicas](#competencias-específicas)
  - [Descripción General](#descripción-general)
  - [Componentes de la Interfaz](#componentes-de-la-interfaz)
    - [Editor](#editor)
    - [Funcionalidades](#funcionalidades)
    - [Herramientas](#herramientas)
    - [Reportes](#reportes)
    - [Consola](#consola)
  - [Flujo del Proyecto](#flujo-del-proyecto)
  - [Inicialización del Backend](#inicialización-del-backend)
    - [Configuración clave (`Program.cs`)](#configuración-clave-programcs)
    - [Controlador Principal: `Compile.cs`](#controlador-principal-compilecs)
  - [Estructura del Proyecto](#estructura-del-proyecto)
  - [Tecnologías Utilizadas](#tecnologías-utilizadas)
  - [Documentación Complementaria](#documentación-complementaria)
  - [Cómo Ejecutar el Proyecto](#cómo-ejecutar-el-proyecto)
    - [1. Clona el repositorio:](#1-clona-el-repositorio)
    - [2. Backend (C#):](#2-backend-c)
    - [3. Frontend (React):](#3-frontend-react)
    - [4. Accede en tu navegador:](#4-accede-en-tu-navegador)

## Competencias

### Competencia General

Capacidad para desarrollar un intérprete funcional aplicando principios de análisis léxico, sintáctico, semántico y generación de AST para la correcta interpretación del lenguaje GoLight.

### Competencias Específicas

- Implementación de analizadores léxicos y sintácticos con ANTLR en C#.
- Desarrollo de estructuras de datos apropiadas (tabla de símbolos, AST).
- Recorrido y evaluación semántica del AST.

## Descripción General

GoLight es un lenguaje didáctico que permite al estudiante explorar los fundamentos de los compiladores mediante la implementación de su propio intérprete. El flujo de la aplicación es el siguiente:

1. El usuario carga un archivo `.glt` o escribe código en el editor.
2. El código se envía al backend en C#, donde es analizado léxica, sintáctica y semánticamente.
3. Se genera el AST, la tabla de símbolos y un conjunto de errores, si los hay.
4. Los reportes y resultados son devueltos al frontend para visualización.

## Componentes de la Interfaz

### Editor

Permite escribir, abrir, guardar archivos `.glt`, visualizar la línea actual y trabajar con múltiples archivos.

### Funcionalidades

- Crear, abrir y guardar archivos `.glt`
- Ejecutar código con botón interactivo

### Herramientas

- Ejecución completa del código, con análisis y reporte automático.

### Reportes

- Reporte de errores (léxico, sintáctico, semántico)
- Reporte de tabla de símbolos
- Reporte gráfico del AST (en DOT)

### Consola

- Muestra resultado de ejecución, advertencias y errores.

## Flujo del Proyecto

1. Ingreso de código (.glt) desde la interfaz.
2. Análisis léxico y sintáctico con ANTLR.
3. Análisis semántico y verificación de tipos.
4. Recorrido del AST y ejecución.
5. Generación de reportes y resultado.
6. Visualización desde el frontend React.

## Inicialización del Backend

El backend está construido con **ASP.NET Core** y funciona como servidor de interpretación de código. Expone una API que recibe el código fuente, lo analiza usando ANTLR y devuelve:

- La salida del código (si es válida).
- La tabla de símbolos generada.
- La tabla de errores.
- El código DOT del AST para su visualización.

### Configuración clave (`Program.cs`)

```csharp
app.UseHttpsRedirection();
app.UseCors("AllowAll");
app.MapControllers();
app.Run();
```

### Controlador Principal: `Compile.cs`

El controlador `Compile` maneja las siguientes rutas:

- POST `/compile`: Recibe el código, lo analiza y devuelve errores, símbolos y resultados.
- GET `/compile/errors`: Devuelve los errores encontrados.
- GET `/compile/symbols`: Devuelve la tabla de símbolos generada.
- GET `/compile/generateDot`: Devuelve el AST en formato DOT para graficar.

## Estructura del Proyecto

```plain-text
Archivos de prueba/
├─ recursivas.gt

client/
├─ Analyzer/
│  ├─ Environment.cs
│  ├─ ErrorListener.cs
│  ├─ Symbol.cs
│  ├─ SymbolTable.cs
│  └─ Visitors/
│     ├─ Function.cs
│     ├─ Slice.cs
│     ├─ SliceOperations.cs
│     ├─ StructType.cs
│     ├─ Visitor.cs
│     ├─ VisitorArithmetics.cs
│     ├─ VisitorAssign.cs
│     ├─ VisitorDeclaration.cs
│     ├─ VisitorEmbeddedFunc.cs
│     ├─ VisitorExpressions.cs
│     ├─ VisitorFor.cs
│     ├─ VisitorForWhile.cs
│     ├─ VisitorFunction.cs
│     ├─ VisitorIdentifiers.cs
│     ├─ VisitorLiterals.cs
│     ├─ VisitorLogical.cs
│     ├─ VisitorPrint.cs
│     ├─ VisitorSlices.cs
│     ├─ VisitorStatements.cs
│     ├─ VisitorStructs.cs
│     ├─ VisitorTransfer.cs
│
├─ AST/
│  ├─ DOTgenerator.cs
│  ├─ VisitAST.cs
│  ├─ ASTnode.cs
│
├─ Controllers/
│  ├─ Compile
│
├─ grammar/
│  ├─ gramatica.tokens
│  ├─ gramatica.interp
│  ├─ gramaticaBaseListener.cs
│  ├─ gramaticaLexer.cs
│  ├─ gramaticaBaseVisitor.cs
│  ├─ gramaticaLexer.interp
│  ├─ gramaticaLexer.tokens
│  ├─ gramaticaListener.cs
│  ├─ gramaticaVisitor.cs
│  ├─ new_file
│  ├─ gramaticaParser.cs
│
├─ gramatica.g4
├─ gramatcia.txt
├─ Program.cs
├─ client.csproj

frontend/
├─ src/
│  ├─ assets/
│  ├─ components/
│  │  ├─ AST.tsx
│  │  ├─ CommandExecution.tsx
│  │  ├─ ErrorTable.tsx
│  │  ├─ FileInput.tsx
│  │  ├─ Navbar.tsx
│  │  ├─ SymbolTable.tsx
│  ├─ hooks/
│  │  ├─ useCommandExecution.tsx
│  │  ├─ useErrors.tsx
│  │  ├─ useGenerateDot.tsx
│  │  ├─ useLineCounter.tsx
│  │  ├─ useSymbolTable.tsx
│  ├─ interface/
│  │  ├─ FileInputsProps.tsx
│  │  ├─ Message.tsx
│  ├─ App.css
│  ├─ App.tsx
│  ├─ Index.css
│  ├─ main.tsx
│  ├─ vite-env.d.ts
├─ .gitignore
├─ eslint.config.js
├─ index.html
├─ package-lock.json
├─ package.json
├─ postcss.config.js
├─ README.md
├─ tailwind.config.js
├─ tsconfig.app.json
├─ tsconfig.json
├─ tsconfig.node.json
├─ vite.config.ts

.gitignore
OLC2_Proyecto1_202100106.sln
README.md
```

## Tecnologías Utilizadas

<p align="center">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/csharp/csharp-original.svg" alt="C#" width="50"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/dot-net/dot-net-original-wordmark.svg" alt=".NET" width="50"/>
  <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" viewBox="0 0 512 512">
    <path fill="black" d="M256 0C114.615 0 0 114.615 0 256s114.615 256 256 256s256-114.615 256-256S397.385 0 256 0m138.2 389.825c-5.613 2.509-14.055 3.692-19.931.754l-160.49-88.942l113.761.292l-70.955-158.787l-103.73 233.99c-5.48 12.993-17.64 18.347-31.73 13.618c-18.25-6.125-19.576-21.26-13.98-33.882L222.201 97.33l.068-.153c6.166-13.66 19.84-22.359 34.817-22.13a37.586 37.586 0 0 1 34.005 22.758L406.825 356.8c5.633 12.605-.02 27.39-12.626 33.024"/>
  </svg>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/react/react-original.svg" alt="React" width="50"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/typescript/typescript-original.svg" alt="TypeScript" width="50"/>
  <img src="https://www.vectorlogo.zone/logos/tailwindcss/tailwindcss-icon.svg" alt="TailwindCSS" width="50"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/linux/linux-original.svg" alt="Linux" width="50"/>
</p>

## Documentación Complementaria

- Gramática GoLight: definición de tokens, operadores y estructura del lenguaje.
- Manual Técnico: implementación del intérprete en C#, estructura de datos, visitantes.
- Manual de Usuario: uso del editor, generación de reportes, flujo general de ejecución.

## Cómo Ejecutar el Proyecto

### 1. Clona el repositorio:

```bash
git clone https://github.com/tuusuario/tu-repo.git
```

### 2. Backend (C#):

- Abre `OLC2_Proyecto1_202100106.sln` en Visual Studio.
- Restaura los paquetes y ejecuta el proyecto.

### 3. Frontend (React):

```bash
cd frontend
npm install
npm run dev
```

### 4. Accede en tu navegador:

```bash
http://localhost:5173
```
