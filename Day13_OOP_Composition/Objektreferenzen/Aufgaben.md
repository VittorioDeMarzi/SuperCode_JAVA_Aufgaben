# a) Was gibt folgendes Codefragment aus ? Erkläre, warum die entsprechende Ausgabe zu Stande kommt.

    Position p1 = new Position(11, 21);
    Position p2 = new Position(11, 21);

    if (p1 == p2) {
            System.out.println("true");
    } else {
        System.out.println("false");
    }

* Gibt false zurück, weil mit == nicht der Inhalt, sondern die Speicheradressen überprüft werden, die in diesem Fall unterschiedlich sind.

# b) Was gibt folgendes Codefragment aus ? Erkläre, warum die entsprechende Ausgabe zu Stande kommt.

    Position p1 = new Position(0, 0);
    Position p2 = new Position(0, 0);
    p1 = p2;
    p1.x = 21;
    p2.y = 11;
    p2 = p1;
    System.out.println("p1 -> X: " + p2.x + ", Y: " + p2.y);

* p1 -> X: 21, Y: 11
Dank der Zeile p1 = p2 weisen wir beiden Objekten dieselbe Speicheradresse zu. Es ist, als ob wir uns auf dasselbe Objekt beziehen. Wenn wir also das eine ändern, ändern wir automatisch auch das andere.

# c) Was gibt folgendes Codefragment aus ? Erkläre, warum die entsprechende Ausgabe zu Stande kommt.
    Position p1 = new Position(3, 3);
    Position p2 = new Position(6, 6);
    Position p3 = p1;

    p1 = p2;
    p2 = new Position(9, 9);
    p3.y = 12;

    System.out.println("p1 -> X: " + p1.x + ", Y: " + p1.y);
    System.out.println("p2 -> X: " + p2.x + ", Y: " + p2.y);
    System.out.println("p3 -> X: " + p3.x + ", Y: " + p3.y);

* p1 -> X: 6, Y: 6
  p2 -> X: 9, Y: 9
  p3 -> X: 6, Y: 12

Mit p1 = p2; übernimmt p1 die Werte von p2.

Mit p2 = new Position(9, 9); definiere ich ein neues Objekt mit neuen Koordinaten.

Mit p3.y = 12; ändert sich die y-Koordinate von p3, aber nicht von p1, nachdem p1 = p2; ausgeführt wurde.