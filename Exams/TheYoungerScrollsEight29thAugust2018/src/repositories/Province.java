package repositories;

import interfaces.GuildInterface;

import java.util.*;
//TODO there are some interface and implementation mix ups for Guild, but changing the public method signatures would break judge
public class Province {
    private static final String GUILD_ADDED_MESSAGE = "Added Guild: %s";
    private static final String GUILD_ALREADY_EXISTS_MESSAGE = "Guild already exists.";
    private static final String GUILD_REMOVED_MESSAGE = "Removed guild [%s] with %d members.";
    private static final String GUILD_DOES_NOT_EXIST_MESSAGE = "Guild %s does not exist.";

    private String name;
    private Map<String, GuildInterface> nameGuild;
    private Comparator<GuildInterface> guildComparator;

    public Province(String name, Comparator<GuildInterface> guildComparator) {
        this.name = name;
        this.nameGuild = new HashMap<>();
        this.guildComparator = guildComparator;
    }

    public String getName() { //possible problem
        return this.name;
    }

    public String addGuild(Guild guild)  {
        String guildName = guild.getName();

        if (!this.nameGuild.containsKey(guildName)) {
            this.nameGuild.put(guildName, guild);
            return String.format(GUILD_ADDED_MESSAGE, guildName);
        } else {
            return GUILD_ALREADY_EXISTS_MESSAGE;
        }
    }

    public String removeGuild(Guild guild) {
        String guildName = guild.getName();

        if (this.nameGuild.containsKey(guildName)) {
            this.nameGuild.remove(guildName);
            return String.format(GUILD_REMOVED_MESSAGE, guildName, guild.getGuildSize());
        } else {
            return String.format(GUILD_DOES_NOT_EXIST_MESSAGE, guildName);
        }
    }

    public Guild getGuildByName(String guildName) {
        return (Guild)this.nameGuild.get(guildName); //returns null if there is no such guild
    }

    public boolean contains(String guildName) {
        return this.nameGuild.containsKey(guildName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Province: ").append(this.name).append(System.lineSeparator());
        sb.append("#Guilds: ");

        if (this.nameGuild.isEmpty()) {
            sb.append("None");
            return sb.toString();
        } else {
            sb.append(System.lineSeparator());
        }

        Set<GuildInterface> guildsSorted = new TreeSet<>(this.guildComparator);
        guildsSorted.addAll(this.nameGuild.values());

        for (GuildInterface guild : guildsSorted) {
            sb.append(this.guildToString(guild)).append(System.lineSeparator());
        }

//        this.nameGuild.values().stream().sorted((g1, g2) -> { //easier and faster way
//            int comparisonResult = Double.compare(g2.getGuildPower(), g1.getGuildPower());
//
//            if (comparisonResult != 0) {
//                return comparisonResult;
//            } else {
//                return g1.getName().compareTo(g2.getName());
//            }
//        }).forEach(g -> {
//            sb.append(this.guildToString(g)).append(System.lineSeparator());
//        });

        return sb.toString().trim();
    }

    private String guildToString(GuildInterface guild) {
        return String.format("##Guild: Name: %s, Power: %.2f, Size: %d",
                guild.getName(), guild.getGuildPower(), guild.getGuildSize());
    }
}
