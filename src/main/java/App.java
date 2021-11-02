import dao.Sql2oHeroDao;
import models.Hero;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        String connectionString = "jdbc:h2:~/hero.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString,"","");
        Sql2oHeroDao heroDao = new Sql2oHeroDao(sql2o);

        //show all heros
        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> heros = heroDao.getAllHeros();
            model.put("heros",heros);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

        //show new hero form
        get("/heros/new",(request,response)->{
            Map<String,Object>model = new HashMap<>();
            return new ModelAndView(model,"new-hero.hbs");
        },new HandlebarsTemplateEngine());

        //process new hero
        post("/heros",(request,response)->{
            Map<String,Object>model = new HashMap<>();
            String heroName = request.queryParams("heroName");
            int heroAge = Integer.parseInt(request.queryParams("heroAge"));
            String heroPower = request.queryParams("heroPower");
            String heroWeakness = request.queryParams("heroWeakness");
            String avatarUrl = request.queryParams("avatarUrl");
            Hero newHero = new Hero(heroName,heroAge,heroPower,heroWeakness,avatarUrl);
            heroDao.addHero(newHero);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //display a single hero
        get("/heros/:id",(request,response)->{
            Map<String,Object>model = new HashMap<>();
            int heroId = Integer.parseInt(request.params("id"));
            Hero foundHero = heroDao.findHeroById(heroId);
            model.put("hero",foundHero);
            return new ModelAndView(model,"hero-details.hbs");
        },new HandlebarsTemplateEngine());

    }
}
