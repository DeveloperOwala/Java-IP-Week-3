import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

/**
 * Authored by @erickokumu
 **
 */
public class App {

    // I hope you know this method is used when deploying to server :Heroku

    public static void main(String[] args) { //type “psvm + tab” to autocreate this
        // directing the server to immediate files it should access. Just like index
        staticFileLocation("/public");


        // routes as per their handlebars templates. Make sure to read and understand what they do
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animalnew", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animalForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangerednew", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return modelAndView(model,"endangeredForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightingsnew", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return modelAndView(model,"sightingsForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List peter = Endangered.relative_All();
            System.out.println(peter.get(0));
            model.put("endangered", peter);
            return modelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine());


        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return modelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/saved", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List sightings = Sightings.retrieveFromSightings();
            model.put("sightings", sightings);
            return new ModelAndView(model,"sight.hbs");
        }, new HandlebarsTemplateEngine());


        get("/newanimal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List animal = Animal.relative_All();
            model.put("animals", animal);
            return new ModelAndView(model, "wildlife.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/:id/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animal", Animal.find(Integer.parseInt(request.params(":id"))));
            return new ModelAndView(model, "editForm.hbs");
        }, new HandlebarsTemplateEngine());


        get("/animals/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Animal.find(Integer.parseInt(request.params(":id"))).delete();
            response.redirect("/animals");
            return null;
        }, new HandlebarsTemplateEngine());


        post("/animals/:id/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int id = Integer.parseInt(request.params(":id"));
            String name = request.queryParams("name");
            Animal animal = Animal.find(id);
            animal.setName(name);
            animal.update();
            return new ModelAndView(model, "ess.hbs");
        }, new HandlebarsTemplateEngine());


        post("/succ", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String animalname = req.queryParams("animalname");
            String rangername = req.queryParams("ranger");
            String location = req.queryParams("location");
            Sightings sightings = new Sightings(animalname,rangername,location);
            sightings.save();
            model.put("sightings", sightings);
            return modelAndView(model, "succ.hbs");
        }, new HandlebarsTemplateEngine());



        //post methods
        post("/success", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String health = req.queryParams("health");
            String age = req.queryParams("age");
            Endangered endangered = new Endangered(name, health, age);
            endangered.save();
            System.out.println("Please enter all input fields.");
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/wildlife", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            Animal animal = new Animal(name);
            animal.save();
            return new ModelAndView(model,"ess.hbs");
        }, new HandlebarsTemplateEngine());
    }

    }
