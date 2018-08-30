package engine;

import interfaces.*;
import repositories.Guild;
import repositories.Province;

import java.lang.Runnable;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CreationEngine implements Runnable {
    private static final String NO_PROVINCE_SELECTED_MESSAGE = "No province selected!";
    private static final String PROVINCE_DOES_NOT_EXIST_MESSAGE = "Province %s does not exist";
    private static final String PROVINCE_ALREADY_EXISTS_MESSAGE = "Province with name %s already exists!";
    private static final String PROVINCE_CREATED_MESSAGE = "Created province %s";
    private static final String PROVINCE_HAS_ALREADY_BEEN_SELECTED_MESSAGE = "Province %s has already been selected!";
    private static final String PROVINCE_SELECTED_MESSAGE = "Province %s selected!";

    private static final String GUILD_DOES_NOT_EXIST_MESSAGE = "Guild [%s] does not exist.";
    private static final String NO_SUCH_HERO_IN_GUILD_MESSAGE = "No such hero in this guild!";
    private static final String GUILD_DOES_NOT_EXIST_MESSAGE_2 = "Guild %s does not exist.";//i guess judge wants 2 versions of this

    private static final String HERO_SLICED_HERO_MESSAGE = "Hero %s sliced hero %s.";
    private static final String HEROES_FROM_SAME_GUILD_CANNOT_FIGHT_MESSAGE = "Heroes from the same guild can not fight each other.";

    private static final String SPLITTER = "\\s+";

    private Map<String, Province> nameProvince;
    private Province currentProvince;

    private InputReader reader;
    private OutputWriter writer;
    private Factory<Hero> heroFactory;
    private Comparator<GuildInterface> guildComparator;

    public CreationEngine(InputReader reader, OutputWriter writer, Factory heroFactory, Comparator<GuildInterface> guildComparator) {
        this.nameProvince = new TreeMap<>();
        this.currentProvince = null;

        this.writer = writer;
        this.reader = reader;
        this.heroFactory = heroFactory;
        this.guildComparator = guildComparator;
    }

    @Override
    public void run() {
        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(SPLITTER);
            String command = tokens[0];

            switch (command) {
                //•	CREATE_PROVINCE: {provinceName}
                case "CREATE_PROVINCE:":
                    String provinceName = tokens[1];

                    if (this.provinceExists(provinceName)) {
                        this.writer.writeLineFormat(PROVINCE_ALREADY_EXISTS_MESSAGE, provinceName);
                    } else {
                        this.writer.writeLineFormat(PROVINCE_CREATED_MESSAGE, provinceName);
                        Province newProvince = new Province(provinceName, this.guildComparator);
                        this.currentProvince = newProvince;
                        this.nameProvince.put(provinceName, newProvince);
                    }
                    break;

                case "SELECT:":
                    provinceName = tokens[1];

                    if (!this.provinceExists(provinceName)) {
                        this.writer.writeLineFormat(PROVINCE_DOES_NOT_EXIST_MESSAGE, provinceName);
                    } else if (this.currentProvince.getName().equals(provinceName)) {
                        this.writer.writeLineFormat(PROVINCE_HAS_ALREADY_BEEN_SELECTED_MESSAGE, provinceName);
                    } else {//there is such a province in the collection and it is not the selected one
                        this.writer.writeLineFormat(PROVINCE_SELECTED_MESSAGE, provinceName);
                        this.currentProvince = this.nameProvince.get(provinceName);
                    }

                    break;

                case "ADD_HERO:":
                    String guildName = tokens[1];
                    String heroType = tokens[2];
                    String heroName = tokens[3];
                    int health = Integer.parseInt(tokens[4]);
                    int fatigue = Integer.parseInt(tokens[5]);
                    int magicka = Integer.parseInt(tokens[6]);

                    if (this.currentProvince == null) {
                        this.writer.writeLine(NO_PROVINCE_SELECTED_MESSAGE);
                        break;
                    }

                    Guild currentGuild = this.currentProvince.getGuildByName(guildName);
                    if (currentGuild == null) {
                        currentGuild = new Guild(guildName);
                        this.currentProvince.addGuild(currentGuild);
                    }

                    try {
                        //hero factory will throw exception, after that created hero would
                        Hero newHero = this.heroFactory.create(tokens);
                        this.writer.writeLine(currentGuild.addHero(newHero));
                    } catch (IllegalArgumentException iae) {
                        this.writer.writeLine(iae.getMessage());
                    }

                    break;

                case "ADD_GUILD:":
                    guildName = tokens[1];
                    currentGuild = new Guild(guildName);
                    this.writer.writeLine(this.currentProvince.addGuild(currentGuild));
                    break;

                case "DETAILS:":
                    guildName = tokens[1];
                    if (!this.currentProvince.contains(guildName)) {
                        this.writer.writeLineFormat(GUILD_DOES_NOT_EXIST_MESSAGE, guildName);
                        break;
                    }

                    if (tokens.length == 2) {
                        this.writer.writeLine(this.currentProvince.getGuildByName(guildName).toString());
                    } else {
                        //•	DETAILS: {guildName} {heroName}
                        heroName = tokens[2];
                        Hero hero = this.currentProvince.getGuildByName(guildName).getHeroByName(heroName);
                        if (hero == null) {
                            this.writer.writeLine(NO_SUCH_HERO_IN_GUILD_MESSAGE);
                        } else {
                            this.writer.writeLine(hero.toString());
                        }
                    }
                    break;

                case "REMOVE:":
                    guildName = tokens[1];
                    currentGuild = this.currentProvince.getGuildByName(guildName);

                    if (currentGuild == null) {
                        this.writer.writeLineFormat(GUILD_DOES_NOT_EXIST_MESSAGE_2, guildName);
                        break;
                    }

                    if (tokens.length == 2) {
                        this.writer.writeLine(this.currentProvince.removeGuild(currentGuild));
                    } else {
                        heroName = tokens[2];
                        Hero hero = currentGuild.getHeroByName(heroName);
                        this.writer.writeLine(currentGuild.removeHero(hero));
                    }
                    break;

                case "FIGHT:":
                    String guild1Name = tokens[1];
                    String guild2Name = tokens[3];
                    if (guild1Name.equals(guild2Name)) {
                        this.writer.writeLine(HEROES_FROM_SAME_GUILD_CANNOT_FIGHT_MESSAGE);
                        break;
                    }

                    Hero hero1 = this.currentProvince.getGuildByName(guild1Name).getHeroByName(tokens[2]);
                    Hero hero2 = this.currentProvince.getGuildByName(guild2Name).getHeroByName(tokens[4]);

                    if (hero1 == null || hero2 == null) {
                        this.writer.writeLine(NO_SUCH_HERO_IN_GUILD_MESSAGE);
                        break;
                    }

                    this.fight(hero1, hero2);

                    if (hero1.isDead()) {
                        this.writer.writeLineFormat(HERO_SLICED_HERO_MESSAGE, hero2.getName(), hero1.getName());
                        this.currentProvince.getGuildByName(guild1Name).removeHero(hero1);
                    } else {
                        this.writer.writeLineFormat(HERO_SLICED_HERO_MESSAGE, hero1.getName(), hero2.getName());
                        this.currentProvince.getGuildByName(guild2Name).removeHero(hero2);
                    }
                    break;
            }
            this.writer.writeLine("---");

        } //"END" has been entered

        for (Province province : this.nameProvince.values()) {
            this.writer.writeLine(province.toString());
        }
    }

    private boolean provinceExists(String provinceName) {
        return this.nameProvince.containsKey(provinceName);
    }

    private void fight(Hero hero1, Hero hero2) {
        while (!hero1.isDead() && !hero2.isDead()) {
            int hero1Health = hero1.getHealth();
            int hero2Health = hero2.getHealth();

            if (hero1Health < hero2Health) {
                hero1.attack(hero2);
            } else if (hero2Health < hero1Health) {
                hero2.attack(hero1);
            } else { //they have equal health
                double hero1Offense = hero1.getOffense();
                double hero2Offense = hero2.getOffense();

                if (hero1Offense < hero2Offense) {
                    hero1.attack(hero2);
                } else {
                    hero2.attack(hero1);
                }
            }
        }
    }

}
