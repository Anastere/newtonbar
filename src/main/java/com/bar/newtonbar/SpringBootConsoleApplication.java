package com.bar.newtonbar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootConsoleApplication {

    private static final Logger LOGGER = LogManager.getLogger(SpringBootConsoleApplication.class);

    public static void main(String[] args) {
        LOGGER.info("STARTING THE APPLICATION");
        SpringApplication.run(SpringBootConsoleApplication.class, args);
        LOGGER.info("APPLICATION FINISHED");
    }

//    @Bean
//    public CommandLineRunner demo(CocktailRepository cocktailRepository) {
//        return (args) -> {
//            Console console = System.console();
//            String cocktailName = console.readLine("Enter cocktail name: ");
//            double cocktailPrice = Double.parseDouble(console.readLine("Enter cocktail price: "));
//            LOGGER.info("Cocktail name: " + cocktailName);
//            LOGGER.info("Cocktail price: " + cocktailPrice);
//        };
//    }



//    String recipe = "{\n" +
//            "    \"rum\": 50,\n" +
//            "    \"pineapple juice\": 90,\n" +
//            "    \"coconut milk\": 30,\n" +
//            "    \"ice\": 50,\n" +
//            "    \"cream\": 20\n" +
//            "}";
//    String margRecipe = "{\n" +
//            "    \"silver tequila\": 50,\n" +
//            "    \"triple sec liquor\": 25,\n" +
//            "    \"sugar syrup\": 10,\n" +
//            "    \"ice\": 200,\n" +
//            "    \"lime juice\": 30,\n" +
//            "    \"lime\": 10,\n" +
//            "    \"salt\": 2\n" +
//            "}";
//    Cocktail pina_colada = new Cocktail("pina colada", 10, recipe);
//    Cocktail margarita = new Cocktail("margarita", 12, margRecipe);
//            LOGGER.info("ID: " + pina_colada.getId());
//            cocktailRepository.save(pina_colada);
//            cocktailRepository.save(margarita);
//            LOGGER.info("REPOSITORY: " + cocktailRepository);
//            for (Cocktail cocktail : cocktailRepository.findAll()) {
//        LOGGER.info(cocktail);
//    }

//
//
//    @Override
//    public void run(String... args) throws Exception {
//        Console console = System.console();
//        String cocktailName = console.readLine("Enter cocktail name: ");
//        double cocktailPrice = Double.parseDouble(console.readLine("Enter cocktail price: "));
//        LOGGER.info("Cocktail name: " + cocktailName);
//        LOGGER.info("Cocktail price: " + cocktailPrice);
//
//    }
}
