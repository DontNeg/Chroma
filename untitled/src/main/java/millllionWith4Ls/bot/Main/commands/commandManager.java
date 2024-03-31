package millllionWith4Ls.bot.Main.commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class commandManager extends ListenerAdapter{
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        String command = event.getName();
        switch(command.toLowerCase()){
            case "color" -> {
                OptionMapping colorOption = event.getOption("color");
                String textOption = Objects.requireNonNull(event.getOption("message")).getAsString();
                String color = Objects.requireNonNull(colorOption).getAsString();
                event.reply(cleanUp.color(textOption,color)).queue();
            }
            case "mod" ->{
                OptionMapping modOption = event.getOption("mod");
                String textOption = Objects.requireNonNull(event.getOption("message")).getAsString();
                String mod = Objects.requireNonNull(modOption).getAsString();
                event.reply(cleanUp.modify(textOption,mod)).queue();
            }
            case "modtwo" ->{
                OptionMapping modOptionTwo = event.getOption("modtwo");
                OptionMapping modOption = event.getOption("mod");
                String textOption = Objects.requireNonNull(event.getOption("message")).getAsString();
                String mod = Objects.requireNonNull(modOption).getAsString();
                String modtwo = Objects.requireNonNull(modOptionTwo).getAsString();
                event.reply(cleanUp.modify(textOption,modtwo,mod)).queue();
            }
            case "modthree" ->{
                OptionMapping modOptionTwo = event.getOption("modtwo");
                OptionMapping modOption = event.getOption("mod");
                OptionMapping modOptionThree = event.getOption("modthree");
                String textOption = Objects.requireNonNull(event.getOption("message")).getAsString();
                String mod = Objects.requireNonNull(modOption).getAsString();
                String modtwo = Objects.requireNonNull(modOptionTwo).getAsString();
                String modthree = Objects.requireNonNull(modOptionThree).getAsString();
                event.reply(cleanUp.modify(textOption,modthree,modtwo,mod)).queue();
            }
            case "modfour" ->{
                String textOption = Objects.requireNonNull(event.getOption("message")).getAsString();
                event.reply("***__~~" + textOption + "~~__***").queue();
            }
        }
    }
    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        OptionData main = new OptionData(OptionType.STRING, "message", "message you want colorized", true);
        OptionData colorOpp = new OptionData(OptionType.STRING, "color", "Color you want the text to be", true)
                .addChoice("yellow","yellow")
                .addChoice("cyan","cyan")
                .addChoice("red","red")
                .addChoice("green","green")
                .addChoice("blue","blue")
                .addChoice("grey","grey")
                .addChoice("orange","orange");
        OptionData modOpp = new OptionData(OptionType.STRING, "mod", "Option you want the text to be", true)
                .addChoice("bold","bold")
                .addChoice("italic","italic")
                .addChoice("strike","strike")
                .addChoice("under","under");
        OptionData modOppTwo = new OptionData(OptionType.STRING, "modtwo", "Option you want the text to be", true)
                .addChoice("bold","bold")
                .addChoice("italic","italic")
                .addChoice("strike","strike")
                .addChoice("under","under");
        OptionData modOppThree = new OptionData(OptionType.STRING, "modthree", "Option you want the text to be", true)
                .addChoice("bold","bold")
                .addChoice("italic","italic")
                .addChoice("strike","strike")
                .addChoice("under","under");
        commandData.add(Commands.slash("color","Generate text with a specific color")
                .addOptions(main,colorOpp));
        commandData.add(Commands.slash("mod","Generate text with a specific modifier")
                .addOptions(main,modOpp));
        commandData.add(Commands.slash("modtwo","Generate text with two specific modifiers")
                .addOptions(main,modOpp,modOppTwo));
        commandData.add(Commands.slash("modthree","Generate text with three specific modifiers")
                .addOptions(main,modOpp,modOppTwo,modOppThree));
        commandData.add(Commands.slash("modfour","Generate text with four specific modifiers")
                .addOptions(main));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
    public static void main(String[] args) {
    }
}
