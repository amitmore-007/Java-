import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance){
    @Override
    public String toString() {
        return String.format(" %s (%d)", name,distance);
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {


        var placesToVisit = new LinkedList<Place>();
        Place paris = new Place("Paris",10002);
        addPlace(placesToVisit,paris);
        addPlace(placesToVisit, new Place("Finland",7500));
        addPlace(placesToVisit, new Place("Italy",5500));
        addPlace(placesToVisit, new Place("India",4500));
        addPlace(placesToVisit, new Place("UK",9500));
        addPlace(placesToVisit, new Place("Switz",10500));
        placesToVisit.addFirst(new Place("Sydney",0));

        System.out.println(placesToVisit);
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;
        printActions();

        while (!quitLoop) {
            System.out.println("Enter the value :");
            String menu = scanner.nextLine().toUpperCase();

            switch (menu){
                case "F" : {
                    forward(placesToVisit);
                    break;
                }
                case "B" : {
                    backward(placesToVisit);
                    break;
                }
                case "M" : {
                    printActions();
                    break;
                }
                case "L" : {
                    System.out.println(placesToVisit);
                    break;
                }
                default : {
                    quitLoop = true;
                    break;
                }

            };
        }


    }
    private static void addPlace(LinkedList<Place> list, Place place){
        if(list.contains(place)){
            System.out.println("Found a duplicate : " + place);
            return;
        }

        for(Place p : list){
            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println("Found duplicate : " + place);
                return;
            }
        }
        int matchedIndex = 0 ;
        for(var placeList : list){
            if(place.distance() < placeList.distance()){
                list.add(matchedIndex,place);
                return;

            }
            matchedIndex++;

        }
        list.add(place);

    }

    public static void forward(LinkedList<Place> list){
        System.out.println("Trip starts at " + list.getFirst());
        var iterator = list.listIterator();
        while (iterator.hasNext()){

            System.out.println(iterator.next());


        }
        System.out.println("Trip ends at " + list.getLast());

    }
    public static void backward(LinkedList<Place> list){
        var iterator = list.listIterator(6);

        while (iterator.hasPrevious()){

            System.out.println(iterator.previous());


        }

    }

    private static void printActions(){
        String textBlock = """
                Available actions(select word or letter):
                (F) Forward
                (B) Backward
                (L) List Places
                (M) Menu
                (Q) Quit """;
        System.out.println(textBlock + " ");
    }
}