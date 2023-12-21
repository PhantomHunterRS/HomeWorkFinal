import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<NoteBook> noteBooks = initsList();
        Scanner sc = new Scanner(System.in);
        Map<String,String> chooseSelect = new HashMap<>();
        boolean circle = true;
        while (circle){
            System.out.println("Select the notebook set:");
            System.out.println("press 1. RAM");
            System.out.println("press 2. Volume SSD M2");
            System.out.println("press 3. Operation system");
            System.out.println("press 4. Color");
            System.out.println("press 5. Search notebook ...");
            System.out.println();
            int choose = sc.nextInt();
            switch (choose){
                case 1:
                    System.out.println("Enter the desired amount of RAM in multiples 8");
                    int ram = sc.nextInt();
                    chooseSelect.put("RAM",Integer.toString((ram/8 ==0)?8:8*(ram/8)));
                    break;
                case 2:
                    System.out.println("Enter the desired amount of SSD M2");
                    int ssd = sc.nextInt();
                    chooseSelect.put("SSD",Integer.toString(ssd));
                    break;
                case 3:
                    System.out.println("Enter the operation system");
                    System.out.println(OSystem.printedNumbers());
                    int os = sc.nextInt();
                    chooseSelect.put("OS",OSystem.chooseOS(os));
                    break;
                case 4:
                    System.out.println("Enter the Colors notebook");
                    System.out.println(Colors.printedNumbers());
                    int colors = sc.nextInt();
                    chooseSelect.put("Color",Colors.chooseColors(colors));
                    break;
                case 5:
                    System.out.println("I recommend :");
                    searchNotebook(noteBooks,chooseSelect);
                    // не смог написать в одну строчку  stream вынес в отдельный метод
                    // не понял как записать вот это в Лямбда выражение
                    //if (chooseSet.get("RAM") != null){
                    //   stream =  stream.filter(x -> x.getRam() == Integer.parseInt(chooseSet.get("RAM")));
                    //}
                    //
                    //    noteBooks.stream().filter(x ->((chooseSelect.get("RAM")!= null) && x.getRam() == Integer.parseInt(chooseSelect.get("RAM"))))
                    //           .filter(y -> ((chooseSelect.get("SSD") != null) && y.getSsd() == Integer.parseInt(chooseSelect.get("SSD"))))
                    //           .forEach(System.out::println);
                    circle = false;
                    System.out.println("|-------------Price---List---Notebooks---All----|");
                    printed(noteBooks);
                        break;
                default:
                    circle = false;
                    break;
            }
        }
        System.out.println("Select the notebook set: ");
        System.out.println(chooseSelect);
    }
    public static void searchNotebook(List<NoteBook> noteBookList, Map<String,String> chooseSet){
        Stream<NoteBook> stream = noteBookList.stream();
        if (chooseSet.get("RAM") != null){
            stream =  stream.filter(x -> x.getRam() == Integer.parseInt(chooseSet.get("RAM")));
            }
        if (chooseSet.get("SSD") != null){
            stream = stream.filter(x -> x.getSsd() == Integer.parseInt(chooseSet.get("SSD")));
        }
        if (chooseSet.get("OS") != null){
            stream = stream.filter(x -> x.getOperSyst().equals(chooseSet.get("OS")));
        }
        if (chooseSet.get("Color") != null){
            stream = stream.filter(x -> x.getOperSyst().equals(chooseSet.get("Color")));
        }
        stream.forEach(System.out::println);
    }
    public static List<NoteBook> initsList(){
        List<NoteBook> noteBookList = new ArrayList<>();
        noteBookList.add(new NoteBook(4,128,OSystem.chooseOS(new Random().nextInt(5)+1),Colors.chooseColors(new Random().nextInt(5)+1)));
        noteBookList.add(new NoteBook(12,500,OSystem.chooseOS(new Random().nextInt(5)+1),Colors.chooseColors(new Random().nextInt(5)+1)));
        noteBookList.add(new NoteBook(16,400,OSystem.chooseOS(new Random().nextInt(5)+1),Colors.chooseColors(new Random().nextInt(5)+1)));
        noteBookList.add(new NoteBook(28,128,OSystem.chooseOS(new Random().nextInt(5)+1),Colors.chooseColors(new Random().nextInt(5)+1)));
        noteBookList.add(new NoteBook(10,1024,OSystem.chooseOS(new Random().nextInt(5)+1),Colors.chooseColors(new Random().nextInt(5)+1)));
        noteBookList.add(new NoteBook(15,2048,OSystem.chooseOS(new Random().nextInt(5)+1),Colors.chooseColors(new Random().nextInt(5)+1)));
        noteBookList.add(new NoteBook(20,500,OSystem.chooseOS(new Random().nextInt(5)+1),Colors.chooseColors(new Random().nextInt(5)+1)));
        noteBookList.add(new NoteBook(8,256,OSystem.chooseOS(new Random().nextInt(5)+1),Colors.chooseColors(new Random().nextInt(5)+1)));
        noteBookList.add(new NoteBook(32,1024,OSystem.chooseOS(new Random().nextInt(5)+1),Colors.chooseColors(new Random().nextInt(5)+1)));
        return noteBookList;
    }
    public enum OSystem {
        DOS_6_22,win3_11,Win11,Win10,withOut_OS;
        public static String printedNumbers() {
            return new StringBuilder("1 - " + OSystem.DOS_6_22 + "\n"
                    + "2 - " + OSystem.win3_11 + "\n"
                    + "3 - " + OSystem.Win10 + "\n"
                    + "4 - " + OSystem.Win11 + "\n"
                    + "5 - " + OSystem.withOut_OS).toString();
        }
        public static String chooseOS(int choose){
            switch (choose){
                case 1 :
                    return "" + OSystem.DOS_6_22;
                case 2 :
                    return "" + OSystem.win3_11;
                case 3 :
                    return "" + OSystem.Win10;
                case 4 :
                    return "" + OSystem.Win11;
                case 5 :
                    return "" + OSystem.withOut_OS;
                default:
                    return "" + OSystem.withOut_OS;
            }
        }
    }
    public enum Colors {
        Black,White,Grey,Blue,Red;
        public static String printedNumbers() {
            return new StringBuilder("1 - " + Colors.Black + "\n"
                    + "2 - " + Colors.White + "\n"
                    + "3 - " + Colors.Grey + "\n"
                    + "4 - " + Colors.Blue + "\n"
                    + "5 - " + Colors.Red).toString();
        }
        public static String chooseColors(int choose){
            switch (choose){
                case 1 :
                    return "" + Colors.Black;
                case 2 :
                    return "" + Colors.White;
                case 3 :
                    return "" + Colors.Grey;
                case 4 :
                    return "" + Colors.Blue;
                case 5 :
                    return "" + Colors.Red;
                default:
                    return "";
            }
        }
    }
    public static void printed(List<NoteBook> noteBookList){
        for (NoteBook x: noteBookList) {
            System.out.println(x);
        }
    }

}
