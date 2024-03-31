package millllionWith4Ls.bot.Main.commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class commandManager extends ListenerAdapter{
    SlashCommandInteractionEvent mainEvent;

    private @SuppressWarnings("all") String getOption(String name){
        return mainEvent.getOption(name).getAsString();
    }
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        mainEvent = event;
        String textOption = getOption("message");
        switch(event.getName().toLowerCase()){
            case "color" -> {
                String bgColor;
                String color = getOption("color");
                try{
                    bgColor = getOption("background");
                }catch(NullPointerException e){
                    bgColor = "no_color";}

                event.reply(cleanUp.getMessage(bgColor,color,textOption)).queue();
            }
            case "modify" ->{
                String modifierTwo;
                String modifierThree;
                String modifierFour;
                String modifierOne = getOption("modifier_one");
                try{
                    modifierTwo = getOption("modifier_two");
                }catch(NullPointerException e){
                    modifierTwo = "no_modifier";}
                try{
                    modifierThree = getOption("modifier_three");
                }catch(NullPointerException e){
                    modifierThree = "no_modifier";}
                try{
                    modifierFour = getOption("modifier_four");
                }catch(NullPointerException e){
                    modifierFour = "no_modifier";}

                event.reply(cleanUp.modify(textOption,modifierOne,modifierTwo,modifierThree,modifierFour)).queue();
            }
        }
    }
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        //Variables
        String[] colors = new String[]{"gray","red","green","orange","blue","pink","cyan","white"};
        String[] bgColors = new String[]{"dark blue","orange","dark gray","gray","purple","light gray","white"};
        String[] mods = new String[]{"bold","italic","strikethrough","underline"};
        List<CommandData> commandData = new ArrayList<>();

        //Option Descriptions
        OptionData colorDescription = new OptionData(OptionType.STRING, "message", "message you want colorized", true);
        OptionData modDescription = new OptionData(OptionType.STRING, "message", "message you want modified", true);

        //Color Options
        OptionData colorOption = new OptionData(OptionType.STRING, "color", "Color you want the text to be", true);
        OptionData backgroundColorOption = new OptionData(OptionType.STRING, "background", "Color you want the text background to be", false);

        //Modifier Options
        OptionData modifierOptionOne = new OptionData(OptionType.STRING, "modifier_one", "First modifier you want applied", true);
        OptionData modifierOptionTwo = new OptionData(OptionType.STRING, "modifier_two", "Second modifier you want applied", false);
        OptionData modifierOptionThree = new OptionData(OptionType.STRING, "modifier_three", "Third modifier you want applied", false);
        OptionData modifierOptionFour = new OptionData(OptionType.STRING, "modifier_four", "Fourth modifier you want applied", false);

        //Choices
        for(String color: colors){
            colorOption.addChoice(color, color);
        }
        for(String bgColor: bgColors){
            backgroundColorOption.addChoice(bgColor,bgColor);
        }
        for(String mod: mods){
            modifierOptionOne.addChoice(mod,mod);
            modifierOptionTwo.addChoice(mod,mod);
            modifierOptionThree.addChoice(mod,mod);
            modifierOptionFour.addChoice(mod,mod);
        }

        //Adding Commands
        commandData.add(Commands.slash("color","Generate text with a specific color")
                .addOptions(colorDescription,colorOption,backgroundColorOption));
        commandData.add(Commands.slash("modify","Generate text with a specific modifier")
                .addOptions(modDescription,modifierOptionOne,modifierOptionTwo,modifierOptionThree,modifierOptionFour));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
    public static void main(String[] args) {
    }
}
