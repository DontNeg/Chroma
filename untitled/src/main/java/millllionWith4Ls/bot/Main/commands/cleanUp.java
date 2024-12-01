package millllionWith4Ls.bot.Main.commands;

public class cleanUp {
    cleanUp(){}
    public static String getMessage(String bgColor, String color, String text){
        return "```ansi\n\u001b[" + backgroundColor(bgColor) + ";" + mainColor(color) + "m" + text + "\n```";
    }
    public static int backgroundColor(String backgroundColor){
        return switch(backgroundColor.toLowerCase()){
            case "dark blue" -> 40;
            case "orange" -> 41;
            case "dark gray" -> 43;
            case "gray" -> 44;
            case "purple" -> 45;
            case "light gray" -> 46;
            case "white" -> 47;
            default -> 0;
        };
    }
    public static int mainColor(String color){
        return switch(color.toLowerCase()){
            case "gray" -> 30;
            case "red" -> 31;
            case "green" -> 32;
            case "orange" -> 33;
            case "blue" -> 34;
            case "pink" -> 35;
            case "cyan" -> 36;
            case "white" -> 37;
            default -> 0;
        };
    }
    private static String mainModifier(String msg, String modifier) {
        return switch(modifier.toLowerCase()) {
            case "bold" -> "**" + msg + "**";
            case "italic" -> "*" + msg + "*";
            case "strikethrough" -> "~~" + msg + "~~";
            case "underline" -> "__" + msg + "__";
            default -> msg;
        };
    }
    public static String modify(String msg, String... modifiers) {
        StringBuilder mods = new StringBuilder();
        for (String modifier: modifiers){
            if(!mods.toString().contains(modifier)){
                msg = mainModifier(msg, modifier);
            }
            mods.append(modifier);
        }
        return msg;
    }
    public static String header(String msg, String size){
        String updatedSize = switch(size){
            case "large" -> "#";
            case "medium" -> "##";
            case "small" -> "###";
            default -> "";
        };
        return updatedSize + " " + msg;
    }
}
