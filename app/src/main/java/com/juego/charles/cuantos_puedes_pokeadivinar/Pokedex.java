package com.juego.charles.cuantos_puedes_pokeadivinar;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Pokedex extends ActionBarActivity {

    private ListViewAdapter lista_pokedex;
    private String pokemon_pokedex="";
    private boolean[] p_pokedex = new boolean[151];
    private String[] altura = { "0,7", "1,0", "2,0", "0,6", "1,1", "2,5", "0,5", "1,0", "2,3", "0,3", "0,7", "1,1", "0,3", "0,6", "1,0", "0,3", "1,1", "1,5", "0,3", "0,7",
            "0,3", "1,2", "2,0", "3,5", "0,4", "0,8", "0,6", "1,0", "0,4", "0,8", "1,3", "0,5", "0,9", "1,4", "0,6", "1,3", "0,6", "1,1", "0,5", "1,0", "0,8", "1,6", "0,5", "0,8", "1,2",
            "0,3", "1,0", "1,0", "1,5", "0,2", "0,7", "0,4", "1,0", "0,8", "1,7", "0,5", "1,0", "0,7", "1,9", "0,6", "1,0", "1,3", "0,9", "1,3", "1,5", "0,8", "1,5", "1,6", "0,7", "1,0",
            "1,7", "0,9", "1,6", "0,4", "1,0", "1,4", "1,0", "1,7", "1,2", "1,6", "0,3", "1,0", "0,8", "1,4", "1,8", "1,1", "1,7", "0,9", "1,2", "0,3", "1,5", "1,3", "1,6", "1,5", "8,8",
            "1,0", "1,6", "0,4", "1,3", "0,5", "1,2", "0,4", "2,0", "0,4", "1,0", "1,5", "1,4", "1,2", "0,6", "1,2", "1,0", "1,9", "1,1", "1,0", "2,2", "0,4", "1,2", "0,6", "1,3", "0,8",
            "1,1", "1,3", "1,5", "1,4", "1,1", "1,3", "1,5", "1,4", "0,9", "6,5", "2,5", "0,3", "0,3", "1,0", "0,8", "0,9", "0,8", "0,4", "1,0", "0,5", "1,3", "1,8", "2,1", "1,7", "1,6",
            "2,0", "1,8", "4,0", "2,2", "2,0", "0,4"

    };
    private String[] peso = { "6,9", "13,0", "100,0", "8,5", "19,0", "130,0", "9,0", "22,5", "175,3", "2,9", "9,9", "32,0", "3,2", "10,0", "29,5", "1,8", "30,0", "39,5", "3,5", "18,5",
            "2,0", "38,0", "6,9", "65,0", "6,0", "30,0", "12,0", "29,5", "7,0", "20,0", "60,0", "9,0", "19,5", "62,0", "7,5", "40,0", "9,9", "19,9", "5,5", "12,0", "7,5", "55,0", "5,4", "8,6", "18,6",
            "5,4", "29,5", "30,0", "12,5", "0,8", "33,3", "4,2", "32,0", "19,6", "76,6", "28,0", "32,0", "19,0", "155,0", "12,4", "20,0", "54,0", "19,5", "56,5", "48,0", "19,5", "70,5", "130,0", "4,0", "6,4",
            "15,5", "45,5", "55,0", "20,0", "105,0", "300,0", "30,0", "95,0", "36,0", "78,5", "6,0", "60,0", "15,0", "39,2", "85,2", "90,0", "120,0", "30,0", "30,0", "4,0", "132,5", "0,1", "0,1", "40,5", "210,0",
            "32,4", "75,6", "6,5", "60,0", "10,4", "66,6", "2,5", "120,0", "6,5", "45,0", "49,8", "50,2", "65,5", "1,0", "9,5", "115,0", "120,0", "34,6", "35,0", "80,0", "8,0", "25,0", "15,0", "39,0", "34,5",
            "80,0", "54,5", "56,0", "40,6", "30,0", "44,5", "55,0", "88,4", "10,0", "235,0", "220,0", "4,0", "6,5", "29,0", "24,5", "25,0", "36,5", "7,5", "35,0", "11,5", "40,5", "59,0", "460,0", "55,4", "52,6",
            "60", "3,3", "16,5", "210,0", "122,0", "4,0"
    };






    private String[] descripcion = {
            "A Bulbasaur es fácil verle echándose una siesta al sol. La semilla que tiene en el lomo va creciendo cada vez más a medida que absorbe los rayos solares."
            , "Este Pokémon lleva un bulbo en el lomo y, para poder con su peso, tiene unas patas y un tronco gruesos y fuertes. Si empieza a pasar más tiempo al sol, será porque el bulbo está a punto de florecer."
            , "Venusaur tiene una flor enorme en el lomo cuyo aroma tiene un efecto relajante en las personas y pokemons."
            , "La llama que tiene en la punta de la cola arde según sus sentimientos. Llamea levemente cuando está alegre y arde vigorosamente cuando está enfadado."
            , "Charmeleon no tiene reparo en acabar con su rival usando las afiladas garras que tiene. Si su enemigo es fuerte, se vuelve agresivo, y la llama que tiene en el extremo de la cola empieza a arder con mayor intensidad tornándose azulada."
            , "Es muy presuntuoso, violento, agresivo y muy orgulloso. Es tanto así, que no es capaz de pelear contra un Pokémon más débil que él. Es por esta sencilla razón que prefiere luchar contra oponentes que le representen un desafío."
            , "El caparazón de Squirtle no le sirve de protección únicamente. Su forma redondeada y las hendiduras que tiene le ayudan a deslizarse en el agua y le permiten nadar a gran velocidad."
            , "Tiene una cola larga y cubierta de un pelo abundante y grueso que se torna más oscuro a medida que crece. Los arañazos que tiene en el caparazón dan fe de lo buen guerrero que es."
            , "Blastoise lanza chorros de agua con gran precisión por los tubos que le salen del caparazón que tiene en la espalda. Dispara chorros de agua con una potencia capaz de traspasar muros de hormigón."
            , "Caterpie tiene un apetito voraz. Es capaz de devorar hojas que superen su tamaño en un abrir y cerrar de ojos. Atención a la antena que tiene: libera un hedor realmente fuerte."
            , "La capa que recubre el cuerpo de este Pokémon es tan dura como una plancha de hierro. Metapod apenas se mueve. Permanece inmóvil para que las vísceras evolucionen dentro de la coraza que le rodea."
            , "Butterfree tiene una habilidad especial para encontrar delicioso polen en las flores. Puede localizar, extraer y transportar polen de flores que estén floreciendo a 10 km de distancia de su nido."
            , "Weedle tiene un finísimo sentido del olfato. Es capaz de distinguir las hojas que le gustan de las que no le gustan olisqueando un poco con la gran nariz que tiene."
            , "Kakuna permanece prácticamente inmóvil al encaramarse a los árboles, aunque la actividad interna de su organismo tiene un ritmo frenético, pues se prepara para su evolución. Prueba de esto es la alta temperatura de su caparazón."
            , "Los Beedrill defienden su territorio a toda costa. No es conveniente acercarse a su colmena, por seguridad. Si se les molesta, todo un enjambre atacará ferozmente."
            , "Pidgey tiene un sentido de la orientación muy desarrollado. Es capaz de regresar a su nido, por lejos que se encuentre de las zonas que le resultan familiares."
            , "Pidgeotto se apodera de una zona muy vasta como su territorio y la sobrevuela para controlarla. Si alguien invade su espacio vital, no tendrá ningún reparo en castigarlo con sus afiladas garras."
            , "El plumaje de este Pokémon es bonito e hipnótico. Muchos Entrenadores se quedan embobados ante la belleza impactante de las plumas que tiene en la cabeza; lo que les lleva a elegir a Pidgeot como su Pokémon."
            , "Rattata es cauto como él solo. Hasta cuando duerme mueve las orejas para oír todos los ruidos. No es nada delicado a la hora de elegir su hábitat. Cualquier sitio es bueno para cavar su madriguera."
            , "A Raticate le crecen los incisivos firmes y fuertes. Para mantenerlos afilados roe troncos y rocas, e incluso las paredes de las casas."
            , "Spearow pía con tanta fuerza que se le puede oír a 1 km de distancia. Si al agudo chillido le sigue una especie de eco, estaremos oyendo la respuesta de otros Spearow que contestan ante el aviso de peligro."
            , "A Fearow se le reconoce por tener un pescuezo y un pico largos que le permiten cazar en tierra y agua. Tiene una gran habilidad moviendo el fino pico para atrapar a sus presas."
            , "Ekans se enrosca para descansar. Adoptando esta posición puede responder rápidamente a cualquier amenaza que le aceche desde cualquier lugar, levantando la cabeza con una feroz mirada."
            , "Este Pokémon es tremendamente fuerte, puede oprimir cualquier cosa con su cuerpo y hasta es capaz de estrujar un barril de acero. Una vez que Arbok se enrosca a su víctima, no hay forma de escapar de su asfixiante abrazo."
            , "Cada vez que un Pikachu se encuentra con algo nuevo, le lanza una descarga eléctrica. Cuando se ve alguna baya chamuscada, es muy probable que sea obra de un Pikachu, ya que a veces no controlan la intensidad de la descarga."
            , "Si las bolsas de los mofletes se le cargan demasiado, Raichu planta la cola en el suelo para liberar electricidad. Es común encontrar zonas chamuscadas cerca de la madriguera de este Pokémon."
            , "Sandshrew es capaz de absorber agua y no perder ni una gota, algo que le permite sobrevivir en el desierto. Este Pokémon se enrosca para defenderse de los enemigos."
            , "Sandslash está recubierto de duras púas que son partes endurecidas de la piel. Suele mudarlas una vez al año; debajo de las viejas púas crecen unas nuevas que las sustituyen."
            , "Nidoran tiene púas que segregan un veneno muy potente. Se piensa que las desarrolló como protección del cuerpo tan pequeño que tiene. Cuando se enfada, libera una horrible sustancia tóxica por el cuerno."
            , "Cuando están en familia o con sus amigos, esconden las púas para evitar accidentes. Según parece, se alteran bastante si se separan del grupo."
            , "Nidoqueen tiene el cuerpo totalmente recubierto de escamas durísimas. Suele lanzar por los aires a sus rivales de los violentos golpes que les propina. Cuando se trata de defender a sus crías, alcanza su nivel máximo de fuerza."
            , "Nidoran ha desarrollado músculos para mover las orejas y orientarlas en cualquier dirección. De este modo, es capaz de captar hasta el sonido más leve."
            , "Nidorino tiene un cuerno de dureza superior a la del diamante. Si siente una presencia hostil, se le erizan las púas del lomo enseguida y carga contra el enemigo con todas sus fuerzas."
            , "La gruesa cola de Nidoking encierra una fuerza realmente destructora. Con una vez que la agite, es capaz de tumbar una torre metálica de transmisión. Una vez que este Pokémon se desboca, no hay quien lo pare."
            , "Siempre que hay luna llena, salen en grupo para jugar. Al amanecer, los Clefairy, agotados, regresan a sus refugios de montaña para dormir acurrucados unos con otros."
            , "Clefable se mueve dando saltitos como si fuera haciendo uso de las alas. Estos pequeños brincos le permiten caminar por el agua. De todos es sabido que le encanta darse paseos por los lagos en tranquilas noches de luna llena."
            , "Clefable se mueve dando saltitos como si fuera haciendo uso de las alas. Estos pequeños brincos le permiten caminar por el agua. De todos es sabido que le encanta darse paseos por los lagos en tranquilas noches de luna llena."
            , "Ninetales emite una siniestra luz a través de los brillantes ojos rojos que tiene, para conseguir controlar del todo la mente de su rival. Dicen que este Pokémon llega a vivir mil años."
            , "Jigglypuff tiene unas cuerdas vocales que ajustan sin problema la longitud de onda de su voz. Este Pokémon usa la habilidad que tiene para cantar con la longitud de onda necesaria para adormecer a su rival."
            , "Wigglytuff tiene unos ojos enormes con forma de platillo, que siempre están cubiertos de lágrimas. Si se le metiera algo en el ojo, enseguida se le saldría solo."
            , "Durante el día, Zubat permanece inmóvil y a oscuras. Si este Pokémon pasara mucho tiempo expuesto al sol, correría el peligro de sufrir quemaduras."
            , "A Golbat le encanta chuparles la sangre a los seres vivos. Este Pokémon es más activo en la oscuridad de la noche. Es al caer la noche cuando sale a revolotear y a buscar sangre fresca."
            , "Durante el día, Oddish se entierra en el suelo para absorber nutrientes valiéndose de todo el cuerpo. Cuanto más fértil sea el suelo, mayor brillo tendrá en las hojas."
            , "Gloom libera un fétido olor por el pistilo de la flor. Cuando está en peligro, el hedor se intensifica. Si este Pokémon está tranquilo y no se siente amenazado, no libera el desagradable olor."
            , "El polen que contienen las esporas tóxicas de Vileplume causa unos ataques de alergia muy agudos. Por eso, no es aconsejable acercarse a ninguna flor selvática, por muy bonita que sea."
            , "Paras lleva dos setas parásitas a cuestas llamadas tochukaso. Estas crecen alimentándose de los nutrientes de este Pokémon de tipo Bicho y Planta que les sirve de huésped. Las setas se usan como elixir de vida."
            , "Parasect es conocido por destruir en plaga grandes árboles, absorbiendo los nutrientes que tienen en la parte baja del tronco y las raíces. Cuando un árbol azotado por la plaga muere, los Parasect van a por el siguiente al instante."
            , "Dicen que durante su evolución Venonat desarrolló una fina capa de espeso pelo alrededor de todo el cuerpo para protegerse. Tiene unos ojos tan grandes que no hay presa que le pase desapercibida."
            , "Venomoth es nocturno, solo actúa en la oscuridad. Su alimento preferido son los pequeños insectos que se concentran cerca de los focos de luz en la oscuridad de la noche."
            , "En la mayoría de las granjas se suelen criar Diglett por la sencilla razón de que, excaven donde excaven, dejan la tierra perfectamente labrada para sembrar. El terreno queda listo para plantar ricas verduras."
            , "Los Dugtrio son trillizos que se originaron a partir de un solo cuerpo, por eso piensan de la misma forma. A la hora de excavar, trabajan en equipo y sin descanso."
            , "Meowth retrae las afiladas uñas de sus zarpas para caminar a hurtadillas, dando sigilosos pasos para pasar inadvertido. No se sabe muy bien por qué, pero este Pokémon adora las monedas brillantes que resplandecen con la luz."
            , "Persian tiene seis llamativos bigotes que le dan un aspecto feroz. Además, le sirven para detectar el movimiento del aire, delator de la presencia cercana de algún Pokémon. Si se le agarra por los bigotes, se vuelve dócil."
            , "Psyduck tiene un extraño poder, que consiste en generar ondas cerebrales iguales a las que se generan cuando se está dormido. Este descubrimiento levantó una gran polémica entre eruditos."
            , "Golduck alcanza una velocidad de vértigo gracias a las aletas palmípedas de las extremidades y a la forma aerodinámica de su cuerpo. Realmente, la velocidad de este Pokémon supera la de cualquier nadador."
            , "Cuando Mankey empieza a temblar y a respirar con más intensidad, seguro que va a enfadarse. Aunque prever su enfado no sirve de nada porque alcanza un estado de rabia tan rápido que no hay escapatoria."
            , "Cuando Primeape se enfada, se le acelera el ritmo cardíaco y se le fortalecen los músculos. Con todo, pierde en inteligencia."
            , "Growlithe tiene un sentido del olfato excepcional y una memoria sensitiva tremenda, nunca olvida una esencia. Este Pokémon saca provecho de este don para identificar las sensaciones que tienen otros seres vivos."
            , "Arcanine es conocido por lo veloz que es. Dicen que es capaz de correr 10 000 km en 24 horas. El fuego que arde con vigor en el interior de este Pokémon constituye su fuente de energía."
            , "Poliwag tiene una piel muy fina. Tanto que es posible entrever a través de la misma las vísceras en espiral que tiene. La piel, aunque fina, tiene la ventaja de ser flexible y hacer rebotar hasta los colmillos más afilados."
            , "La piel de Poliwhirl está siempre húmeda y lubricada con un fluido viscoso. Gracias a esta película resbaladiza, puede escapar de las garras del enemigo, resbalándosele de las zarpas en pleno combate."
            , "Poliwrath tiene unos músculos fornidos y muy desarrollados, por lo que nunca se agota. Es tan fuerte e incansable que cruzar el océano a nado no le supone ningún esfuerzo."
            , "Abra duerme 18 horas al día, pero puede detectar a cualquier enemigo que se le acerque mientras duerme. En una situación así, usa Teletransporte para protegerse."
            , "Kadabra emite unas ondas alfa muy particulares que provocan dolores de cabeza a los demás. Solo aquellos que tengan gran poder mental podrán optar a ser Entrenador de este Pokémon."
            , "El cerebro de Alakazam nunca deja de crecer y por eso al cuello le cuesta sostener el peso de la cabeza. Este Pokémon usa sus poderes psicoquinéticos para sostener este peso."
            , "Gracias a su portentosa musculatura, Machop no se agota por mucho esfuerzo que haga. Este Pokémon es tan fuerte que puede derrotar a cien personas adultas de una sola vez."
            , "Los entrenados músculos de Machoke son tan fuertes como el acero. Este Pokémon es tan fuerte que puede levantar con un solo dedo a un luchador de sumo."
            , "Machamp es tan fuerte que puede derribar lo que quiera. Sin embargo, cuando tiene que realizar una tarea que requiere delicadeza y destreza, se le enredan los brazos. Este Pokémon pasa a la acción sin pensar."
            , "Bellsprout tiene un cuerpo delgado y flexible que le permite inclinarse y balancearse para esquivar los ataques. Este Pokémon escupe por la boca un fluido corrosivo capaz de hacer que se derrita hasta el hierro."
            , "Weepinbell tiene un gancho a modo de extremidad superior trasera, que usa por la noche para colgarse de una rama y echarse a dormir. Si se mueve mientras duerme, puede acabar en el suelo."
            , "Victreebel tiene una enredadera que le sale de la cabeza y que agita a modo de señuelo para atraer a sus presas y así engullirlas por sorpresa cuando estas se aproximan incautas."
            , "Tentacool está compuesto en su mayor parte por agua. Si se le saca del mar, se secará y se quedará acartonado. Si este Pokémon se deshidrata, hay que echarlo inmediatamente de vuelta al mar."
            , "Tentacruel tiene unas enormes esferas rojas en la cabeza, que brillan antes de lanzar una descarga ultrasónica a lo que le rodea. Este estallido crea unas olas tremendas a su alrededor."
            , "Cuanto más larga es la vida de Geodude, mayor es el desgaste y la erosión que sufre, y más redondeada la forma que va adquiriendo. Sin embargo, el corazón permanece siempre duro, rocoso y tosco."
            , "Graveler crece alimentándose a base de piedras. Y, según parece, las prefiere cubiertas de musgo. Cada día se abre camino comiéndose una tonelada de rocas."
            , "Golem vive en las montañas. Si se produce un gran terremoto, estos Pokémon descienden rodando en masa por las laderas."
            , "Al nacer, Ponyta es muy débil y apenas puede ponerse en pie. Con todo, se va haciendo más fuerte al tropezarse y caerse en su intento por seguir a sus progenitores."
            , "A Rapidash se le suele ver trotando sin rumbo fijo por los campos y llanos. Cuando tiene que ir a algún sitio en concreto, se le aviva el fuego de las melenas y emprende el galope llameante llegando a los 240 km/h."
            , "Slowpoke usa la cola para atrapar a sus presas metiéndola bajo el agua de los ríos a modo de caña de pescar. Con todo, es olvidadizo, se le puede pasar lo que estaba haciendo y quedarse días enteros holgazaneando en la orilla."
            , "Slowbro lleva en la cola un Shellder enganchado, sujeto por los dientes. Como Slowbro no puede usar la cola para pescar, se mete en el agua de mala gana en busca de sus presas."
            , "Magnemite se engancha a las líneas de tensión para nutrirse de electricidad. Cuando se producen apagones en las casas, es aconsejable revisar el automático y comprobar que no hay Pokémon de este tipo colgados de la caja de fusibles."
            , "Magneton emite una fuerte energía magnética que causa estragos en los instrumentos mecánicos. Por ello, en las ciudades se avisa con sirenas cuando hay concentraciones de estos Pokémon."
            , "Al parecer, entre los puerros que suelen llevar los Farfetch'd, los hay mejores y peores. A estos Pokémon se les ha visto luchar entre ellos por los mejores puerros."
            , "Las dos cabezas de Doduo duermen de forma independiente, siempre por turnos. Mientras una duerme, la otra hace de centinela por si aparecen enemigos."
            , "Según parece, las cabezas no son las únicas partes del cuerpo que tiene triplicadas. Dodrio también tiene tres corazones y tres pares de pulmones. Con esta constitución, puede correr largas distancias sin cansarse."
            , "Seel busca a sus presas en aguas heladas, bajo las capas de hielo. Cuando necesita respirar, abre un agujerito en el hielo con la afilada protuberancia que tiene encima de la cabeza."
            , "A Dewgong le encanta dormitar sobre la frialdad del hielo. Antiguamente, algún que otro marino lo confundió con una sirena al verlo dormido sobre un glaciar."
            , "El elástico cuerpo de lodo de Grimer le permite colarse por cualquier orificio, sea del tamaño que sea. Este Pokémon entra en los bajantes de las cloacas para beberse el agua sucia."
            , "Muk emana por todo el cuerpo un fluido maloliente que obliga a taparse la nariz. Con solo una gota de la sustancia que exuda este Pokémon, se podría contaminar un estanque."
            , "Por la noche, este Pokémon usa la ancha lengua que tiene para hacer un agujero en el fondo del mar y echarse a dormir. Mientras duerme, Shellder cierra la concha, pero deja la lengua por fuera."
            , "Cloyster es capaz de nadar por el mar. Su técnica consiste en tragar agua y expulsarla por el conducto que tiene en la parte trasera. Este mismo sistema es el que usa para lanzar los pinchos que tiene alrededor de la concha."
            , "Gastly está compuesto en gran medida de materia gaseosa. Cuando hay viento, el aire arrastra parte de esta materia y el Pokémon mengua. Suelen agruparse bajo los aleros de las casas para resguardarse del viento."
            , "Haunter es un Pokémon peligroso. Si se ve alguno flotando en la oscuridad y haciendo señas, conviene no acercarse. Este Pokémon intentará robarle la energía a su presa a base de lametazos."
            , "Si alguien ve que su sombra le adelanta de repente en una noche oscura, es muy probable que lo que esté viendo no sea su sombra, sino a un Gengar haciéndose pasar por la misma."
            , "Onix tiene un imán en el cerebro, que actúa como una brújula para no perder la orientación cuando está cavando túneles. A medida que crece, se le redondea y suaviza el cuerpo."
            , "Si a alguien le pica la nariz mientras duerme, seguro que es porque tiene a uno de estos Pokémon cerca de la almohada intentando sacarle los sueños por la nariz para comérselos."
            , "Hypno lleva un péndulo en la mano. El balanceo y el brillo que tiene sumen al rival en un estado de hipnosis profundo. Mientras busca a su presa, saca brillo al péndulo."
            , "Krabby vive en la playa, enterrado en agujeros en la arena. Cuando en las playas de arena fina escasea la comida, es común ver a estos Pokémon echando un pulso panza contra panza en defensa de su territorio."
            , "Kingler tiene una pinza enorme y descomunal que usa agitándola en el aire para comunicarse con otros. Lo malo es que, al pesarle tanto, se cansa enseguida."
            , "Voltorb fue visto por primera vez en una empresa encargada de comercializar Poké Balls. La conexión que existe entre aquella primera vez que se le vio y el hecho de que se parece mucho a una Poké Ball sigue siendo un misterio."
            , "Los Electrode se alimentan de la electricidad de la atmósfera. En días de tormenta con rayos, es fácil verlos explotando por todos lados tras haber consumido demasiada electricidad."
            , "Este Pokémon está compuesto de seis huevos que forman una tupida piña que va girando. Cuando se empiezan a resquebrajar las cáscaras, no hay duda de que Exeggcute está a punto de evolucionar."
            , "Exeggutor es originario del trópico. Cuando se expone a un sol intenso, le empiezan a crecer las cabezas. Hay quien dice que, cuando las cabezas caen al suelo, se unen para formar un Exeggcute."
            , "A Cubone le ahoga la pena porque no volverá a ver jamás a su madre. La luna le recuerda a veces a ella, y se pone a llorar. Los churretes que tiene en el cráneo que lleva puesto son debidos a las lágrimas que derrama."
            , "Marowak es la forma evolucionada de Cubone. Es más fuerte porque ha superado la pena por la pérdida de su madre. El ánimo de este Pokémon, ya curtido y fortalecido, no es muy fácil de alterar."
            , "Hitmonlee tiene la facilidad de encoger y estirar las patas. Con extremidades tan flexibles, propina unas patadas demoledoras. Tras la lucha, se masajea las piernas y relaja los músculos para descansar."
            , "Dicen que Hitmonchan tiene el mismo ímpetu que un boxeador entrenándose para un campeonato mundial. Este Pokémon tiene un espíritu indomable que nunca se doblega ante la adversidad."
            , "Cada vez que Lickitung se encuentra con algo que no conoce, le da un lametazo. Es la forma que tiene de memorizar las cosas, por la textura y el sabor. No soporta los sabores ácidos."
            , "Si Koffing se pone nervioso, aumenta el nivel de toxicidad de los gases que tiene y los expulsa por todo el cuerpo. También suele hincharse mucho hasta llegar a explotar."
            , "A Weezing le encantan los gases que emanan de los desperdicios que quedan en la cocina. Este Pokémon busca casas sucias y descuidadas para crear su hogar. De noche, cuando los habitantes de la casa duermen, va a por la basura."
            , "Rhyhorn corre en línea recta arrasando todo lo que encuentra en su camino. Aun estrellándose de cabeza contra un bloque de acero, no se vería afectado; a lo sumo, notaría algo de dolor al día siguiente."
            , "Rhydon tiene un cuerno capaz de horadar hasta un diamante en bruto y con una sacudida de la cola puede derribar un edificio. La piel de este Pokémon es muy fuerte; ni los disparos de un cañón le arañarían."
            , "Chansey pone a diario huevos con un valor nutritivo altísimo. Están tan ricos que hasta quien no tenga hambre se los comerá en un abrir y cerrar de ojos."
            , "A Tangela se le desprenden los tentáculos con facilidad en cuanto se los agarras. Y no solo no le duele, sino que le resulta muy útil para escapar rápido. Además, al día siguiente le crecen otros."
            , "No es recomendable molestar ni intentar atrapar a crías de Kangaskhan mientras estén jugando, ya que seguro que su madre anda cerca y reaccionará con enfado y violencia."
            , "Horsea come insectos pequeños y el musgo de las rocas. Si las corrientes del océano cobran fuerza, este Pokémon se anclará con la cola a rocas o corales para evitar que las aguas lo arrastren."
            , "Seadra se echa a dormir tras abrirse un hueco entre las ramas de los corales. Los pescadores de coral suelen pincharse con las púas venenosas de estos Pokémon si no los ven."
            , "Goldeen es un bello Pokémon que mueve con elegancia las aletas en el agua. Con todo, no hay que bajar la guardia, en cualquier momento puede embestir con el cuerno."
            , "En otoño, se ven ejemplares de Seaking macho danzando en las riberas de los ríos para cortejar a las hembras. En esta época, la coloración de este Pokémon alcanza sus niveles máximos de belleza."
            , "Staryu posee un órgano central, conocido como su núcleo, que brilla con una luz roja. A finales de verano, pueden verse en la playa los núcleos de estos Pokémon brillando como las estrellas del cielo."
            , "La parte central de Starmie, el núcleo brillante, resplandece con siete colores distintos. Debido a su naturaleza luminosa, a este Pokémon se le ha dado el apelativo de la Gema del Mar."
            , "Mr. Mime es un experto en pantomima. Con sus gestos y movimientos es capaz de convencer a sus espectadores de que algo existe, cuando en realidad no es así. Pero, cuando el público se lo cree, las ilusiones se hacen realidad."
            , "Es espectacular ver lo rápido que es Scyther. Su increíble velocidad refuerza el efecto del par de guadañas que tiene en los brazos, que ya son de por sí contundentes; rebanan gruesos troncos de un tajo."
            , "Jynx camina con ritmo, balanceándose y moviendo las caderas como si estuviera bailando. Realiza unos movimientos tan vistosos y atractivos que no hay quien pueda resistirse a su encanto."
            , "Al desatarse una tormenta, bandadas de estos Pokémon se enfrentan entre sí para ver quién alcanza antes sitios altos en los que suelan caer rayos. Hay ciudades que usan Electabuzz en lugar de pararrayos."
            , "Al luchar, Magmar expulsa violentas llamas por todo el cuerpo para intimidar a su rival. Estos estallidos de fuego crean ondas de calor que abrasan la hierba y los árboles que haya en las proximidades."
            , "Pinsir es sorprendentemente fuerte. Puede agarrar con los cuernos a un rival que pese el doble que él y levantarlo por los aires. En zonas frías, los movimientos de este Pokémon se vuelven lentos."
            , "Este Pokémon no está contento a menos que esté continuamente de aquí para allá. Si no hay rival que luche contra Tauros, se estampa contra árboles grandes para calmarse y los embiste para echarlos abajo."
            , "Magikarp es el triste ejemplo de un Pokémon capaz únicamente de saltar y salpicar. Esta conducta llevó a científicos a estudiarlo en profundidad."
            , "Cuando Magikarp evoluciona y se convierte en Gyarados, sufre un cambio estructural en las células del cerebro. Dicen que esa transformación es la causa de la naturaleza violenta y salvaje de este Pokémon."
            , "Por culpa de la gente, Lapras está casi en extinción. Dicen que, al anochecer, se pone a cantar quejicoso mientras busca a los miembros de su especie que puedan quedar."
            , "Ditto reorganiza la estructura de sus células para adoptar otras formas. Pero, como intente transformarse en algo guiándose por los datos que tenga almacenados en la memoria, habrá detalles que se le escapen."
            , "La configuración genética de Eevee le permite mutar y adaptarse enseguida a cualquier medio en el que viva. La evolución de este Pokémon suele ser posible gracias a las radiaciones emitidas por varias piedras."
            , "Vaporeon sufrió una mutación repentina y desarrolló aletas y branquias que le permiten vivir bajo el agua. Asimismo, este Pokémon tiene la habilidad de controlar las aguas."
            , "Las células de Jolteon generan un nivel bajo de electricidad, cuya intensidad aumenta con la electricidad estática que acumula en un pelaje formado por agujas cargadas de electricidad. Esta característica le permite lanzar rayos."
            , "La suavidad del pelaje de Flareon tiene una función clara: libera calor para que el Pokémon no se asfixie. La temperatura corporal de este Pokémon puede alcanzar los 900 °C."
            , "Porygon es capaz de convertirse otra vez en datos informáticos y de entrar en el ciberespacio. Tiene protección anticopia, así que es imposible duplicarlo."
            , "Omanyte es uno de esos Pokémon ancestrales que se extinguieron hace muchísimo tiempo y que la gente ha recuperado a partir de fósiles. Si un enemigo le ataca, se esconderá dentro de la dura concha que tiene."
            , "Omastar usa los tentáculos para atrapar a su presa. Se cree que el motivo de su extinción fue el tamaño y el peso que llegó a alcanzar la concha que lleva a cuestas, lo que le entorpeció y ralentizó los movimientos."
            , "Kabuto es un Pokémon regenerado a partir de un fósil, aunque, en raras ocasiones, se han encontrado casos de ejemplares vivos en estado salvaje. En 300 millones de años, este Pokémon no ha cambiado en nada."
            , "Hace mucho tiempo, Kabutops buceaba para atrapar a sus presas. Parece ser que en algún momento cambió de hábitat y se adaptó a vivir en tierra firme. La transformación que se aprecia en las patas y branquias así lo confirma."
            , "Los orígenes de Aerodactyl datan de la era de los dinosaurios. Se regeneró a partir de material genético contenido en ámbar. Se supone que fue el amo de los cielos en épocas pasadas."
            , "Un día cualquiera en la vida de Snorlax consiste en comer y dormir. Es un Pokémon tan dócil que es fácil ver niños usando la gran panza que tiene como lugar de juegos."
            , "Articuno es un Pokémon pájaro legendario que puede controlar el hielo. El batir de sus alas congela el aire. Dicen que consigue hacer que nieve cuando vuela."
            , "Zapdos es un Pokémon pájaro legendario que tiene la habilidad de controlar la electricidad. Suele vivir en nubarrones. Este Pokémon gana mucha fuerza si le alcanzan los rayos."
            , "Moltres es un Pokémon pájaro legendario que tiene la habilidad de controlar el fuego. Dicen que, si resulta herido, se sumerge en el líquido magma de un volcán para arder y curarse."
            , "Dratini muda y se despoja de la vieja piel continuamente. Es algo que necesita hacer porque la energía que tiene en su interior no para de alcanzar niveles incontrolables."
            , "Dragonair acumula grandes cantidades de energía dentro de sí. Dicen que altera el clima de la zona en la que está descargando energía a través de las esferas de cristal que tiene en el cuello y en la cola."
            , "Dragonite es capaz de dar la vuelta al mundo en solo 16 horas. Es un Pokémon de buen corazón que guía hasta tierra a los barcos que se encuentran perdidos en plena tormenta y a punto de zozobrar."
            , "Mewtwo fue creado por manipulación genética. Pero, a pesar de que el hombre creó su cuerpo, dotar a Mewtwo de un corazón compasivo quedó en el olvido."
            , "Dicen que Mew posee el mapa genético de todos los Pokémon. Puede hacerse invisible cuando quiere, así que pasa desapercibido cada vez que se le acerca alguien."


    };
    String[] p_nombre_pokemon = {"001.Bulbasaur", "002.Ivysaur", "003.Venusaur", "004.Charmander", "005.Charmeleon", "006.Charizard", "007.Squirtle", "008.Wartortle", "009.Blastoise", "010.Caterpie",
            "011.Metapod", "012.Butterfree", "013.Weedle", "014.Kakuna", "015.Beedrill", "016.Pidgey", "017.Pidgeotto", "018.Pidgeot", "019.Rattata", "020.Raticate", "021.Spearow", "022.Fearow", "023.Ekans",
            "024.Arbok", "025.Pikachu", "026.Raichu", "027.Sandshrew", "028.Sandslash", "029.Nidoran", "030.Nidorina", "031.Nidoqueen", "032.Nidoran", "033.Nidorino", "034.Nidoking", "035.Clefairy", "036.Clefable",
            "037.Vulpix", "038.Ninetales", "039.Jigglypuff", "040.Wigglytuff", "041.Zubat", "042.Golbat", "043.Oddish", "044.Gloom", "045.Vileplume", "046.Paras", "047.Parasect", "048.Venonat", "049.Venomoth",
            "050.Diglett", "051.Dugtrio", "052.Meowth", "053.Persian", "054.Psyduck", "055.Golduck", "056.Mankey", "057.Primeape", "058.Growlithe", "059.Arcanine", "060.Poliwag", "061.Poliwhirl", "062.Poliwrath",
            "063.Abra", "064.Kadabra", "065.Alakazam", "066.Machop", "067.Machoke", "068.Machamp", "069.Bellsprout", "070.Weepinbell", "071.Victreebel", "072.Tentacool", "073.Tentacruel", "074.Geodude", "075.Graveler",
            "076.Golem", "077.Ponyta", "078.Rapidash", "079.Slowpoke", "080.Slowbro", "081.Magnemite", "082.Magneton", "083.Farfetch'd", "084.Doduo", "085.Dodrio", "086.Seel", "087.Dewgong", "088.Grimer", "089.Muk", "090.Shellder",
            "091.Cloyster", "092.Gastly", "093.Haunter", "094.Gengar", "095.Onix", "096.Drowzee", "097.Hypno", "098.Krabby", "099.Kingler", "100.Voltorb", "101.Electrode", "102.Exeggcute", "103.Exeggutor", "104.Cubone", "105.Marowak",
            "106.Hitmonlee", "107.Hitmonchan", "108.Lickitung", "109.Koffing", "110.Weezing", "111.Rhyhorn", "112.Rhydon", "113.Chansey", "114.Tangela", "115.Kangaskhan", "116.Horsea", "117.Seadra", "118.Goldeen", "119.Seaking",
            "120.Staryu", "121.Starmie", "122.Mr.Mime", "123.Scyther", "124.Jynx", "125.Electabuzz", "126.Magmar", "127.Pinsir", "128.Tauros", "129.Magikarp", "130.Gyarados", "131.Lapras", "132.Ditto", "133.Eevee", "134.Vaporeon",
            "135.Jolteon", "136.Flareon", "137.Porygon", "138.Omanyte", "139.Omastar", "140.Kabuto", "141.Kabutops", "142.Aerodactyl", "143.Snorlax", "144.Articuno", "145.Zapdos", "146.Moltres", "147.Dratini", "148.Dragonair", "149.Dragonite",
            "150.Mewtwo", "151.Mew"
    };

    private int[] imagenBuena = {
            R.drawable.bulbasaur, R.drawable.ivysaur, R.drawable.venusaur, R.drawable.charmander, R.drawable.charmeleon,
            R.drawable.charizard, R.drawable.squirtle, R.drawable.wartortle, R.drawable.blastoise, R.drawable.caterpie,
            R.drawable.metapod, R.drawable.butterfree, R.drawable.weedle, R.drawable.kakuna, R.drawable.beedrill,
            R.drawable.pidgey, R.drawable.pidgeotto, R.drawable.pidgeot, R.drawable.rattata, R.drawable.raticate,
            R.drawable.spearow, R.drawable.fearow, R.drawable.ekans, R.drawable.arbok, R.drawable.pikachu, R.drawable.raichu,
            R.drawable.sandshrew, R.drawable.sandslash, R.drawable.nidorann, R.drawable.nidorina, R.drawable.nidoqueen,
            R.drawable.nidoran, R.drawable.nidorino, R.drawable.nidoking, R.drawable.clefairy, R.drawable.clefable,
            R.drawable.vulpix, R.drawable.ninetales, R.drawable.jigglypuff, R.drawable.wigglytuff, R.drawable.zubat,
            R.drawable.golbat, R.drawable.oddish, R.drawable.gloom, R.drawable.vileplume, R.drawable.paras, R.drawable.parasect,
            R.drawable.venonat, R.drawable.venomoth, R.drawable.diglett, R.drawable.dugtrio, R.drawable.meowth, R.drawable.persian,
            R.drawable.psyduck, R.drawable.golduck, R.drawable.mankey, R.drawable.primeape, R.drawable.growlithe, R.drawable.arcanine,
            R.drawable.poliwag, R.drawable.poliwhirl, R.drawable.poliwrath, R.drawable.abra, R.drawable.kadabra, R.drawable.alakazam,
            R.drawable.machop, R.drawable.machoke, R.drawable.machamp, R.drawable.bellsprout, R.drawable.weepinbell,
            R.drawable.victreebel, R.drawable.tentacool, R.drawable.tentacruel, R.drawable.geodude, R.drawable.graveler, R.drawable.golem,
            R.drawable.ponyta, R.drawable.rapidash, R.drawable.slowpoke, R.drawable.slowbro, R.drawable.magnemite, R.drawable.magneton,
            R.drawable.farfetchd, R.drawable.doduo, R.drawable.dodrio, R.drawable.seel, R.drawable.dewgong, R.drawable.grimer,
            R.drawable.muk, R.drawable.shellder, R.drawable.cloyster, R.drawable.gastly, R.drawable.haunter, R.drawable.gengar,
            R.drawable.onix, R.drawable.drowzee, R.drawable.hypno, R.drawable.krabby, R.drawable.kingler, R.drawable.voltorb,
            R.drawable.electrode, R.drawable.exeggcute, R.drawable.exeggutor, R.drawable.cubone, R.drawable.marowak, R.drawable.hitmonlee,
            R.drawable.hitmonchan, R.drawable.lickitung, R.drawable.koffing, R.drawable.weezing, R.drawable.rhyhorn, R.drawable.rhydon,
            R.drawable.chansey, R.drawable.tangela, R.drawable.kangaskhan, R.drawable.horsea, R.drawable.seadra, R.drawable.goldeen,
            R.drawable.seaking, R.drawable.staryu, R.drawable.starmie, R.drawable.mr_mime, R.drawable.scyther, R.drawable.jynx,
            R.drawable.electabuzz, R.drawable.magmar, R.drawable.pinsir, R.drawable.tauros, R.drawable.magikarp, R.drawable.gyarados,
            R.drawable.lapras, R.drawable.ditto, R.drawable.eevee, R.drawable.vaporeon, R.drawable.jolteon, R.drawable.flareon,
            R.drawable.porygon, R.drawable.omanyte, R.drawable.omastar, R.drawable.kabuto, R.drawable.kabutops, R.drawable.aerodactyl,
            R.drawable.snorlax, R.drawable.articuno, R.drawable.zapdos, R.drawable.moltres, R.drawable.dratini, R.drawable.dragonair,
            R.drawable.dragonite, R.drawable.mewtwo, R.drawable.mew
    };

    int[] imagenes = {
            R.drawable.pbulbasaur, R.drawable.pivysaur, R.drawable.pvenusaur, R.drawable.pcharmander, R.drawable.pcharmeleon, R.drawable.pcharizard,
            R.drawable.psquirtle, R.drawable.pwartortle, R.drawable.pblastoise, R.drawable.pcaterpie, R.drawable.pmetapod, R.drawable.pbutterfree,
            R.drawable.pweedle, R.drawable.pkakuna, R.drawable.pbeedrill, R.drawable.ppidgey, R.drawable.ppidgeotto, R.drawable.ppidgeot,
            R.drawable.prattata, R.drawable.praticate, R.drawable.pspearow, R.drawable.pfearow, R.drawable.pekans, R.drawable.parbok, R.drawable.ppikachu,
            R.drawable.praichu, R.drawable.psandshrew, R.drawable.psandslash, R.drawable.pnidoran, R.drawable.pnidorina, R.drawable.pnidoqueen,
            R.drawable.pnidorann, R.drawable.pnidorino, R.drawable.pnidoking, R.drawable.pclefairy, R.drawable.pclefable, R.drawable.pvulpix,
            R.drawable.pninetales, R.drawable.pjigglypuff, R.drawable.pwigglytuff, R.drawable.pzubat, R.drawable.pgolbat, R.drawable.poddish,
            R.drawable.pgloom, R.drawable.pvileplume, R.drawable.pparas, R.drawable.pparasect, R.drawable.pvenonat, R.drawable.pvenomoth,
            R.drawable.pdiglett, R.drawable.pdugtrio, R.drawable.pmeowth, R.drawable.ppersian, R.drawable.ppsyduck, R.drawable.pgolduck,
            R.drawable.pmankey, R.drawable.pprimeape, R.drawable.pgrowlithe, R.drawable.parcanine, R.drawable.ppoliwag, R.drawable.ppoliwhirl,
            R.drawable.ppoliwrath, R.drawable.pabra, R.drawable.pkadabra, R.drawable.palakazam, R.drawable.pmachop, R.drawable.pmachoke,
            R.drawable.pmachamp, R.drawable.pbellsprout, R.drawable.pweepinbell, R.drawable.pvictreebel, R.drawable.ptentacool, R.drawable.ptentacruel,
            R.drawable.pgeodude, R.drawable.pgraveler, R.drawable.pgolem, R.drawable.pponyta, R.drawable.prapidash, R.drawable.pslowpoke,
            R.drawable.pslowbro, R.drawable.pmagnemite, R.drawable.pmagneton, R.drawable.pfarfetch_d, R.drawable.pdoduo, R.drawable.pdodrio, R.drawable.pseel,
            R.drawable.pdewgong, R.drawable.pgrimer, R.drawable.pmuk, R.drawable.pshellder, R.drawable.pcloyster, R.drawable.pgastly, R.drawable.phaunter,
            R.drawable.pgengar, R.drawable.ponix, R.drawable.pdrowzee, R.drawable.phypno, R.drawable.pkrabby, R.drawable.pkingler, R.drawable.pvoltorb,
            R.drawable.pelectrode, R.drawable.pexeggcute, R.drawable.pexeggutor, R.drawable.pcubone, R.drawable.pmarowak, R.drawable.phitmonlee,
            R.drawable.phitmonchan, R.drawable.plickitung, R.drawable.pkoffing, R.drawable.pweezing, R.drawable.prhyhorn, R.drawable.prhydon,
            R.drawable.pchansey, R.drawable.ptangela, R.drawable.pkangaskhan, R.drawable.phorsea, R.drawable.pseadra, R.drawable.pgoldeen, R.drawable.pseaking,
            R.drawable.pstaryu, R.drawable.pstarmie, R.drawable.pmr_mime, R.drawable.pscyther, R.drawable.pjynx, R.drawable.pelectabuzz, R.drawable.pmagmar,
            R.drawable.ppinsir, R.drawable.ptauros, R.drawable.pmagikarp, R.drawable.pgyarados, R.drawable.plapras, R.drawable.pditto, R.drawable.peevee,
            R.drawable.pvaporeon, R.drawable.pjolteon, R.drawable.pflareon, R.drawable.pporygon, R.drawable.pomanyte, R.drawable.pomastar, R.drawable.pkabuto,
            R.drawable.pkabutops, R.drawable.paerodactyl, R.drawable.psnorlax, R.drawable.particuno, R.drawable.pzapdos, R.drawable.pmoltres, R.drawable.pdratini,
            R.drawable.pdragonair, R.drawable.pdragonite, R.drawable.pmewtwo, R.drawable.pmew
    };

    private Pokemon pokemon;
    private MediaPlayer pokemon_theme;
    private SoundPool mySound;
    private int soundId;
    private boolean todoOk = false;

    private boolean quiereMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        getSupportActionBar().hide();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mySound = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
        soundId = mySound.load(this, R.raw.sonido_boton, 1);


        Bundle param = getIntent().getExtras();
        if( param!= null) {
            pokemon_pokedex = param.getString("pokemon_pokedex");
            quiereMusica = param.getBoolean("musica");
        }

        pokemon_theme = MediaPlayer.create(this, R.raw.pokemon_theme);
        if(quiereMusica) {
            pokemon_theme.setLooping(true);
            pokemon_theme.start();
        }
        pokemon = new Pokemon(0);


        if(!pokemon_pokedex.equals(""))
            pokemonsRegistrados();

        final ListView lista = (ListView) findViewById(R.id.listView);
        lista_pokedex = new ListViewAdapter(this, pokemon_pokedex, p_pokedex, p_nombre_pokemon, imagenes);
        lista.setAdapter(lista_pokedex);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(!p_pokedex[position]) {
                    mostrarDialogPokedex(1000);
                }
                else {
                    pokemon.ActualizarPokemon(position);
                    mostrarDialogPokedex(position);
                }
            }
        });

    }

    protected void onDestroy() {
        super.onDestroy();
        if(pokemon_theme.isPlaying()) {
            pokemon_theme.stop();
            pokemon_theme.release();
        }
    }

    protected void onPause() {
        super.onPause();
        pokemon_theme.pause();
    }

    protected void onResume() {
        super.onResume();
        if(quiereMusica) {
            pokemon_theme.seekTo(0);
            pokemon_theme.start();
        }
    }

    public void pokemonsRegistrados(){

        String [] campos = pokemon_pokedex.split("\\s+");
        int j = 0, poke;

        for (int i = 0; i < 151; i++){
            p_pokedex[i] = false;
        }

        while(j < campos.length){
            poke = setIntBooleanos(campos[j]);
            if(todoOk)
                p_pokedex[poke] = true;
            j++;
        }
    }

    public int setIntBooleanos(String campo){

        int i = 0;
        boolean encontrado = false;
        String nombre;

        while(i < p_nombre_pokemon.length && !encontrado) {

            nombre = p_nombre_pokemon[i].substring(4);

            if(campo.equalsIgnoreCase(nombre)) {
                encontrado = true;
                todoOk = true;
            }
            else {
                    i++;
            }
        }

        if(campo.equalsIgnoreCase("Nidoran2")){
            encontrado = true;
            i = 31;
        }
        if(!encontrado)
            todoOk = false;

        return i;
    }

    public void mostrarDialogPokedex(int posicion){
        final Dialog customDialog = new Dialog(this);
        //deshabilitamos el título por defecto
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //obligamos al usuario a pulsar los botones para cerrarlo
        customDialog.setCancelable(false);
        //establecemos el contenido de nuestro dialog
        customDialog.setContentView(R.layout.dialog_pokedex2);

        if(posicion == 1000){

            ((TextView) customDialog.findViewById(R.id.textView30)).setText("???");
            ((TextView) customDialog.findViewById(R.id.textView32)).setText("??? " + " m");
            ((TextView) customDialog.findViewById(R.id.textView36)).setText("??? " + " kg");
            ((TextView) customDialog.findViewById(R.id.textView37)).setText("Tipo:");
            ((TextView) customDialog.findViewById(R.id.textView38)).setText("???");
            ((TextView) customDialog.findViewById(R.id.textView20)).setText("");
            ((TextView) customDialog.findViewById(R.id.textView21)).setText("");
            ((ImageView) customDialog.findViewById(R.id.imageView14)).setImageResource(R.drawable.cat0);
            ((ImageView) customDialog.findViewById(R.id.imageView19)).setImageResource(R.drawable.cat0);

        } else {


            ((TextView) customDialog.findViewById(R.id.textView30)).setText(p_nombre_pokemon[posicion]);
            ((TextView) customDialog.findViewById(R.id.textView32)).setText(altura[posicion] + " m");
            ((TextView) customDialog.findViewById(R.id.textView36)).setText(peso[posicion] + " kg");

            if (pokemon.getTipo2().equalsIgnoreCase(""))
                ((TextView) customDialog.findViewById(R.id.textView37)).setText("Tipo:");
            else
                ((TextView) customDialog.findViewById(R.id.textView37)).setText("Tipos:");

            ((TextView) customDialog.findViewById(R.id.textView38)).setText(pokemon.getTipo1());
            ((TextView) customDialog.findViewById(R.id.textView20)).setText(pokemon.getTipo2());
            ((TextView) customDialog.findViewById(R.id.textView21)).setText(descripcion[posicion]);
            ((ImageView) customDialog.findViewById(R.id.imageView14)).setImageResource(imagenBuena[posicion]);

            if (pokemon.getEvolucion()) {

                if(pokemon.getNombre_pokemon().equalsIgnoreCase("jolteon"))
                    ((ImageView) customDialog.findViewById(R.id.imageView19)).setImageResource(imagenes[posicion - 2]);
                else {
                    if (pokemon.getNombre_pokemon().equalsIgnoreCase("flareon"))
                        ((ImageView) customDialog.findViewById(R.id.imageView19)).setImageResource(imagenes[posicion - 3]);
                    else
                        ((ImageView) customDialog.findViewById(R.id.imageView19)).setImageResource(imagenes[posicion - 1]);
                }
            } else
                ((ImageView) customDialog.findViewById(R.id.imageView19)).setImageResource(R.drawable.guion);
        }

        (customDialog.findViewById(R.id.btnAceptar5000)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                mySound.play(soundId, 1, 1, 1, 0, 2);
                customDialog.dismiss();
            }
        });

        customDialog.show();
    }

}
