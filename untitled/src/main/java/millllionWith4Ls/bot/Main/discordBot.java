package millllionWith4Ls.bot.Main;

import io.github.cdimascio.dotenv.Dotenv;
import millllionWith4Ls.bot.Main.commands.commandManager;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class discordBot {
    public discordBot() {}
    public static void main(String[] args) {
        Dotenv config = Dotenv.configure().load();
        String token = config.get("TOKEN");
        JDABuilder builder = JDABuilder.createDefault(token)
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.listening("your commands"));
        builder.build().addEventListener(new commandManager());
    }
    //.enableIntents(GatewayIntent.MESSAGE_CONTENT)
}
