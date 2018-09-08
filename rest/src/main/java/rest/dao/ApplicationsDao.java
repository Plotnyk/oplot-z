package rest.dao;


//import org.springframework.stereotype.Component;
import rest.model.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class ApplicationsDao {

    private static Map<Long, List<Application>> applicationsByCategory;

    public static final long TOOLS_ID = 2L;
    public static final long GAMES_ID = 1L;

    {
        applicationsByCategory = new HashMap<>();

        List<Application> gamesList = new ArrayList<>();
        gamesList.add(new Application(1L, GAMES_ID, "Doom", "com.games.doom", "picture128", "picture512"));
        gamesList.add(new Application(2L, GAMES_ID, "Starcraft", "com.games.blizzard", "picture128", "picture512"));
        gamesList.add(new Application(3L, GAMES_ID, "Mario", "com.games.mario", "picture128", "picture512"));
        gamesList.add(new Application(4L, GAMES_ID, "Pacman", "com.games.pacman", "picture128", "picture512"));
        gamesList.add(new Application(5L, GAMES_ID, "DukeNukem", "com.games.duke", "picture128", "picture512"));

        applicationsByCategory.put(GAMES_ID, gamesList);

        List<Application> toolsList = new ArrayList<>();
        toolsList.add(new Application(6L, TOOLS_ID, "Doom", "com.games.doom", "picture128", "picture512"));
        toolsList.add(new Application(7L, TOOLS_ID, "Starcraft", "com.games.blizzard", "picture128", "picture512"));
        toolsList.add(new Application(8L, TOOLS_ID, "Mario", "com.games.mario", "picture128", "picture512"));
        toolsList.add(new Application(9L, TOOLS_ID, "Pacman", "com.games.pacman", "picture128", "picture512"));
        toolsList.add(new Application(10L, TOOLS_ID, "DukeNukem", "com.games.duke", "picture128", "picture512"));

        applicationsByCategory.put(TOOLS_ID, toolsList);

    }

    public List<Application> list(Long categoryId) {
        return applicationsByCategory.get(categoryId);
    }

    public Application get(Long categoryId, Long id) {

        List<Application> apps = applicationsByCategory.get(categoryId);

        for (Application app : apps) {
            if (app.getId().equals(id)) {
                return app;
            }
        }
        return null;
    }

    public Application create(Application application) {
        application.setId(System.currentTimeMillis());
        applicationsByCategory.get(application.getCategoryId()).add(application);
        return application;
    }

    public Long delete(Long id, Long categoryId) {
        List<Application> apps = applicationsByCategory.get(categoryId);

        for (Application app : apps) {
            if (app.getId().equals(id)) {
                apps.remove(app);
                return id;
            }
        }

        return null;
    }

    public Application update(Application updatedApp) {
        List<Application> apps = applicationsByCategory.get(updatedApp.getCategoryId());

        for (Application app : apps) {
            if (app.getId().equals(updatedApp.getId())) {
                apps.remove(app);
                apps.add(updatedApp);
                return updatedApp;
            }
        }

        return null;
    }

}
