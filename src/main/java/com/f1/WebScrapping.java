package com.f1;

import com.f1.models.Piloto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WebScrapping {

    List<Piloto> pilotos = new ArrayList<Piloto>();
    static final String DB_URL = "jdbc:mysql://localhost:3306/formula1";
    static final String USER = "root";
    static final String PASS = "151000_Ph";

    public void scraping(){
        //Elements aspirantes = getHTML("https://www.rtve.es/television/masterchef/").select("div.mod notic_mod txtsize_03 show_mid");

        Elements podiumDrivers = getHTML("https://www.formula1.com/en/drivers.html").getElementsByClass("col-12 col-md-6 col-lg-4 image-center");
        checkElements(podiumDrivers);
        Elements drivers = getHTML("https://www.formula1.com/en/drivers.html").getElementsByClass("col-12 col-md-6 col-lg-4 col-xl-3");
        checkElements(drivers);
        insertDrivers(pilotos);
    }

    private void insertDrivers(List<Piloto> pilotos) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String deleteDrivers = "DELETE FROM formula1.drivers;";
            String resetAutoIncrement = "ALTER TABLE formula1.drivers AUTO_INCREMENT = 1;";
            stmt.executeUpdate(deleteDrivers);
            stmt.executeUpdate(resetAutoIncrement);
            System.out.println("Tabla de drivers vaciada");
            // Execute a query
            for(Piloto pil : pilotos){
                System.out.println("Inserting records into the table...");
                String sql = "INSERT INTO formula1.drivers(name, image, team, driver_number, biography, birth_date, country, country_flag, driver_number_url, helmet, highest_result, podiums, world_championships, image_detail) VALUES ('"+pil.getName()+"', '"+pil.getImage()+"', '"+ pil.getTeam()+"', "+pil.getDriverNumber()+", \""+pil.getBiography()+"\", '"+pil.getBirthDate()+"', '"+pil.getCountry()+"', '"+pil.getCountryFlag()+"', '"+pil.getDriverNumberUrl()+"', '"+pil.getHelmet()+"', '"+pil.getHighestResult()+"', "+pil.getPodiums()+", '"+pil.getWorldChampionships()+"', '"+pil.getImageDetail()+"');";
                stmt.executeUpdate(sql);
                System.out.println("Inserted records into the table...");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Document getHTML(String url){
        Document html = null;
        try {
            html = Jsoup.connect(url).timeout(100000).get();
        }catch (Exception e){
            System.out.println("ERROR");
        }
        return html;
    }

    public void checkElements(Elements elements){

        HashMap<String, String> driversGif = new HashMap<>();
        driversGif.put("Max Verstappen", "max-verstappen.gif");
        driversGif.put("Sergio Perez", "sergio-perez.gif");
        driversGif.put("Charles Leclerc", "charles-leclerc.gif");
        driversGif.put("Carlos Sainz", "carlos-sainz.gif");
        driversGif.put("Fernando Alonso", "fernando-alonso.gif");
        driversGif.put("Lance Stroll", "lance-stroll.gif");
        driversGif.put("Lewis Hamilton", "lewis-hamilton.gif");
        driversGif.put("George Russell", "george-russell.gif");
        driversGif.put("Lando Norris", "lando-norris.gif");
        driversGif.put("Oscar Piastri", "oscar-piastri.gif");
        driversGif.put("Esteban Ocon", "esteban-ocon.gif");
        driversGif.put("Pierre Gasly", "pierre-gasly.gif");
        driversGif.put("Yuki Tsunoda", "yuki-tsunoda.gif");
        driversGif.put("Nyck De Vries", "nyck-de-vries.gif");
        driversGif.put("Valtteri Bottas", "valtteri-bottas.gif");
        driversGif.put("Guanyu Zhou", "guanyu-zhou.gif");
        driversGif.put("Alexander Albon", "alexander-albon.gif");
        driversGif.put("Logan Sargeant", "logan-sargeant.gif");
        driversGif.put("Kevin Magnussen", "kevin-magnussen.gif");
        driversGif.put("Nico Hulkenberg", "nico-hulkenberg.gif");

        for(Element driver : elements){
            try {
                String url = "https://www.formula1.com"+driver.select("a").attr("href");
                String fullName = driver.select("span.d-block").text();
                String img = driver.select("picture.listing-item--photo").select("img").attr("data-src");
                String driverNumberUrl = driver.select("picture.listing-item--number").select("img").attr("data-src");
                String imageDetail = driversGif.get(fullName);

                String team = "";
                String country = "";
                String countryFlag = "";
                String helmet = "";
                String biography = "";
                String birthDate = "";
                int podiums = 0;
                String highestResult = "";
                String worldChampionships = "";
                int driverNumber = 0;

                Document driverStats = getHTML(url);

                Elements stats = driverStats.select("section.stats");
                Elements biographyElements = driverStats.select("section.biography");

                countryFlag = driverStats.select("span.icn-flag").select("img").attr("src");

                for(Element e : biographyElements){
                    biography += (e.select("div.text").select("p").text()+"\r\n");
                }

                for(Element el : stats){
                    helmet = el.select("div.brand-logo").select("img").attr("src");
                }

                Elements ds = driverStats.select("tr");

                for(Element e : ds){
                    switch (e.select("span").text()){
                        case "Team":
                            team = e.select("td.stat-value").text();
                            break;

                        case "Country":
                            country = e.select("td.stat-value").text();
                            break;

                        case "Podiums":
                            String result = e.select("td.stat-value").text();
                            if(!result.equals("N/A")){
                                podiums = Integer.parseInt(result);
                            }else {
                                podiums = 0;
                            }
                            break;

                        case "World Championships":
                            worldChampionships = e.select("td.stat-value").text();
                            break;

                        case "Highest race finish":
                            highestResult = e.select("td.stat-value").text();
                            break;

                        case "Date of birth":
                            birthDate = e.select("td.stat-value").text();
                            break;
                    }
                }

                driverNumber = Integer.parseInt(driverStats.select("div.driver-number").text());

                Piloto p = new Piloto();

                p.setName(fullName);
                p.setImage(img);
                p.setTeam(team);
                p.setDriverNumber(driverNumber);
                p.setCountry(country);
                p.setCountryFlag(countryFlag);
                p.setBiography(biography);
                p.setHelmet(helmet);
                p.setDriverNumberUrl(driverNumberUrl);
                p.setWorldChampionships(worldChampionships);
                p.setBirthDate(birthDate);
                p.setPodiums(podiums);
                p.setHighestResult(highestResult);
                p.setImageDetail(imageDetail);

                pilotos.add(p);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

}
