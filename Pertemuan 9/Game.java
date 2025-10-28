public class Game{
    private Parser parser;
    private Room currentRoom;

    public Game(){
        createRoom();
        parser = new Parser();
    }

    private void createRoom(){
        Room outside, theater, pub, lab, office;
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        outside.setExits(null, theater, lab, pub);
        theater.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);
        currentRoom = outside;
    }

    private void printWelcome(){
        System.out.println();
        System.out.println("Welcome to Adventure!");
        System.out.println("Adventure is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.println("Exits: ");
        if(currentRoom.northExit != null){
            System.out.println("north");
        }
        if(currentRoom.eastExit != null){
            System.out.println("east");
        }
        if(currentRoom.southExit != null){
            System.out.println("south");            
        }
        if(currentRoom.westExit != null){
            System.out.println("west");
        }
    }

    private void printHelp(){
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("[go <direction>] - [quit] - [help]");
    }

    private boolean quit(Command command){
        if(command.hasSecondWord()){
            System.out.println("Quit what?");
            return false;
        }
        return true;
    }

    private void goRoom(Command command){
        if(!command.hasSecondWord()){
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = null;
        if(direction.equals("north")){
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")){
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")){
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")){
            nextRoom = currentRoom.westExit;
        }
        if(nextRoom == null){
            System.out.println("There is no door!");
        }
        else{
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            System.out.println("Exits:");
            if(currentRoom.northExit != null){
               System.out.println("north"); 
            }   
            if(currentRoom.eastExit != null){
                System.out.println("east");
            }
            if(currentRoom.southExit != null){
                System.out.println("south");
            }
            if(currentRoom.westExit != null){
                System.out.println("west");
            }
            System.out.println();
        }
    }
    
    private boolean processCommand(Command command){
        boolean wantToQuit = false;
        if(command.isUnknown()){
            System.out.println("I don't know what you mean...");
            return false;
        }
        String commandWord = command.getCommandWord();
        if(commandWord.equals("help")) printHelp();
        else if(commandWord.equals("go")) goRoom(command);
        else if(commandWord.equals("quit")) wantToQuit = quit(command);
        return wantToQuit;
    }

    public void play(){
        printWelcome();
        boolean finished = false;
        while(!finished){
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye!");
    }
}