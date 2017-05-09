package com.juego.charles.cuantos_puedes_pokeadivinar;

/**
 * Created by Carlos on 31/03/2015.
 */
public class Pokemon {

    private String nombre_pokemon;
    private boolean evolucion;
    private String tipo1;
    private String tipo2;

    private String[] nombre_pokemons = {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon","Charizard", "Squirtle", "Wartortle",
            "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot",
            "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu", "Sandshrew", "Sandslash", "Nidoran",
            "Nidorina", "Nidoqueen", "Nidoran", "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff",
            "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume", "Paras", "Parasect", "Venonat", "Venomoth", "Diglett",
            "Dugtrio", "Meowth", "Persian", "Psyduck", "Golduck", "Mankey", "Primeape", "Growlithe", "Arcanine", "Poliwag", "Poliwhirl",
            "Poliwrath", "Abra", "Kadabra", "Alakazam", "Machop", "Machoke", "Machamp", "Bellsprout", "Weepinbell", "Victreebel",
            "Tentacool", "Tentacruel", "Geodude", "Graveler", "Golem", "Ponyta", "Rapidash", "Slowpoke", "Slowbro", "Magnemite", "Magneton",
            "Farfetch'd", "Doduo", "Dodrio", "Seel", "Dewgong", "Grimer", "Muk", "Shellder", "Cloyster", "Gastly", "Haunter", "Gengar",
            "Onix", "Drowzee", "Hypno", "Krabby", "Kingler", "Voltorb", "Electrode", "Exeggcute", "Exeggutor", "Cubone", "Marowak",
            "Hitmonlee", "Hitmonchan", "Lickitung", "Koffing", "Weezing", "Rhyhorn", "Rhydon", "Chansey", "Tangela", "Kangaskhan", "Horsea",
            "Seadra", "Goldeen", "Seaking", "Staryu", "Starmie", "Mr.Mime", "Scyther", "Jynx", "Electabuzz", "Magmar", "Pinsir", "Tauros",
            "Magikarp", "Gyarados", "Lapras", "Ditto", "Eevee", "Vaporeon", "Jolteon", "Flareon", "Porygon", "Omanyte", "Omastar", "Kabuto",
            "Kabutops", "Aerodactyl", "Snorlax", "Articuno", "Zapdos", "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew"
    };
    private boolean[] evoluciones = {false, true, true, false, true, true, false, true, true, false, true, true, false, true, true, false,
            true, true, false, true, false, true, false, true, false, true, false, true, false, true, true, false, true, true, false, true,
            false, true, false, true, false, true, false, true, true, false, true, false, true, false, true, false, true, false, true,
            false, true, false, true, false, true, true, false, true, true, false, true, true, false, true, true, false, true, false, true,
            true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, false, true, true, false,
            false, true, false, true, false, true, false, true, false, true, false, false, false, false, true, false, true, false, false, false,
            false, true, false, true, false, true, false, false, false, false, false, false, false, false, true, false, false, false, true, true,
            true, false, false, true, false, true, false, false, false, false, false, false, true, true, false, false
    };

    private String[] tipos1 = {"planta", "planta", "planta", "fuego", "fuego", "fuego", "agua", "agua", "agua", "bicho", "bicho", "bicho", "bicho",
            "bicho", "bicho", "normal", "normal", "normal", "normal", "normal", "normal", "normal", "veneno", "veneno", "electrico", "electrico",
            "tierra", "tierra", "veneno", "veneno", "veneno", "veneno", "veneno", "veneno", "normal", "normal", "fuego", "fuego", "normal", "normal", "veneno",
            "veneno", "planta", "planta", "planta", "bicho", "bicho", "bicho", "bicho", "tierra", "tierra", "normal", "normal", "agua", "agua", "lucha",
            "lucha", "fuego", "fuego", "agua", "agua", "agua", "psiquico", "psiquico", "psiquico", "lucha", "lucha", "lucha", "planta", "planta", "planta",
            "agua", "agua", "roca", "roca", "roca", "fuego", "fuego", "agua", "agua", "electrico", "electrico", "normal", "normal", "normal", "agua", "agua", "veneno",
            "veneno", "agua", "agua", "fantasma", "fantasma", "fantasma", "roca", "psiquico", "psiquico", "agua", "agua", "electrico", "electrico", "planta", "planta",
            "tierra", "tierra", "lucha", "lucha", "normal", "veneno", "veneno", "tierra", "tierra", "normal", "planta", "normal", "agua", "agua", "agua", "agua", "agua",
            "agua", "psiquico", "bicho", "hielo", "electrico", "fuego", "bicho", "normal", "agua", "agua", "agua", "normal", "normal", "agua", "electrico", "fuego",
            "normal", "roca", "roca", "roca", "roca", "roca", "normal", "hielo", "electrico", "fuego", "dragon", "dragon", "dragon", "psiquico", "psiquico"
    };
    private String[] tipos2 = {"veneno", "veneno", "veneno", "", "", "volador", "", "", "", "", "", "volador", "veneno", "veneno", "veneno", "volador", "volador",
            "volador", "", "", "volador", "volador", "", "", "", "", "", "", "", "", "tierra", "", "", "tierra", "", "", "", "", "", "", "volador",
            "volador", "veneno", "veneno", "veneno", "planta", "planta", "veneno", "veneno", "", "", "", "", "", "", "", "", "", "", "", "", "lucha", "", "", "",
            "", "", "", "veneno", "veneno", "veneno", "veneno", "veneno", "tierra", "tierra", "tierra", "", "", "psiquico", "psiquico", "acero", "acero",
            "volador", "volador", "volador", "", "hielo", "", "", "", "hielo", "veneno", "veneno", "veneno", "tierra", "", "", "", "", "", "", "psiquico",
            "psiquico", "", "", "", "", "", "", "", "roca", "roca", "", "", "", "", "", "", "", "", "psiquico", "", "volador", "psiquico", "", "", "", "", "",
            "volador", "hielo", "", "", "", "", "", "", "agua", "agua", "agua", "agua", "volador", "", "volador", "volador", "volador", "", "", "volador", "", ""
    };

    public Pokemon(int num){

        this.nombre_pokemon = nombre_pokemons[num];
        this.evolucion = evoluciones[num];
        this.tipo1 = tipos1[num];
        this.tipo2 = tipos2[num];

    }

    public void ActualizarPokemon(int num){
        this.nombre_pokemon = nombre_pokemons[num];
        this.evolucion = evoluciones[num];
        this.tipo1 = tipos1[num];
        this.tipo2 = tipos2[num];
    }

    public int getLength(){
        return nombre_pokemons.length;
    }

    public String getNombre_pokemon(int num){
        return nombre_pokemons[num];
    }

    public String getNombre_pokemon(){
        return this.nombre_pokemon;
    }

    public String getTipo1(){
        return this.tipo1;
    }

    public String getTipo2(){
        return this.tipo2;
    }

    public boolean getEvolucion(){
        return this.evolucion;
    }

}
