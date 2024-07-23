# 1.Theoretische Analyse:

## Erstelle eine umfassende Übersicht zu Vererbung und Interfaces**:
       
1 - Beschreibe die Definition und die Hauptmerkmale von Vererbung und Interfaces.

- In Java bezeichnet der Begriff „Vererbung“ (auf Deutsch „Vererbung“) ein zentrales Konzept der objektorientierten Programmierung, bei dem eine Klasse (die sogenannte „Unterklasse“ oder „abgeleitete Klasse“) von einer anderen Klasse (der „Oberklasse“ oder „Basis-Klasse“) erbt. Dies ermöglicht der Unterklasse, die Attribute und Methoden der Oberklasse zu übernehmen und zusätzlich eigene Attribute und Methoden hinzuzufügen oder bestehende Methoden zu überschreiben. 
- In Java bezeichnet der Begriff „Interface“ (auf Deutsch „Schnittstelle“) ein spezielles Konstrukt, das eine Sammlung von abstrakten Methoden definiert, die von Klassen implementiert werden müssen. Ein Interface legt fest, welche Methoden eine implementierende Klasse bereitstellen muss, ohne die konkrete Implementierung dieser Methoden vorzuschreiben. Es dient als Vertrag, den Klassen einhalten müssen.

2 - Erkläre die Unterschiede und Gemeinsamkeiten zwischen diesen beiden Konzepten.

Unterschiede:
- Zweck: Mit vererbung die abgeleitete Klasse (Unterklasse) erbt Attribute und Methoden von der Basis-Klasse (Oberklasse). Ein Interface dient dazu, eine Sammlung von Methoden zu definieren, die von beliebigen Klassen implementiert werden können.
- Implementierung: Eine Klasse kann nur von einer anderen Klasse erben. Eine Klasse kann mehrere Interfaces implementieren.
- Methoden: Mit Vererbung die Methoden der Oberklasse können von der Unterklasse überschrieben werden. Interfaces definieren nur Methodensignaturen ohne Implementierung. Die konkrete Implementierung der Methoden erfolgt in den Klassen.

Gemeinsamkeiten:
- Wiederverwendbarkeit
- Polymorphismus: Sowohl Vererbung als auch Interfaces unterstützen den Polymorphismus, bei dem Objekte unterschiedlichen Typs über eine gemeinsame Schnittstelle angesprochen werden können.


### 2. Praktische Anwendung und Reflexion:
1 - **Erkläre, wann welches Konzept am besten verwendet wird**:
Unter welchen Umständen sollte Vererbung genutzt werden ?
- Vererbung ist am besten geeignet, wenn es eine klare Hierarchie oder eine „ist-ein“-Beziehung zwischen Klassen gibt. Das bedeutet, dass eine Klasse von einer anderen Klasse ableitet und deren Eigenschaften und Methoden übernehmen möchte.

Wann sind Interfaces die bessere Wahl? 
- Interfaces sind die bessere Wahl, wenn man Flexibilität in Bezug auf die Implementierung und die Möglichkeit zur Kombination unterschiedlicher Funktionalitäten benötigt.


