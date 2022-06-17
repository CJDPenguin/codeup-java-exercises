import util.Input;

public class ServerNameGenerator {
    static Input input = new Input();
    static String[] adjs = {"decrepit", "single", "sulking", "drab", "broken", "jealous", "rusted", "fatigued", "robotic", "poor", "blue"};
    static String[] nouns = {"tiger", "teenager", "clown", "monkey", "farmer", "architect", "philosopher", "youngling", "alligator", "tower", "falcon"};

    static String randomElement(String[] array) {
        int random = (int) Math.floor(Math.random() * array.length);
        return array[random];
    }

    static public void serverName(boolean check) {
        if (check) {
            System.out.printf("Your server name is:\n\"%s - %s\"\n", randomElement(adjs), randomElement(nouns));
            serverName(input.yesNo(true));
        }
    }

    public static void main(String[] args) {
        System.out.println("Generate a server name?");
        serverName(input.yesNo());
        System.out.println("Really? Why'd you even start me then?");
    }
}
