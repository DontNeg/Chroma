package millllionWith4Ls.bot.Main.commands;

public class cleanUp {
    cleanUp(){}
    public static String getMessage(String bgColor, String color, String text){
        return "```ansi\n\u001b[" + backgroundColor(bgColor) + ";" + mainColor(color) + "m" + text + "\n```";
    }
    public static int backgroundColor(String backgroundColor){
        int rBackgroundColor;
        switch(backgroundColor.toLowerCase()){
            case "dark blue" -> rBackgroundColor = 40;
            case "orange" -> rBackgroundColor = 41;
            case "dark gray" -> rBackgroundColor = 43;
            case "gray" -> rBackgroundColor = 44;
            case "purple" -> rBackgroundColor = 45;
            case "light gray" -> rBackgroundColor = 46;
            case "white" -> rBackgroundColor =47;
            default -> rBackgroundColor = 0;
        }
        return rBackgroundColor;
    }
    public static int mainColor(String color){
        int rColor;
        switch(color.toLowerCase()){
            case "gray" -> rColor = 30;
            case "red" -> rColor = 31;
            case "green" -> rColor = 32;
            case "orange" -> rColor = 33;
            case "blue" -> rColor = 34;
            case "pink" -> rColor = 35;
            case "cyan" -> rColor =36;
            case "white" -> rColor =37;
            default -> rColor = 0;
        }
        return rColor;
    }
    private static String mainModifier(final String msg, final String modifier) {
        return switch (modifier.toLowerCase()) {
            case "bold" -> "**" + msg + "**";
            case "italic" -> "*" + msg + "*";
            case "strike" -> "~~" + msg + "~~";
            case "under" -> "__" + msg + "__";
            default -> msg;
        };
    }
    public static String modify(String base,  final String... modifiers) {
        for (String modifier: modifiers)
            base = mainModifier(base, modifier);
        return base;
    }
}
