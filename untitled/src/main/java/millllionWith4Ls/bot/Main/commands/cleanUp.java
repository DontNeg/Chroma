package millllionWith4Ls.bot.Main.commands;

public class cleanUp {
    cleanUp(){}
    public static String color(String textOption,String color){
        String reply;
        switch(color.toLowerCase()){
            case "yellow" -> reply = "```fix\n" + textOption + "\n```";
            case "cyan" -> reply = "```yaml\n" + textOption + "\n```";
            case "red" -> reply = "```diff\n-" + textOption + "\n```";
            case "green" -> reply = "```diff\n+" + textOption + "\n```";
            case "blue" -> reply = "```ini\n[" + textOption + "\n```";
            case "grey" -> reply = "```brainfuck\n" + textOption + "\n```";
            case "orange" -> reply = "```css\n[" + textOption + "]\n```";
            default -> reply = "invalid color";
        }
        return reply;
    }
    private static String applyMD(final String msg, final String modifier) {
        return  switch (modifier.toLowerCase()) {
            case "bold" -> "**" + msg + "**";
            case "italic" -> "*" + msg + "*";
            case "strike" -> "~~" + msg + "~~";
            case "under" -> "__" + msg + "__";
            default -> msg;
        };
    }
    public static String modify(String base,  final String... modifiers) {
        for (String modifier: modifiers)
            base = applyMD(base, modifier);
        return base;
    }
}
